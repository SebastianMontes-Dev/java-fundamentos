import java.util.*;

class Producto { String categoria, nombre; double precio, calificacion;
    Producto(String c, String n, double p, double cal) { categoria=c; nombre=n; precio=p; calificacion=cal; }
    public String toString() { return String.format("%-12s %-15s $%7.2f %.1f", categoria, nombre, precio, calificacion); }
    String getCategoria() { return categoria; } double getPrecio() { return precio; } double getCalificacion() { return calificacion; } }

public class Solucion21_OrdenarObjetos {
    public static void main(String[] args) {
        List<Producto> productos = Arrays.asList(
            new Producto("Electronica", "Laptop", 999.99, 4.5),
            new Producto("Libros", "1984", 14.99, 4.8), new Producto("Electronica", "Mouse", 25.50, 4.2),
            new Producto("Libros", "Dune", 19.99, 4.6), new Producto("Electronica", "Teclado", 79.99, 4.7));
        System.out.println("--- Antes ---"); productos.forEach(System.out::println);
        productos.sort(Comparator.comparing(Producto::getCategoria).thenComparing(Producto::getPrecio).thenComparing(Comparator.comparing(Producto::getCalificacion).reversed()));
        System.out.println("\n--- Despues ---"); productos.forEach(System.out::println);
    }
}
