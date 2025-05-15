# 🐾 Backend - Aplicación de Mascotas Virtuales (Spring Boot WebFlux)

Este repositorio contiene el backend de una aplicación de **mascotas virtuales** desarrollada en **Java con Spring Boot** utilizando programación **reactiva (WebFlux)** y una base de datos **MongoDB** o **MySQL**. Proporciona una API REST para gestionar mascotas virtuales, con funciones de creación, lectura, actualización y eliminación.

## ⚙️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring WebFlux** (programación reactiva)
- **MongoDB** (reactivo) o **MySQL** (R2DBC)
- **Spring Data Reactive**
- **Lombok**
- **Swagger OpenAPI**
- **JUnit 5 + Mockito**
- **DevTools** (para recarga en caliente)

---

## 📦 Estructura del Proyecto

src/
├── main/
│ ├── java/
│ │ └── com/tuusuario/pets/
│ │ ├── controller/ # Controladores REST
│ │ ├── model/ # Clases de dominio (Pet, etc.)
│ │ ├── repository/ # Interfaces de acceso a datos
│ │ ├── service/ # Lógica de negocio
│ │ ├── config/ # Configuración WebFlux o Mongo/MySQL
│ │ └── exception/ # Manejo de errores globales
│ └── resources/
│ ├── application.yml # Configuración de la aplicación
└── test/ # Pruebas unitarias
---
## 🚀 Funcionalidades de la API

| Método | Endpoint       | Descripción                  |
|--------|----------------|------------------------------|
| GET    | `/api/pets`    | Obtener todas las mascotas   |
| GET    | `/api/pets/{id}` | Obtener una mascota por ID  |
| POST   | `/api/pets`    | Crear una nueva mascota      |
| PUT    | `/api/pets/{id}` | Actualizar una mascota      |
| DELETE | `/api/pets/{id}` | Eliminar una mascota        |

---

## 🔧 Configuración del entorno

### Requisitos

- Java 17+
- Maven 3+
- MongoDB o MySQL en ejecución

### Configuración `application.yml`

#### MongoDB (modo reactivo)
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/petsdb
MySQL (modo R2DBC)
spring:
  r2dbc:
    url: r2dbc:mysql://localhost:3306/petsdb
    username: root
    password: tu_clave
  sql:
    init:
      mode: always
⚠️ Asegúrate de tener el conector R2DBC correcto en el pom.xml si usas MySQL
<dependency>
  <groupId>dev.miku</groupId>
  <artifactId>r2dbc-mysql</artifactId>
  <version>0.8.2.RELEASE</version>
</dependency>
▶️ Ejecutar el proyecto
./mvnw spring-boot:run
La API estará disponible en:
http://localhost:8080/api/pets
Swagger UI estará en:
http://localhost:8080/swagger-ui.html
🧪 Pruebas
./mvnw test
Se incluye un conjunto de pruebas unitarias con JUnit 5 y Mockito para los servicios y controladores.

✅ Buenas prácticas implementadas
Separación en capas: controller, service, repository

Manejo de excepciones global con @ControllerAdvice

Validaciones con anotaciones @Valid

Respuestas reactivas (Mono y Flux)

Documentación automática con Swagger

Código limpio con Lombok

📬 Contacto
Desarrollado por [Tu nombre o alias]
🔗 YouTube - deimus _23

📝 Licencia
Este proyecto está bajo la Licencia MIT. Puedes usarlo, modificarlo y compartirlo libremente.


