import java.util.Arrays;
import java.util.List;

/**
 * ============================================================
 *  TEMA: La Clase Arrays en Java
 *  SECCIÓN: 12 — Utilidades de Java
 *  ARCHIVO: ClaseArrays.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  java.util.Arrays es el kit de herramientas definitivo para trabajar
 *  con arreglos. En vez de escribir bucles para ordenar, buscar o
 *  comparar arreglos manualmente, esta clase te da métodos ya probados
 *  y optimizados: sort() ordena con QuickSort/DualPivot, binarySearch()
 *  encuentra elementos en O(log n), fill() rellena todo el arreglo,
 *  copyOf() crea copias redimensionadas, y toString() convierte el
 *  arreglo a String para imprimirlo bonito en una línea.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - sort(arr): ordena el arreglo in-place (modifica el original).
 *  - binarySearch(arr, key): búsqueda binaria (requiere arreglo ordenado).
 *  - fill(arr, value): llena todo el arreglo con un valor.
 *  - copyOf(original, newLength): crea una copia (trunca o rellena con 0).
 *  - toString(arr): [1, 2, 3] en vez de basura como [I@4617c264.
 *  - deepToString(matriz): para arreglos multidimensionales.
 *  - equals(a, b): compara contenido de dos arreglos.
 *  - asList(arr): convierte arreglo a List (tamaño fijo).
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  int[] nums = {3, 1, 4, 1, 5};
 *  Arrays.sort(nums);             // [1, 1, 3, 4, 5]
 *  System.out.println(Arrays.toString(nums));
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - binarySearch() en arreglo NO ordenado da resultado impredecible.
 *  - Usar arr.toString() en vez de Arrays.toString(arr).
 *  - La lista de asList() tiene tamaño FIJO: no puedes add() ni remove().
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Arrays.html
 * ============================================================
 */
public class ClaseArrays {

    public static void main(String[] args) {
        System.out.println("=== La Clase Arrays: Domina los Arreglos ===");
        System.out.println();

        // --- ORDENAR ---
        System.out.println("--- sort(): Ordenar ---");

        int[] numeros = {5, 2, 8, 1, 9, 3};
        System.out.println("Original:  " + Arrays.toString(numeros));

        Arrays.sort(numeros);
        System.out.println("Ordenado:  " + Arrays.toString(numeros));
        System.out.println();

        // --- ORDENAR PARCIAL ---
        System.out.println("--- sort(fromIndex, toIndex): Ordenar Rango ---");

        int[] parcial = {9, 7, 5, 3, 1, 8};
        System.out.println("Antes:     " + Arrays.toString(parcial));
        Arrays.sort(parcial, 2, 5);
        System.out.println("sort(2,5): " + Arrays.toString(parcial) + " (solo índices 2-4 ordenados)");
        System.out.println();

        // --- BÚSQUEDA BINARIA ---
        System.out.println("--- binarySearch(): Búsqueda Rápida ---");

        int[] datos = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int indice = Arrays.binarySearch(datos, 40);
        System.out.println("Arreglo:   " + Arrays.toString(datos));
        System.out.println("binarySearch(40): índice " + indice);

        int noExiste = Arrays.binarySearch(datos, 45);
        System.out.println("binarySearch(45): " + noExiste + " (negativo = punto de inserción)");

        System.out.println("¡IMPORTANTE! binarySearch requiere arreglo ORDENADO");
        System.out.println();

        // --- LLENAR ---
        System.out.println("--- fill(): Rellenar ---");

        int[] vacio = new int[5];
        Arrays.fill(vacio, 7);
        System.out.println("fill(7):    " + Arrays.toString(vacio));

        int[] parcial2 = {1, 2, 3, 4, 5};
        Arrays.fill(parcial2, 1, 4, 99);
        System.out.println("fill(1,4,99): " + Arrays.toString(parcial2));
        System.out.println();

        // --- COPIAR ---
        System.out.println("--- copyOf(): Copiar y Redimensionar ---");

        int[] original = {1, 2, 3, 4, 5};
        int[] copiaIgual = Arrays.copyOf(original, original.length);
        int[] copiaMenor = Arrays.copyOf(original, 3);
        int[] copiaMayor = Arrays.copyOf(original, 8);

        System.out.println("Original:   " + Arrays.toString(original));
        System.out.println("copyOf(5):  " + Arrays.toString(copiaIgual));
        System.out.println("copyOf(3):  " + Arrays.toString(copiaMenor) + " (truncada)");
        System.out.println("copyOf(8):  " + Arrays.toString(copiaMayor) + " (rellena con 0)");
        System.out.println();

        // --- COMPARAR ---
        System.out.println("--- equals(): Comparar Contenido ---");

        int[] a = {1, 2, 3};
        int[] b = {1, 2, 3};
        int[] c = {1, 2, 4};

        System.out.println("a = " + Arrays.toString(a));
        System.out.println("b = " + Arrays.toString(b));
        System.out.println("c = " + Arrays.toString(c));
        System.out.println("a == b:      " + (a == b) + " (comparación de REFERENCIAS)");
        System.out.println("equals(a,b): " + Arrays.equals(a, b) + " (comparación de CONTENIDO)");
        System.out.println("equals(a,c): " + Arrays.equals(a, c));
        System.out.println();

        // --- CONVERTIR A LISTA ---
        System.out.println("--- asList(): Arreglo → Lista ---");

        String[] frutas = {"Manzana", "Banana", "Naranja"};
        List<String> listaFrutas = Arrays.asList(frutas);
        System.out.println("Lista: " + listaFrutas);
        System.out.println("(¡Cuidado! La lista tiene tamaño FIJO)");

        // listaFrutas.add("Uva");  // UnsupportedOperationException
        listaFrutas.set(0, "Pera");  // Modificar SÍ funciona
        System.out.println("Después de set(0, \"Pera\"): " + listaFrutas);
        System.out.println("Arreglo original: " + Arrays.toString(frutas));
        System.out.println("(La lista y el arreglo comparten los datos)");
    }
}
