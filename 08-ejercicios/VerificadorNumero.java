/**
 * ============================================================
 *  TEMA: Ejercicios Aplicados en Java
 *  SECCIÓN: 08 — Ejercicios
 *  ARCHIVO: VerificadorNumero.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aplicarás condiciones compuestas con `&&` (AND) y un descuento escalonado
 *  basado en el monto de compra y la membresía del cliente. Este ejercicio simula
 *  un sistema real de punto de venta donde el descuento depende de múltiples
 *  factores. Refuerza el uso de if-else-if con operadores lógicos y relacionales.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Operador lógico && (AND): ambas condiciones deben ser true.
 *  - Operadores relacionales: >, >=, <, <= para comparar valores numéricos.
 *  - Descuento porcentual: `monto * 0.10` calcula el 10% del monto.
 *  - Acumulador con operador compuesto: `monto -= descuento`.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  if (gasto > 1000 && miembro) {
 *      descuento = gasto * 0.10;  // 10% de descuento
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Confundir `&&` (AND) con `||` (OR): aquí necesitamos AMBAS condiciones.
 *  - Escribir `if (miembro == true)` en vez de `if (miembro)` — redundante.
 *  - No considerar el caso en que `gasto <= 1000` por separado del caso sin membresía.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html
 * ============================================================
 */
import java.util.Scanner;

public class VerificadorNumero {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        // Capturamos el monto de la compra
        System.out.print("¿Cuánto gastó en la tienda? $");
        var gasto = sc.nextDouble();

        // Capturamos si el cliente es miembro (true/false)
        System.out.print("¿Es miembro de la tienda? (true/false): ");
        var miembro = sc.nextBoolean();

        System.out.println("\n--- Resultado ---");

        // Caso 1: Gasto alto Y es miembro → 10% de descuento
        if (gasto > 1000 && miembro) {
            var descuento = gasto * 0.10;
            gasto -= descuento; // aplicamos el descuento
            System.out.printf("¡Felicidades! Tienes 10%% de descuento.%n");
            System.out.printf("Total a pagar: $%.2f%n", gasto);

        // Caso 2: Gasto menor/igual a 1000 Y es miembro → 5% de descuento
        } else if (gasto <= 1000 && miembro) {
            var descuento = gasto * 0.05;
            gasto -= descuento;
            System.out.printf("Tienes 5%% de descuento por ser miembro.%n");
            System.out.printf("Total a pagar: $%.2f%n", gasto);

        // Caso 3: No es miembro → sin descuento
        } else {
            System.out.println("Usted no es miembro de la tienda.");
            System.out.printf("Total a pagar: $%.2f%n", gasto);
            System.out.println("Lo invitamos a hacerse miembro para obtener descuentos.");
        }

        sc.close();
    }
}
