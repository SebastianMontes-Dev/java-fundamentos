/**
 * ============================================================
 *  TEMA: Colecciones en Java — Iteración
 *  SECCIÓN: 13 — Colecciones
 *  ARCHIVO: IterarColecciones.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Existen múltiples formas de recorrer (iterar) colecciones en Java: el bucle
 *  for-each (más legible), el bucle for clásico con índice (solo para listas),
 *  el Iterator (permite eliminar durante la iteración) y el método forEach()
 *  con expresiones lambda (Java 8+). Conocer cada método te permitirá elegir
 *  la herramienta correcta según necesites solo leer o también modificar.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - for-each: `for (Tipo elem : coleccion)` — simple, solo lectura.
 *  - for clásico: acceso por índice, útil para listas.
 *  - Iterator: permite eliminar elementos de forma segura durante la iteración.
 *  - forEach + lambda: estilo funcional, muy conciso (Java 8+).
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  // for-each
 *  for (String item : lista) { System.out.println(item); }
 *  // Iterator
 *  Iterator<String> it = lista.iterator();
 *  while (it.hasNext()) { System.out.println(it.next()); }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar for-each y modificar la colección (ConcurrentModificationException).
 *  - Llamar a next() sin verificar hasNext() en Iterator.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/collections/interfaces/collection.html
 * ============================================================
 */
import java.util.ArrayList;
import java.util.Iterator;

public class IterarColecciones {

    public static void main(String[] args) {

        System.out.println("=== Formas de Iterar Colecciones en Java ===\n");

        ArrayList<String> lenguajes = new ArrayList<>();
        lenguajes.add("Java");
        lenguajes.add("Python");
        lenguajes.add("JavaScript");
        lenguajes.add("C#");
        lenguajes.add("Go");

        // Método 1: for-each (el más común y legible cuando solo necesitas leer)
        System.out.println("--- 1. Bucle for-each ---");
        for (String lenguaje : lenguajes) {
            System.out.println("  Lenguaje: " + lenguaje);
        }

        // Método 2: for clásico con índice (necesitas el índice para algo más)
        System.out.println("\n--- 2. Bucle for con índice ---");
        for (int i = 0; i < lenguajes.size(); i++) {
            System.out.println("  [" + i + "] " + lenguajes.get(i));
        }

        // Método 3: Iterator (permite eliminar elementos de forma segura)
        System.out.println("\n--- 3. Iterator (recorriendo y eliminando) ---");
        ArrayList<String> copia = new ArrayList<>(lenguajes);
        Iterator<String> iterador = copia.iterator();

        while (iterador.hasNext()) {
            String lenguaje = iterador.next();
            if (lenguaje.startsWith("J")) {
                // Eliminación segura con Iterator.remove()
                iterador.remove();
                System.out.println("  Eliminado: " + lenguaje);
            }
        }
        System.out.println("  Lista resultante: " + copia);

        // Método 4: forEach + expresión lambda (Java 8+, estilo funcional)
        System.out.println("\n--- 4. forEach con Lambda (Java 8+) ---");
        lenguajes.forEach(lenguaje -> System.out.println("  -> " + lenguaje));

        // Método 5: forEach + method reference (incluso más conciso)
        System.out.println("\n--- 5. forEach con Method Reference ---");
        lenguajes.forEach(System.out::println);
    }
}
