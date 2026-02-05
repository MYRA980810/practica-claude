# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build and Run Commands

```bash
# Build and install dependencies
./mvnw clean install

# Run the application (starts on http://localhost:8080)
./mvnw spring-boot:run

# Run all tests
./mvnw test

# Run a single test class
./mvnw test -Dtest=CrudSpringWebJpaApplicationTests

# Package as JAR
./mvnw clean package
```

## Database Setup

MySQL database required:
- Database: `db_jpa_crud`
- Port: 3306
- Credentials configured in `src/main/resources/application.properties`

## Architecture

This is a Spring Boot 4.0.1 REST API for product CRUD operations following a layered architecture:

```
Controller (ProductController) → Service (ServicesRepositoryImpl) → Repository (ProductRepository) → Entity (Product)
```

**Key Architectural Components:**

- **DTOs with MapStruct**: Request/response separation using `ProductRequest`, `ProductResponse`, `ProductUpdateResponse`. The `ProductMapper` interface handles entity-DTO conversions.

- **Custom Validation**: Jakarta validation with custom annotations in `/validation`:
  - `@IsRequirer` - validates description is not empty
  - `@IsExixtsDb` - validates SKU uniqueness in database

- **Global Exception Handling**: `GlobalExceptionHandler` provides centralized error responses with i18n support.

- **Internationalization**: Spanish locale by default. Messages defined in `src/main/resources/messages.properties`. Locale resolved via HTTP Accept-Language header.

## API Endpoints

Base path: `/api/products`

| Method | Path | Purpose |
|--------|------|---------|
| GET | / | List all products |
| GET | /{id} | Get product by ID |
| POST | / | Create product |
| PATCH | /{id} | Partial update product |
| DELETE | /{id} | Delete product |

## Validation Rules

**ProductRequest (Create):**
- name: required, 3-20 characters
- price: required, minimum 500
- description: required (custom validator)
- sku: must be unique in database

**ProductUpdateResponse (PATCH):**
- All fields optional, same constraints apply when provided

## Code Style

- Use comments sparingly. Only comment complex code.
