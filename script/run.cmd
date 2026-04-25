@echo off
setlocal enabledelayedexpansion

REM 🍳 KotlinCookBook - Run any recipe with Docker
REM Usage: run.cmd <recipe-path>

REM Colors for output (Windows 10+ ANSI support)
set "GREEN=[32m"
set "YELLOW=[33m"
set "RED=[31m"
set "BLUE=[34m"
set "NC=[0m"

set "IMAGE_NAME=kotlincookbook"
set "RECIPE=%1"
set "CATEGORY=%2"

REM Function to check if Docker is available
:check_docker
where docker >nul 2>&1
if %errorlevel% neq 0 (
    echo %RED%❌ Docker not found. Please install Docker Desktop for Windows%NC%
    echo.
    echo Download from: https://docs.docker.com/desktop/install/windows-install/
    exit /b 1
)

REM Check if Docker daemon is running
docker info >nul 2>&1
if %errorlevel% neq 0 (
    echo %RED%❌ Docker daemon is not running%NC%
    echo Please start Docker Desktop and try again
    exit /b 1
)
exit /b 0

REM Function to ensure Docker image exists
:ensure_docker_image
docker image inspect %IMAGE_NAME% >nul 2>&1
if %errorlevel% neq 0 (
    echo %YELLOW%📦 Building Docker image...%NC%
    docker build -t %IMAGE_NAME% .
    if %errorlevel% neq 0 (
        echo %RED%❌ Failed to build Docker image%NC%
        exit /b 1
    )
    echo.
)
exit /b 0

REM Function to list all recipes
:list_recipes
echo %GREEN%📚 Available recipes:%NC%
echo ================================
echo.

call :check_docker
if %errorlevel% neq 0 exit /b 1
call :ensure_docker_image

REM List all .kt files recursively
docker run --rm %IMAGE_NAME% cmd /c "dir /s /b src\kotlin\normal\*.kt 2>nul" | sort
exit /b 0

REM Function to run all recipes
:run_all_recipes
echo %GREEN%🍳 Running all recipes...%NC%
echo ================================
echo.

call :check_docker
if %errorlevel% neq 0 exit /b 1
call :ensure_docker_image

set "failed=0"
set "total=0"
set "tempfile=%TEMP%\kotlin_recipes_%RANDOM%.txt"

REM Get list of recipes
docker run --rm %IMAGE_NAME% cmd /c "dir /s /b src\kotlin\normal\*.kt 2>nul" > "%tempfile%" 2>nul

if not exist "%tempfile%" (
    echo %RED%❌ No recipes found%NC%
    exit /b 1
)

for /f "usebackq delims=" %%r in ("%tempfile%") do (
    set /a total+=1
    set "recipe_path=%%r"
    
    REM Extract filename without extension and path
    for %%f in ("%%r") do (
        set "fullname=%%~nf"
        set "dirname=%%~dpf"
    )
    
    REM Get relative path for display
    set "display_path=!recipe_path:src\kotlin\normal\=!"
    
    echo %BLUE%🔪 Running: !display_path!%NC%
    echo --------------------------------
    
    REM Run the recipe
    docker run --rm %IMAGE_NAME% kotlinc -script "%%r" 2>&1
    if !errorlevel! equ 0 (
        echo %GREEN%✅ PASS%NC%
    ) else (
        echo %RED%❌ FAIL%NC%
        set /a failed+=1
    )
    echo.
)

del "%tempfile%" 2>nul

echo ================================
set /a passed=%total%-%failed%
echo %GREEN%📊 Summary: %passed%/%total% passed%NC%

if %failed% gtr 0 (
    echo %RED%❌ %failed% recipe(s) failed%NC%
    exit /b 1
) else (
    echo %GREEN%🎉 All recipes passed!%NC%
    exit /b 0
)

REM Function to run recipes by category
:run_category
echo %GREEN%🍳 Running all recipes in category: %CATEGORY%%NC%
echo ================================
echo.

call :check_docker
if %errorlevel% neq 0 exit /b 1
call :ensure_docker_image

set "failed=0"
set "total=0"
set "tempfile=%TEMP%\kotlin_recipes_%RANDOM%.txt"

REM Check if category exists
docker run --rm %IMAGE_NAME% cmd /c "if exist src\kotlin\normal\%CATEGORY% (exit 0) else (exit 1)" >nul 2>&1
if %errorlevel% neq 0 (
    echo %RED%❌ Category not found: %CATEGORY%%NC%
    echo.
    echo %YELLOW%Available categories:%NC%
    docker run --rm %IMAGE_NAME% cmd /c "for /d %%i in (src\kotlin\normal\*) do @echo %%~nxi" 2>nul
    exit /b 1
)

REM Get list of recipes in category
docker run --rm %IMAGE_NAME% cmd /c "dir /s /b src\kotlin\normal\%CATEGORY%\*.kt 2>nul" > "%tempfile%" 2>nul

