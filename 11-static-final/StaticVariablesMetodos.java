/**
 * ============================================================
 *  TEMA: Variables y Métodos Estáticos en Java
 *  SECCIÓN: 11 — Static y Final
 *  ARCHIVO: StaticVariablesMetodos.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  El modificador `static` significa "pertenece a la CLASE, no al objeto".
 *  Una variable static es compartida por TODAS las instancias; un método
 *  static puede llamarse sin crear un objeto (`Clase.metodo()`). Esta es
 *  una de las herramientas más poderosas de Java, pero también una de las
 *  que más confunde a principiantes. Aprenderás a usar static para crear
 *  contadores de instancias, métodos utilitarios y constantes de clase.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Variable static: una sola copia compartida por todas las instancias.
 *  - Método static: se llama con Clase.metodo(), no necesita objeto.
 *  - Regla MÁS IMPORTANTE: un método static NO puede usar `this` ni
 *    acceder directamente a atributos no static.
 *  - Los métodos static pueden acceder a variables static.
 *  - main() es static porque la JVM lo llama sin crear un objeto.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  static int contador = 0;
 *  static void metodoDeClase() { ... }
 *  Clase.metodoDeClase();  // Llamada sin instanciar
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar `this` dentro de un método static (error de compilación).
 *  - Crear instancias solo para llamar métodos static (innecesario).
 *  - Abusar de static para compartir estado mutable (peligro en concurrencia).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html
 * ============================================================
 */
public class StaticVariablesMetodos {

    public static void main(String[] args) {
        System.out.println("=== Static: Variables y Métodos de Clase ===");
        System.out.println();

        // --- CONTADOR DE INSTANCIAS ---
        System.out.println("--- Contador de Instancias ---");
        System.out.println("Productos creados inicialmente: " + Producto.getTotalCreados());

        Producto p1 = new Producto("Laptop", 999.99);
        Producto p2 = new Producto("Mouse", 25.50);
        Producto p3 = new Producto("Teclado", 79.99);

        System.out.println("Total de productos creados: " + Producto.getTotalCreados());
        System.out.println();

        // --- MÉTODOS STATIC UTILITARIOS ---
        System.out.println("--- Métodos Static Utilitarios ---");
        System.out.println("Suma: 10 + 5 = " + Calculadora.sumar(10, 5));
        System.out.println("Multiplicación: 10 * 5 = " + Calculadora.multiplicar(10, 5));
        System.out.println("Es par 7?: " + Calculadora.esPar(7));
        System.out.println("Es par 8?: " + Calculadora.esPar(8));
        System.out.println("(No necesitas instanciar Calculadora para usar sus métodos)");
        System.out.println();

        // --- DEMOSTRACIÓN: static vs no-static ---
        System.out.println("--- static vs no-static ---");

        DemoEstatica d1 = new DemoEstatica("A");
        DemoEstatica d2 = new DemoEstatica("B");

        d1.setValorInstancia(100);
        DemoEstatica.setValorEstatico(999);

        System.out.println("d1.valorInstancia = " + d1.getValorInstancia());
        System.out.println("d2.valorInstancia = " + d2.getValorInstancia());
        System.out.println("Valor static (compartido) = " + DemoEstatica.getValorEstatico());
        System.out.println("(El valor static es el mismo para TODAS las instancias)");
    }
}

// Clase con variable static para contar instancias
class Producto {
    private String nombre;
    private double precio;
    private static int totalCreados = 0;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        totalCreados++;
        System.out.println("  Nuevo producto: " + nombre + " (Total: " + totalCreados + ")");
    }

    // Método static: pertenece a la CLASE, no a cada producto
    public static int getTotalCreados() {
        return totalCreados;
    }
}

// Clase con métodos static utilitarios
class Calculadora {
    public static int sumar(int a, int b) {
        return a + b;
    }

    public static int multiplicar(int a, int b) {
        return a * b;
    }

    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }
}

// Demo de la diferencia entre static y no-static
class DemoEstatica {
    private String nombre;
    private int valorInstancia;          // Cada instancia tiene su propia copia
    private static int valorEstatico;    // Una sola copia compartida

    public DemoEstatica(String nombre) {
        this.nombre = nombre;
    }

    public void setValorInstancia(int v) { this.valorInstancia = v; }
    public int getValorInstancia() { return valorInstancia; }

    public static void setValorEstatico(int v) { valorEstatico = v; }
    public static int getValorEstatico() { return valorEstatico; }
}
