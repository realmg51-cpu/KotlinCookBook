#!/bin/bash
# 🍳 KotlinCookBook - Run any recipe with Docker
# Usage: ./run.sh <recipe-path>

# Colors for output
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

IMAGE_NAME="kotlincookbook"
RECIPE="$1"

# Function to check if Docker is available
check_docker() {
    if ! command -v docker &> /dev/null; then
        echo -e "${RED}❌ Docker is not installed or not in PATH${NC}"
        echo "Please install Docker: https://docs.docker.com/get-docker/"
        exit 1
    fi
    
    if ! docker info &> /dev/null; then
        echo -e "${RED}❌ Docker daemon is not running${NC}"
        echo "Please start Docker Desktop or your Docker service"
        exit 1
    fi
}

# Function to build Docker image if needed
ensure_docker_image() {
    if ! docker image inspect "$IMAGE_NAME" &> /dev/null; then
        echo -e "${YELLOW}📦 Building Docker image...${NC}"
        if ! docker build -t "$IMAGE_NAME" .; then
            echo -e "${RED}❌ Failed to build Docker image${NC}"
            exit 1
        fi
        echo ""
    fi
}

# Function to list all recipes
list_recipes() {
    echo -e "${GREEN}📚 Available recipes:${NC}"
    echo "================================"
    
    check_docker
    ensure_docker_image
    
    docker run --rm "$IMAGE_NAME" find src/kotlin/normal -name "*.kt" -type f | sort | while read -r f; do
        # Remove src/kotlin/normal/ prefix
        echo "  ${f#src/kotlin/normal/}"
    done
    exit 0
}

# Function to run all recipes
run_all_recipes() {
    echo -e "${GREEN}🍳 Running all recipes...${NC}"
    echo "================================"
    echo ""
    
    check_docker
    ensure_docker_image
    
    local failed=0
    local total=0
    
    # Fixed: Using process substitution to avoid subshell variable scope issue
    while IFS= read -r recipe; do
        local name=$(basename "$recipe" .kt)
        ((total++))
        
        echo -e "${BLUE}🔪 Running: $name${NC}"
        echo "--------------------------------"
        
        if docker run --rm "$IMAGE_NAME" kotlinc -script "$recipe" 2>&1; then
            echo -e "${GREEN}✅ PASS${NC}"
        else
            echo -e "${RED}❌ FAIL${NC}"
            ((failed++))
        fi
        echo ""
    done < <(docker run --rm "$IMAGE_NAME" find src/kotlin/normal -name "*.kt" -type f | sort)
    
    local passed=$((total - failed))
    echo "================================"
    echo -e "${GREEN}📊 Summary: $passed/$total passed${NC}"
    
    if [ $failed -gt 0 ]; then
        echo -e "${RED}❌ $failed recipe(s) failed${NC}"
        exit 1
    else
        echo -e "${GREEN}🎉 All recipes passed!${NC}"
        exit 0
    fi
}

# Show help if no recipe provided
if [ -z "$RECIPE" ]; then
    echo -e "${YELLOW}🍳 KotlinCookBook${NC}"
    echo "================================"
    echo ""
    echo "Usage: ./run.sh <recipe-path>"
    echo ""
    echo -e "${BLUE}Examples:${NC}"
    echo "  ./run.sh GettingStarted/HelloWorld.kt"
    echo "  ./run.sh Variables/ImmutableVariables.kt"
    echo "  ./run.sh Loops/While/WhileStirring.kt"
    echo "  ./run.sh BreakAndContinue/Break.kt"
    echo ""
    echo -e "${BLUE}List all recipes:${NC}"
    echo "  ./run.sh --list"
    echo "  ./run.sh -l"
    echo ""
    echo -e "${BLUE}Run all recipes:${NC}"
    echo "  ./run.sh --all"
    echo "  ./run.sh -a"
    echo ""
    echo "Created by realmg51-cpu and Sun,star if you feel it useful!"
    echo "Visit repo: https://github.com/realmg51-cpu/KotlinCookBook"
    exit 0
fi

# Handle special commands
case "$RECIPE" in
    --list|-l)
        list_recipes
        ;;
    --all|-a)
        run_all_recipes
        ;;
    *)
        # Single recipe mode
        # Auto-add .kt extension if missing
        if [[ ! "$RECIPE" == *.kt ]]; then
            RECIPE="${RECIPE}.kt"
        fi
        
        RECIPE_PATH="src/kotlin/normal/$RECIPE"
        
        check_docker
        ensure_docker_image
        
        # Check if recipe exists in Docker image
        if ! docker run --rm "$IMAGE_NAME" test -f "$RECIPE_PATH" &> /dev/null; then
            echo -e "${RED}❌ Recipe not found: $RECIPE${NC}"
            echo ""
            echo -e "${YELLOW}Available recipes (first 10):${NC}"
            docker run --rm "$IMAGE_NAME" find src/kotlin/normal -name "*.kt" -type f | head -10 | sed 's|src/kotlin/normal/||'
            exit 1
        fi
        
        # Run the recipe
        echo -e "${GREEN}🍳 Running: $RECIPE${NC}"
        echo "================================"
        echo ""
        
        # Use -it flag for interactive output, but remove it in CI environments
        if [ -t 0 ] && [ -t 1 ]; then
            docker run --rm -it "$IMAGE_NAME" kotlinc -script "$RECIPE_PATH"
        else
            docker run --rm "$IMAGE_NAME" kotlinc -script "$RECIPE_PATH"
        fi
        
        echo ""
        echo "================================"
        echo -e "${GREEN}✅ Done!${NC}"
        ;;
esac
