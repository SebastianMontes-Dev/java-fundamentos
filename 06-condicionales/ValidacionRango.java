import java.util.Scanner;

/**
 * Ejercicio: Validación de rango con operadores lógicos y relacionales.
 *
 * El programa determina si un número ingresado por el usuario se encuentra
 * dentro del rango cerrado [0, 5].
 *
 * Conceptos practicados:
 *   - Constantes con final para definir límites inmutables.
 *   - Operadores relacionales: >= (mayor o igual), <= (menor o igual).
 *   - Operador lógico && (AND): devuelve true solo si AMBAS condiciones son verdaderas.
 *   - Inferencia de tipo con var.
 *   - Lectura de enteros con Scanner.
 *
 * Tabla de verdad del operador &&:
 *   true  && true  = true
 *   true  && false = false
 *   false && true  = false
 *   false && false = false
 */
public class ValidacionRango {

    public static void main(String[] args) {
        final int LIMITE_INFERIOR = 0;
        final int LIMITE_SUPERIOR = 5;

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Validación de Rango ===");
        System.out.println("Rango válido: [" + LIMITE_INFERIOR + ", " + LIMITE_SUPERIOR + "]");
        System.out.println();

        System.out.print("Ingrese un número para verificar: ");
        var numero = scanner.nextInt();

        // true solo si número >= 0 Y número <= 5
        var estaEnRango = numero >= LIMITE_INFERIOR && numero <= LIMITE_SUPERIOR;

        System.out.println();
        System.out.println("Número ingresado: " + numero);
        System.out.println("¿Está en el rango [" + LIMITE_INFERIOR + ", " + LIMITE_SUPERIOR + "]? " + estaEnRango);

        scanner.close();
    }
}
