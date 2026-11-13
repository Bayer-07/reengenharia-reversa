# Etapa 1: compila e testa a aplicação
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY gradlew settings.gradle build.gradle gradle.lockfile ./
COPY gradle gradle
RUN ./gradlew --no-daemon dependencies > /dev/null
COPY src src
RUN ./gradlew --no-daemon build

# Etapa 2: imagem final mínima, apenas com JRE e o jar
FROM eclipse-temurin:17-jre-alpine
RUN apk upgrade --no-cache \
    && addgroup -S app && adduser -S app -G app
WORKDIR /app
COPY --from=build /app/build/libs/financial-calculator-*.jar app.jar
USER app
ENTRYPOINT ["java", "-jar", "app.jar"]
