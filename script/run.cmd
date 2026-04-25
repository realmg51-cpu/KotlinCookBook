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

REM Check if recipe is provided
if "%RECIPE%"=="" (
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
    echo.
    echo %BLUE%List all recipes:%NC%
    echo   run.cmd --list
    echo.
    echo %BLUE%Run all recipes:%NC%
    echo   run.cmd --all
    echo Created by realmg51-cpu and Sun,star if you feel it useful!
    echo Visit repo: https://github.com/realmg51-cpu/KotlinCookBook
    exit /b 0
)

REM List all recipes
if "%RECIPE%"=="--list" goto :list
if "%RECIPE%"=="-l" goto :list
if "%RECIPE%"=="--all" goto :all
if "%RECIPE%"=="-a" goto :all

REM Single recipe mode
set "RECIPE_PATH=src\kotlin\normal\%RECIPE%"

REM Check if Docker is available
where docker >nul 2>&1
if %errorlevel% neq 0 (
    echo %RED%❌ Docker not found. Please install Docker Desktop for Windows%NC%
    exit /b 1
)

REM Check if Docker image exists
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

REM Check if recipe exists in Docker image
docker run --rm %IMAGE_NAME% cmd /c "if exist %RECIPE_PATH% (exit 0) else (exit 1)" >nul 2>&1
if %errorlevel% neq 0 (
    echo %RED%❌ Recipe not found: %RECIPE%%NC%
    echo.
    echo %YELLOW%Available recipes (first 10):%NC%
    docker run --rm %IMAGE_NAME% cmd /c "dir /b src\kotlin\normal\*.kt 2>nul"
    exit /b 1
)

REM Run the recipe
echo %GREEN%🍳 Running: %RECIPE%%NC%
echo ================================
echo.

docker run --rm -it %IMAGE_NAME% kotlinc -script "%RECIPE_PATH%"

echo.
echo ================================
echo %GREEN%✅ Done!%NC%
exit /b 0

:list
echo %GREEN%📚 Available recipes:%NC%
echo ================================

REM Check if Docker image exists
docker image inspect %IMAGE_NAME% >nul 2>&1
if %errorlevel% neq 0 (
    echo %YELLOW%📦 Building Docker image first...%NC%
    docker build -t %IMAGE_NAME% . >nul 2>&1
)

REM List all .kt files
docker run --rm %IMAGE_NAME% cmd /c "dir /b /s src\kotlin\normal\*.kt 2>nul" | findstr /v /i "\\build\\" | sort
exit /b 0

:all
echo %GREEN%🍳 Running all recipes...%NC%
echo ================================
echo.

REM Check if Docker image exists
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

set "failed=0"
set "total=0"
set "tempfile=%TEMP%\kotlin_recipes_%RANDOM%.txt"

REM Get list of recipes
docker run --rm %IMAGE_NAME% cmd /c "dir /b /s src\kotlin\normal\*.kt 2>nul" > "%tempfile%" 2>nul

for /f "usebackq delims=" %%r in ("%tempfile%") do (
    set /a total+=1
    set "recipe_path=%%r"
    
    REM Extract filename without extension
    for %%f in ("%%r") do set "name=%%~nf"
    
    echo %BLUE%🔪 Running: !name!%NC%
    echo --------------------------------
    
    REM Run the recipe
    docker run --rm %IMAGE_NAME% kotlinc -script "%%r" >nul 2>&1
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
