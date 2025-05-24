# ✅ Todo API - Spring Boot & PostgreSQL

Une API REST simple de gestion de tâches (ToDo) construite avec **Spring Boot**, **JPA**, **Hibernate**, et **PostgreSQL**.

---

## 🔧 Fonctionnalités
- 📥 Créer une tâche
- 📄 Lister toutes les tâches
- ✏️ Mettre à jour une tâche
- 🗑 Supprimer une tâche

---

## 🚀 Démarrage rapide

### 📦 Prérequis
- Java 17+
- PostgreSQL installé et configuré
- Maven
- (Facultatif) Docker

### ⚙️ Configuration
Dans le fichier `application.properties` :
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/todo_db
spring.datasource.username=noumbis
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
