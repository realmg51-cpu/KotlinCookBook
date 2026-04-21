#!/bin/bash
# 🐳 Run KotlinCookBook with Docker

IMAGE_NAME="kotlincookbook"
RECIPE="${1:-}"  # First argument is recipe name

# Colors for output
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo -e "${GREEN}🍳 KotlinCookBook Docker Runner${NC}"
echo "================================"

# Build image if not exists
if [[ "$(docker images -q $IMAGE_NAME 2> /dev/null)" == "" ]]; then
    echo -e "${YELLOW}📦 Building Docker image...${NC}"
    docker build -t $IMAGE_NAME .
fi

# If no recipe specified, show available recipes
if [ -z "$RECIPE" ]; then
    echo -e "${GREEN}📚 Available recipes:${NC}"
    docker run --rm $IMAGE_NAME ls -1 src/kotlin/normal/
    echo ""
    echo -e "${YELLOW}Usage:${NC}"
    echo "  ./scripts/docker-run.sh <recipe-name>"
    echo "  ./scripts/docker-run.sh HelloWorld.kt"
    echo "  ./scripts/docker-run.sh all    # Run all recipes"
    exit 0
fi

# Run all recipes
if [ "$RECIPE" == "all" ]; then
    echo -e "${GREEN}🍳 Running all recipes...${NC}"
    docker run --rm -v "$(pwd)/src:/app/src" $IMAGE_NAME \
        sh -c 'for f in src/kotlin/normal/*.kt; do echo "=== $(basename $f) ==="; kotlin "$f"; echo ""; done'
    exit 0
fi

# Run specific recipe
RECIPE_PATH="src/kotlin/normal/$RECIPE"
if [ ! -f "$RECIPE_PATH" ]; then
    echo "❌ Recipe not found: $RECIPE"
    echo "Available recipes:"
    docker run --rm $IMAGE_NAME ls -1 src/kotlin/normal/
    exit 1
fi

echo -e "${GREEN}🔪 Running recipe: $RECIPE${NC}"
echo "================================"
docker run --rm -it \
    -v "$(pwd)/src:/app/src" \
    $IMAGE_NAME \
    kotlin "$RECIPE_PATH"
