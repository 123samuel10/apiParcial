# Usa una imagen base de OpenJDK 17
FROM openjdk:17-jdk-slim

# Establece una variable de entorno para el archivo JAR (puedes omitir esto si prefieres no usar ARG)
ARG JAR_FILE=target/demo-0.0.1.jar

# Copia el archivo JAR de tu máquina local al contenedor
COPY ${JAR_FILE} demo_usuarios.jar

# Expone el puerto 8080 para la aplicación
EXPOSE 8080

# Define el punto de entrada para ejecutar la aplicación Java
ENTRYPOINT ["java", "-jar", "demo_usuarios.jar"]
