/**
 * ============================================================
 *  TEMA: Arreglos (Arrays) Unidimensionales en Java
 *  SECCIÓN: 08 — Arrays
 *  ARCHIVO: IntroducirEnterosEnArreglo.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Combinarás Scanner con arreglos para crear un programa que pide al usuario
 *  el tamaño del arreglo, lo llena con valores ingresados por teclado y luego
 *  recorre el arreglo mostrando cada índice con su valor. Este es el patrón
 *  fundamental de "carga y recorrido de datos" usado en inventarios, notas de
 *  estudiantes y cualquier sistema que procese listas de valores.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Tamaño dinámico: el usuario determina cuántos elementos tendrá el arreglo.
 *  - Llenado con bucle for: iterar desde 0 hasta arreglo.length para asignar valores.
 *  - Recorrido con bucle for: leer cada posición usando el mismo índice.
 *  - arreglo.length: propiedad que devuelve el tamaño del arreglo.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  var arreglo = new int[tamaño];
 *  for (var i = 0; i < arreglo.length; i++) {
 *      arreglo[i] = valorIngresado;
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar `<= arreglo.length` en vez de `<` (causa ArrayIndexOutOfBoundsException).
 *  - No consumir el salto de línea después de nextInt() al alternar con nextLine().
 *  - No cerrar el Scanner al final del programa.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html
 * ============================================================
 */
import java.util.Scanner;

public class IntroducirEnterosEnArreglo {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        // Paso 1: El usuario define el tamaño del arreglo
        System.out.print("Ingrese el tamaño del arreglo: ");
        var tamano = sc.nextInt();

        // Paso 2: Creamos el arreglo con el tamaño especificado
        var arreglo = new int[tamano];

        // Paso 3: Llenamos el arreglo con valores del usuario
        System.out.println("\n--- Ingrese los " + tamano + " números ---");
        for (var i = 0; i < arreglo.length; i++) {
            System.out.print("Posición " + i + ": ");
            arreglo[i] = sc.nextInt();
        }

        // Paso 4: Recorremos el arreglo para mostrar todos los valores
        System.out.println("\n--- Contenido del arreglo ---");
        for (var i = 0; i < arreglo.length; i++) {
            System.out.println("Índice [" + i + "] = " + arreglo[i]);
        }

        sc.close();
    }
}
