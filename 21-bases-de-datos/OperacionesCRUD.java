/**
 * ============================================================
 *  TEMA: Operaciones CRUD y PreparedStatement
 *  SECCIÓN: 21 — Bases de Datos JDBC
 *  ARCHIVO: OperacionesCRUD.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás a realizar operaciones CRUD (Crear, Leer, Actualizar,
 *  Eliminar) utilizando PreparedStatement, lo cual previene ataques
 *  de inyección SQL y mejora el rendimiento. También verás cómo
 *  leer resultados usando ResultSet.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - PreparedStatement: Sentencia SQL precompilada que acepta parámetros.
 *  - Inyección SQL: Vulnerabilidad de seguridad prevenida al usar parámetros (?).
 *  - ResultSet: Estructura de datos que almacena el resultado de una consulta (SELECT).
 *  - executeUpdate(): Método para INSERT, UPDATE, DELETE.
 *  - executeQuery(): Método para SELECT.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tabla (col) VALUES (?)");
 *  pstmt.setString(1, "valor");
 *  pstmt.executeUpdate();
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Intentar leer datos de un ResultSet sin llamar a next() primero.
 *  - Confundir el índice de los parámetros (empiezan en 1, no en 0).
 *  - Usar concatenación de strings para formar sentencias SQL en lugar de PreparedStatement.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html
 * ============================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OperacionesCRUD {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:ejemplo.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            // Asegurarse de que la tabla exista
            crearTabla(conn);
            
            // C: Create (Insertar)
            insertarUsuario(conn, "Juan Perez", "juan@example.com");
            insertarUsuario(conn, "Ana Lopez", "ana@example.com");
            
            // R: Read (Leer)
            System.out.println("--- Usuarios después de insertar ---");
            leerUsuarios(conn);
            
            // U: Update (Actualizar)
            actualizarEmailUsuario(conn, 1, "juan.perez@nuevo.com");
            
            System.out.println("--- Usuarios después de actualizar ---");
            leerUsuarios(conn);
            
            // D: Delete (Eliminar)
            eliminarUsuario(conn, 2);
            
            System.out.println("--- Usuarios después de eliminar ---");
            leerUsuarios(conn);

        } catch (SQLException e) {
            System.out.println("Error de base de datos: " + e.getMessage());
        }
    }
    
    /**
     * Crea la tabla de prueba si no existe.
     * @param conn Conexión activa a la base de datos
     */
    private static void crearTabla(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios ("
                   + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                   + "nombre TEXT NOT NULL,"
                   + "email TEXT NOT NULL"
                   + ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    /**
     * Inserta un nuevo usuario en la base de datos.
     * @param conn Conexión activa a la base de datos
     * @param nombre Nombre del usuario
     * @param email Correo electrónico del usuario
     */
    private static void insertarUsuario(Connection conn, String nombre, String email) throws SQLException {
        String sql = "INSERT INTO usuarios(nombre, email) VALUES(?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            System.out.println("Usuario insertado: " + nombre);
        }
    }

    /**
     * Lee y muestra todos los usuarios en la consola.
     * @param conn Conexión activa a la base de datos
     */
    private static void leerUsuarios(Connection conn) throws SQLException {
        String sql = "SELECT id, nombre, email FROM usuarios";
        
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
             
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + 
                                   "\tNombre: " + rs.getString("nombre") + 
                                   "\tEmail: " + rs.getString("email"));
            }
        }
    }

    /**
     * Actualiza el correo electrónico de un usuario existente.
     * @param conn Conexión activa a la base de datos
     * @param id Identificador del usuario a modificar
     * @param nuevoEmail El nuevo correo electrónico
     */
    private static void actualizarEmailUsuario(Connection conn, int id, String nuevoEmail) throws SQLException {
        String sql = "UPDATE usuarios SET email = ? WHERE id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nuevoEmail);
            pstmt.setInt(2, id);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Email actualizado para el ID: " + id);
            }
        }
    }

    /**
     * Elimina un usuario de la base de datos.
     * @param conn Conexión activa a la base de datos
     * @param id Identificador del usuario a eliminar
     */
    private static void eliminarUsuario(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Usuario eliminado con ID: " + id);
            }
        }
    }
}
