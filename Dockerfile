# Usa una imagen base de Maven con Java 17
FROM maven:3.8.4-openjdk-17-slim AS build

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml y el código fuente
COPY pom.xml .
COPY src /app/src

# Construye el proyecto
RUN mvn clean install

# Usa una imagen de OpenJDK 17 para ejecutar la aplicación
FROM openjdk:17-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado desde el paso anterior
COPY --from=build /app/target/MyRoutineAPI-0.0.1-SNAPSHOT.jar /app/MyRoutineAPI-0.0.1-SNAPSHOT.jar

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "MyRoutineAPI-0.0.1-SNAPSHOT.jar"]
