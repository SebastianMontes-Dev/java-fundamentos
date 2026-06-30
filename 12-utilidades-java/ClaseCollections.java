import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ============================================================
 *  TEMA: La Clase Collections en Java
 *  SECCIÓN: 12 — Utilidades de Java
 *  ARCHIVO: ClaseCollections.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  java.util.Collections es el equivalente de Arrays pero para colecciones
 *  (List, Set, Map). Es una clase llena de métodos static que resuelven
 *  las operaciones más comunes: ordenar listas, invertirlas, mezclarlas
 *  aleatoriamente, encontrar el mínimo y máximo, contar ocurrencias, y
 *  hacer búsqueda binaria en listas ordenadas.
 *
 *  Un detalle importante: Collections es una CLASE con métodos static,
 *  mientras que Collection (sin 's') es una INTERFAZ. No las confundas.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - sort(list): ordena la lista (modifica la original).
 *  - reverse(list): invierte el orden de los elementos.
 *  - shuffle(list): mezcla aleatoriamente.
 *  - min(list) / max(list): encuentra el mínimo/máximo.
 *  - frequency(list, elemento): cuenta cuántas veces aparece.
 *  - binarySearch(list, key): búsqueda binaria (requiere lista ordenada).
 *  - fill(list, valor): reemplaza todos los elementos con un valor.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  List<Integer> nums = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5));
 *  Collections.sort(nums);    // [1, 1, 3, 4, 5]
 *  Collections.reverse(nums); // [5, 4, 3, 1, 1]
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Confundir Collection (interfaz) con Collections (clase utilidad).
 *  - Ordenar listas con nulls en el medio (NullPointerException).
 *  - binarySearch en lista no ordenada da resultado impredecible.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Collections.html
 * ============================================================
 */
public class ClaseCollections {

    public static void main(String[] args) {
        System.out.println("=== La Clase Collections: Operaciones con Listas ===");
        System.out.println();

        List<Integer> numeros = new ArrayList<>(Arrays.asList(8, 3, 5, 1, 9, 2, 3, 7));

        // --- ORDENAR ---
        System.out.println("--- sort(): Ordenar ---");
        System.out.println("Original:  " + numeros);
        Collections.sort(numeros);
        System.out.println("Ordenado:  " + numeros);
        System.out.println();

        // --- INVERTIR ---
        System.out.println("--- reverse(): Invertir ---");
        Collections.reverse(numeros);
        System.out.println("Invertido: " + numeros);
        System.out.println();

        // --- MEZCLAR ALEATORIAMENTE ---
        System.out.println("--- shuffle(): Mezclar ---");
        List<String> cartas = new ArrayList<>(Arrays.asList(
                "A♠", "K♠", "Q♠", "J♠", "10♠", "A♥", "K♥", "Q♥"
        ));
        System.out.println("Baraja:  " + cartas);
        Collections.shuffle(cartas);
        System.out.println("Mezclada: " + cartas);
        System.out.println();

        // --- MÍNIMO Y MÁXIMO ---
        System.out.println("--- min() y max() ---");
        System.out.println("Lista:    " + numeros);
        System.out.println("Mínimo:   " + Collections.min(numeros));
        System.out.println("Máximo:   " + Collections.max(numeros));

        List<String> palabras = Arrays.asList("Java", "Python", "C", "Rust", "Go");
        System.out.println("Palabras: " + palabras);
        System.out.println("Mín (alfabético): " + Collections.min(palabras));
        System.out.println("Máx (alfabético): " + Collections.max(palabras));
        System.out.println();

        // --- FRECUENCIA ---
        System.out.println("--- frequency(): Contar Ocurrencias ---");

        List<String> votos = Arrays.asList(
                "Sí", "No", "Sí", "Sí", "Abstención", "No", "Sí"
        );
        System.out.println("Votos: " + votos);
        System.out.println("'Sí': " + Collections.frequency(votos, "Sí") + " votos");
        System.out.println("'No': " + Collections.frequency(votos, "No") + " votos");
        System.out.println("'Abstención': " + Collections.frequency(votos, "Abstención") + " votos");
        System.out.println();

        // --- BÚSQUEDA BINARIA ---
        System.out.println("--- binarySearch(): Búsqueda ---");

        List<Integer> ordenada = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70));
        int pos = Collections.binarySearch(ordenada, 40);
        System.out.println("Lista: " + ordenada);
        System.out.println("binarySearch(40): índice " + pos);
        System.out.println("(Requiere lista ORDENADA)");
        System.out.println();

        // --- LLENAR ---
        System.out.println("--- fill(): Rellenar ---");

        List<String> iniciales = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println("Antes: " + iniciales);
        Collections.fill(iniciales, "X");
        System.out.println("fill(\"X\"): " + iniciales);
    }
}
