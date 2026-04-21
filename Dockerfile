# 🍳 KotlinCookBook - Hoàn toàn tự cài Kotlin
# Không cần login, không lỗi authentication

FROM eclipse-temurin:17-jdk-alpine

# Cài đặt công cụ cần thiết
RUN apk add --no-cache curl unzip bash

# Tải và cài Kotlin 2.0.20 trực tiếp từ GitHub
RUN curl -L "https://github.com/JetBrains/kotlin/releases/download/v2.0.20/kotlin-compiler-2.3.20.zip" -o /tmp/kotlin.zip \
    && unzip /tmp/kotlin.zip -d /opt \
    && ln -s /opt/kotlinc/bin/kotlin /usr/local/bin/kotlin \
    && ln -s /opt/kotlinc/bin/kotlinc /usr/local/bin/kotlinc \
    && rm /tmp/kotlin.zip

WORKDIR /app

# Copy recipes
COPY src/ ./src/

# Hiển thị thông tin khi chạy container
CMD sh -c "echo '🍳 KotlinCookBook' && echo '================' && kotlin -version && echo '' && echo '📚 Recipes:' && ls -1 src/kotlin/normal/*.kt 2>/dev/null | sed 's/.*\///'"
