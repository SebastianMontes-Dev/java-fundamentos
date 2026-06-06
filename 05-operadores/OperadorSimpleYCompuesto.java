/**
 * ============================================================
 *  TEMA: Operadores en Java
 *  SECCIÓN: 05 — Operadores
 *  ARCHIVO: OperadorSimpleYCompuesto.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  La asignación puede ser SIMPLE (=) o COMPUESTA (+=, -=, *=, /=, %=). Los
 *  operadores compuestos son atajos que realizan una operación aritmética y la
 *  asignación en un solo paso: `a += 5` equivale a `a = a + 5`. Además de ser
 *  más concisos, evitan tener que escribir el nombre de la variable dos veces,
 *  reduciendo errores de tipeo en código extenso.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Asignación simple (=): copia el valor derecho en la variable izquierda.
 *  - Operadores compuestos (+=, -=, *=, /=, %=): operan y asignan en un solo paso.
 *  - Los operadores compuestos incluyen un CAST implícito si es necesario.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  int x = 10;
 *  x += 5;  // x = 15 (equivale a x = x + 5)
 *  x *= 2;  // x = 30 (equivale a x = x * 2)
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Confundir = (asignación) con == (comparación) en condiciones if.
 *  - Escribir `a =+ 5` en vez de `a += 5` (el primero asigna +5, el segundo suma 5).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
 * ============================================================
 */
public class OperadorSimpleYCompuesto {

    public static void main(String[] args) {
        // Asignación simple
        int a = 15;
        System.out.println("=== Operadores de Asignación ===");
        System.out.println("Valor inicial: a = " + a);
        System.out.println();

        // += : a = a + 3 → 15 + 3 = 18
        a += 3;
        System.out.println("a += 3   →  a = " + a);

        // *= : a = a * 20 → 18 * 20 = 360
        a *= 20;
        System.out.println("a *= 20  →  a = " + a);

        System.out.println();

        // Asignación simple: cada variable recibe directamente su valor literal
        int b = 32;
        int c = 52;
        int d = 88;
        System.out.printf("Asignación simple: b = %d, c = %d, d = %d%n", b, c, d);
    }
}
