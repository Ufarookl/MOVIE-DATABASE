# 🎬 Movie CRUD API - Spring Boot

A simple yet enterprise-style Movie CRUD (Create, Read, Update, Delete) REST API built using Spring Boot, Spring Data JPA, and MySQL.

---

## 🚀 Features

* Add new movies
* Get all or specific movies
* Update movie details
* Delete movies
* Filter movies by genre or language
* Pagination support
* Centralized exception handling
* DTO and Mapper layers for clean separation

---

## 🧰 Tech Stack

* Java 17
* Spring Boot 3.x
* Spring Data JPA
* MySQL
* Lombok
* Swagger (OpenAPI) - for API documentation

---

## 📁 Project Structure

```
com.example.movieapi
├── controller      --> REST APIs
├── dto             --> MovieDTO class
├── exception       --> Custom exceptions & handler
├── mapper          --> Entity <-> DTO conversion
├── model           --> JPA Movie entity
├── repository      --> MovieRepository (JPA)
├── service         --> Service interface
├── serviceImpl     --> Business logic
└── MovieApiApplication.java
```

---

## 📦 Setup Instructions

### ✅ Prerequisites:

* Java 17
* Maven
* MySQL running locally (default port 3306)

### ⚙️ Configure `application.properties`

Update your DB credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/moviedb
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 🔨 Build & Run

```bash
mvn clean install
mvn spring-boot:run
```

---

## 🔗 API Endpoints

### ➕ Add Movie

`POST /api/movies`

```json
{
  "title": "Inception",
  "genre": "Sci-Fi",
  "language": "English",
  "director": "Christopher Nolan",
  "releaseYear": 2010,
  "durationMinutes": 148,
  "description": "A mind-bending thriller"
}
```

### 📄 Get All Movies

`GET /api/movies`

### 🔍 Get Movie by ID

`GET /api/movies/{id}`

### 🎭 Get Movies by Genre

`GET /api/movies/genre/{genre}`

### 🌐 Get Movies by Language

`GET /api/movies/language/{language}`

### 📑 Paginated Movies

`GET /api/movies/paginated?page=0&size=5&sortBy=title`

### ✏️ Update Movie

`PUT /api/movies/{id}`

* Request body: same as `POST`

### ❌ Delete Movie

`DELETE /api/movies/{id}`

---

## 📘 Swagger UI

After running the application, access:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🐛 Exception Handling

Handled via `@ControllerAdvice`:

* `ResourceNotFoundException` → 404
* Generic exceptions → 500

---

## 📥 Add to Git Repository

### Step-by-step:

```bash
git init
git add .
git commit -m "Initial commit: Movie CRUD API"
git remote add origin https://github.com/your-username/MOVIE-DATABASE.git
git branch -M main
git push -u origin main
```

---

## ✍️ Author

**Umar Farook**

---

## 📄 License

This project is licensed under the MIT License.

Happy coding...❤️❤️
