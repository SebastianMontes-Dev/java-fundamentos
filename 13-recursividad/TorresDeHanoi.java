/**
 * ============================================================
 *  TEMA: Torres de Hanoi — Recursividad Indirecta
 *  SECCIÓN: 13 — Recursividad
 *  ARCHIVO: TorresDeHanoi.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Las Torres de Hanoi es un problema legendario que muestra el VERDADERO
 *  poder de la recursividad: hay 3 varillas (origen, auxiliar, destino) y N
 *  discos de tamaños decrecientes en la varilla origen. El objetivo es mover
 *  todos los discos a la varilla destino siguiendo 2 reglas: (1) solo puedes
 *  mover un disco a la vez, y (2) nunca puedes poner un disco grande sobre
 *  uno más pequeño.
 *
 *  Lo que hace este problema tan especial es que su solución recursiva es
 *  trivial (3 líneas), mientras que la iterativa es un dolor de cabeza. La
 *  clave mental: para mover N discos de A a C, primero mueves N-1 discos de
 *  A a B (usando C como auxiliar), luego mueves el disco grande de A a C, y
 *  finalmente mueves los N-1 discos de B a C. El número de movimientos es
 *  2^N - 1: para 64 discos necesitarías 18 trillones de movimientos.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Recursión indirecta: hanoi(n, origen, auxiliar, destino).
 *  - El caso base es n=1: mover el disco directamente.
 *  - Número de movimientos: 2^n - 1 (crecimiento exponencial).
 *  - Resolver iterativamente es mucho más complejo.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  hanoi(n, 'A', 'B', 'C') {
 *      si n == 1: mover disco de A a C
 *      sino:
 *          hanoi(n-1, 'A', 'C', 'B')  // pasar N-1 al auxiliar
 *          mover disco N de A a C     // mover el grande
 *          hanoi(n-1, 'B', 'A', 'C')  // pasar N-1 al destino
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Confundir el orden de los parámetros (origen, auxiliar, destino).
 *  - No usar long para contar movimientos (int desborda con n > 31).
 *  - Intentar resolver con > 20 discos (la salida es ENORME).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Simulación interactiva: https://www.mathsisfun.com/games/towerofhanoi.html
 * ============================================================
 */
public class TorresDeHanoi {

    private static long movimientos = 0;

    public static void main(String[] args) {
        System.out.println("=== Torres de Hanoi ===");
        System.out.println("(Moviendo discos de varilla A a varilla C)");
        System.out.println();

        // Ejemplo con 3 discos (7 movimientos)
        int n = 3;
        movimientos = 0;
        System.out.println("--- " + n + " discos ---");
        hanoi(n, 'A', 'B', 'C');
        System.out.println("Total movimientos: " + movimientos);
        System.out.println("2^" + n + " - 1 = " + ((long) Math.pow(2, n) - 1));
        System.out.println();

        // Ejemplo con 4 discos (15 movimientos)
        n = 4;
        movimientos = 0;
        System.out.println("--- " + n + " discos ---");
        hanoi(n, 'A', 'B', 'C');
        System.out.println("Total movimientos: " + movimientos);
        System.out.println("2^" + n + " - 1 = " + ((long) Math.pow(2, n) - 1));
        System.out.println();

        // Mostrar tabla de complejidad
        System.out.println("--- Complejidad: 2^n - 1 ---");
        System.out.println("Discos | Movimientos");
        System.out.println("-------|------------");
        for (int i = 1; i <= 10; i++) {
            long m = (long) Math.pow(2, i) - 1;
            System.out.printf("  %2d   | %d%n", i, m);
        }
        System.out.println();
        System.out.println("Con 64 discos: 18,446,744,073,709,551,615 movimientos");
        System.out.println("(A 1 movimiento/segundo: ~585 mil millones de años)");
    }

    /**
     * Mueve n discos desde la varilla 'origen' hasta 'destino'
     * usando 'auxiliar' como varilla temporal.
     */
    static void hanoi(int n, char origen, char auxiliar, char destino) {
        if (n == 1) {
            // Caso base: mover el disco más pequeño
            movimientos++;
            System.out.printf("  Movimiento #%d: Disco %d de %c → %c%n",
                    movimientos, n, origen, destino);
            return;
        }

        // Paso 1: Mover n-1 discos de origen a auxiliar
        hanoi(n - 1, origen, destino, auxiliar);

        // Paso 2: Mover el disco más grande de origen a destino
        movimientos++;
        System.out.printf("  Movimiento #%d: Disco %d de %c → %c%n",
                movimientos, n, origen, destino);

        // Paso 3: Mover n-1 discos de auxiliar a destino
        hanoi(n - 1, auxiliar, origen, destino);
    }
}
