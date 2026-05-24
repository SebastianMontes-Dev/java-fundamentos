import java.util.Scanner;

/**
 * Ejercicio: Generador de tabla de multiplicar.
 *
 * El programa solicita un número entero al usuario y muestra
 * su tabla de multiplicar del 1 al 10, con formato alineado.
 *
 * Conceptos practicados:
 *   - Entrada de datos con Scanner.
 *   - Bucle for para iterar del 1 al 10.
 *   - printf() para formatear la salida en columnas.
 */
public class TablaMultiplicar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número para ver su tabla de multiplicar: ");
        int numero = scanner.nextInt();

        System.out.println();
        System.out.println("Tabla de multiplicar del " + numero);
        System.out.println("================================");

        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            System.out.printf("%d x %2d = %d%n", numero, i, resultado);
        }

        scanner.close();
    }
}
