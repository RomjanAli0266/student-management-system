# Employee Management System

A secure and scalable **Employee Management System** built using **Java, Spring Boot, Spring Security, JWT, JPA/Hibernate, and MySQL**. The application provides REST APIs for managing employees with authentication, role-based authorization, validation, pagination, sorting, searching, and centralized exception handling.

## 🚀 Features

* 🔐 JWT-based authentication and authorization
* 👤 User registration and login
* 🛡️ Role-based access control (`ADMIN`, `USER`)
* 👨‍💼 Employee CRUD operations
* 🔎 Employee search and filtering
* 📄 Pagination
* ↕️ Sorting
* ✅ Request validation
* ⚠️ Global exception handling
* 📚 Swagger/OpenAPI documentation
* 🗄️ MySQL database integration
* 🔒 Protected REST APIs

## 🛠️ Technologies Used

| Technology        | Purpose                        |
| ----------------- | ------------------------------ |
| Java 21           | Programming Language           |
| Spring Boot       | Backend Framework              |
| Spring Security   | Authentication & Authorization |
| JWT               | Token-based Authentication     |
| Spring Data JPA   | Database Access                |
| Hibernate         | ORM                            |
| MySQL             | Database                       |
| Maven             | Dependency Management          |
| Swagger / OpenAPI | API Documentation              |
| Postman           | API Testing                    |
| Git & GitHub      | Version Control                |

## 📂 Project Structure

```text
employee-management
│
├── src
│   └── main
│       ├── java
│       │   └── com.example.employee_management
│       │       ├── controller
│       │       ├── service
│       │       ├── repository
│       │       ├── entity
│       │       ├── dto
│       │       ├── mapper
│       │       ├── security
│       │       └── exception
│       │
│       └── resources
│           └── application.properties
│
├── pom.xml
└── README.md
```

## 🗄️ Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE employeedb;
```

Configure your database connection in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employeedb
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> Replace `YOUR_USERNAME` and `YOUR_PASSWORD` with your local MySQL credentials.

## ▶️ How to Run

### 1. Clone the repository

```bash
git clone https://github.com/RomjanAli0266/employee-management.git
```

### 2. Open the project

Open the project in IntelliJ IDEA, Eclipse, or VS Code.

### 3. Configure MySQL

Make sure MySQL is running and create the `employeedb` database.

### 4. Update database credentials

Edit:

```text
src/main/resources/application.properties
```

### 5. Run the application

Using Maven:

```bash
mvn spring-boot:run
```

Or run the main Spring Boot application class from your IDE.

The application will start at:

```text
http://localhost:8080
```

## 🔐 Authentication

The application uses **JWT authentication**.

### Register

```http
POST /auth/register
```

Example request:

```json
{
  "username": "admin",
  "password": "password123",
  "role": "ADMIN"
}
```

### Login

```http
POST /auth/login
```

Example:

```json
{
  "username": "admin",
  "password": "password123"
}
```

After successful login, the server returns a JWT token.

Use the token in protected requests:

```http
Authorization: Bearer <JWT_TOKEN>
```

## 👨‍💼 Employee APIs

### Create Employee

```http
POST /employees
```

### Get All Employees

```http
GET /employees
```

### Get Employee by ID

```http
GET /employees/{id}
```

### Update Employee

```http
PUT /employees/{id}
```

### Delete Employee

```http
DELETE /employees/{id}
```

### Search Employees

The application supports employee searching/filtering based on available fields such as:

* Name
* Department

### Pagination & Sorting

Example:

```http
GET /employees?page=0&size=5&sortBy=id&direction=asc
```

Supported sorting fields include:

```text
id
name
email
salary
designation
department
```

## 🧾 Employee Example

```json
{
  "name": "Rahul Kumar",
  "email": "rahul@example.com",
  "salary": 45000,
  "designation": "Software Developer",
  "department": "IT"
}
```

## 🛡️ Authorization

Different operations are protected using role-based authorization.

| Role            | Access                               |
| --------------- | ------------------------------------ |
| ADMIN           | Full employee management access      |
| USER            | Authorized user-level operations     |
| Unauthenticated | Public authentication endpoints only |

Unauthorized requests return:

```text
401 Unauthorized
```

Requests from authenticated users without sufficient permissions return:

```text
403 Forbidden
```

## ✅ Validation

Employee requests are validated using Jakarta Bean Validation.

Examples:

```java
@NotBlank
@Email
@Positive
```

Invalid requests are handled centrally using the application's global exception handler.

## 📚 API Documentation

Swagger/OpenAPI is integrated into the project for API documentation and testing.

After starting the application, open the Swagger UI URL configured by the project.

## 🧪 Testing

The REST APIs were tested using **Postman**.

Testing includes:

* Registration
* Login
* JWT authentication
* Employee creation
* Employee retrieval
* Employee update
* Employee deletion
* Search
* Pagination
* Sorting
* Validation
* Unauthorized requests
* Role-based authorization

## 🌐 Frontend — EmployeeHub

A professional frontend named **EmployeeHub** is being developed using:

* React
* TypeScript
* Vite
* TSX

The frontend is designed to consume the Spring Boot REST APIs.

Planned/implemented screens include:

* Login
* Dashboard
* Employee Directory
* Add Employee
* Edit Employee
* Employee Details
* Settings

Frontend development server:

```text
http://localhost:5173
```

Backend:

```text
http://localhost:8080
```

## 🔮 Future Improvements

* Employee profile pictures
* Advanced dashboard analytics
* Salary statistics
* Department-wise employee reports
* Export employee data to Excel/PDF
* Email notifications
* Refresh token implementation
* Docker deployment
* Cloud deployment
* Production database configuration

## 👨‍💻 Author

**Romjan Ali**

B.Tech Computer Science & Engineering

GitHub: `RomjanAli0266`

## 📄 License

This project is created for educational, portfolio, and learning purposes.
