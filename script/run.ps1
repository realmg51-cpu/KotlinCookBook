#!/usr/bin/env pwsh
# 🍳 KotlinCookBook - Run any recipe with Docker
# Usage: ./run.ps1 <recipe-path>

param(
    [Parameter(Position=0)]
    [string]$Recipe
)

# Colors for output
$GREEN = "`e[32m"
$YELLOW = "`e[33m"
$RED = "`e[31m"
$BLUE = "`e[34m"
$NC = "`e[0m"

$IMAGE_NAME = "kotlincookbook"

# Show help if no recipe provided
if ([string]::IsNullOrEmpty($Recipe)) {
    Write-Host "${YELLOW}🍳 KotlinCookBook${NC}"
    Write-Host "================================"
    Write-Host ""
    Write-Host "Usage: ./run.ps1 <recipe-path>"
    Write-Host ""
    Write-Host "${BLUE}Examples:${NC}"
    Write-Host "  ./run.ps1 GettingStarted/HelloWorld.kt"
    Write-Host "  ./run.ps1 Variables/ImmutableVariables.kt"
    Write-Host "  ./run.ps1 Loops/While/WhileStirring.kt"
    Write-Host "  ./run.ps1 BreakAndContinue/Break.kt"
    Write-Host ""
    Write-Host "${BLUE}List all recipes:${NC}"
    Write-Host "  ./run.ps1 --list"
    Write-Host ""
    Write-Host "${BLUE}Run all recipes:${NC}"
    Write-Host "  ./run.ps1 --all"
    Write-Host "Created by realmg51-cpu and Sun,star if you feel it useful!"
    Write-Host "Visit repo: https://github.com/realmg51-cpu/KotlinCookBook"
    return
}

# Check Docker availability
if (-not (Get-Command docker -ErrorAction SilentlyContinue)) {
    Write-Host "${RED}❌ Docker not found. Please install Docker Desktop for Windows${NC}"
    exit 1
}

# List recipes
if ($Recipe -in "--list", "-l") {
    Write-Host "${GREEN}📚 Available recipes:${NC}"
    Write-Host "================================"
    
    # Check if Docker image exists
    $null = docker image inspect $IMAGE_NAME 2>$null
    if ($LASTEXITCODE -ne 0) {
        Write-Host "${YELLOW}📦 Building Docker image first...${NC}"
        docker build -t $IMAGE_NAME . > $null 2>&1
    }
    
    docker run --rm $IMAGE_NAME find src/kotlin/normal -name "*.kt" -type f | Sort-Object | ForEach-Object {
        $_ -replace '^src/kotlin/normal/', ''
    }
    return
}

# Run all recipes
if ($Recipe -in "--all", "-a") {
    Write-Host "${GREEN}🍳 Running all recipes...${NC}"
    Write-Host "================================"
    Write-Host ""
    
    # Check if Docker image exists
    $null = docker image inspect $IMAGE_NAME 2>$null
    if ($LASTEXITCODE -ne 0) {
        Write-Host "${YELLOW}📦 Building Docker image...${NC}"
        docker build -t $IMAGE_NAME .
        if ($LASTEXITCODE -ne 0) { exit 1 }
        Write-Host ""
    }
    
    $failed = 0
    $total = 0
    
    $recipes = docker run --rm $IMAGE_NAME find src/kotlin/normal -name "*.kt" -type f | Sort-Object
    
    foreach ($recipe in $recipes) {
        $name = Split-Path $recipe -LeafBase
        $total++
        
        Write-Host "${BLUE}🔪 Running: $name${NC}"
        Write-Host "--------------------------------"
        
        $output = docker run --rm $IMAGE_NAME kotlinc -script $recipe 2>&1
        if ($LASTEXITCODE -eq 0) {
            Write-Host "${GREEN}✅ PASS${NC}"
        } else {
            Write-Host "${RED}❌ FAIL${NC}"
            $failed++
            Write-Host $output -ForegroundColor DarkGray
        }
        Write-Host ""
    }
    
    $passed = $total - $failed
    Write-Host "================================"
    Write-Host "${GREEN}📊 Summary: $passed/$total passed${NC}"
    
    if ($failed -gt 0) {
        Write-Host "${RED}❌ $failed recipe(s) failed${NC}"
        exit 1
    } else {
        Write-Host "${GREEN}🎉 All recipes passed!${NC}"
        exit 0
    }
}

# Single recipe mode
$RECIPE_PATH = "src/kotlin/normal/$Recipe"

# Check if Docker image exists
$null = docker image inspect $IMAGE_NAME 2>$null
if ($LASTEXITCODE -ne 0) {
    Write-Host "${YELLOW}📦 Building Docker image...${NC}"
    docker build -t $IMAGE_NAME .
    if ($LASTEXITCODE -ne 0) { exit 1 }
    Write-Host ""
}

# Check if recipe exists
$null = docker run --rm $IMAGE_NAME test -f $RECIPE_PATH 2>$null
if ($LASTEXITCODE -ne 0) {
    Write-Host "${RED}❌ Recipe not found: $Recipe${NC}"
    Write-Host ""
    Write-Host "${YELLOW}Available recipes:${NC}"
    docker run --rm $IMAGE_NAME find src/kotlin/normal -name "*.kt" -type f | Select-Object -First 10
    exit 1
}

# Run the recipe
Write-Host "${GREEN}🍳 Running: $Recipe${NC}"
Write-Host "================================"
Write-Host ""

docker run --rm -it $IMAGE_NAME kotlinc -script $RECIPE_PATH

Write-Host ""
Write-Host "================================"
Write-Host "${GREEN}✅ Done!${NC}"
