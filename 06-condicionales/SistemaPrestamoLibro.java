import java.util.Scanner;

/**
 * Ejercicio: Sistema de préstamo de libro gratuito.
 *
 * El préstamo se aprueba cuando se cumple AL MENOS UNA de estas condiciones:
 *   1. El usuario tiene credenciales de estudiante activas.
 *   2. El usuario vive a no más de 3 km de la biblioteca.
 *
 * Concepto clave — operador lógico || (OR):
 *   Devuelve true si AL MENOS UNA condición es verdadera.
 *   Solo devuelve false si AMBAS condiciones son falsas.
 *
 *   Tabla de verdad:
 *     true  || true  = true   → préstamo aprobado
 *     true  || false = true   → préstamo aprobado
 *     false || true  = true   → préstamo aprobado
 *     false || false = false  → préstamo denegado
 *
 * Buenas prácticas aplicadas:
 *   - Se evita escribir (variable == true); la variable booleana ya es la expresión.
 *   - Nombres de variable descriptivos que expresan el significado del dato.
 *
 * Conceptos practicados:
 *   - Operador lógico || (OR).
 *   - Lectura de booleanos con Scanner.
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
