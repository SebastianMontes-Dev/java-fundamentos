/**
 * ============================================================
 *  TEMA: Estructuras de Control — Bucles en Java
 *  SECCIÓN: 07 — Bucles
 *  ARCHIVO: NumerosParesWhile.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Combinarás el bucle `while` con una condición `if` para filtrar valores
 *  dentro de un rango. El operador módulo `%` es la herramienta clave para
 *  determinar si un número es par (resto 0 al dividir entre 2). Este patrón
 *  es común en validaciones, filtros y procesamiento de datos por lotes.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Operador módulo (%): devuelve el resto de una división entera.
 *  - Número par: cualquier entero donde `numero % 2 == 0`.
 *  - Bucle con filtro: while que recorre un rango e if que selecciona valores.
 *  - Scanner para entrada dinámica del usuario.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  while (inicio <= fin) {
 *      if (inicio % 2 == 0) {
 *          System.out.println(inicio);
 *      }
 *      inicio++;
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Confundir `=` (asignación) con `==` (comparación) en la condición del if.
 *  - No cerrar el Scanner, dejando el recurso abierto.
 *  - No validar que el número inicial sea menor que el final.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
 * ============================================================
 */
import java.util.Scanner;

public class NumerosParesWhile {

    public static void main(String[] args) {
        // Creamos el Scanner para leer lo que el usuario escribe en consola
        var sc = new Scanner(System.in);

        // Solicitamos el rango de números al usuario
        System.out.print("Ingrese el número desde el que quiere ver los pares: ");
        var inicioPar = sc.nextInt();

        System.out.print("Ingrese el número final: ");
        var finPar = sc.nextInt();

        System.out.println("\nNúmeros pares entre " + inicioPar + " y " + finPar + ":");
        System.out.println("----------------------------------------");

        // Recorremos desde inicioPar hasta finPar
        while (inicioPar <= finPar) {

            // Si el número es divisible entre 2 sin dejar resto, es PAR
            if (inicioPar % 2 == 0) {
                System.out.println(inicioPar);
            }

            // Avanzamos al siguiente número (¡fundamental para no crear bucle infinito!)
            inicioPar++;
        }

        // Buenas prácticas: siempre cerrar el Scanner al terminar
        sc.close();
    }
}
