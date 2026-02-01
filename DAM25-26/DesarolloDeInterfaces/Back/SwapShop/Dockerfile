FROM amazoncorretto:21-alpine-jdk AS build
WORKDIR /app

# Al definir el Root Directory en Render, '.' ahora es la carpeta 'SwapShop'
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN chmod +x mvnw

# Descargar dependencias
RUN ./mvnw dependency:go-offline

# Copiar el código fuente (src/ está dentro de SwapShop)
COPY src/ src/

# Compilar
RUN ./mvnw clean package -DskipTests

# Etapa final de ejecución
FROM amazoncorretto:21-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]