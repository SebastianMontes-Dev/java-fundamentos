import java.util.Scanner;

/**
 * ============================================================
 *  TEMA: Operadores en Java
 *  SECCIÓN: 05 — Operadores
 *  ARCHIVO: TicketVenta.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Simularás un ticket de venta que calcula subtotales, impuestos y totales usando
 *  operadores aritméticos en un contexto de negocio real. Leerás precios desde
 *  consola, los acumularás con suma (+) y aplicarás el operador módulo (%)
 *  para calcular un impuesto ficticio. Ideal para entender cómo los operadores
 *  trabajan juntos en aplicaciones del mundo real.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - nextDouble(): lectura de valores decimales desde consola.
 *  - Operador suma (+): acumula precios para obtener el subtotal.
 *  - Operador módulo (%): obtiene el residuo de una división (útil para cálculos periódicos).
 *  - printf() con %f: formateo de salida con dos decimales.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  double subtotal = precio1 + precio2 + precio3;
 *  double impuesto = subtotal % 10;
 *  double total = subtotal + impuesto;
 *  System.out.printf("Total: $%.2f%n", total);
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - No consumir el salto de línea tras leer doubles si luego se usa nextLine().
 *  - Usar % para calcular porcentajes directamente (% no es porcentaje, es residuo).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
 * ============================================================
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
