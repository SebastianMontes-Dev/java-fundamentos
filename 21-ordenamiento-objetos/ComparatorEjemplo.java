import java.util.*;

/**
 * ============================================================
 *  TEMA: Ordenamiento Múltiple con Comparator
 *  SECCIÓN: 21 — Ordenamiento y Optional
 *  ARCHIVO: ComparatorEjemplo.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Comparable define UN orden natural. Pero, ¿y si necesitas ordenar
 *  por diferentes criterios según el contexto? Por precio ascendente
 *  en la tienda, por calificación descendente en reseñas, por fecha
 *  en el historial. Comparator resuelve esto: defines el criterio de
 *  orden como un OBJETO SEPARADO, sin modificar la clase original.
 *
 *  Con Java 8+, crear Comparators es trivial: `Comparator.comparing()`
 *  extrae el campo, `thenComparing()` encadena criterios, `reversed()`
 *  invierte el orden. Es funcional, declarativo y mucho más limpio que
 *  las clases anónimas pre-Java 8.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Comparator<T>: interfaz con método compare(T a, T b).
 *  - comparing(Function): extrae un campo para comparar.
 *  - thenComparing(): segundo criterio de desempate.
 *  - reversed(): invierte el orden (ascendente ↔ descendente).
 *  - naturalOrder() / reverseOrder(): comparators predefinidos.
 *  - nullsFirst() / nullsLast(): manejo de valores null.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  Comparator<Persona> porEdad = Comparator.comparing(Persona::getEdad);
 *  Comparator<Persona> porNombreYEdad =
 *      Comparator.comparing(Persona::getNombre).thenComparing(Persona::getEdad);
 *  lista.sort(porEdad.reversed()); // descendente por edad
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Crear un Comparator nuevo cada vez (compílalo en una variable/constante).
 *  - Olvidar que reversed() requiere tipado explícito a veces.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Comparator.html
 * ============================================================
 */
public class ComparatorEjemplo {

    public static void main(String[] args) {
        System.out.println("=== Comparator: Múltiples Criterios de Orden ===");
        System.out.println();

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Laptop", "Electrónica", 999.99, 4.5));
        productos.add(new Producto("Mouse", "Electrónica", 25.50, 4.2));
        productos.add(new Producto("Teclado", "Electrónica", 79.99, 4.7));
        productos.add(new Producto("Harry Potter", "Libros", 19.99, 4.8));
        productos.add(new Producto("1984", "Libros", 14.99, 4.6));
        productos.add(new Producto("Silla", "Muebles", 149.99, 4.0));

        System.out.println("--- Original ---");
        productos.forEach(p -> System.out.println("  " + p));
        System.out.println();

        // --- COMPARATOR POR PRECIO ---
        System.out.println("--- Por Precio (ascendente) ---");
        Comparator<Producto> porPrecio = Comparator.comparing(Producto::getPrecio);
        productos.sort(porPrecio);
        productos.forEach(p -> System.out.println("  " + p));
        System.out.println();

        // --- COMPARATOR POR PRECIO DESCENDENTE ---
        System.out.println("--- Por Precio (descendente) ---");
        productos.sort(porPrecio.reversed());
        productos.forEach(p -> System.out.println("  " + p));
        System.out.println();

        // --- COMPARATOR POR CATEGORÍA Y LUEGO PRECIO ---
        System.out.println("--- Por Categoría → Precio ---");
        Comparator<Producto> porCategoriaYPrecio = Comparator
                .comparing(Producto::getCategoria)
                .thenComparing(Producto::getPrecio);
        productos.sort(porCategoriaYPrecio);
        productos.forEach(p -> System.out.println("  " + p));
        System.out.println();

        // --- COMPARATOR: MEJOR CALIFICACIÓN PRIMERO ---
        System.out.println("--- Por Calificación (mejores primero) ---");
        productos.sort(Comparator.comparing(Producto::getCalificacion).reversed());
        productos.forEach(p -> System.out.println("  " + p));
        System.out.println();

        // --- COMPARATOR PERSONALIZADO CON LAMBDA ---
        System.out.println("--- Por longitud del nombre ---");
        productos.sort((a, b) -> Integer.compare(
                a.getNombre().length(),
                b.getNombre().length()));
        productos.forEach(p -> System.out.println("  " + p));
        System.out.println();

        // --- COMPARATOR CON MÚLTIPLES CRITERIOS (estilo clásico) ---
        System.out.println("--- Demo: Ranking (precio desc, calificación desc) ---");

        List<Map.Entry<Producto, Double>> ranking = new ArrayList<>();
        for (Producto p : productos) {
            ranking.add(new AbstractMap.SimpleEntry<>(p, p.getPrecio() * p.getCalificacion()));
        }

        ranking.sort(Map.Entry.<Producto, Double>comparingByValue().reversed());

        System.out.println("Ranking (precio × calificación):");
        for (int i = 0; i < ranking.size(); i++) {
            Map.Entry<Producto, Double> entry = ranking.get(i);
            System.out.printf("  #%d: %s → %.1f pts%n",
                    i + 1, entry.getKey().getNombre(), entry.getValue());
        }
    }
}

class Producto {
    private String nombre;
    private String categoria;
    private double precio;
    private double calificacion;

    public Producto(String nombre, String categoria, double precio, double calificacion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.calificacion = calificacion;
    }

    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public double getPrecio() { return precio; }
    public double getCalificacion() { return calificacion; }

    @Override
    public String toString() {
        return String.format("%-20s %-12s $%7.2f  %.1f★",
                nombre, categoria, precio, calificacion);
    }
}
