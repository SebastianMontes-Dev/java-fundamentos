/**
 * Demostración de los operadores de asignación: simple y compuesto.
 *
 * Operador simple:
 *   =   → asigna el valor del lado derecho a la variable del lado izquierdo.
 *
 * Operadores compuestos (combinan una operación aritmética con la asignación):
 *   +=  → equivale a: variable = variable + valor
 *   -=  → equivale a: variable = variable - valor
 *   *=  → equivale a: variable = variable * valor
 *   /=  → equivale a: variable = variable / valor
 *   %=  → equivale a: variable = variable % valor
 *
 * Los operadores compuestos son más concisos y el compilador los trata
 * de manera equivalente a la forma extendida.
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
