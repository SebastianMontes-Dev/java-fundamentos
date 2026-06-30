/**
 * ============================================================
 *  TEMA: Colecciones en Java — HashSet
 *  SECCIÓN: 19 — Colecciones
 *  ARCHIVO: HashSetEjemplo.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  `HashSet` es una colección que NO permite elementos DUPLICADOS y NO garantiza
 *  ningún orden de iteración. Internamente usa una tabla hash (como HashMap pero
 *  solo con claves, sin valores). Es la opción ideal cuando necesitas almacenar
 *  elementos únicos y realizar búsquedas rápidas de pertenencia (contains).
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Unicidad: no admite duplicados (determinado por equals() y hashCode()).
 *  - Sin orden: los elementos no se almacenan en orden de inserción.
 *  - contains(): búsqueda en O(1) promedio.
 *  - add(): devuelve false si el elemento ya existía.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  HashSet<String> conjunto = new HashSet<>();
 *  conjunto.add("Java");
 *  System.out.println(conjunto.contains("Java")); // true
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Asumir que HashSet mantiene orden de inserción (para eso usa LinkedHashSet).
 *  - No sobrescribir equals() y hashCode() en clases propias (comportamiento inesperado).
 *  - Intentar acceder por índice (no tiene, no es una lista).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/8/docs/api/java/util/HashSet.html
 * ============================================================
 */
import java.util.HashSet;

public class HashSetEjemplo {

    public static void main(String[] args) {

        System.out.println("=== HashSet en Java ===\n");

        HashSet<String> paises = new HashSet<>();

        // Agregar elementos con add()
        System.out.println("--- Agregando países ---");
        System.out.println("Agregando 'México': " + paises.add("México"));     // true
        System.out.println("Agregando 'España': " + paises.add("España"));     // true
        System.out.println("Agregando 'Argentina': " + paises.add("Argentina")); // true
        System.out.println("Agregando 'México': " + paises.add("México"));     // false (duplicado)

        System.out.println("\nTamaño del conjunto: " + paises.size());
        System.out.println("Elementos (sin orden garantizado): " + paises);

        // Verificar pertenencia con contains() — O(1) en promedio
        System.out.println("\n--- Verificando miembros ---");
        System.out.println("¿Contiene 'España'? " + paises.contains("España"));
        System.out.println("¿Contiene 'Brasil'? " + paises.contains("Brasil"));

        // Eliminar un elemento
        paises.remove("Argentina");
        System.out.println("\nDespués de eliminar 'Argentina': " + paises);

        // Operaciones de conjunto: unión, intersección, diferencia
        HashSet<String> america = new HashSet<>();
        america.add("México");
        america.add("Colombia");
        america.add("Chile");

        System.out.println("\n--- Operaciones entre conjuntos ---");
        System.out.println("Conjunto A (países): " + paises);
        System.out.println("Conjunto B (américa): " + america);

        // Unión: todos los elementos de A + B (sin duplicados)
        HashSet<String> union = new HashSet<>(paises);
        union.addAll(america);
        System.out.println("Unión (A ∪ B): " + union);

        // Intersección: elementos que están en A Y en B
        HashSet<String> interseccion = new HashSet<>(paises);
        interseccion.retainAll(america);
        System.out.println("Intersección (A ∩ B): " + interseccion);
    }
}
