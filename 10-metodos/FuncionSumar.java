/**
 * ============================================================
 *  TEMA: Métodos (Funciones) en Java — Valor de retorno
 *  SECCIÓN: 10 — Métodos
 *  ARCHIVO: FuncionSumar.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Un método puede devolver un valor usando la palabra clave `return`. La firma
 *  del método debe especificar el tipo de dato que retorna (int, double, boolean,
 *  String, etc.). Aquí aprenderás a declarar un método que recibe parámetros,
 *  realiza un cálculo y devuelve el resultado al código que lo invocó.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Tipo de retorno: el tipo de dato que el método devuelve (int, double, etc.).
 *  - return: palabra clave que envía un valor de vuelta y termina el método.
 *  - static: permite invocar el método sin crear una instancia de la clase.
 *  - Parámetros: variables que reciben los valores de entrada del método.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  static int sumar(int a, int b) {
 *      return a + b;
 *  }
 *  // Invocación: int resultado = sumar(5, 10);
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar el `return` en un método con tipo de retorno distinto de void.
 *  - Declarar `void` cuando se necesita devolver un valor.
 *  - No capturar el valor devuelto si se necesita usar después.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html
 *  - Guía de return: https://docs.oracle.com/javase/tutorial/java/javaOO/returnvalue.html
 * ============================================================
 */
public class FuncionSumar {

    /**
     * Método estático que recibe dos números enteros y devuelve su suma.
     *
     * @param a primer número entero
     * @param b segundo número entero
     * @return la suma de a + b
     */
    static int sumar(int a, int b) {
        var resultado = a + b;
        return resultado;
    }

    public static void main(String[] args) {

        System.out.println("=== Método con valor de retorno ===\n");

        int num1 = 6, num2 = 20;

        // Invocamos el método sumar() y almacenamos el valor devuelto
        int resultadoSuma = sumar(num1, num2);

        System.out.println("El resultado de " + num1 + " + " + num2 + " es: " + resultadoSuma);
    }
}
