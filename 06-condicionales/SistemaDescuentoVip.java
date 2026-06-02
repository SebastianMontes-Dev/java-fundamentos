import java.util.Scanner;

/**
 * Ejercicio: Sistema de descuento para clientes VIP.
 *
 * El descuento se aplica únicamente cuando se cumplen DOS condiciones al mismo tiempo:
 *   1. El cliente ha comprado 10 o más artículos.
 *   2. El cliente tiene estado VIP activo.
 *
 * Concepto clave — operador lógico && (AND):
 *   Devuelve true solo si AMBAS condiciones son verdaderas.
 *   Si cualquiera de las dos es false, el resultado es false.
 *
 *   Tabla de verdad:
 *     true  && true  = true   → descuento aplicado
 *     true  && false = false  → sin descuento
 *     false && true  = false  → sin descuento
 *     false && false = false  → sin descuento
 *
 * Conceptos practicados:
 *   - Operador lógico && (AND).
 *   - Operador relacional >= (mayor o igual).
 *   - Lectura de enteros y booleanos con Scanner.
 */
public class SistemaDescuentoVip {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistema de Descuento VIP ===");
        System.out.println();

        System.out.print("¿Cuántos artículos ha comprado? ");
        int articulos = scanner.nextInt();

        System.out.print("¿Es cliente VIP? (true/false): ");
        boolean esClienteVip = scanner.nextBoolean();

        // El descuento solo se aplica si se cumplen AMBAS condiciones
        boolean aplicaDescuento = articulos >= 10 && esClienteVip;

        System.out.println();
        System.out.println("--- Resultado ---");
        System.out.println("Artículos comprados:  " + articulos);
        System.out.println("Cliente VIP:          " + esClienteVip);
        System.out.println("¿Aplica descuento?    " + aplicaDescuento);

        scanner.close();
    }
}
