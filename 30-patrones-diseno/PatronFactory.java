/**
 * ============================================================
 *  TEMA: Patrón de Diseño Factory Method
 *  SECCIÓN: 30 — Patrones de Diseño Básicos
 *  ARCHIVO: PatronFactory.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás a implementar el patrón Factory Method (Método de Fábrica).
 *  Este patrón creacional proporciona una interfaz para crear objetos en una
 *  superclase o interfaz, pero permite que las subclases alteren el tipo
 *  de objetos que se crearán, delegando la lógica de instanciación.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Interfaz o Clase Abstracta que define el comportamiento común (Producto).
 *  - Clases Concretas que implementan la interfaz (Productos Concretos).
 *  - Clase Fábrica (Creator) con un método que encapsula la lógica para instanciar objetos.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  public class Fabrica {
 *      public static Producto crearProducto(String tipo) {
 *          if (tipo.equals("A")) return new ProductoA();
 *          else return new ProductoB();
 *      }
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Crear una fábrica demasiado compleja con cientos de condiciones 'if-else' o 'switch'.
 *  - Usar una fábrica cuando una instanciación simple con 'new' es suficiente.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Refactoring.guru (Factory Method): https://refactoring.guru/es/design-patterns/factory-method
 * ============================================================
 */

import java.util.Scanner;

public class PatronFactory {

    public static void main(String[] args) {
        System.out.println("--- Demostración del Patrón Factory Method ---");
        
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Qué tipo de notificación deseas enviar? (1: Email, 2: SMS, 3: Push): ");
        int opcion = sc.nextInt();
        
        try {
            // Usamos la fábrica para crear la notificación en lugar de instanciarla directamente con 'new'
            Notificacion notificacion = NotificacionFactory.crearNotificacion(opcion);
            
            // Usamos la interfaz común sin preocuparnos de qué clase concreta estamos utilizando
            notificacion.enviarMensaje("¡Hola! Este es un mensaje de prueba utilizando el patrón Factory.");
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

// 1. Interfaz común (Producto)
interface Notificacion {
    /**
     * Envía un mensaje a través del medio de notificación.
     * @param mensaje El contenido a enviar.
     */
    void enviarMensaje(String mensaje);
}

// 2. Implementaciones concretas (Productos Concretos)
class NotificacionEmail implements Notificacion {
    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("[EMAIL] Enviando correo: " + mensaje);
    }
}

class NotificacionSMS implements Notificacion {
    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("[SMS] Enviando mensaje de texto: " + mensaje);
    }
}

class NotificacionPush implements Notificacion {
    @Override
    public void enviarMensaje(String mensaje) {
        System.out.println("[PUSH] Enviando notificación a la app: " + mensaje);
    }
}

// 3. Clase Fábrica (Creator)
class NotificacionFactory {
    /**
     * Crea y devuelve una instancia concreta de Notificacion basada en el tipo solicitado.
     * 
     * @param tipo El identificador numérico del tipo de notificación.
     * @return Una instancia de una clase que implementa Notificacion.
     * @throws IllegalArgumentException si el tipo no es válido.
     */
    public static Notificacion crearNotificacion(int tipo) {
        switch (tipo) {
            case 1:
                return new NotificacionEmail();
            case 2:
                return new NotificacionSMS();
            case 3:
                return new NotificacionPush();
            default:
                throw new IllegalArgumentException("Tipo de notificación desconocido.");
        }
    }
}
