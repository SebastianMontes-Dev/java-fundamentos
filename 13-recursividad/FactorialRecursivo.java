/**
 * ============================================================
 *  TEMA: Recursividad en Java
 *  SECCIÓN: 13 — Recursividad
 *  ARCHIVO: FactorialRecursivo.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  La recursividad es una función que se llama a sí misma. Suena a magia,
 *  pero tiene dos reglas muy claras: (1) un CASO BASE que detiene la recursión,
 *  y (2) un PASO RECURSIVO que reduce el problema hacia el caso base. Sin
 *  caso base, la función se llama infinitamente hasta que el stack de llamadas
 *  se desborda (StackOverflowError). Implementarás el factorial de forma
 *  recursiva e iterativa para comparar ambos enfoques.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Caso base: condición que detiene la recursión. Ej: factorial(1) = 1.
 *  - Paso recursivo: la función se llama a sí misma con un argumento menor.
 *  - Stack de llamadas: cada llamada recursiva apila un nuevo frame.
 *  - StackOverflowError: demasiadas llamadas recursivas sin caso base.
 *  - La recursividad suele ser más legible pero menos eficiente que el bucle.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  static int factorial(int n) {
 *      if (n <= 1) return 1;           // caso base
 *      return n * factorial(n - 1);    // paso recursivo
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar el caso base: recursión infinita → StackOverflowError.
 *  - Usar recursión para problemas con profundidad > 10,000.
 *  - Confundir recursión de cola (tail recursion) con recursión normal.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/recursion.html
 * ============================================================
 */
public class FactorialRecursivo {

    public static void main(String[] args) {
        System.out.println("=== Factorial: Recursivo vs Iterativo ===");
        System.out.println();

        int n = 5;

        // Demostración con traza
        System.out.println("--- Con traza ---");
        int resultadoConTraza = factorialConTraza(n, 0);
        System.out.println("factorial(" + n + ") = " + resultadoConTraza);
        System.out.println();

        // Sin traza (limpio)
        System.out.println("--- Sin traza ---");
        System.out.println("Recursivo:      factorial(" + n + ") = " + factorial(n));
        System.out.println("Iterativo(for): factorial(" + n + ") = " + factorialIterativo(n));
        System.out.println();

        // Comparación de rendimiento
        System.out.println("--- Comparación para n grandes ---");
        int grande = 20;
        long inicioRec = System.nanoTime();
        long resultadoRec = factorial(grande);
        long finRec = System.nanoTime();

        long inicioIter = System.nanoTime();
        long resultadoIter = factorialIterativo(grande);
        long finIter = System.nanoTime();

        System.out.println("factorial(" + grande + ") = " + resultadoRec);
        System.out.println("Recursivo:  " + (finRec - inicioRec) + " ns");
        System.out.println("Iterativo:  " + (finIter - inicioIter) + " ns");
        System.out.println();

        // Peligro: sin caso base
        System.out.println("--- ¡Peligro! StackOverflowError ---");
        System.out.println("Si llamas factorialSinCasoBase(5), la recursión no termina...");
        System.out.println("(El stack tiene ~10,000 frames, luego colapsa)");
    }

    // Factorial recursivo clásico
    static long factorial(int n) {
        if (n <= 1) return 1;       // caso base
        return n * factorial(n - 1); // paso recursivo
    }

    // Factorial con traza para visualizar la recursión
    static int factorialConTraza(int n, int nivel) {
        String indent = "  ".repeat(nivel);
        System.out.println(indent + "factorial(" + n + ") llamado");

        if (n <= 1) {
            System.out.println(indent + "-> caso base: factorial(1) = 1");
            return 1;
        }

        int resultado = n * factorialConTraza(n - 1, nivel + 1);
        System.out.println(indent + "factorial(" + n + ") = " + resultado);
        return resultado;
    }

    // Factorial iterativo (con bucle for)
    static long factorialIterativo(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // ¡CUIDADO! Sin caso base = recursión infinita
    // static int factorialSinCasoBase(int n) {
    //     return n * factorialSinCasoBase(n - 1); // Nunca se detiene
    // }
}