if not exist "%tempfile%" (
    echo %RED%❌ No recipes found in category: %CATEGORY%%NC%
    exit /b 1
)

for /f "usebackq delims=" %%r in ("%tempfile%") do (
    set /a total+=1
    
    REM Get relative path for display
    set "recipe_path=%%r"
    set "display_path=!recipe_path:src\kotlin\normal\%CATEGORY%\=!"
    
    echo %BLUE%🔪 Running: !display_path!%NC%
    echo --------------------------------
    
    docker run --rm %IMAGE_NAME% kotlinc -script "%%r" 2>&1
    if !errorlevel! equ 0 (
        echo %GREEN%✅ PASS%NC%
    ) else (
        echo %RED%❌ FAIL%NC%
        set /a failed+=1
    )
    echo.
)

del "%tempfile%" 2>nul

echo ================================
set /a passed=%total%-%failed%
echo %GREEN%📊 Summary: %passed%/%total% passed in category %CATEGORY%%NC%

if %failed% gtr 0 (
    echo %RED%❌ %failed% recipe(s) failed%NC%
    exit /b 1
) else (
    echo %GREEN%🎉 All recipes in category %CATEGORY% passed!%NC%
    exit /b 0
)

REM Main script starts here
if "%RECIPE%"=="" goto :show_help

REM Handle special commands
if "%RECIPE%"=="--list" goto :list
if "%RECIPE%"=="-l" goto :list
if "%RECIPE%"=="--all" goto :all
if "%RECIPE%"=="-a" goto :all
if "%RECIPE%"=="--category" goto :category
if "%RECIPE%"=="-c" goto :category

REM Single recipe mode
REM Auto-add .kt extension if missing
echo "%RECIPE%" | findstr /i "\.kt$" >nul
if %errorlevel% neq 0 (
    set "RECIPE=%RECIPE%.kt"
)

REM Convert forward slashes to backslashes for Windows
set "RECIPE=%RECIPE:/=\%"
set "RECIPE_PATH=src\kotlin\normal\%RECIPE%"

call :check_docker
if %errorlevel% neq 0 exit /b 1
call :ensure_docker_image

REM Check if recipe exists in Docker image
docker run --rm %IMAGE_NAME% cmd /c "if exist %RECIPE_PATH% (exit 0) else (exit 1)" >nul 2>&1
if %errorlevel% neq 0 (
    echo %RED%❌ Recipe not found: %RECIPE%%NC%
    echo.
    echo %YELLOW%Available recipes (first 10):%NC%
    docker run --rm %IMAGE_NAME% cmd /c "dir /s /b src\kotlin\normal\*.kt 2>nul" | findstr /n "^" | findstr "^[0-9]:" | head -10
    exit /b 1
)

REM Run the recipe
echo %GREEN%🍳 Running: %RECIPE%%NC%
echo ================================
echo.

REM Check if running in interactive terminal
if "%PROMPT%"=="" (
    docker run --rm %IMAGE_NAME% kotlinc -script "%RECIPE_PATH%"
) else (
    docker run --rm -it %IMAGE_NAME% kotlinc -script "%RECIPE_PATH%"
)

echo.
echo ================================
echo %GREEN%✅ Done!%NC%
exit /b 0

:show_help
echo %YELLOW%🍳 KotlinCookBook%NC%
echo ================================
echo.
echo Usage: run.cmd ^<recipe-path^>
echo.
echo %BLUE%Examples:%NC%
echo   run.cmd GettingStarted\HelloWorld.kt
echo   run.cmd Variables\ImmutableVariables.kt
echo   run.cmd Loops\While\WhileStirring.kt
echo   run.cmd BreakAndContinue\Break.kt
echo   run.cmd Functions\BasicFunctions\BasicFunctions.kt
echo.
echo %BLUE%List all recipes:%NC%
echo   run.cmd --list
echo   run.cmd -l
echo.
echo %BLUE%Run all recipes:%NC%
echo   run.cmd --all
echo   run.cmd -a
echo.
echo %BLUE%Run recipes by category:%NC%
echo   run.cmd --category Loops
echo   run.cmd -c Functions
echo.
echo %BLUE%Category names available:%NC%
echo   - BreakAndContinue
echo   - Functions
echo   - GettingStarted
echo   - IfChef
echo   - InputAndNullSafety
echo   - Loops
echo   - Variables
echo   - WhenChef
echo.
echo Created by realmg51-cpu and Sun,star if you feel it useful!
echo Visit repo: https://github.com/realmg51-cpu/KotlinCookBook
exit /b 0

:list
call :list_recipes
exit /b %errorlevel%

:all
call :run_all_recipes
exit /b %errorlevel%

:category
if "%CATEGORY%"=="" (
    echo %RED%❌ Please specify a category%NC%
    echo.
    echo Usage: run.cmd --category ^<category-name^>
    echo Example: run.cmd --category Loops
    exit /b 1
)
call :run_category
exit /b %errorlevel%
