# Plants vs Zombies - API Back-end

## Description
API Back-end développée en Java pour un jeu inspiré de Plants vs Zombies. Ce projet a été réalisé dans le cadre de la formation à l'EPF.

## Technologies Utilisées
* Java 21
* Spring MVC 6.2.2
* Spring JDBC 6.1.13
* MySQL 8.0.33
* Maven
* JUnit 4.13.2
* Mockito 5.7.0
* Jackson 2.18.2
* Logback 1.5.16

## Prérequis
* JDK 21
* Maven
* MySQL
* Apache Tomcat 10

## Structure du Projet
```
projet_pvz/
├── .idea/
├── src/
│   ├── main/
│   │   ├── java/com/epf/
│   │   │   ├── api/
│   │   │   │   ├── controller/  # Contrôleurs REST
│   │   │   │   └── DTO/         # Objets de transfert de données
│   │   │   ├── config/
│   │   │   ├── core/
│   │   │   │   └── service/     # Logique métier
│   │   │   └── persistance/     # Accès aux données
│   │   │   │   └── dao/ 
│   │   │   │   └── implementation/ 
│   │   │   │   └── mapper/ 
│   │   └── webapp/
│   │   │   └── images/          # Images du jeu
│   │   │   └── WEB-INF/ 
│   │   └── ressources/
│   └── test/
│       └── java/
│           └── testapi/         # Tests unitaires
│               └── testcontroller/ 
│               └── testDTO/ 
│           └── testcore/        # Tests unitaires
│           └── testpersistance/ # Tests unitaires
└── package-lock.json
└── pom.xml
└── projet_pvz.iml
└── README.md
```

## Installation

### 1. Base de données
```sql
CREATE DATABASE pvz;
USE pvz;
```

### 2. Configuration
Dans `src/main/resources/application.properties` :
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/pvz
spring.datasource.username=votre_user
spring.datasource.password=votre_mdp
```

### 3. Compilation
```bash
mvn clean install
```

### 4. Déploiement
Copier le fichier WAR généré vers Tomcat :
```bash
copy target\CoursEpfBack.war C:\chemin\vers\tomcat\webapps
```

## API REST

### Plantes
* `GET /plantes` - Liste des plantes
* `GET /plantes/{id}` - Détails d'une plante
* `POST /plantes` - Création d'une plante
* `PUT /plantes/{id}` - Modification d'une plante
* `DELETE /plantes/{id}` - Suppression d'une plante

### Zombies
* `GET /zombies` - Liste des zombies
* `GET /zombies/{id}` - Détails d'un zombie
* `POST /zombies` - Création d'un zombie
* `PUT /zombies/{id}` - Modification d'un zombie
* `DELETE /zombies/{id}` - Suppression d'un zombie

### Cartes
* `GET /maps` - Liste des cartes
* `GET /maps/{id}` - Détails d'une carte
* `POST /maps` - Création d'une carte
* `PUT /maps/{id}` - Modification d'une carte
* `DELETE /maps/{id}` - Suppression d'une carte et ses zombies

## Tests
Le projet inclut une suite de tests unitaires complète :

```bash
# Exécuter tous les tests
mvn test

# Exécuter une classe de test spécifique
mvn test -Dtest=TestPlanteService
```

Tests disponibles :
* Controllers (TestPlanteController, TestZombieController, TestMapsController)
* Services (TestPlanteService, TestZombieService, TestMapsService)
* DTOs (TestPlanteDTO, TestZombieDTO, TestMapsDTO)
* Entités (TestPlante, TestZombie, TestMaps)

## Développement

### Prérequis VSCode
* Extension "Java Extension Pack"
* Extension "Maven for Java"

### Commandes utiles
```bash
# Démarrer Tomcat
C:\chemin\vers\tomcat\bin\%CATALINA_HOME%/bin/startup.bat

# Arrêter Tomcat
C:\chemin\vers\tomcat\bin\%CATALINA_HOME%/bin/shutdown.bat

# Nettoyer et compiler
mvn clean install
```
