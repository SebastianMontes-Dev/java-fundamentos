/**
 * ============================================================
 *  TEMA: Gestión de Transacciones en JDBC
 *  SECCIÓN: 29 — Bases de Datos JDBC
 *  ARCHIVO: Transacciones.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás a manejar transacciones en base de datos. Las transacciones
 *  permiten agrupar múltiples operaciones SQL en una sola unidad lógica,
 *  garantizando que todas se completen exitosamente (commit) o que ninguna
 *  se aplique si ocurre un error (rollback).
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Auto-commit: Por defecto, cada sentencia en JDBC es una transacción automática.
 *  - setAutoCommit(false): Desactiva el guardado automático para iniciar una transacción manual.
 *  - commit(): Confirma y guarda los cambios de la transacción actual.
 *  - rollback(): Deshace todos los cambios desde el inicio de la transacción si hay error.
 *  - ACID: Propiedades de las transacciones (Atomicidad, Consistencia, Aislamiento, Durabilidad).
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  conn.setAutoCommit(false);
 *  try {
 *      // operaciones SQL
 *      conn.commit();
 *  } catch(SQLException e) {
 *      conn.rollback();
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar llamar a commit() después de deshabilitar auto-commit (los cambios no se guardan).
 *  - No incluir un bloque catch con rollback() para restaurar el estado en caso de error.
 *  - Dejar la conexión con auto-commit desactivado si se va a devolver a un pool de conexiones.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/jdbc/basics/transactions.html
 * ============================================================
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Transacciones {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:ejemplo.db";

        // Usamos try-with-resources para cerrar la conexión automáticamente
        try (Connection conn = DriverManager.getConnection(url)) {
            
            // Preparar el entorno (crear y limpiar tabla de cuentas)
            prepararTablaCuentas(conn);
            
            System.out.println("Iniciando transferencia bancaria...");
            
            // Variables para la transacción
            int idCuentaOrigen = 1; // Saldo inicial: 1000
            int idCuentaDestino = 2; // Saldo inicial: 500
            double montoATransferir = 200.0;

            // 1. Desactivar auto-commit para iniciar la transacción
            conn.setAutoCommit(false);
            
            String sqlRestar = "UPDATE cuentas SET saldo = saldo - ? WHERE id = ?";
            String sqlSumar = "UPDATE cuentas SET saldo = saldo + ? WHERE id = ?";
            
            try (PreparedStatement pstmtRestar = conn.prepareStatement(sqlRestar);
                 PreparedStatement pstmtSumar = conn.prepareStatement(sqlSumar)) {
                 
                // Paso 1: Restar dinero de la cuenta origen
                pstmtRestar.setDouble(1, montoATransferir);
                pstmtRestar.setInt(2, idCuentaOrigen);
                pstmtRestar.executeUpdate();
                
                // Simulamos un error inesperado a la mitad del proceso
                // (descomenta la siguiente línea para ver cómo actúa el rollback)
                // if (true) throw new SQLException("Error simulado de red o base de datos");
                
                // Paso 2: Sumar dinero a la cuenta destino
                pstmtSumar.setDouble(1, montoATransferir);
                pstmtSumar.setInt(2, idCuentaDestino);
                pstmtSumar.executeUpdate();
                
                // 2. Si todo sale bien, confirmar los cambios
                conn.commit();
                System.out.println("¡Transferencia exitosa! Cambios guardados (commit).");
                
            } catch (SQLException e) {
                // 3. Si ocurre algún error, deshacer todos los cambios de la transacción
                System.out.println("Error en la transferencia. Deshaciendo cambios (rollback)...");
                conn.rollback();
                System.out.println("Detalle del error: " + e.getMessage());
            } finally {
                // Es buena práctica restaurar el estado original de la conexión
                conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
    
    /**
     * Crea la tabla de cuentas y añade datos iniciales de prueba.
     * @param conn Conexión activa a la base de datos
     */
    private static void prepararTablaCuentas(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS cuentas ("
                       + "id INTEGER PRIMARY KEY,"
                       + "titular TEXT NOT NULL,"
                       + "saldo REAL NOT NULL"
                       + ");");
            
            // Limpiar datos previos y colocar valores fijos
            stmt.execute("DELETE FROM cuentas;");
            stmt.execute("INSERT INTO cuentas (id, titular, saldo) VALUES (1, 'Cuenta A', 1000.0);");
            stmt.execute("INSERT INTO cuentas (id, titular, saldo) VALUES (2, 'Cuenta B', 500.0);");
        }
    }
}
