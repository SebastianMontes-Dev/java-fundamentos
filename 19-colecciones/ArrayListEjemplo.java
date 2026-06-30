/**
 * ============================================================
 *  TEMA: Colecciones en Java — ArrayList
 *  SECCIÓN: 19 — Colecciones
 *  ARCHIVO: ArrayListEjemplo.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  `ArrayList` es una de las colecciones más usadas en Java. A diferencia de los
 *  arreglos tradicionales, su TAMAÑO es DINÁMICO: crece y decrece automáticamente
 *  según agregas o eliminas elementos. Pertenece al paquete `java.util` y usa un
 *  arreglo interno redimensionable. Es ideal para listas donde necesitas agregar
 *  elementos frecuentemente y acceder por índice.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - ArrayList<T>: colección genérica que almacena objetos del tipo T.
 *  - add(elemento): agrega un elemento al final de la lista.
 *  - get(indice): obtiene el elemento en la posición indicada.
 *  - remove(indice): elimina el elemento en la posición indicada.
 *  - size(): devuelve la cantidad de elementos actuales.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  import java.util.ArrayList;
 *  ArrayList<String> lista = new ArrayList<>();
 *  lista.add("Manzana");
 *  System.out.println(lista.get(0)); // "Manzana"
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar tipos primitivos como genérico: ArrayList<int> NO compila, debe ser Integer.
 *  - Acceder a un índice fuera de rango: IndexOutOfBoundsException.
 *  - Modificar la lista mientras se itera con for-each (ConcurrentModificationException).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
 * ============================================================
 */
import java.util.ArrayList;

public class ArrayListEjemplo {

    public static void main(String[] args) {

        System.out.println("=== ArrayList en Java ===\n");

        // Declaramos un ArrayList que almacenará Strings
        // Nota: ArrayList usa genéricos <String> para seguridad de tipos
        ArrayList<String> frutas = new ArrayList<>();

        // Agregar elementos al final de la lista con add()
        System.out.println("--- Agregando frutas ---");
        frutas.add("Manzana");
        frutas.add("Banana");
        frutas.add("Naranja");
        frutas.add("Uva");

        // size() devuelve la cantidad de elementos
        System.out.println("Total de frutas: " + frutas.size());

        // Acceder por índice con get()
        System.out.println("\n--- Accediendo por índice ---");
        System.out.println("Fruta en índice 0: " + frutas.get(0));
        System.out.println("Fruta en índice 2: " + frutas.get(2));

        // Insertar en una posición específica (el resto se desplaza)
        frutas.add(1, "Fresa");
        System.out.println("\nDespués de insertar Fresa en índice 1:");
        mostrarLista(frutas);

        // Eliminar por índice
        frutas.remove(3); // elimina "Naranja"
        System.out.println("\nDespués de eliminar el índice 3:");
        mostrarLista(frutas);

        // Verificar si un elemento existe
        System.out.println("\n¿Contiene 'Banana'? " + frutas.contains("Banana"));
        System.out.println("¿Contiene 'Sandía'? " + frutas.contains("Sandía"));

        // Limpiar toda la lista
        frutas.clear();
        System.out.println("\nDespués de clear(), tamaño: " + frutas.size());
    }

    static void mostrarLista(ArrayList<String> lista) {
        // for-each: itera automáticamente sobre cada elemento
        for (String fruta : lista) {
            System.out.println("  - " + fruta);
        }
    }
}
