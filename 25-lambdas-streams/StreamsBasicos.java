/**
 * ============================================================
 *  TEMA: Expresiones Lambda y Streams
 *  SECCIÓN: 25 — Lambdas y Streams
 *  ARCHIVO: StreamsBasicos.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás qué es la API de Streams en Java, cómo crear
 *  streams a partir de colecciones y cómo encadenar operaciones
 *  como filter(), map(), forEach() y collect() para procesar
 *  datos de forma declarativa y elegante. Verás ejemplos
 *  prácticos con listas de estudiantes y productos.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Stream: secuencia de elementos que soporta operaciones encadenadas
 *  - Operaciones intermedias: filter(), map(), sorted() (retornan un Stream)
 *  - Operaciones terminales: forEach(), collect(), count() (producen un resultado)
 *  - Evaluación perezosa (lazy): las operaciones intermedias no se ejecutan
 *    hasta que se invoca una operación terminal
 *  - Los Streams NO modifican la colección original
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *      lista.stream()
 *           .filter(x -> condición)
 *           .map(x -> transformación)
 *           .collect(Collectors.toList());
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Intentar reutilizar un Stream después de una operación terminal
 *  - Olvidar la operación terminal (el pipeline no se ejecuta)
 *  - Confundir map() (transforma) con filter() (filtra)
 *  - No importar java.util.stream.Collectors
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
 *  - Tutorial de Streams: https://docs.oracle.com/javase/tutorial/collections/streams/
 * ============================================================
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsBasicos {

    // =====================================================
    // CLASE AUXILIAR: Estudiante
    // =====================================================

    /**
     * Representa a un estudiante con nombre, carrera y promedio.
     */
    static class Estudiante {
        private String nombre;
        private String carrera;
        private double promedio;
        private int edad;

        /**
         * Constructor del estudiante.
         * @param nombre   nombre completo
         * @param carrera  carrera universitaria
         * @param promedio promedio académico (0-10)
         * @param edad     edad del estudiante
         */
        public Estudiante(String nombre, String carrera, double promedio, int edad) {
            this.nombre = nombre;
            this.carrera = carrera;
            this.promedio = promedio;
            this.edad = edad;
        }

        public String getNombre()  { return nombre; }
        public String getCarrera() { return carrera; }
        public double getPromedio() { return promedio; }
        public int getEdad()       { return edad; }

        @Override
        public String toString() {
            return String.format("%s (%-12s | Prom: %.1f | Edad: %d)",
                nombre, carrera, promedio, edad);
        }
    }

    // =====================================================
    // CLASE AUXILIAR: Producto
    // =====================================================

    /**
     * Representa un producto en una tienda.
     */
    static class Producto {
        private String nombre;
        private String categoria;
        private double precio;
        private int stock;

        /**
         * Constructor del producto.
         * @param nombre    nombre del producto
         * @param categoria categoría del producto
         * @param precio    precio unitario
         * @param stock     unidades disponibles
         */
        public Producto(String nombre, String categoria, double precio, int stock) {
            this.nombre = nombre;
            this.categoria = categoria;
            this.precio = precio;
            this.stock = stock;
        }

        public String getNombre()    { return nombre; }
        public String getCategoria() { return categoria; }
        public double getPrecio()    { return precio; }
        public int getStock()        { return stock; }

        @Override
        public String toString() {
            return String.format("%-20s | %-12s | $%8.2f | Stock: %d",
                nombre, categoria, precio, stock);
        }
    }

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║        STREAMS API - CONCEPTOS BÁSICOS          ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        // -------------------------------------------------
        // EJEMPLO 1: CREAR STREAMS
        // -------------------------------------------------
        System.out.println("━━━ 1. FORMAS DE CREAR STREAMS ━━━\n");

        // Desde una lista
        List<String> colores = Arrays.asList("Rojo", "Verde", "Azul", "Amarillo");
        Stream<String> streamDeLista = colores.stream();
        System.out.print("  Desde lista:   ");
        streamDeLista.forEach(c -> System.out.print(c + " "));
        System.out.println();

        // Desde Stream.of()
        Stream<Integer> streamDirecto = Stream.of(10, 20, 30, 40, 50);
        System.out.print("  Desde of():    ");
        streamDirecto.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Desde Stream.iterate()
        System.out.print("  Desde iterate: ");
        Stream.iterate(1, n -> n * 2)
              .limit(8)
              .forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Desde Stream.generate()
        System.out.print("  Desde generate:");
        Stream.generate(() -> " ★")
              .limit(5)
              .forEach(System.out::print);
        System.out.println("\n");

        // -------------------------------------------------
        // EJEMPLO 2: FILTER — Filtrar elementos
        // -------------------------------------------------
        System.out.println("━━━ 2. FILTER — Filtrar elementos ━━━\n");

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 20);
        System.out.println("  Lista original: " + numeros);

        // Filtrar pares
        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("  Solo pares:     " + pares);

        // Filtrar mayores a 7
        List<Integer> mayoresA7 = numeros.stream()
                .filter(n -> n > 7)
                .collect(Collectors.toList());
        System.out.println("  Mayores a 7:    " + mayoresA7);

        // Filtrar múltiples condiciones (pares Y mayores a 5)
        List<Integer> paresGrandes = numeros.stream()
                .filter(n -> n % 2 == 0)
                .filter(n -> n > 5)
                .collect(Collectors.toList());
        System.out.println("  Pares y > 5:    " + paresGrandes);

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 3: MAP — Transformar elementos
        // -------------------------------------------------
        System.out.println("━━━ 3. MAP — Transformar elementos ━━━\n");

        List<String> nombres = Arrays.asList("ana", "pedro", "maría", "luis", "carmen");
        System.out.println("  Nombres originales: " + nombres);

        // Convertir a mayúsculas
        List<String> enMayusculas = nombres.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("  En mayúsculas:      " + enMayusculas);

        // Obtener longitudes
        List<Integer> longitudes = nombres.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("  Longitudes:         " + longitudes);

        // Transformar números
        List<Integer> cuadrados = numeros.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("  Números²:           " + cuadrados);

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 4: FOREACH — Iterar elementos
        // -------------------------------------------------
        System.out.println("━━━ 4. FOREACH — Iterar elementos ━━━\n");

        System.out.println("  Tabla del 5:");
        Stream.iterate(1, n -> n + 1)
              .limit(10)
              .forEach(n -> System.out.printf("     5 × %2d = %2d%n", n, 5 * n));

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 5: COLLECT — Recolectar resultados
        // -------------------------------------------------
        System.out.println("━━━ 5. COLLECT — Recolectar resultados ━━━\n");

        List<String> palabras = Arrays.asList(
            "Java", "es", "un", "lenguaje", "de", "programación", "orientado", "a", "objetos"
        );

        // Recolectar como lista
        List<String> palabrasLargas = palabras.stream()
                .filter(p -> p.length() > 3)
                .collect(Collectors.toList());
        System.out.println("  Palabras largas (>3 chars): " + palabrasLargas);

        // Unir como String
        String frase = palabras.stream()
                .collect(Collectors.joining(" "));
        System.out.println("  Frase unida: " + frase);

        // Unir con delimitador personalizado
        String listaFormateada = palabrasLargas.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(" | "));
        System.out.println("  Formateada:  " + listaFormateada);

        // Contar elementos
        long cantidadLargas = palabras.stream()
                .filter(p -> p.length() > 3)
                .count();
        System.out.println("  Cantidad de palabras largas: " + cantidadLargas);

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 6: CASO PRÁCTICO — Estudiantes
        // -------------------------------------------------
        System.out.println("━━━ 6. CASO PRÁCTICO: GESTIÓN DE ESTUDIANTES ━━━\n");

        List<Estudiante> estudiantes = crearListaEstudiantes();

        System.out.println("  ── Todos los estudiantes:");
        estudiantes.forEach(e -> System.out.println("     " + e));

        System.out.println();

        // a) Estudiantes con promedio >= 8.5
        System.out.println("  ── Estudiantes destacados (promedio ≥ 8.5):");
        estudiantes.stream()
                .filter(e -> e.getPromedio() >= 8.5)
                .forEach(e -> System.out.println("     ★ " + e));

        System.out.println();

        // b) Nombres de estudiantes de Ingeniería
        System.out.println("  ── Nombres de estudiantes de Ingeniería:");
        List<String> ingenieros = estudiantes.stream()
                .filter(e -> e.getCarrera().equals("Ingeniería"))
                .map(Estudiante::getNombre)
                .collect(Collectors.toList());
        System.out.println("     " + ingenieros);

        // c) Promedio general
        double promedioGeneral = estudiantes.stream()
                .mapToDouble(Estudiante::getPromedio)
                .average()
                .orElse(0.0);
        System.out.printf("  ── Promedio general: %.2f%n", promedioGeneral);

        // d) Cantidad por carrera
        System.out.println("  ── Cantidad de estudiantes por carrera:");
        Map<String, Long> porCarrera = estudiantes.stream()
                .collect(Collectors.groupingBy(
                    Estudiante::getCarrera,
                    Collectors.counting()
                ));
        porCarrera.forEach((carrera, cantidad) ->
            System.out.printf("     %-15s → %d estudiantes%n", carrera, cantidad)
        );

        // e) Ordenados por promedio (descendente)
        System.out.println("  ── Top 3 estudiantes por promedio:");
        estudiantes.stream()
                .sorted((a, b) -> Double.compare(b.getPromedio(), a.getPromedio()))
                .limit(3)
                .forEach(e -> System.out.println("     🏆 " + e));

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 7: CASO PRÁCTICO — Productos
        // -------------------------------------------------
        System.out.println("━━━ 7. CASO PRÁCTICO: CATÁLOGO DE PRODUCTOS ━━━\n");

        List<Producto> productos = crearListaProductos();

        System.out.println("  ── Catálogo completo:");
        productos.forEach(p -> System.out.println("     " + p));

        System.out.println();

        // a) Productos con precio > $500
        System.out.println("  ── Productos premium (precio > $500):");
        productos.stream()
                .filter(p -> p.getPrecio() > 500)
                .forEach(p -> System.out.println("     💎 " + p));

        System.out.println();

        // b) Nombres de productos de Electrónica, en mayúsculas
        System.out.println("  ── Productos de Electrónica:");
        List<String> electronica = productos.stream()
                .filter(p -> p.getCategoria().equals("Electrónica"))
                .map(p -> p.getNombre().toUpperCase())
                .collect(Collectors.toList());
        System.out.println("     " + electronica);

        // c) Valor total del inventario
        double valorTotal = productos.stream()
                .mapToDouble(p -> p.getPrecio() * p.getStock())
                .sum();
        System.out.printf("  ── Valor total del inventario: $%,.2f%n", valorTotal);

        // d) Producto más caro
        productos.stream()
                .max((a, b) -> Double.compare(a.getPrecio(), b.getPrecio()))
                .ifPresent(p -> System.out.println("  ── Producto más caro: " + p.getNombre()
                    + " ($" + p.getPrecio() + ")"));

        // e) ¿Hay productos sin stock?
        boolean haySinStock = productos.stream()
                .anyMatch(p -> p.getStock() == 0);
        System.out.println("  ── ¿Hay productos sin stock? " + (haySinStock ? "Sí" : "No"));

        // f) Productos con bajo stock (< 15)
        long conBajoStock = productos.stream()
                .filter(p -> p.getStock() < 15)
                .count();
        System.out.println("  ── Productos con bajo stock (<15): " + conBajoStock);

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 8: IMPORTANTE — STREAMS NO SON REUTILIZABLES
        // -------------------------------------------------
        System.out.println("━━━ 8. ⚠ STREAMS NO SON REUTILIZABLES ━━━\n");

        Stream<String> streamUnico = colores.stream();
        streamUnico.forEach(c -> {}); // Operación terminal

        try {
            // ❌ Esto lanzará IllegalStateException
            streamUnico.forEach(c -> System.out.println(c));
        } catch (IllegalStateException e) {
            System.out.println("  ❌ Error: " + e.getMessage());
            System.out.println("     (Un Stream no se puede reutilizar después");
            System.out.println("      de una operación terminal)");
        }

        System.out.println();

        // ✅ Solución: crear un nuevo stream cada vez
        System.out.println("  ✅ Solución: crea un nuevo stream cada vez que lo necesites");
        System.out.print("     Primera vez:  ");
        colores.stream().forEach(c -> System.out.print(c + " "));
        System.out.println();
        System.out.print("     Segunda vez:  ");
        colores.stream().forEach(c -> System.out.print(c + " "));
        System.out.println();

        System.out.println();
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("  RESUMEN:");
        System.out.println("  • stream() crea un flujo desde una colección");
        System.out.println("  • filter() selecciona elementos por condición");
        System.out.println("  • map() transforma cada elemento");
        System.out.println("  • forEach() ejecuta una acción en cada elemento");
        System.out.println("  • collect() recolecta resultados en una colección");
        System.out.println("  • Los streams son de un solo uso");
        System.out.println("═══════════════════════════════════════════════════");
    }

    // =====================================================
    // MÉTODOS AUXILIARES — Creación de datos
    // =====================================================

    /**
     * Crea una lista de estudiantes para los ejemplos.
     * @return lista con datos de prueba de estudiantes
     */
    private static List<Estudiante> crearListaEstudiantes() {
        List<Estudiante> lista = new ArrayList<>();
        lista.add(new Estudiante("Ana García",      "Ingeniería",  9.2, 21));
        lista.add(new Estudiante("Pedro López",     "Medicina",    8.5, 23));
        lista.add(new Estudiante("María Rodríguez", "Ingeniería",  7.8, 20));
        lista.add(new Estudiante("Luis Martínez",   "Derecho",     8.9, 22));
        lista.add(new Estudiante("Carmen Sánchez",  "Medicina",    9.5, 24));
        lista.add(new Estudiante("Roberto Díaz",    "Ingeniería",  6.5, 21));
        lista.add(new Estudiante("Elena Torres",    "Derecho",     8.1, 20));
        lista.add(new Estudiante("Jorge Ramírez",   "Medicina",    7.3, 25));
        lista.add(new Estudiante("Sofía Hernández", "Ingeniería",  9.0, 22));
        lista.add(new Estudiante("Diego Flores",    "Derecho",     8.7, 23));
        return lista;
    }

    /**
     * Crea una lista de productos para los ejemplos.
     * @return lista con datos de prueba de productos
     */
    private static List<Producto> crearListaProductos() {
        List<Producto> lista = new ArrayList<>();
        lista.add(new Producto("Laptop HP",           "Electrónica", 12999.99, 25));
        lista.add(new Producto("Mouse Logitech",      "Electrónica",   349.50, 80));
        lista.add(new Producto("Teclado Mecánico",     "Electrónica",   899.00, 45));
        lista.add(new Producto("Monitor Samsung 27\"", "Electrónica",  5499.00, 12));
        lista.add(new Producto("Escritorio Madera",    "Muebles",     3200.00, 8));
        lista.add(new Producto("Silla Ergonómica",     "Muebles",     4500.00, 15));
        lista.add(new Producto("Lámpara LED",          "Hogar",        189.99, 60));
        lista.add(new Producto("Cable HDMI 2m",        "Electrónica",  129.00, 200));
        lista.add(new Producto("Organizador Cables",   "Hogar",         89.50, 0));
        lista.add(new Producto("Librero 5 Niveles",    "Muebles",     2800.00, 5));
        return lista;
    }
}
