# Sección 21: Bases de Datos JDBC

Esta sección introduce los conceptos fundamentales para conectar y manipular bases de datos desde aplicaciones Java utilizando JDBC (Java Database Connectivity).

## Archivos en esta sección:

1. **ConexionBD.java**:
   - Introducción a JDBC y al uso de `DriverManager`.
   - Establecimiento de conexiones con bases de datos (usando SQLite como ejemplo conceptual).
   - Creación de tablas mediante sentencias SQL estándar usando la clase `Statement`.

2. **OperacionesCRUD.java**:
   - Cómo realizar operaciones CRUD completas (Create, Read, Update, Delete).
   - Uso de `PreparedStatement` para mejorar el rendimiento y prevenir inyección SQL.
   - Procesamiento de resultados obtenidos mediante sentencias SELECT usando `ResultSet`.

3. **Transacciones.java**:
   - Gestión de transacciones para asegurar la integridad de los datos.
   - Modificación del comportamiento por defecto usando `setAutoCommit(false)`.
   - Implementación de un bloque `try-catch` para manejar `commit()` (confirmar cambios) o `rollback()` (deshacer cambios en caso de error).

## ¿Cómo usar estos ejemplos?

Para ejecutar estos archivos y probar la conexión real, asegúrate de tener el driver JDBC de la base de datos en tu *classpath*. Por defecto, los ejemplos están diseñados para usar **SQLite** debido a su simplicidad (no requiere un servidor separado), por lo que necesitarás descargar y añadir la librería `sqlite-jdbc` a tu proyecto, o configurar tu herramienta de construcción (como Maven o Gradle) para incluir la dependencia.
