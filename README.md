# Hijos de Andres - Backend

Este repositorio contiene el backend del proyecto "Hijos de Andres" desarrollado para el hackathon ECICiencia.

## Integrantes

- Isaac David Burgos
- Juan Sebastian Puentes
- Daniel Patiño Mejia
- Tulio Riaño Sánchez

## Resumen

API REST desarrollada con Spring Boot que provee gestión de usuarios, subida/análisis de imágenes y autenticación. El proyecto integra servicios de terceros (OpenAI para análisis/etiquetado de imágenes) y persiste datos en MongoDB.

## Tecnologías principales

- Java 21
- Spring Boot 3.3.x (Web, Data MongoDB, Security)
- Spring Security (con utilidades JWT en el proyecto)
- MapStruct (mappers DTO <-> entidad)
- Lombok (reducción de boilerplate)
- MongoDB (spring-boot-starter-data-mongodb)
- Springdoc OpenAPI / Swagger UI (documentación de la API)
- Maven (gestión de dependencias y build)
- OpenAI API (integración para análisis de imágenes — la clave se configura en variables de entorno)

Las versiones exactas de dependencias están en `pom.xml`.

## Estructura principal del proyecto

- `controller/` — Controladores REST (AuthController, ImageController, UserController)
- `service/` — Lógica de negocio (AuthService, ImageService, UserService)
- `repository/` — Repositorios MongoDB
- `model/entity` — Entidades persistidas
- `model/dto` — DTOs de request/response
- `mapper/` — MapStruct mappers
- `security/` — Configuraciones y utilidades de seguridad (JWT)

## Endpoints principales

Nota: las rutas listadas reflejan los controladores actuales. Para detalles, revisar los controladores en `src/main/java/edu/hackaton/controller`.

- Autenticación
	- POST /auth/login — Login y obtención de token (AuthController)

- Usuarios
	- POST /users — Crear usuario (UserController)
	- DELETE /users/{id} — Eliminar usuario por id (UserController)

- Imágenes
	- POST /api/images/analyze — Analizar y almacenar imagen (ImageController)
	- GET /api/images/user/{userId} — Obtener imágenes por userId (ImageController)

## Documentación OpenAPI / Swagger

Swagger UI está habilitado y disponible (según `application.properties`) en:

`/swagger-ui.html`

o vía el endpoint de OpenAPI: `/v3/api-docs` (configuración por defecto de springdoc).

## Configuración y variables de entorno

No se deben poner claves ni credenciales en el repositorio. En `src/main/resources/application.properties` pueden encontrarse valores de ejemplo; asegúrate de sobrescribirlos en tu entorno.

Variables recomendadas:

- `SPRING_DATA_MONGODB_URI` o configurar `spring.data.mongodb.uri` para la conexión a MongoDB.
- `OPENAI_API_KEY` para la integración con OpenAI (si se usa el servicio de análisis de imágenes).

Ejemplo de export en Linux/macOS (zsh/bash):

```bash
export OPENAI_API_KEY="tu_api_key_aqui"
export SPRING_DATA_MONGODB_URI="mongodb://usuario:pass@host:port/db"
```

## Ejecutar la aplicación (local)

Usamos el wrapper de Maven incluido en el repositorio.

```bash
# Construir
./mvnw -DskipTests package

# Ejecutar
./mvnw spring-boot:run
```

La aplicación arrancará por defecto en el puerto 8080 (configurable en `application.properties`).

## Docker

El proyecto incluye un `Dockerfile` en la raíz del repositorio que permite construir una imagen Docker multi-stage (compila con Maven en la imagen builder y empaqueta la JAR en la imagen final basada en Temurin JRE).

Ejemplo de uso para crear y ejecutar la imagen localmente:

```bash
# Construir imagen (desde la raíz del repo)
docker build -t hijosdeandres:latest .

# Ejecutar contenedor enlazando puerto 8080
docker run -p 8080:8080 --env OPENAI_API_KEY="$OPENAI_API_KEY" --env SPRING_DATA_MONGODB_URI="$SPRING_DATA_MONGODB_URI" hijosdeandres:latest
```

Esto permite ejecutar la API en un contenedor sin necesidad de Maven instalado en la máquina de destino.

## Despliegue en Azure

Este proyecto está configurado para desplegarse automáticamente en Azure Web App mediante GitHub Actions. El workflow se encuentra en `.github/workflows/main_hijosdeandres.yml` y hace lo siguiente:

- Ejecuta tests y construye el paquete JAR con Maven.
- Sube el artefacto y usa la acción `azure/webapps-deploy@v3` para desplegar el JAR al App Service con el nombre `hijosdeandres` (slot `Production`).

El despliegue se ejecuta en pushes a las ramas `main` y `develop` (y por dispatch manual). Para que el flujo funcione es necesario configurar los secretos en el repositorio de GitHub (Settings → Secrets) que usa el workflow, por ejemplo:

- `AZUREAPPSERVICE_CLIENTID_*` (client id)
- `AZUREAPPSERVICE_TENANTID_*` (tenant id)
- `AZUREAPPSERVICE_SUBSCRIPTIONID_*` (subscription id)

Alternativamente, si prefieres desplegar como contenedor, puedes publicar la imagen en un registry (Docker Hub o Azure Container Registry) y apuntar un Azure Web App al contenedor resultante.

## Notas de seguridad

- Nunca comites claves ni credenciales. En `application.properties` pueden verse valores de ejemplo: elimínalos o movelos a variables de entorno.
- Hay utilidades de JWT en el proyecto (`security/JwtUtil.java`) y la configuración de seguridad está en `security/SecurityConfig.java`. Actualmente la configuración permite todas las peticiones (`permitAll`) — revisar y activar las reglas necesarias para producción.

## Tests

Si existen tests (ver `src/test`), se pueden ejecutar con:

```bash
./mvnw test
```

## Desarrollo y contribuciones

- MapStruct y Lombok usan procesado de anotaciones; el `mvnw` configurado ya incluye los procesadores. Si añades mappers, asegúrate de compilar para generar las implementaciones.
- Abrir issues o PRs para cambios.

## Contacto

Para dudas técnicas dentro del equipo, contactar a los integrantes listados arriba.

---

README generado automáticamente y actualizado con la información disponible en el repositorio.
