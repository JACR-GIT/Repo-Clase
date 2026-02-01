# --- ETAPA DE CONSTRUCCIÓN ---
FROM amazoncorretto:21-alpine-jdk AS build
WORKDIR /app

# Definimos una variable para no repetir la ruta larga (ajusta si tiene errores de escritura)
ARG PROJECT_PATH=DAM25-26/DesarolloDeInterfaces/Back/SwapShop

# Copiamos los archivos de Maven usando la ruta completa del repo
COPY ${PROJECT_PATH}/mvnw ${PROJECT_PATH}/pom.xml ./
COPY ${PROJECT_PATH}/.mvn/ .mvn/

# Corregimos permisos y descargamos dependencias
RUN chmod +x mvnw && ./mvnw dependency:go-offline -B

# Copiamos el código fuente desde la ruta larga
COPY ${PROJECT_PATH}/src/ src/

# Compilamos
RUN ./mvnw clean package -DskipTests

# --- ETAPA DE EJECUCIÓN ---
FROM amazoncorretto:21-alpine
WORKDIR /app

# El JAR se genera en la raíz de /app/target dentro del contenedor
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]