/**
 * ============================================================
 *  TEMA: Patrón de Diseño Singleton
 *  SECCIÓN: 30 — Patrones de Diseño Básicos
 *  ARCHIVO: PatronSingleton.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás cómo implementar el patrón de diseño Singleton, que
 *  garantiza que una clase tenga solo una instancia en toda la
 *  aplicación y proporciona un punto de acceso global a ella.
 *  Además, entenderás por qué frameworks como Spring lo usan por defecto.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Constructor privado para evitar la instanciación externa.
 *  - Variable estática privada para almacenar la única instancia.
 *  - Método estático público (generalmente getInstance) para obtener la instancia.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  public class Singleton {
 *      private static Singleton instancia;
 *      private Singleton() {}
 *      public static Singleton getInstance() {
 *          if (instancia == null) {
 *              instancia = new Singleton();
 *          }
 *          return instancia;
 *      }
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar hacer el constructor privado, permitiendo crear múltiples instancias.
 *  - No manejar la concurrencia en entornos multihilo (aunque en este ejemplo básico no se cubre, es crucial en la práctica).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Refactoring.guru (Singleton): https://refactoring.guru/es/design-patterns/singleton
 * ============================================================
 */

public class PatronSingleton {

    public static void main(String[] args) {
        System.out.println("--- Demostración del Patrón Singleton ---");

        // Intentar crear una instancia con 'new ConexionBaseDatos()' daría un error de compilación
        // ConexionBaseDatos conexionError = new ConexionBaseDatos(); // ¡ERROR!

        // Obteniendo la única instancia de la clase
        ConexionBaseDatos conexion1 = ConexionBaseDatos.getInstance();
        conexion1.conectar();

        // Obteniendo nuevamente la instancia
        ConexionBaseDatos conexion2 = ConexionBaseDatos.getInstance();
        conexion2.desconectar();

        // Comprobando que ambas variables apuntan al mismo objeto en memoria
        System.out.println("\n¿Son la misma instancia?");
        if (conexion1 == conexion2) {
            System.out.println("¡Sí! conexion1 y conexion2 son exactamente el mismo objeto.");
        } else {
            System.out.println("No, son instancias diferentes.");
        }
        
        System.out.println("\nNota sobre Spring Framework:");
        System.out.println("Spring utiliza el patrón Singleton por defecto para sus 'Beans'.");
        System.out.println("Esto significa que Spring crea una única instancia de cada clase gestionada,");
        System.out.println("lo que ahorra memoria y tiempo de creación de objetos, ideal para servicios sin estado.");
    }
}

class ConexionBaseDatos {
    
    // 1. Variable estática y privada que almacena la única instancia
    private static ConexionBaseDatos instancia;
    
    // 2. Constructor privado para evitar instanciación desde el exterior
    private ConexionBaseDatos() {
        System.out.println("Inicializando la conexión a la base de datos... (Esto solo debería verse una vez)");
    }
    
    // 3. Método estático público para obtener la instancia
    public static ConexionBaseDatos getInstance() {
        if (instancia == null) {
            instancia = new ConexionBaseDatos();
        }
        return instancia;
    }
    
    public void conectar() {
        System.out.println("Conectando a la base de datos...");
    }
    
    public void desconectar() {
        System.out.println("Desconectando de la base de datos...");
    }
}
