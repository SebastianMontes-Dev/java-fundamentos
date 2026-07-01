import java.util.*;

/**
 * ============================================================
 *  TEMA: Orden Natural de Objetos con Comparable
 *  SECCIÓN: 21 — Ordenamiento y Optional
 *  ARCHIVO: ComparableBasico.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Comparable es la interfaz que define el ORDEN NATURAL de una clase.
 *  Cuando una clase implementa Comparable<T>, estás diciendo "esta es
 *  la forma canónica de ordenar estos objetos": personas por nombre,
 *  transacciones por fecha, productos por precio. Collections.sort()
 *  y Arrays.sort() usan Comparable para ordenar automáticamente.
 *
 *  El método compareTo() devuelve: NEGATIVO si this < otro, CERO si
 *  son iguales, POSITIVO si this > otro. La magia está en que tipos
 *  como String, Integer y LocalDate YA implementan Comparable — puedes
 *  delegar en su compareTo() para ahorrar trabajo.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - interface Comparable<T>: método compareTo(T otro).
 *  - compareTo retorna: <0 (menor), 0 (igual), >0 (mayor).
 *  - Collections.sort(lista): ordena usando Comparable.
 *  - TreeSet y TreeMap: colecciones que MANTIENEN el orden natural.
 *  - Delegar en compareTo de String, Integer, etc. para comparar campos.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  class Persona implements Comparable<Persona> {
 *      public int compareTo(Persona otra) {
 *          return this.nombre.compareTo(otra.nombre);
 *      }
 *  }
 *  Collections.sort(listaPersonas); // ordena por nombre
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Restar edades directamente (puede causar overflow con int).
 *  - Olvidar el genérico <T> en el implements.
 *  - compareTo inconsistente con equals (rompe TreeSet).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Comparable.html
 * ============================================================
 */
public class ComparableBasico {

    public static void main(String[] args) {
        System.out.println("=== Comparable: Orden Natural de Objetos ===");
        System.out.println();

        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Carlos", 22, 8.5));
        estudiantes.add(new Estudiante("Ana", 20, 9.2));
        estudiantes.add(new Estudiante("Beto", 25, 7.8));
        estudiantes.add(new Estudiante("Diana", 21, 9.5));
        estudiantes.add(new Estudiante("Ana", 23, 8.0));

        System.out.println("--- Original ---");
        estudiantes.forEach(e -> System.out.println("  " + e));
        System.out.println();

        // Orden natural: por nombre, luego por edad
        System.out.println("--- Orden Natural (nombre → edad) ---");
        Collections.sort(estudiantes);
        estudiantes.forEach(e -> System.out.println("  " + e));
        System.out.println();

        // TreeSet: mantiene el orden natural automáticamente
        System.out.println("--- TreeSet (orden automático) ---");
        Set<Estudiante> treeSet = new TreeSet<>();
        treeSet.add(new Estudiante("Zoe", 20, 7.0));
        treeSet.add(new Estudiante("Abel", 21, 8.0));
        treeSet.add(new Estudiante("María", 19, 9.0));
        treeSet.add(new Estudiante("Abel", 20, 8.5)); // Mismo nombre, diferente edad

        System.out.println("(Agregados en desorden, TreeSet los ordena solo)");
        treeSet.forEach(e -> System.out.println("  " + e));
        System.out.println();

        // Demostración de compareTo con números (delegando a Integer)
        System.out.println("--- Orden Natural con Tarea (por prioridad) ---");

        List<Tarea> tareas = new ArrayList<>();
        tareas.add(new Tarea("Hacer informe", 3));
        tareas.add(new Tarea("Revisar bugs", 1));
        tareas.add(new Tarea("Actualizar docs", 5));
        tareas.add(new Tarea("Responder emails", 2));

        Collections.sort(tareas);
        System.out.println("Ordenadas por prioridad (1 = más urgente):");
        tareas.forEach(t -> System.out.println("  " + t));
    }
}

class Estudiante implements Comparable<Estudiante> {
    private String nombre;
    private int edad;
    private double promedio;

    public Estudiante(String nombre, int edad, double promedio) {
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public double getPromedio() { return promedio; }

    /**
     * Orden natural: primero por nombre alfabéticamente,
     * luego por edad (si mismo nombre).
     */
    @Override
    public int compareTo(Estudiante otro) {
        int comparacionNombre = this.nombre.compareTo(otro.nombre);
        if (comparacionNombre != 0) {
            return comparacionNombre; // Diferente nombre → ordenar por nombre
        }
        // Mismo nombre → ordenar por edad
        return Integer.compare(this.edad, otro.edad);
    }

    @Override
    public String toString() {
        return String.format("%s (edad: %d, promedio: %.1f)", nombre, edad, promedio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante)) return false;
        Estudiante e = (Estudiante) o;
        return edad == e.edad && nombre.equals(e.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad);
    }
}

class Tarea implements Comparable<Tarea> {
    private String descripcion;
    private int prioridad; // 1 = más urgente

    public Tarea(String descripcion, int prioridad) {
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    @Override
    public int compareTo(Tarea otra) {
        return Integer.compare(this.prioridad, otra.prioridad);
    }

    @Override
    public String toString() {
        return "Prioridad " + prioridad + ": " + descripcion;
    }
}
