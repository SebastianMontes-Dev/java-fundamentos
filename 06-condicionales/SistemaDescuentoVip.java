import java.util.Scanner;

/**
 * ============================================================
 *  TEMA: Estructuras Condicionales en Java
 *  SECCIÓN: 06 — Condicionales
 *  ARCHIVO: SistemaDescuentoVip.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Implementarás un sistema de descuentos que solo se activa cuando se cumplen
 *  DOS condiciones simultáneamente usando el operador lógico && (AND). Este es
 *  el patrón clásico de "desbloqueo por múltiples requisitos" presente en
 *  sistemas de fidelización, control de acceso y validación de formularios donde
 *  TODOS los criterios deben satisfacerse para otorgar un beneficio.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Operador lógico && (AND): true solo si AMBAS condiciones son true.
 *  - Operador relacional >= (mayor o igual): compara valores numéricos.
 *  - nextBoolean(): lectura de valores true/false desde consola.
 *  - Tabla de verdad del operador &&: true&&true=true, el resto es false.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  boolean aplicaDescuento = (articulos >= 10) && (esClienteVip);
 *  if (aplicaDescuento) {
 *      System.out.println("Descuento aplicado");
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar un solo & (AND bit a bit) en vez de && (AND lógico con cortocircuito).
 *  - Escribir `if (esVip == true)` en vez de `if (esVip)` (redundante).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html
 * ============================================================
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
