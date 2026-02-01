# ETAPA DE CONSTRUCCIÓN
FROM amazoncorretto:21-alpine-jdk AS build
WORKDIR /app

# Copiamos todo lo que hay en SwapShop al contenedor
COPY . .

# Corregimos permisos y compilamos
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# ETAPA DE EJECUCIÓN
FROM amazoncorretto:21-alpine
WORKDIR /app

# Buscamos el JAR generado en target y lo copiamos
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]