import java.util.Random;
import java.util.Scanner;

/**
 * Ejercicio: Generador de ID único de usuario.
 *
 * El programa construye un identificador combinando:
 *   - Las 2 primeras letras del nombre (en mayúsculas).
 *   - Las 2 primeras letras del apellido (en mayúsculas).
 *   - Los 2 últimos dígitos del año de nacimiento.
 *   - Un número aleatorio de 4 dígitos.
 *
 * Conceptos practicados:
 *   - substring() para extraer porciones de una cadena.
 *   - toUpperCase() para normalizar a mayúsculas.
 *   - Random.nextInt() para generar un valor aleatorio.
 *   - Formateo del ID con guiones para legibilidad.
 */
public class GeneradorIdUsuario {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String inicialesNombre = scanner.nextLine().toUpperCase().substring(0, 2);

        System.out.print("Ingrese sus apellidos: ");
        String inicialesApellido = scanner.nextLine().toUpperCase().substring(0, 2);

        System.out.print("Ingrese su año de nacimiento (ej. 1995): ");
        String anioNacimiento = scanner.nextLine();
        String digitosAnio = anioNacimiento.substring(2, 4);

        int numeroAleatorio = random.nextInt(10000);

        // ID formateado: NA-AP-95-XXXX
        String idUsuario = inicialesNombre + "-" + inicialesApellido
                + "-" + digitosAnio + "-" + numeroAleatorio;

        System.out.println("\nID generado: " + idUsuario);

        scanner.close();
    }
}
