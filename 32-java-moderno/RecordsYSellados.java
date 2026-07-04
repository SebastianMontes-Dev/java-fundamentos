/**
 * ============================================================
 *  TEMA: Records y Sealed Classes (Java 14-17)
 *  SECCIÓN: 32 — Java Moderno
 *  ARCHIVO: RecordsYSellados.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  RECORDS (Java 14+): Si tu clase solo existe para transportar datos
 *  (DTO, value object, tupla), un record te ahorra escribir constructor,
 *  getters, equals, hashCode y toString. En UNA línea defines todos los
 *  campos, y el compilador genera el resto. Son inmutables por diseño:
 *  no hay setters, y cada campo es final.
 *
 *  SEALED CLASSES (Java 17): Controlas QUIÉN puede heredar de tu clase
 *  con `sealed class` + `permits`. Es perfecto para modelar jerarquías
 *  cerradas como "un Resultado es Éxito o Error", o "una Figura es
 *  Círculo, Rectángulo o Triángulo". El compilador verifica que todas
 *  las subclases permitidas estén declaradas. Combinado con switch
 *  expressions, obtienes exhaustividad verificada por el compilador.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Records: `record Punto(int x, int y) { }`.
 *  - Constructor canónico automático y modificable.
 *  - equals/hashCode/toString generados automáticamente.
 *  - Sealed: `sealed class Figura permits Circulo, Rectangulo { }`.
 *  - Las subclases deben ser final, sealed o non-sealed.
 *  - non-sealed permite herencia abierta desde ese punto.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  record Persona(String nombre, int edad) { }
 *  Persona p = new Persona("Sebastián", 25);
 *  System.out.println(p.nombre()); // getter automático
 *
 *  sealed interface Resultado permits Exito, Error { }
 *  record Exito(String msg) implements Resultado { }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Records no pueden extender clases (ya extienden java.lang.Record).
 *  - No puedes añadir campos de instancia adicionales (solo static).
 *  - Sealed: las subclases deben estar en el mismo módulo o package.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - JEP 395 (Records): https://openjdk.org/jeps/395
 *  - JEP 409 (Sealed Classes): https://openjdk.org/jeps/409
 * ============================================================
 */
public class RecordsYSellados {

    public static void main(String[] args) {
        System.out.println("=== Records y Sealed Classes (Java 14-17) ===");
        System.out.println();

        // ============================================
        //  RECORDS
        // ============================================
        System.out.println("--- 1. Records (Data Carriers) ---");
        System.out.println();

        // Crear un record (como un constructor normal)
        Persona p1 = new Persona("Sebastián", 25);
        Persona p2 = new Persona("Sebastián", 25);
        Persona p3 = new Persona("Ana", 30);

        // Los getters NO tienen "get": es solo nombre()
        System.out.println("p1: " + p1);
        System.out.println("Nombre: " + p1.nombre());
        System.out.println("Edad:   " + p1.edad());

        // equals/hashCode automáticos
        System.out.println("\np1.equals(p2): " + p1.equals(p2) + " (mismos valores = true)");
        System.out.println("p1.equals(p3): " + p1.equals(p3) + " (diferente = false)");
        System.out.println();

        // Record con constructor compacto (validación)
        System.out.println("--- Record con Validación ---");
        try {
            new Producto("TV", -50.0);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        Producto prod = new Producto("Laptop", 999.99);
        System.out.println(prod);
        System.out.println("Precio con IVA: $" + prod.precioConIVA());
        System.out.println();

        // ============================================
        //  SEALED CLASSES
        // ============================================
        System.out.println("--- 2. Sealed Classes (Jerarquías Cerradas) ---");
        System.out.println();

        // Crear figuras (solo Círculo y Rectángulo están permitidos)
        Figura fig1 = new Circulo(5.0);
        Figura fig2 = new Rectangulo(4.0, 6.0);

        Figura[] figuras = {fig1, fig2};
        for (Figura f : figuras) {
            System.out.println(f);
            System.out.println("  Área: " + area(f));
        }
        System.out.println();

        // --- SEALED + SWITCH: exhaustividad verificada ---
        System.out.println("--- Sealed + Switch Expression ---");

        for (Figura f : figuras) {
            String descripcion = describir(f);
            System.out.println("  " + descripcion);
        }
    }

    // Método que calcula área usando pattern matching
    static double area(Figura f) {
        if (f instanceof Circulo c) {
            return Math.PI * c.radio() * c.radio();
        } else if (f instanceof Rectangulo r) {
            return r.base() * r.altura();
        }
        return 0;
    }

    // Switch con sealed class: el compilador verifica exhaustividad
    static String describir(Figura f) {
        return switch (f) {
            case Circulo c -> String.format("Círculo de radio %.1f", c.radio());
            case Rectangulo r -> String.format("Rectángulo de %.1f x %.1f", r.base(), r.altura());
            // No necesita default: las sealed classes garantizan solo estos casos
        };
    }
}

// --- RECORDS ---

record Persona(String nombre, int edad) {
    // Constructor compacto (sin parámetros): se ejecuta DESPUÉS del canónico
    Persona {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
    }
}

record Producto(String nombre, double precio) {
    Producto {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo: " + precio);
        }
    }

    // Método adicional
    double precioConIVA() {
        return precio * 1.16;
    }
}

// --- SEALED CLASSES ---

sealed interface Figura permits Circulo, Rectangulo { }

record Circulo(double radio) implements Figura {
    @Override
    public String toString() {
        return "Círculo(radio=" + radio + ")";
    }
}

record Rectangulo(double base, double altura) implements Figura {
    @Override
    public String toString() {
        return "Rectángulo(base=" + base + ", altura=" + altura + ")";
    }
}

// non-sealed permite herencia abierta desde este punto
// public non-sealed class OtraFigura implements Figura { }
