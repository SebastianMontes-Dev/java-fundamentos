import java.util.Scanner;

/**
 * Ejercicio: Registro de receta de cocina.
 *
 * El programa solicita los datos de una receta (nombre, ingredientes,
 * tiempo de preparación y dificultad) y los muestra formateados.
 *
 * Conceptos practicados:
 *   - Lectura de cadenas con Scanner.nextLine().
 *   - Conversión de String a double con Double.parseDouble().
 *   - Formateo de salida con \t (tabulador) y \n (salto de línea).
 */
public class RegistroReceta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la receta: ");
        String receta = scanner.nextLine();

        System.out.print("Ingrese los ingredientes principales: ");
        String ingredientes = scanner.nextLine();

        System.out.print("Ingrese el tiempo de preparación (minutos): ");
        double tiempo = Double.parseDouble(scanner.nextLine());

        System.out.print("Dificultad de la receta (Fácil, Media, Difícil): ");
        String dificultad = scanner.nextLine();

        System.out.println("\n--- Receta Registrada ---");
        System.out.println("\tNombre:       " + receta);
        System.out.println("\tIngredientes: " + ingredientes);
        System.out.println("\tTiempo:       " + tiempo + " minuto(s)");
        System.out.println("\tDificultad:   " + dificultad);

        scanner.close();
    }
}
