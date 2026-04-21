# 🍳 KotlinCookBook Dockerfile
# Learn Kotlin the fun way - No installation required!

FROM kotlin:2.3.20

WORKDIR /app

# Copy all recipes
COPY src/ ./src/

# Set entrypoint
ENTRYPOINT ["kotlin"]

# Default: show version and available recipes
CMD ["-version"]
