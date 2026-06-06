import java.util.Scanner;

/**
 * ============================================================
 *  TEMA: Entrada de Datos por Consola con Scanner
 *  SECCIÓN: 03 — Scanner
 *  ARCHIVO: EntradaConsola.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Scanner es la clase principal para leer datos ingresados por el usuario desde
 *  la terminal. Aquí aprenderás a crear un objeto Scanner conectado a System.in,
 *  leer una línea de texto completa con nextLine() y la buena práctica de cerrar
 *  el Scanner al finalizar. Es la base de toda aplicación de consola interactiva.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - System.in: flujo de entrada estándar (el teclado).
 *  - Scanner: clase que facilita la lectura de datos desde cualquier InputStream.
 *  - nextLine(): lee una línea completa de texto (hasta el Enter).
 *  - close(): libera los recursos asociados al Scanner.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  Scanner sc = new Scanner(System.in);
 *  System.out.print("Ingrese su nombre: ");
 *  String nombre = sc.nextLine();
 *  sc.close();
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - No cerrar el Scanner: aunque el programa termine, es mala práctica dejar recursos abiertos.
 *  - Mezclar nextInt()/nextDouble() con nextLine() sin consumir el salto de línea pendiente.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html
 * ============================================================
 */
public class EntradaConsola {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Su nombre es: " + nombre);

        scanner.close();
    }
}
