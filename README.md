# 🎓 EduTracker — Backend

**A robust RESTful backend for managing students, courses, teachers, and enrollments.**

---

## 📌 Overview

The Student Management System (SMS) backend is a Spring Boot REST API that powers a full-featured academic management platform. It handles student registration, course management, teacher assignments, and enrollment tracking — backed by MySQL with JPA/Hibernate ORM.

---

## ✨ Features

- 🎓 Student Management — Add, update, delete, and list students
- 📚 Course Management — Create and manage academic courses
- 👨‍🏫 Teacher Management — Manage teacher profiles and assignments
- 📋 Enrollment Tracking — Track student enrollments per course
- 📊 Dashboard Stats — Get total counts for students, courses, teachers, enrollments
- 🔒 Optimistic Locking — Prevents data conflicts with @Version
- 🗂️ DTO Pattern — Clean separation between API layer and persistence layer

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.x |
| ORM | Hibernate 6.6 / Spring Data JPA |
| Database | MySQL 8.0 |
| Build Tool | Maven |
| Boilerplate | Lombok |
| Server | Embedded Tomcat (port 8080) |

---

## 🌐 API Endpoints

### 👤 Students
| Method | Endpoint | Description |
|---|---|---|
| GET | /api/students | Get all students |
| GET | /api/students/{id} | Get student by ID |
| GET | /api/students/count | Get total student count |
| POST | /api/students | Create new student |
| PUT | /api/students/{id} | Update student |
| DELETE | /api/students/{id} | Delete student |

### 📚 Courses
| Method | Endpoint | Description |
|---|---|---|
| GET | /api/course | Get all courses |
| GET | /api/course/{courseId} | Get course by ID |
| GET | /api/course/count | Get total course count |
| POST | /api/course | Create new course |
| PUT | /api/course/{courseId} | Update course |
| DELETE | /api/course/{courseId} | Delete course |

### 👨‍🏫 Teachers
| Method | Endpoint | Description |
|---|---|---|
| GET | /api/teachers | Get all teachers |
| GET | /api/teachers/{id} | Get teacher by ID |
| GET | /api/teachers/count | Get total teacher count |
| POST | /api/teachers | Create new teacher |
| PUT | /api/teachers/{id} | Update teacher |
| DELETE | /api/teachers/{id} | Delete teacher |

### 📋 Enrollments
| Method | Endpoint | Description |
|---|---|---|
| GET | /api/enrollments | Get all enrollments |
| GET | /api/enrollments/{id} | Get enrollment by ID |
| GET | /api/enrollments/count | Get total enrollment count |
| POST | /api/enrollments | Create new enrollment |
| PUT | /api/enrollments/{id} | Update enrollment |
| DELETE | /api/enrollments/{id} | Delete enrollment |

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven 3.x
- MySQL 8.0+
- IntelliJ IDEA (recommended)

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/akhil14712-debug/sms-backend.git
cd sms-backend
```

### 2️⃣ Create MySQL Database
```sql
CREATE DATABASE sms_db;
```

### 3️⃣ Configure application.properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sms_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
server.port=8080
spring.application.name=sms.backend
```

### 4️⃣ Run the Application
```bash
mvn spring-boot:run
```

---

## ⚠️ Common Issues and Fixes

| Issue | Fix |
|---|---|
| ObjectOptimisticLockingFailureException | Set id = null before saving in create methods |
| CORS error from frontend | Add @CrossOrigin on controllers |
| Table not found | Set spring.jpa.hibernate.ddl-auto=update |
| Access denied for MySQL | Check username/password in application.properties |

---

## 👨‍💻 Author

**Akhil**
GitHub: https://github.com/akhil14712-debug

---

## 📄 License

This project is licensed under the MIT License.

---

Made with ❤️ by Akhil | Student Management System
```

