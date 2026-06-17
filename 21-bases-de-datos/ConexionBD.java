/**
 * ============================================================
 *  TEMA: Introducción a JDBC y Conexión
 *  SECCIÓN: 21 — Bases de Datos JDBC
 *  ARCHIVO: ConexionBD.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás cómo conectar una aplicación Java a una base de datos
 *  usando JDBC (Java Database Connectivity). Veremos cómo usar
 *  DriverManager para establecer la conexión y cómo crear una tabla.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - JDBC: API de Java para interactuar con bases de datos relacionales.
 *  - DriverManager: Clase que maneja los controladores de bases de datos.
 *  - Connection: Representa la sesión con la base de datos.
 *  - Statement: Objeto usado para ejecutar sentencias SQL estáticas.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  Connection conn = DriverManager.getConnection("jdbc:sqlite:mi_base.db");
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - No agregar el driver (JAR) al classpath del proyecto.
 *  - Olvidar cerrar la conexión (Connection) o el Statement.
 *  - Escribir incorrectamente la URL de conexión de la base de datos.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/jdbc/
 * ============================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
    public static void main(String[] args) {
        // Usaremos SQLite como ejemplo (requiere el driver SQLite JDBC en el classpath)
        // URL de conexión (si el archivo no existe, SQLite lo crea)
        String url = "jdbc:sqlite:ejemplo.db";

        // Usamos try-with-resources para asegurar que la conexión se cierre automáticamente
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("¡Conexión a la base de datos establecida exitosamente!");
                
                // Crear una tabla
                String sqlCrearTabla = "CREATE TABLE IF NOT EXISTS usuarios ("
                                     + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                     + "nombre TEXT NOT NULL,"
                                     + "email TEXT NOT NULL"
                                     + ");";
                                     
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(sqlCrearTabla);
                    System.out.println("Tabla 'usuarios' verificada/creada correctamente.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
}
