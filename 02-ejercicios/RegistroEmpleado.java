import java.util.Scanner;

/**
 * Ejercicio: Registro de datos de un empleado.
 *
 * El programa solicita al usuario los datos de un empleado (nombre, edad,
 * salario y si es jefe de departamento) y los muestra formateados en consola.
 *
 * Conceptos practicados:
 *   - Lectura de distintos tipos con Scanner.
 *   - Conversión con Integer.parseInt(), Double.parseDouble(), Boolean.parseBoolean().
 *   - Uso de \t (tabulador) para alinear la salida.
 *   - Uso de \n (salto de línea) para separar secciones.
 */
public class RegistroEmpleado {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre del empleado: ");
        String empleado = scanner.nextLine();

        System.out.print("Ingrese su edad: ");
        int edad = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese su salario: ");
        double salario = Double.parseDouble(scanner.nextLine());

        System.out.print("¿Es jefe del departamento? (true/false): ");
        boolean esJefe = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("\nDatos del empleado:");
        System.out.println("\tNombre:  " + empleado);
        System.out.println("\tEdad:    " + edad);
        System.out.println("\tSalario: " + salario);
        System.out.println("\tJefe:    " + esJefe);

        scanner.close();
    }
}
