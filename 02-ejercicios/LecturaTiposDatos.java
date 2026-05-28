import java.util.Scanner;

/**
 * Ejercicio: Lectura de distintos tipos de datos desde consola.
 *
 * Scanner ofrece métodos específicos para cada tipo de dato.
 * Este programa demuestra dos enfoques para leer valores:
 *
 * Enfoque 1 — Métodos directos (más simples):
 *   - nextInt()    : lee un entero directamente.
 *   - nextDouble() : lee un decimal directamente.
 *
 * Enfoque 2 — Leer como String y convertir (más robusto):
 *   - nextLine() + Integer.parseInt() : evita problemas con el salto de línea pendiente.
 *
 * Conceptos practicados:
 *   - Lectura con nextInt(), nextDouble() y nextLine().
 *   - Uso de nextLine() adicional para consumir el salto de línea.
 *   - Conversión de String a entero con Integer.parseInt().
 */
public class LecturaTiposDatos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Enfoque 1: métodos directos ---

        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();
        System.out.println("Su edad es: " + edad);

        System.out.print("Ingrese su altura: ");
        double altura = scanner.nextDouble();
        System.out.println("Su altura es: " + altura);

        // nextInt() y nextDouble() dejan un salto de línea pendiente.
        // Se consume con un nextLine() extra antes de leer la siguiente cadena.
        scanner.nextLine();

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Su nombre es: " + nombre);

        // --- Enfoque 2: leer como String y convertir ---

        System.out.print("Ingrese un valor entero (usando conversión): ");
        String texto = scanner.nextLine();
        int enteroConvertido = Integer.parseInt(texto);
        System.out.println("El valor entero convertido es: " + enteroConvertido);

        scanner.close();
    }
}
