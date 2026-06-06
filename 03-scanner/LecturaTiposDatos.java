import java.util.Scanner;

/**
 * ============================================================
 *  TEMA: Entrada de Datos por Consola con Scanner
 *  SECCIÓN: 03 — Scanner
 *  ARCHIVO: LecturaTiposDatos.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Scanner tiene métodos especializados para cada tipo de dato primitivo:
 *  nextInt(), nextDouble(), nextBoolean(), nextLine(), etc. Aprenderás dos enfoques:
 *  el directo (más corto) y el robusto con nextLine() + parseo (evita el molesto
 *  bug del salto de línea pendiente). Conocer ambos te ahorrará horas de debugging.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - nextInt() / nextDouble(): leen el tipo directamente (dejan \n pendiente).
 *  - nextLine() adicional: consume el salto de línea que dejan los métodos numéricos.
 *  - Integer.parseInt() / Double.parseDouble(): convierten String a número.
 *  - Enfoque robusto: siempre leer con nextLine() y convertir manualmente.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  // Enfoque directo (más simple pero con precaución):
 *  int edad = sc.nextInt();
 *  sc.nextLine(); // consumir salto de línea
 *
 *  // Enfoque robusto:
 *  int edad = Integer.parseInt(sc.nextLine());
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar nextInt() y luego nextLine() sin consumir el \n: el nextLine() lee vacío.
 *  - Intentar leer un double con nextInt() o viceversa: InputMismatchException.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html
 * ============================================================
 */
public class LecturaTiposDatos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Enfoque 1: métodos directos ---

        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();
        System.out.println("Su edad es: " + edad);

        System.out.print("Ingrese su altura: ");
        double altura = scanner.nextDouble();
        System.out.println("Su altura es: " + altura);

        // nextInt() y nextDouble() dejan un salto de línea pendiente.
        // Se consume con un nextLine() extra antes de leer la siguiente cadena.
        scanner.nextLine();

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Su nombre es: " + nombre);

        // --- Enfoque 2: leer como String y convertir ---

        System.out.print("Ingrese un valor entero (usando conversión): ");
        String texto = scanner.nextLine();
        int enteroConvertido = Integer.parseInt(texto);
        System.out.println("El valor entero convertido es: " + enteroConvertido);

        scanner.close();
    }
}
