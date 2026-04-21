# 🍳 Stage 1: Build (if needed for complex projects)
FROM openjdk:17-slim AS builder

RUN apt-get update && apt-get install -y curl unzip
ENV KOTLIN_VERSION=2.0.20
RUN curl -s https://api.github.com/repos/JetBrains/kotlin/releases/tags/v${KOTLIN_VERSION} \
    | grep "browser_download_url.*kotlin-compiler-${KOTLIN_VERSION}.zip" \
    | cut -d : -f 2,3 | tr -d \" | wget -qi - -O /tmp/kotlin.zip \
    && unzip /tmp/kotlin.zip -d /opt \
    && rm /tmp/kotlin.zip

# 🍳 Stage 2: Runtime
FROM openjdk:17-slim

COPY --from=builder /opt/kotlinc /opt/kotlinc
ENV PATH="/opt/kotlinc/bin:${PATH}"

WORKDIR /app
COPY src/ ./src/
COPY README.md .
COPY LICENSE .

# Create an entrypoint script
RUN echo '#!/bin/bash\n\
echo "🍳 KotlinCookBook - Learn Kotlin the fun way!"\n\
echo "=========================================="\n\
echo ""\n\
echo "Available recipes:"\n\
ls -1 src/kotlin/normal/*.kt | xargs -n 1 basename\n\
echo ""\n\
echo "Run a recipe with: docker run kotlincookbook kotlin src/kotlin/normal/HelloWorld.kt"\n\
' > /entrypoint.sh && chmod +x /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]
CMD []
