import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================
 *  TEMA: Recursividad con Fibonacci y Memoización
 *  SECCIÓN: 13 — Recursividad
 *  ARCHIVO: FibonacciRecursivo.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  La sucesión de Fibonacci (0, 1, 1, 2, 3, 5, 8, 13, ...) es el ejemplo
 *  clásico de recursión doble: fib(n) = fib(n-1) + fib(n-2). Es hermoso
 *  pero terrible en rendimiento porque recalcula los mismos valores una y
 *  otra vez. Para n=50, el algoritmo recursivo ingenuo tarda MINUTOS;
 *  con memoización (guardar resultados ya calculados) es instantáneo.
 *
 *  La memoización es la técnica que salva a la recursividad del desastre:
 *  un HashMap que almacena fib(3)=2, fib(4)=3, etc., y los reutiliza en
 *  vez de recalcularlos. Es el puente entre la elegancia recursiva y la
 *  eficiencia iterativa.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Fibonacci recursivo: fib(n) = fib(n-1) + fib(n-2), casos base 0 y 1.
 *  - Explosión exponencial: O(2^n) para recursivo ingenuo.
 *  - Memoización: guardar resultados en un Map para evitar recálculos.
 *  - Con memoización: O(n) tiempo, O(n) espacio.
 *  - Fibonacci iterativo: O(n) tiempo, O(1) espacio (el más eficiente).
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  static long fib(int n) {
 *      if (n <= 1) return n;
 *      return fib(n-1) + fib(n-2);
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - No manejar n negativos (Fibonacci no está definido para negativos).
 *  - Usar memoización con HashMap en vez de array para rendimiento óptimo.
 *  - Overflow: fib(93) ya no cabe en un long.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Visualización interactiva: https://visualgo.net/en/recursion
 * ============================================================
 */
public class FibonacciRecursivo {

    // Memoización: guardamos resultados ya calculados
    private static Map<Integer, Long> cache = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("=== Fibonacci: Recursivo, Memoizado e Iterativo ===");
        System.out.println();

        int n = 10;

        // --- RECURSIVO INGENUO (solo para números pequeños) ---
        System.out.println("--- Recursivo Ingenuo (O(2^n)) ---");
        System.out.println("fib(" + n + ") = " + fibIngenuo(n));
        System.out.println("(Para n=45 esto tarda varios segundos)");
        System.out.println();

        // --- RECURSIVO CON MEMOIZACIÓN ---
        System.out.println("--- Recursivo con Memoización (O(n)) ---");
        cache.clear();
        long resultadoMemo = fibMemoizado(n);
        System.out.println("fib(" + n + ") = " + resultadoMemo);
        System.out.println("Elementos en caché: " + cache.size());
        System.out.println("Caché: " + cache);
        System.out.println();

        // --- PRUEBA DE RENDIMIENTO ---
        int grande = 40;
        System.out.println("--- Rendimiento para fib(" + grande + ") ---");

        // Memoizado
        cache.clear();
        long inicioMemo = System.nanoTime();
        long fibMemo = fibMemoizado(grande);
        long finMemo = System.nanoTime();

        // Iterativo
        long inicioIter = System.nanoTime();
        long fibIter = fibIterativo(grande);
        long finIter = System.nanoTime();

        System.out.println("fib(" + grande + ") = " + fibMemo);
        System.out.println("Memoizado: " + (finMemo - inicioMemo) / 1_000_000 + " ms");
        System.out.println("Iterativo: " + (finIter - inicioIter) / 1_000_000 + " ms");
        System.out.println();

        // --- ITERATIVO (alternativa eficiente) ---
        System.out.println("--- Iterativo (O(n), O(1) espacio) ---");
        for (int i = 0; i <= 10; i++) {
            System.out.print(fibIterativo(i) + " ");
        }
        System.out.println();
        System.out.println("(Este es el enfoque más eficiente para Fibonacci)");
    }

    // Recursivo ingenuo: O(2^n) — terrible para n > 40
    static long fibIngenuo(int n) {
        if (n <= 1) return n;
        return fibIngenuo(n - 1) + fibIngenuo(n - 2);
    }

    // Recursivo con memoización: O(n)
    static long fibMemoizado(int n) {
        if (n <= 1) return n;

        // Si ya lo calculamos, lo devolvemos de la caché
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        // Lo calculamos y lo guardamos
        long resultado = fibMemoizado(n - 1) + fibMemoizado(n - 2);
        cache.put(n, resultado);
        return resultado;
    }

    // Iterativo: O(n) tiempo, O(1) espacio
    static long fibIterativo(int n) {
        if (n <= 1) return n;

        long anterior = 0;
        long actual = 1;

        for (int i = 2; i <= n; i++) {
            long siguiente = anterior + actual;
            anterior = actual;
            actual = siguiente;
        }
        return actual;
    }
}
