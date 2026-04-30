# 🍳 KotlinCookBook Dockerfile
# Multi-arch build for GHCR

FROM eclipse-temurin:17-jdk-alpine

# Install Kotlin
RUN apk add --no-cache curl unzip bash

ENV KOTLIN_VERSION=2.3.21
RUN curl -L "https://github.com/JetBrains/kotlin/releases/download/v${KOTLIN_VERSION}/kotlin-compiler-${KOTLIN_VERSION}.zip" -o /tmp/kotlin.zip \
    && unzip /tmp/kotlin.zip -d /opt \
    && ln -s /opt/kotlinc/bin/kotlin /usr/local/bin/kotlin \
    && ln -s /opt/kotlinc/bin/kotlinc /usr/local/bin/kotlinc \
    && rm /tmp/kotlin.zip

# Set working directory
WORKDIR /workspace

# Copy source (CHANGE THIS)
COPY src/ /workspace/src/
COPY README.md /workspace/
COPY LICENSE /workspace/

# Also copy to /app for compatibility
RUN mkdir -p /app && cp -r /workspace/src /app/ 2>/dev/null || true

# Labels for GHCR
LABEL org.opencontainers.image.title="KotlinCookBook"
LABEL org.opencontainers.image.description="Learn Kotlin the fun way – one recipe at a time!"
LABEL org.opencontainers.image.source="https://github.com/realmg51-cpu/KotlinCookBook"
LABEL org.opencontainers.image.licenses="Apache-2.0"

# Set multiple possible paths for compatibility
ENV PATH="/workspace:/app:${PATH}"

# Default command
CMD sh -c "echo '🍳 KotlinCookBook' && kotlin -version && echo '' && echo '📚 Recipes:' && find /workspace/src -name '*.kt' 2>/dev/null | head -10 || find /app/src -name '*.kt' 2>/dev/null | head -10"
