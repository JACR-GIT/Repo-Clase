FROM amazoncorretto:21-alpine-jdk AS build
WORKDIR /app

# Usamos la ruta completa desde la raíz del repo
COPY "DAM25-26/DesarolloDeInterfaces/Back/SwapShop/mvnw" "DAM25-26/DesarolloDeInterfaces/Back/SwapShop/pom.xml" ./
COPY "DAM25-26/DesarolloDeInterfaces/Back/SwapShop/.mvn/" .mvn/

RUN chmod +x mvnw && ./mvnw dependency:go-offline -B

COPY "DAM25-26/DesarolloDeInterfaces/Back/SwapShop/src/" src/

RUN ./mvnw clean package -DskipTests

FROM amazoncorretto:21-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]