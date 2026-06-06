/**
 * ============================================================
 *  TEMA: Manejo de Excepciones en Java
 *  SECCIÓN: 12 — Excepciones
 *  ARCHIVO: TryCatchBasico.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Las excepciones son eventos que interrumpen el flujo normal del programa (errores
 *  en tiempo de ejecución). El bloque `try-catch` permite CAPTURAR y MANEJAR estas
 *  excepciones para que tu programa no se detenga abruptamente. Aprenderás la
 *  estructura básica: el código riesgoso va en `try`, y el código de recuperación
 *  en `catch`. Es una habilidad indispensable para escribir software robusto.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - try: bloque que contiene el código que podría lanzar una excepción.
 *  - catch: bloque que captura y maneja una excepción específica.
 *  - ArithmeticException: se lanza al dividir un entero entre cero.
 *  - Exception: clase base de todas las excepciones (catch genérico).
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  try {
 *      int resultado = 10 / 0; // peligroso
 *  } catch (ArithmeticException e) {
 *      System.out.println("No se puede dividir entre cero.");
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Poner TODO el código dentro del try (solo lo que puede fallar).
 *  - Dejar el catch vacío (catch silencioso): esconde errores y dificulta depurar.
 *  - No imprimir el stack trace o mensaje de la excepción al menos durante desarrollo.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/essential/exceptions/
 * ============================================================
 */
public class TryCatchBasico {

    public static void main(String[] args) {

        System.out.println("=== Manejo Básico de Excepciones (try-catch) ===\n");

        // Ejemplo 1: División entre cero (ArithmeticException)
        System.out.println("--- Ejemplo 1: División entre cero ---");
        int numerador = 10;
        int denominador = 0;

        try {
            // Código que podría lanzar una excepción
            int resultado = numerador / denominador;
            System.out.println("Resultado: " + resultado); // nunca se alcanza si hay error
        } catch (ArithmeticException e) {
            // Código que se ejecuta SOLO si ocurre ArithmeticException
            System.out.println("Error: No se puede dividir entre cero.");
            System.out.println("Detalle técnico: " + e.getMessage());
        }

        // El programa continúa normalmente después del catch
        System.out.println("El programa sigue ejecutándose después del try-catch.\n");

        // Ejemplo 2: Acceso a índice fuera de rango (ArrayIndexOutOfBoundsException)
        System.out.println("--- Ejemplo 2: Índice fuera de rango en arreglo ---");
        int[] numeros = {10, 20, 30};

        try {
            // Intentamos acceder al índice 5 en un arreglo de 3 elementos
            System.out.println("Accediendo al índice 5: " + numeros[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Índice fuera de rango. El arreglo tiene "
                    + numeros.length + " elementos.");
            System.out.println("Detalle: " + e);
        }

        System.out.println("\n¡Programa finalizado correctamente!");
    }
}
