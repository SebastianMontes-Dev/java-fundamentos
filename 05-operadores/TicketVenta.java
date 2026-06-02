import java.util.Scanner;

/**
 * Ejercicio: Ticket de venta con cálculo de impuesto.
 *
 * El programa solicita el precio de tres productos, calcula el subtotal
 * y añade un impuesto calculado con el operador módulo para demostrar
 * su aplicación en un contexto práctico.
 *
 * Conceptos practicados:
 *   - Lectura de valores decimales con Scanner.nextDouble().
 *   - Operador de suma (+) para acumular el subtotal.
 *   - Operador módulo (%) aplicado a doubles para obtener el residuo.
 *   - Formateo básico de salida con println.
 *
 * Nota: en un sistema real el impuesto se calcularía con un porcentaje fijo
 * (ej. total * 0.16). Aquí se usa % para ilustrar su funcionamiento con doubles.
 */
public class TicketVenta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Ticket de Venta ===");
        System.out.println();

        System.out.print("Precio del plátano ($):      ");
        double platano = scanner.nextDouble();

        System.out.print("Precio de la lechuga ($):    ");
        double lechuga = scanner.nextDouble();

        System.out.print("Precio de la mantequilla ($): ");
        double mantequilla = scanner.nextDouble();

        // Subtotal: suma de los tres productos
        double subtotal = platano + lechuga + mantequilla;

        // Impuesto calculado con módulo: residuo de dividir el subtotal entre 10
        double impuesto = subtotal % 10;
        double total = subtotal + impuesto;

        System.out.println();
        System.out.println("--- Resumen ---");
        System.out.printf("Subtotal:  $%.2f%n", subtotal);
        System.out.printf("Impuesto:  $%.2f%n", impuesto);
        System.out.printf("Total:     $%.2f%n", total);

        scanner.close();
    }
}
