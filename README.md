# Project Refactoring Documentation

The project has been refactored to utilize Enterprise JavaBeans (EJB) and a more standardized repository pattern. Here are the key changes made:

## 1. Repository Layer
- Implemented `AbstractCrudRepository` as the base class for all repositories
- Created specialized repositories:
  - `ClienteCrudRepository`
  - `ProductoCrudRepository`
  - `VentaCrudRepository`
  - `DetalleCrudRepository`
- Each repository extends `AbstractCrudRepository` and implements specific find methods as needed

## 2. Service Layer
- Converted services to stateless EJBs using `@Stateless` annotation
- Updated service implementations to use the new CrudRepository classes
- Removed direct EntityManager usage in favor of repository methods
- Maintained transaction management using `@Transactional`

## 3. Controller Layer
- Updated controllers to use `@EJB` instead of `@Inject` for service dependencies
- Maintained ViewScoped beans for proper state management
- Added serialVersionUID to controllers

## 4. View Layer
- Implemented a template-based layout system
- Created a global navigation menu
- Added CSS styling for consistent look and feel
- Views are organized by feature:
  - /views/cliente/
  - /views/producto/
  - /views/venta/

## Dependencies
- Jakarta EE 9+
- PrimeFaces
- CDI
- EJB
- JPA