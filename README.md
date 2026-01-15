# Order-Management-System
Spring Boot REST API demonstrating JPA relationships (One-to-Many &amp; Many-to-Many) using DTO-based responses, transactional service layer, and clean architecture. Includes User–Order–Product domain with Postman-testable APIs.


# Spring Boot User–Order–Product Management API

This project is a Spring Boot REST API that demonstrates **JPA entity relationships**, **DTO-based API responses**, and **transactional service-layer design**.

It covers:
- One-to-Many relationship (User → Orders)
- Many-to-Many relationship (Orders ↔ Products)
- DTO mapping to avoid infinite JSON recursion
- Proper use of `@Transactional` for lazy-loaded relationships

This project is designed for **learning, practice, and interview preparation**.

---

## 🛠 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Lombok
- Maven
- Postman (for API testing)

---

## 📦 Domain Model

- **User**
  - Can place multiple orders
- **Order**
  - Belongs to one user
  - Can contain multiple products
- **Product**
  - Can be part of multiple orders

---

## 🔗 Entity Relationships

- `User → Orders` : One-to-Many
- `Orders ↔ Products` : Many-to-Many

---

## 📂 Project Structure

src/main/java
├── controller
├── service
├── repository
├── entity
├── dto


---

## 🗄 Database Setup (MySQL)

### 1️⃣ Create Database

```sql
CREATE DATABASE order_management;
USE order_management;

## 📦 Dependencies Used

- Spring Boot Starter Web  
- Spring Boot Starter Data JPA  
- MySQL Connector/J  
- Lombok  
- Spring Boot Starter Validation

## 📦 Dependencies Used

- **spring-boot-starter-web** – For building REST APIs
- **spring-boot-starter-data-jpa** – For database access using JPA & Hibernate
- **mysql-connector-j** – MySQL database connectivity
- **lombok** – Reduces boilerplate code (getters, setters, constructors)
- **spring-boot-starter-validation** – Input validation support
