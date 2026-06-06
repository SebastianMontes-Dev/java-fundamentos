/**
 * ============================================================
 *  TEMA: Arreglos (Arrays) Unidimensionales en Java
 *  SECCIÓN: 08 — Arrays
 *  ARCHIVO: ArreglosSintaxis.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Java ofrece múltiples formas de declarar e inicializar arreglos: la sintaxis
 *  clásica con `new`, la inicialización directa con llaves `{}` y la inferencia
 *  de tipos con `var`. Conocer las diferencias te ayudará a escribir código más
 *  limpio y a elegir la forma correcta según el contexto.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Inicialización por extensión: `int[] nums = {1, 2, 3, 4}` — la forma más concisa.
 *  - Inicialización con `new`: `int[] nums = new int[]{1, 2, 3, 4}` — más explícita.
 *  - Inferencia con `var`: `var nums = new int[]{1, 2, 3}` — requiere new int[] explícito.
 *  - Arreglos vacíos: `new int[tamaño]` reserva espacio sin valores iniciales específicos.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  int[] a = {10, 20, 30};              // forma abreviada
 *  var b = new int[]{10, 20, 30};       // con var (necesita new int[])
 *  int[] c = new int[3];                // arreglo vacío de tamaño 3
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar `var nums = {1, 2, 3}` sin `new int[]` — NO compila con var.
 *  - Declarar `int nums[]` en vez de `int[] nums` (ambas válidas, pero la primera
 *    es estilo C y menos legible en Java).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html
 * ============================================================
 */
public class ArreglosSintaxis {

    public static void main(String[] args) {

        System.out.println("=== Tres formas de inicializar arreglos en Java ===\n");

        // Forma 1: Inicialización directa con llaves (la más común y concisa)
        int[] enteros = {100, 200, 300, 400};
        System.out.println("Forma 1 - Con llaves:   " + java.util.Arrays.toString(enteros));

        // Forma 2: Usando 'new int[]' explícitamente (mismo resultado, más verboso)
        var enteros2 = new int[]{100, 200, 300, 400};
        System.out.println("Forma 2 - Con new int[]: " + java.util.Arrays.toString(enteros2));

        // Forma 3: Arreglo vacío con tamaño fijo (valores por defecto = 0)
        int[] enteros3 = new int[4];
        System.out.println("Forma 3 - Vacío (new int[4]): " + java.util.Arrays.toString(enteros3));

        // Nota: NO se puede hacer var enteros4 = {100, 200, 300};
        // La inferencia con var requiere la parte 'new int[]'
    }
}
