/**
 * Demostración de los operadores aritméticos básicos en Java.
 *
 * Operadores cubiertos:
 *   +  → suma
 *   -  → resta
 *   *  → multiplicación
 *   /  → división entera (al operar dos enteros, el resultado se trunca)
 *   %  → módulo (resto de la división entera)
 *
 * Nota: al dividir dos variables de tipo int, el resultado siempre es entero.
 * Para obtener el decimal es necesario que al menos uno de los operandos sea double.
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
