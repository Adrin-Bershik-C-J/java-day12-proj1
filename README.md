# 🐞 Issue Tracker ORM (Spring Boot + JPA)

A simple **Issue/Bug Tracking System** built with **Spring Boot**, **Spring Data JPA**, and **H2/MySQL Database**.  
This project demonstrates a **RESTful API** to manage **Users**, **Projects**, and **Bugs** with proper relationships and validation.

---

## 🚀 Features

- ✅ Manage **Users** (Developers, Testers, etc.)
- ✅ Manage **Projects**
- ✅ Manage **Bugs/Issues**
- ✅ Search projects by name
- ✅ Filter bugs by **status**, **project**, or **assigned user**
- ✅ Custom Exception Handling (`GlobalExceptionHandler`)
- ✅ DTOs (`BugRequestDTO`, `BugResponseDTO`) for cleaner API design
- ✅ Mapper Layer to convert between DTOs and Entities
- ✅ Validation using `jakarta.validation`
- ✅ RESTful API tested with `requests.http`

---

## 🏗️ Tech Stack

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA (Hibernate)**
- **H2 / MySQL** (configurable)
- **Lombok**
- **Maven**

---

## 📂 Project Structure

```
Directory structure:
└── adrin-bershik-c-j-java-day12-proj1/
    ├── mvnw
    ├── mvnw.cmd
    ├── pom.xml
    ├── requests.http
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── com/
    │   │   │       └── example/
    │   │   │           └── IssueTrackerORM/
    │   │   │               ├── IssueTrackerOrmApplication.java
    │   │   │               ├── controller/
    │   │   │               │   ├── BugController.java
    │   │   │               │   ├── ProjectController.java
    │   │   │               │   └── UserController.java
    │   │   │               ├── domain/
    │   │   │               │   ├── Bug.java
    │   │   │               │   ├── Project.java
    │   │   │               │   └── User.java
    │   │   │               ├── dto/
    │   │   │               │   ├── BugRequestDTO.java
    │   │   │               │   └── BugResponseDTO.java
    │   │   │               ├── exceptions/
    │   │   │               │   ├── GlobalExceptionHandler.java
    │   │   │               │   └── ResourceNotFoundException.java
    │   │   │               ├── mapper/
    │   │   │               │   └── BugMapper.java
    │   │   │               ├── repository/
    │   │   │               │   ├── BugRepository.java
    │   │   │               │   ├── ProjectRepository.java
    │   │   │               │   └── UserRepository.java
    │   │   │               └── service/
    │   │   │                   ├── BugService.java
    │   │   │                   ├── ProjectService.java
    │   │   │                   ├── ProjectServiceImpl.java
    │   │   │                   ├── UserService.java
    │   │   │                   └── UserServiceImpl.java
    │   │   └── resources/
    │   │       └── application.properties
    │   └── test/
    │       └── java/
    │           └── com/
    │               └── example/
    │                   └── IssueTrackerORM/
    │                       └── IssueTrackerOrmApplicationTests.java
    └── .mvn/
        └── wrapper/
            └── maven-wrapper.properties
```

---

## ⚡ API Endpoints

### 🔹 Users API
| Method | Endpoint         | Description              |
|--------|------------------|--------------------------|
| GET    | `/api/users`     | Get all users           |
| GET    | `/api/users/{id}`| Get user by ID          |
| POST   | `/api/users`     | Create a new user       |

### 🔹 Projects API
| Method | Endpoint                           | Description                         |
|--------|-------------------------------------|-------------------------------------|
| GET    | `/api/projects`                    | Get all projects                   |
| GET    | `/api/projects/{id}`               | Get project by ID                  |
| POST   | `/api/projects`                    | Create a new project               |
| GET    | `/api/projects/search/{name}`      | Search projects by name            |
| GET    | `/api/projects/count`              | Get total project count            |
| GET    | `/api/projects/names`              | Get all project names              |
| GET    | `/api/projects/bug-status/{status}`| Get projects having bugs with given status |

### 🔹 Bugs API
| Method | Endpoint                           | Description                         |
|--------|-------------------------------------|-------------------------------------|
| GET    | `/api/bugs`                        | Get all bugs                       |
| GET    | `/api/bugs/status/{status}`        | Get bugs by status                 |
| GET    | `/api/bugs/project/{projectId}`    | Get bugs by project ID             |
| GET    | `/api/bugs/assigned/{userId}`      | Get bugs by assigned user ID       |
| GET    | `/api/bugs/{id}`                   | Get bug by ID                      |
| POST   | `/api/bugs`                        | Create a new bug (DTO with IDs)    |
| PUT    | `/api/bugs/{id}`                   | Update an existing bug             |
| DELETE | `/api/bugs/{id}`                   | Delete bug by ID                   |

---

## 📌 Sample Request (Bug Creation)

```http
POST http://localhost:8080/api/bugs
Content-Type: application/json

{
  "name": "Signup button not working",
  "status": "OPEN",
  "description": "Signup button fails on click",
  "assignedTo": 1,
  "project": 1
}
