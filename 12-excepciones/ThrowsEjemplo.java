/**
 * ============================================================
 *  TEMA: Manejo de Excepciones en Java
 *  SECCIÓN: 12 — Excepciones
 *  ARCHIVO: ThrowsEjemplo.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  La palabra clave `throws` en la firma de un método declara que ese método PUEDE
 *  lanzar una o más excepciones, delegando la responsabilidad de manejarlas al
 *  código que lo invoca. Esto crea una cadena de propagación: el método A lanza,
 *  el método B que lo llama decide si captura o vuelve a delegar hacia arriba.
 *  Es un patrón fundamental para separar la DETECCIÓN del error de su MANEJO.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - throws: declara en la firma del método qué excepciones puede propagar.
 *  - Propagación: la excepción sube por la pila de llamadas hasta ser capturada.
 *  - throws vs throw: `throws` declara, `throw` lanza.
 *  - Método que delega: no maneja el error, solo avisa que puede ocurrir.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  void leerArchivo(String ruta) throws IOException {
 *      // código que puede lanzar IOException
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Declarar `throws Exception` genérico en vez de la excepción específica.
 *  - Olvidar que al invocar un método con throws debes o capturar o redeclarar.
 *  - Usar throws en el main (la excepción sube hasta la JVM y crashea el programa).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/essential/exceptions/declaring.html
 * ============================================================
 */
public class ThrowsEjemplo {

    public static void main(String[] args) {

        System.out.println("=== Propagación de Excepciones con throws ===\n");

        // Manejo centralizado en main: aqui CAPTURAMOS todo
        try {
            procesarPedido("Laptop", 0);   // cantidad inválida → lanza excepción
        } catch (IllegalArgumentException e) {
            System.out.println("Pedido rechazado: " + e.getMessage());
        }

        System.out.println();

        try {
            procesarPedido("Teclado", 3);  // cantidad válida
        } catch (IllegalArgumentException e) {
            System.out.println("Pedido rechazado: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== Demostración de propagación en cadena ===\n");

        // Método C llama a B, B llama a A. Si A lanza, la excepción sube hasta C
        try {
            metodoC();
        } catch (Exception e) {
            System.out.println("[main] Capturé la excepción que subió desde metodoA: " + e.getMessage());
        }
    }

    // Este método DECLARA que puede lanzar IllegalArgumentException
    static void procesarPedido(String producto, int cantidad) throws IllegalArgumentException {
        if (cantidad <= 0) {
            // throw = LANZAR la excepción
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0. Recibido: " + cantidad);
        }
        System.out.println("Pedido procesado: " + cantidad + " x " + producto);
    }

    // Demostración de propagación en 3 niveles
    static void metodoA() throws Exception {
        throw new Exception("Error originado en metodoA");
    }

    static void metodoB() throws Exception {
        metodoA(); // no captura, la excepción sube a metodoC
    }

    static void metodoC() throws Exception {
        metodoB(); // no captura, la excepción sube a main
    }
}
