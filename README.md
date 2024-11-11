# 🌮 Tienda de Tacos - Proyecto de Spring Boot

Este proyecto es una aplicación web de una tienda de tacos en la que los usuarios pueden diseñar sus propios tacos eligiendo entre una variedad de ingredientes. Basado en *Spring in Action*, el proyecto utiliza Spring Boot y Thymeleaf para crear una experiencia de diseño de tacos con operaciones de orden.

## Funcionalidades Principales

- **Diseñar Tacos**: Los usuarios pueden seleccionar ingredientes para crear sus propios tacos personalizados.
- **Gestión de Ordenes**: Los usuarios pueden enviar y confirmar órdenes de tacos, que se almacenan en una base de datos.
- **Validación de Ordenes**: Las órdenes se validan antes de ser procesadas para asegurar la integridad de los datos.
- **Sesión del Usuario**: La aplicación usa sesiones para almacenar temporalmente las órdenes hasta que el usuario las confirme.

## Endpoints de la Aplicación

### Controlador de Diseño de Tacos (`DesignTacoController`)
- `GET /design`: Muestra el formulario de diseño de tacos, donde el usuario puede elegir entre varios ingredientes.
- `POST /design`: Procesa el diseño del taco creado por el usuario y lo guarda en la orden actual.

### Controlador de Ordenes (`OrderController`)
- `GET /orders/current`: Muestra el formulario para completar la orden, donde el usuario revisa su pedido.
- `POST /orders`: Procesa la orden y la guarda en la base de datos, completando la sesión del usuario.

## Tecnologías Utilizadas

- **Java 17**: Lenguaje de programación principal.
- **Spring Boot**: Framework para simplificar la creación de aplicaciones web.
- **Thymeleaf**: Motor de plantillas para generar vistas dinámicas en el lado del servidor.
- **Lombok**: Para reducir el código repetitivo, como getters, setters y el registro de logs (`@Slf4j`).
- **Validación de Datos**: Uso de anotaciones para validar los datos de los tacos y las órdenes.

## Estructura de la Base de Datos

La base de datos almacena dos tipos principales de información:
- **Ingredientes**: Cada ingrediente tiene un tipo (ej. "Carne", "Verduras", "Salsas") y un identificador único.
- **Ordenes**: Cada orden contiene una lista de tacos personalizados y detalles del pedido.

## Cómo Ejecutar el Proyecto

1. Clona este repositorio.
2. Asegúrate de tener **Java 17** y **Maven** instalados.
3. Ejecuta el comando `mvn spring-boot:run` en la raíz del proyecto.
4. Accede a la aplicación en [http://localhost:8080/design](http://localhost:8080/design) para comenzar a diseñar tus tacos.

---

¡Disfruta creando tus tacos personalizados! 🌮
