# Proyecto CRUD Relacionado con Spring Boot

## Descripción
Este proyecto implementa un CRUD completo para dos tablas relacionadas (**Alumno** y **Curso**) usando Spring Boot, JPA y base de datos H2 en memoria. También incluye servicios REST y pruebas con Postman.

## Tecnologías utilizadas
- Java 17 o superior
- Spring Boot 3.x
- Spring Data JPA
- Base de datos H2 (en memoria)
- Maven

## Requisitos previos
- Tener instalado Java JDK 17 o superior
- Tener instalado Maven
- (Opcional) IDE como IntelliJ IDEA para abrir y modificar el proyecto
- (Opcional) Postman para probar los endpoints REST

## Instrucciones para clonar y ejecutar

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/Vania-0731/crud-relacionado.git
   cd crud-relacionado
   ```

2. Ejecutar la aplicación con Maven:
   ```bash
   mvn spring-boot:run
   ```

   O para generar el archivo jar y ejecutarlo:
   ```bash
   mvn clean package
   java -jar target/crud-relacionado-0.0.1-SNAPSHOT.jar
   ```

   Si usa IntelliJ IDEA, también puede ejecutar el proyecto directamente haciendo clic en **Run**.

3. La aplicación correrá por defecto en:
   ```
   http://localhost:8080
   ```

## Endpoints principales disponibles

### Alumno
- `GET    /alumnos`            : Listar todos los alumnos
- `GET    /alumnos/{id}`       : Obtener alumno por ID
- `POST   /alumnos`            : Crear nuevo alumno
- `PUT    /alumnos/{id}`       : Actualizar alumno existente
- `DELETE /alumnos/{id}`       : Eliminar alumno

### Curso
- `GET    /cursos`             : Listar todos los cursos
- `GET    /cursos/{id}`        : Obtener curso por ID
- `POST   /cursos`             : Crear nuevo curso
- `PUT    /cursos/{id}`        : Actualizar curso existente
- `DELETE /cursos/{id}`        : Eliminar curso

## Pruebas
Para probar los endpoints, puede usar **Postman** o cualquier cliente HTTP.

## Notas
- El proyecto crea automáticamente las tablas en la base de datos al iniciar.

---

Gracias por su atención.

