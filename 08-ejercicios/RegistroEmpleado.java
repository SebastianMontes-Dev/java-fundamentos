import java.util.Scanner;

/**
 * ============================================================
 *  TEMA: Ejercicios Aplicados en Java
 *  SECCIÓN: 08 — Ejercicios
 *  ARCHIVO: RegistroEmpleado.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Crearás un formulario de registro de empleados por consola que captura
 *  diferentes tipos de datos: texto (nombre), entero (edad), decimal (salario)
 *  y booleano (es jefe). Aprenderás a convertir Strings a tipos numéricos con
 *  los métodos parse de las clases envolventes (wrapper classes) y a formatear
 *  la salida de manera profesional con tabuladores.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Integer.parseInt(String): convierte texto a entero.
 *  - Double.parseDouble(String): convierte texto a decimal de doble precisión.
 *  - Boolean.parseBoolean(String): convierte texto a booleano.
 *  - Secuencias de escape \t (tabulador) y \n (salto de línea) para formatear salida.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  int edad = Integer.parseInt(sc.nextLine());
 *  double salario = Double.parseDouble(sc.nextLine());
 *  System.out.println("\tNombre: " + nombre);
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Intentar convertir texto no numérico con parseInt: lanza NumberFormatException.
 *  - Usar sc.nextInt() y luego sc.nextLine() sin limpiar el buffer.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Integer.html
 * ============================================================
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
