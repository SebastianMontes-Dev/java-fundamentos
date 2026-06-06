import java.util.Scanner;

/**
 * ============================================================
 *  TEMA: Estructuras Condicionales en Java
 *  SECCIÓN: 06 — Condicionales
 *  ARCHIVO: SistemaPrestamoLibro.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Implementarás un sistema de préstamo donde el beneficio se otorga si se cumple
 *  AL MENOS UNA de varias condiciones, usando el operador lógico || (OR). A
 *  diferencia de && (que exige todas), || es permisivo: basta con que UNA sola
 *  condición sea verdadera. Este patrón se usa en sistemas de elegibilidad,
 *  filtros de búsqueda con múltiples criterios y validaciones flexibles.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Operador lógico || (OR): true si al menos UNA condición es true.
 *  - Tabla de verdad: solo false||false = false.
 *  - Buenas prácticas: no escribir `(variable == true)`, usar la variable directamente.
 *  - Nombres descriptivos: `tieneCredenciales`, `viveEnZona` (autodocumentan el código).
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  boolean prestamoAprobado = tieneCredenciales || viveEnZona;
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar un solo | (OR bit a bit) en vez de || (OR lógico con cortocircuito).
 *  - Confundir || (OR: al menos una) con && (AND: todas).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html
 * ============================================================
 */
public class SistemaPrestamoLibro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistema de Préstamo de Libro ===");
        System.out.println();

        System.out.print("¿Tiene credenciales de estudiante? (true/false): ");
        boolean tieneCredenciales = scanner.nextBoolean();

        System.out.print("¿Vive a no más de 3 km de la biblioteca? (true/false): ");
        boolean viveEnZona = scanner.nextBoolean();

        // El préstamo se aprueba si cumple al menos una de las condiciones
        boolean prestamoAprobado = tieneCredenciales || viveEnZona;

        System.out.println();
        System.out.println("--- Resultado ---");
        System.out.println("Credenciales de estudiante: " + tieneCredenciales);
        System.out.println("Vive a ≤ 3 km:              " + viveEnZona);
        System.out.println("Préstamo aprobado:           " + prestamoAprobado);

        scanner.close();
    }
}
