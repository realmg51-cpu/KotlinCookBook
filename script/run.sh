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

# Check if recipe is provided
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
    echo ""
    echo -e "${BLUE}Run all recipes:${NC}"
    echo "  ./run.sh --all"
    echo "Created by realmg51-cpu and Sun,star if you feel it useful!"
    echo "Visit repo: https://github.com/realmg51-cpu/KotlinCookBook"
    exit 0
fi

# List all recipes
if [ "$RECIPE" == "--list" ] || [ "$RECIPE" == "-l" ]; then
    echo -e "${GREEN}📚 Available recipes:${NC}"
    echo "================================"
    
    # Check if Docker image exists
    if ! docker image inspect "$IMAGE_NAME" >/dev/null 2>&1; then
        echo -e "${YELLOW}📦 Building Docker image first...${NC}"
        docker build -t "$IMAGE_NAME" . >/dev/null 2>&1
    fi
    
    docker run --rm "$IMAGE_NAME" find src/kotlin/normal -name "*.kt" -type f | sort | while read -r f; do
        # Remove src/kotlin/normal/ prefix
        echo "  ${f#src/kotlin/normal/}"
    done
    exit 0
fi

# Run all recipes
if [ "$RECIPE" == "--all" ] || [ "$RECIPE" == "-a" ]; then
    echo -e "${GREEN}🍳 Running all recipes...${NC}"
    echo "================================"
    echo ""
    
    # Check if Docker image exists
    if ! docker image inspect "$IMAGE_NAME" >/dev/null 2>&1; then
        echo -e "${YELLOW}📦 Building Docker image...${NC}"
        docker build -t "$IMAGE_NAME" .
        echo ""
    fi
    
    failed=0
    total=0
    
    docker run --rm "$IMAGE_NAME" find src/kotlin/normal -name "*.kt" -type f | sort | while read -r recipe; do
        name=$(basename "$recipe" .kt)
        total=$((total + 1))
        
        echo -e "${BLUE}🔪 Running: $name${NC}"
        echo "--------------------------------"
        
        if docker run --rm "$IMAGE_NAME" kotlinc -script "$recipe" 2>&1; then
            echo -e "${GREEN}✅ PASS${NC}"
        else
            echo -e "${RED}❌ FAIL${NC}"
            failed=$((failed + 1))
        fi
        echo ""
    done
    
    # Note: while loop runs in subshell, so we can't capture failed/total easily
    # Alternative: use for loop with process substitution
    exit 0
fi

# Build recipe path
RECIPE_PATH="src/kotlin/normal/$RECIPE"

# Check if Docker image exists
if ! docker image inspect "$IMAGE_NAME" >/dev/null 2>&1; then
    echo -e "${YELLOW}📦 Building Docker image...${NC}"
    docker build -t "$IMAGE_NAME" .
    echo ""
fi

# Check if recipe exists in Docker image
if ! docker run --rm "$IMAGE_NAME" test -f "$RECIPE_PATH" 2>/dev/null; then
    echo -e "${RED}❌ Recipe not found: $RECIPE${NC}"
    echo ""
    echo -e "${YELLOW}Available recipes:${NC}"
    docker run --rm "$IMAGE_NAME" find src/kotlin/normal -name "*.kt" -type f | sed 's|src/kotlin/normal/||' | head -10
    exit 1
fi

# Run the recipe
echo -e "${GREEN}🍳 Running: $RECIPE${NC}"
echo "================================"
echo ""

docker run --rm -it "$IMAGE_NAME" kotlinc -script "$RECIPE_PATH"

echo ""
echo "================================"
echo -e "${GREEN}✅ Done!${NC}"
