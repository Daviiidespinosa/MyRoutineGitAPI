# Usa una imagen base de Maven para construir la aplicación
FROM maven:3.8.4-openjdk-11-slim AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y el código fuente
COPY pom.xml .
COPY src /app/src

# Construye el proyecto
RUN mvn clean install

# Usa una imagen de OpenJDK para ejecutar la aplicación
FROM openjdk:11-jre-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado desde el paso anterior
COPY --from=build /app/target/your-api.jar /app/your-api.jar

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "your-api.jar"]