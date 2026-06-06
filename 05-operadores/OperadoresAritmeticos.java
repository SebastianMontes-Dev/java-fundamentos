/**
 * ============================================================
 *  TEMA: Operadores en Java
 *  SECCIÓN: 05 — Operadores
 *  ARCHIVO: OperadoresAritmeticos.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Los operadores aritméticos son la base de cualquier cálculo en programación.
 *  Aprenderás suma (+), resta (-), multiplicación (*), división entera (/) y
 *  módulo (%). Un detalle CRÍTICO: dividir dos enteros en Java produce un resultado
 *  ENTERO (trunca los decimales). Para obtener decimales, al menos un operando
 *  debe ser double. Este comportamiento es fuente constante de bugs en principiantes.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Suma (+), resta (-), multiplicación (*): operaciones básicas.
 *  - División entera (/): si ambos operandos son int, el resultado es int (truncado).
 *  - Módulo (%): devuelve el RESTO de una división entera.
 *  - Promoción numérica: si un operando es double, el resultado se promueve a double.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  int a = 10, b = 3;
 *  int division = a / b;       // 3 (truncado, no 3.33)
 *  double divisionReal = (double) a / b; // 3.3333...
 *  int resto = a % b;          // 1
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Esperar decimales de una división de enteros: 5 / 2 = 2, NO 2.5.
 *  - Dividir por cero con enteros: ArithmeticException. Con doubles: Infinity.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
 * ============================================================
 */
public class OperadoresAritmeticos {

    public static void main(String[] args) {
        int a = 3;
        int b = 7;

        System.out.println("=== Operadores Aritméticos ===");
        System.out.println("a = " + a + ", b = " + b);
        System.out.println();

        // Suma
        int suma = a + b;
        System.out.println("Suma           (a + b) = " + suma);

        // Resta
        int resta = a - b;
        System.out.println("Resta          (a - b) = " + resta);

        // Multiplicación
        int producto = a * b;
        System.out.println("Multiplicación (a * b) = " + producto);

        // División entera: 3 / 7 = 0 (la parte decimal se descarta)
        int division = a / b;
        System.out.println("División       (a / b) = " + division);

        // Módulo: 3 % 7 = 3 (el residuo de dividir 3 entre 7 es 3)
        int modulo = a % b;
        System.out.println("Módulo         (a % b) = " + modulo);
    }
}
