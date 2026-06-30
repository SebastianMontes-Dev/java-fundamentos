/**
 * ============================================================
 *  TEMA: Colecciones en Java — HashMap
 *  SECCIÓN: 19 — Colecciones
 *  ARCHIVO: HashMapEjemplo.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  `HashMap` es una colección que almacena pares CLAVE-VALOR. Cada clave es ÚNICA
 *  y se asocia a un valor; puedes recuperar instantáneamente cualquier valor
 *  conociendo su clave. Internamente usa una tabla hash para lograr búsquedas
 *  ultrarrápidas (O(1) en promedio). Es perfecto para diccionarios, cachés,
 *  configuraciones y cualquier escenario donde necesites mapear identificadores
 *  a datos.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - HashMap<K, V>: K = tipo de la clave, V = tipo del valor.
 *  - put(clave, valor): inserta o actualiza un par clave-valor.
 *  - get(clave): recupera el valor asociado a la clave (null si no existe).
 *  - containsKey(clave): verifica si una clave existe en el mapa.
 *  - keySet(): devuelve un conjunto con todas las claves.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  import java.util.HashMap;
 *  HashMap<String, Integer> edades = new HashMap<>();
 *  edades.put("Ana", 25);
 *  System.out.println(edades.get("Ana")); // 25
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar tipos mutables como clave (si el hashCode cambia, pierdes la entrada).
 *  - Asumir que get() devuelve un valor (puede ser null si la clave no existe).
 *  - Iterar sobre HashMap asumiendo un orden (NO garantiza orden de inserción).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
 * ============================================================
 */
import java.util.HashMap;

public class HashMapEjemplo {

    public static void main(String[] args) {

        System.out.println("=== HashMap en Java ===\n");

        // Creamos un HashMap: clave = String (nombre), valor = Integer (edad)
        HashMap<String, Integer> edades = new HashMap<>();

        // Agregar pares clave-valor con put()
        System.out.println("--- Registrando edades ---");
        edades.put("Ana", 25);
        edades.put("Carlos", 30);
        edades.put("María", 28);
        edades.put("Pedro", 22);

        // Obtener valor por clave con get()
        System.out.println("Edad de Ana: " + edades.get("Ana"));
        System.out.println("Edad de María: " + edades.get("María"));

        // Si la clave no existe, get() devuelve null
        System.out.println("Edad de Juan (no existe): " + edades.get("Juan"));

        // Actualizar un valor: usar put() con la misma clave SOBREESCRIBE
        edades.put("Ana", 26);
        System.out.println("\nNueva edad de Ana (actualizada): " + edades.get("Ana"));

        // Verificar si una clave existe
        System.out.println("\n--- Verificando existencia ---");
        System.out.println("¿Existe 'Carlos'? " + edades.containsKey("Carlos"));
        System.out.println("¿Existe 'Laura'? " + edades.containsKey("Laura"));

        // Recorrer todas las entradas del HashMap
        System.out.println("\n--- Todas las personas registradas ---");
        for (String nombre : edades.keySet()) {
            System.out.println("  " + nombre + " tiene " + edades.get(nombre) + " años");
        }

        System.out.println("\nTotal de registros: " + edades.size());

        // Eliminar una entrada
        edades.remove("Pedro");
        System.out.println("Después de eliminar a Pedro: " + edades.size() + " registros");
    }
}
