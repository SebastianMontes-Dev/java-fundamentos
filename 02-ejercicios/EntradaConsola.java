import java.util.Scanner;

/**
 * Ejercicio: Lectura de datos desde consola con Scanner.
 *
 * Scanner permite leer datos ingresados por el usuario desde la terminal.
 * En este caso se utiliza nextLine() para capturar una línea completa de texto.
 *
 * Conceptos practicados:
 *   - Creación de un objeto Scanner con System.in.
 *   - Lectura de cadenas con nextLine().
 *   - Buenas prácticas: cerrar el Scanner al final para liberar recursos.
 */
public class EntradaConsola {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Su nombre es: " + nombre);

        scanner.close();
    }
}
