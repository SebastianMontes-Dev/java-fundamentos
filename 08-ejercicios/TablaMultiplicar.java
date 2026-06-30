import java.util.Scanner;

/**
 * ============================================================
 *  TEMA: Ejercicios Aplicados en Java
 *  SECCIÓN: 08 — Ejercicios
 *  ARCHIVO: TablaMultiplicar.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Combinarás entrada de usuario, bucles for y formateo de salida para crear
 *  un generador de tablas de multiplicar. Pedirás un número al usuario, iterarás
 *  del 1 al 10 calculando cada producto, y usarás printf() para alinear los
 *  resultados en columnas. Este patrón de "entrada → procesamiento en bucle →
 *  salida formateada" es ubicuo en aplicaciones de consola.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Scanner.nextInt(): lectura de un número entero desde consola.
 *  - Bucle for: iteración controlada de 1 a 10.
 *  - printf(): formateo de salida con especificadores (%d, %2d, %n).
 *  - Aritmética básica: multiplicación dentro del bucle.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  for (int i = 1; i <= 10; i++) {
 *      System.out.printf("%d x %2d = %d%n", numero, i, numero * i);
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar println() en vez de printf() para salida tabular (queda desalineado).
 *  - Olvidar cerrar el Scanner después de usarlo.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html
 * ============================================================
 */
public class TablaMultiplicar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número para ver su tabla de multiplicar: ");
        int numero = scanner.nextInt();

        System.out.println();
        System.out.println("Tabla de multiplicar del " + numero);
        System.out.println("================================");

        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            System.out.printf("%d x %2d = %d%n", numero, i, resultado);
        }

        scanner.close();
    }
}
