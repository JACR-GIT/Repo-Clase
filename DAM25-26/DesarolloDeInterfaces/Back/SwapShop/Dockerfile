# --- ETAPA DE CONSTRUCCIÓN ---
FROM amazoncorretto:21-alpine-jdk AS build
WORKDIR /app

# Instalamos Maven manualmente en la etapa de build
RUN apk add --no-cache maven

# Definimos la ruta del proyecto
ARG PROJECT_PATH=DAM25-26/DesarolloDeInterfaces/Back/SwapShop

# Copiamos el contenido del proyecto
COPY ${PROJECT_PATH}/ .

# Como instalamos Maven en el sistema, usamos 'mvn' en lugar de './mvnw'
# Esto ignora completamente la carpeta .mvn/wrapper que está fallando
RUN mvn dependency:go-offline -B

# Compilamos
RUN mvn clean package -DskipTests

# --- ETAPA DE EJECUCIÓN ---
FROM amazoncorretto:21-alpine
WORKDIR /app

# El JAR se genera en la carpeta target/
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]