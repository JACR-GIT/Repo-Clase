# ETAPA DE CONSTRUCCIÓN
FROM amazoncorretto:21-alpine-jdk AS build
WORKDIR /app

# 1. Copia los archivos de Maven (ya estamos dentro de SwapShop gracias a Render)
COPY mvnw pom.xml ./
COPY .mvn/ .mvn/

# 2. Permisos y descarga de dependencias
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# 3. Copia SOLO la carpeta src (que está al mismo nivel que este Dockerfile)
COPY src/ src/

# 4. Compila
RUN ./mvnw clean package -DskipTests

# ETAPA DE EJECUCIÓN
FROM amazoncorretto:21-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]