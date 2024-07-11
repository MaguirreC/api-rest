# API Rest de Alura Cursos

Este proyecto es una API RESTful para la gestión de tópicos y respuestas en cursos de Alura. Está construido utilizando Spring Boot, JPA y JWT para la autenticación.

## Funcionalidades

- **Usuarios**: Autenticación y generación de tokens JWT.
- **Cursos**: Gestión de cursos.
- **Tópicos**: CRUD de tópicos relacionados con cursos.
- **Respuestas**: CRUD de respuestas relacionadas con tópicos.

## Tecnologías Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT
- H2 Database (para desarrollo y pruebas)
- Maven

## Estructura del Proyecto

- **Controllers**: Controladores que manejan las solicitudes HTTP.
- **Services**: Lógica de negocio.
- **Repositories**: Acceso a datos y operaciones de base de datos.
- **Domain**: Entidades del modelo de datos.
- **Infra**: Configuraciones de seguridad y JWT.

## Endpoints

### Autenticación

- **POST /login**: Autentica un usuario y devuelve un token JWT.

### Tópicos

- **GET /topicos**: Obtiene una lista paginada de todos los tópicos.
- **GET /topicos/{id}**: Obtiene un tópico por su ID.
- **POST /topicos**: Crea un nuevo tópico.
- **PUT /topicos/{id}**: Actualiza un tópico existente.
- **DELETE /topicos/{id}**: Elimina un tópico por su ID.

### Respuestas

- **GET /respuestas/{id}**: Obtiene una respuesta por su ID.
- **POST /respuestas**: Crea una nueva respuesta.
- **PUT /respuestas/{id}**: Actualiza una respuesta existente.
- **DELETE /respuestas/{id}**: Elimina una respuesta por su ID.

## Configuración

### Base de Datos

El proyecto utiliza H2 Database para desarrollo y pruebas. La configuración se encuentra en `src/main/resources/application.properties`.

### Seguridad

La seguridad está configurada en `com.example.aluracursos.api_rest.infra.security.SecurityConfigurations`. Utiliza JWT para la autenticación y autorización.

## Ejemplos de JSON

### Crear Tópico

json
{
    "titulo": "Nuevo Tópico",
    "mensaje": "Este es el mensaje del nuevo tópico",
    "fechaCreacion": "2024-07-03T10:00:00",
    "autor": "Nombre del Autor",
    "nombreCurso": "spring 1"
}

## Ejecucion
### Prerrequisitos
- Java 17 o superior
- Maven

### Clonar  repositorio
git clone https://github.com/MaguirreC/api-rest.git

### Compliar proyecto
- mvn clean install

### Ejecutar aplicacion
- mvn spring-boot:run


## Autor

- Desarollado por michael aguirre(https://github.com/MaguirreCap)


