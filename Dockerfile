# Étape 1 : Utiliser une image Maven avec Java 17
FROM maven:3.9.5-eclipse-temurin-17 AS build

# Définir le répertoire de travail
WORKDIR /app

# Copier les fichiers de ton projet dans le conteneur
COPY . .

# Compiler l'application et créer le JAR
RUN mvn clean package -DskipTests

# Étape 2 : Utiliser une image JDK légère pour exécuter l'application
FROM eclipse-temurin:17-jdk

# Définir le répertoire de travail
WORKDIR /app

# Copier le JAR compilé depuis l'étape précédente
COPY --from=build /app/target/*.jar app.jar

# Exposer le port de l'application (8080 par défaut pour Spring Boot)
EXPOSE 8080

# Commande pour lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
