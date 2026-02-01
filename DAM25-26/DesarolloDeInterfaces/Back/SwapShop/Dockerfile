# --- ETAPA DE CONSTRUCCIÓN ---
FROM amazoncorretto:21-alpine-jdk AS build
WORKDIR /app

# Definimos la ruta del proyecto como argumento
ARG PROJECT_PATH=DAM25-26/DesarolloDeInterfaces/Back/SwapShop

# En lugar de copiar uno a uno, copiamos TODO el contenido de la carpeta del proyecto
# Esto incluirá .mvn, mvnw, pom.xml y src de una sola vez
COPY ${PROJECT_PATH}/ .

# Corregimos los finales de línea (por si vienes de Windows) y damos permisos
RUN tr -d '\r' < mvnw > mvnw_unix && mv mvnw_unix mvnw
RUN chmod +x mvnw

# Descargamos dependencias
RUN ./mvnw dependency:go-offline -B

# Compilamos (el código ya se copió en el paso anterior)
RUN ./mvnw clean package -DskipTests

# --- ETAPA DE EJECUCIÓN ---
FROM amazoncorretto:21-alpine
WORKDIR /app

# Copiamos el JAR generado
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]