/**
 * ============================================================
 *  TEMA: Expresiones Lambda y Streams
 *  SECCIÓN: 17 — Lambdas y Streams
 *  ARCHIVO: StreamsAvanzados.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás operaciones avanzadas de la API de Streams como
 *  reduce(), sorted(), distinct(), flatMap() y el uso de Optional.
 *  Verás cómo calcular estadísticas (suma, promedio, máximo, mínimo)
 *  de conjuntos de datos, y cómo encadenar operaciones complejas
 *  para resolver problemas reales de forma declarativa.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - reduce(): combina todos los elementos en un solo resultado
 *  - sorted(): ordena los elementos del stream
 *  - distinct(): elimina elementos duplicados
 *  - flatMap(): aplana streams anidados en un solo stream
 *  - Optional: contenedor que puede o no tener un valor (evita null)
 *  - Collectors avanzados: groupingBy, partitioningBy, summarizing
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *      // reduce
 *      stream.reduce(valorInicial, (acumulador, elemento) -> resultado);
 *
 *      // flatMap
 *      stream.flatMap(lista -> lista.stream());
 *
 *      // Optional
 *      Optional<T> opt = stream.findFirst();
 *      opt.ifPresent(valor -> ...);
 *      T resultado = opt.orElse(valorPorDefecto);
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar get() en Optional sin verificar isPresent() (lanza excepción)
 *  - Confundir map() con flatMap() al trabajar con colecciones anidadas
 *  - Olvidar que reduce() sin valor inicial retorna Optional
 *  - No manejar el caso vacío en operaciones como max(), min(), findFirst()
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
 *  - Optional: https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html
 *  - Collectors: https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
 * ============================================================
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsAvanzados {

    // =====================================================
    // CLASE AUXILIAR: Venta
    // =====================================================

    /**
     * Representa una venta realizada en una tienda.
     */
    static class Venta {
        private String vendedor;
        private String producto;
        private String categoria;
        private double monto;
        private int cantidad;
        private String mes;

        /**
         * Constructor de la venta.
         * @param vendedor  nombre del vendedor
         * @param producto  nombre del producto vendido
         * @param categoria categoría del producto
         * @param monto     monto total de la venta
         * @param cantidad  unidades vendidas
         * @param mes       mes de la venta
         */
        public Venta(String vendedor, String producto, String categoria,
                     double monto, int cantidad, String mes) {
            this.vendedor = vendedor;
            this.producto = producto;
            this.categoria = categoria;
            this.monto = monto;
            this.cantidad = cantidad;
            this.mes = mes;
        }

        public String getVendedor()  { return vendedor; }
        public String getProducto()  { return producto; }
        public String getCategoria() { return categoria; }
        public double getMonto()     { return monto; }
        public int getCantidad()     { return cantidad; }
        public String getMes()       { return mes; }

        @Override
        public String toString() {
            return String.format("%-10s | %-18s | %-12s | $%9.2f | %3d uds | %s",
                vendedor, producto, categoria, monto, cantidad, mes);
        }
    }

    // =====================================================
    // CLASE AUXILIAR: Curso (para flatMap)
    // =====================================================

    /**
     * Representa un curso con una lista de estudiantes inscritos.
     */
    static class Curso {
        private String nombre;
        private List<String> estudiantes;

        /**
         * Constructor del curso.
         * @param nombre      nombre del curso
         * @param estudiantes lista de nombres de estudiantes
         */
        public Curso(String nombre, List<String> estudiantes) {
            this.nombre = nombre;
            this.estudiantes = estudiantes;
        }

        public String getNombre()           { return nombre; }
        public List<String> getEstudiantes() { return estudiantes; }
    }

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║       STREAMS API - OPERACIONES AVANZADAS       ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        // -------------------------------------------------
        // EJEMPLO 1: REDUCE — Combinar elementos
        // -------------------------------------------------
        System.out.println("━━━ 1. REDUCE — Combinar elementos en uno ━━━\n");

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("  Lista: " + numeros);

        // Suma con reduce (con valor inicial)
        int sumaTotal = numeros.stream()
                .reduce(0, (acumulador, n) -> acumulador + n);
        System.out.println("  Suma (reduce):       " + sumaTotal);

        // Suma con referencia a método
        int sumaMetodo = numeros.stream()
                .reduce(0, Integer::sum);
        System.out.println("  Suma (ref. método):  " + sumaMetodo);

        // Producto con reduce
        int productoTotal = numeros.stream()
                .reduce(1, (acum, n) -> acum * n);
        System.out.println("  Producto:            " + productoTotal);

        // Máximo con reduce (sin valor inicial → retorna Optional)
        Optional<Integer> maximo = numeros.stream()
                .reduce(Integer::max);
        maximo.ifPresent(m -> System.out.println("  Máximo (reduce):     " + m));

        // Concatenar strings con reduce
        List<String> palabras = Arrays.asList("Java", "Streams", "son", "poderosos");
        String frase = palabras.stream()
                .reduce("", (acum, p) -> acum.isEmpty() ? p : acum + " " + p);
        System.out.println("  Frase concatenada:   " + frase);

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 2: SORTED — Ordenar elementos
        // -------------------------------------------------
        System.out.println("━━━ 2. SORTED — Ordenar elementos ━━━\n");

        List<String> frutas = Arrays.asList(
            "Mango", "Banana", "Cereza", "Arándano", "Durazno",
            "Fresa", "Banana", "Cereza", "Arándano"
        );
        System.out.println("  Original:     " + frutas);

        // Orden natural (alfabético)
        List<String> ordenNatural = frutas.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("  Orden natural: " + ordenNatural);

        // Orden inverso
        List<String> ordenInverso = frutas.stream()
                .sorted((a, b) -> b.compareTo(a))
                .collect(Collectors.toList());
        System.out.println("  Orden inverso: " + ordenInverso);

        // Ordenar por longitud del nombre
        List<String> porLongitud = frutas.stream()
                .distinct()
                .sorted((a, b) -> Integer.compare(a.length(), b.length()))
                .collect(Collectors.toList());
        System.out.println("  Por longitud:  " + porLongitud);

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 3: DISTINCT — Eliminar duplicados
        // -------------------------------------------------
        System.out.println("━━━ 3. DISTINCT — Eliminar duplicados ━━━\n");

        System.out.println("  Con duplicados: " + frutas);

        List<String> sinDuplicados = frutas.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("  Sin duplicados: " + sinDuplicados);

        // Combinar distinct + sorted
        List<String> unicasOrdenadas = frutas.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("  Únicas y ordenadas: " + unicasOrdenadas);

        // Distinct con números
        List<Integer> numerosRepetidos = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        List<Integer> numerosUnicos = numerosRepetidos.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("  Números únicos: " + numerosRepetidos + " → " + numerosUnicos);

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 4: FLATMAP — Aplanar estructuras
        // -------------------------------------------------
        System.out.println("━━━ 4. FLATMAP — Aplanar estructuras anidadas ━━━\n");

        // Listas de listas
        List<List<String>> listaDeListas = Arrays.asList(
            Arrays.asList("Hola", "Mundo"),
            Arrays.asList("Java", "Streams"),
            Arrays.asList("Lambda", "Funcional")
        );

        System.out.println("  Lista de listas:");
        listaDeListas.forEach(l -> System.out.println("     " + l));

        // ❌ Con map: Stream<List<String>> — no es lo que queremos
        // ✅ Con flatMap: Stream<String> — todos los elementos en un solo stream
        List<String> todosLosElementos = listaDeListas.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("  Aplanada con flatMap: " + todosLosElementos);

        System.out.println();

        // Ejemplo con cursos y estudiantes
        System.out.println("  ── Cursos y sus estudiantes:");
        List<Curso> cursos = Arrays.asList(
            new Curso("Java",   Arrays.asList("Ana", "Pedro", "Luis")),
            new Curso("Python", Arrays.asList("María", "Ana", "Carlos")),
            new Curso("C++",    Arrays.asList("Pedro", "Elena", "Jorge"))
        );

        cursos.forEach(c -> System.out.println("     " + c.getNombre() + ": " + c.getEstudiantes()));

        // Todos los estudiantes (con duplicados)
        List<String> todosEstudiantes = cursos.stream()
                .flatMap(c -> c.getEstudiantes().stream())
                .collect(Collectors.toList());
        System.out.println("  Todos los estudiantes: " + todosEstudiantes);

        // Estudiantes únicos, ordenados
        List<String> estudiantesUnicos = cursos.stream()
                .flatMap(c -> c.getEstudiantes().stream())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("  Estudiantes únicos:    " + estudiantesUnicos);

        // flatMap con strings: separar palabras de oraciones
        List<String> oraciones = Arrays.asList(
            "Java es genial",
            "Los streams son útiles",
            "Programar es divertido"
        );
        List<String> todasPalabras = oraciones.stream()
                .flatMap(o -> Arrays.stream(o.split(" ")))
                .collect(Collectors.toList());
        System.out.println("  Palabras de oraciones: " + todasPalabras);

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 5: OPTIONAL — Manejo seguro de valores
        // -------------------------------------------------
        System.out.println("━━━ 5. OPTIONAL — Manejo seguro de valores nulos ━━━\n");

        // Crear Optional
        Optional<String> conValor = Optional.of("Hola Java");
        Optional<String> vacio = Optional.empty();
        Optional<String> nullable = Optional.ofNullable(null);

        System.out.println("  conValor está presente: " + conValor.isPresent());   // true
        System.out.println("  vacio está presente:    " + vacio.isPresent());      // false
        System.out.println("  nullable está presente: " + nullable.isPresent());   // false

        // Obtener valor de forma segura
        System.out.println("  conValor.get():         " + conValor.get());
        System.out.println("  vacio.orElse(\"N/A\"):    " + vacio.orElse("N/A"));

        // orElseGet: valor calculado perezosamente
        String valorCalculado = vacio.orElseGet(() -> "Calculado en " + System.currentTimeMillis());
        System.out.println("  vacio.orElseGet():      " + valorCalculado);

        // ifPresent: ejecutar acción solo si hay valor
        System.out.print("  conValor.ifPresent():   ");
        conValor.ifPresent(v -> System.out.println("Valor = " + v));
        System.out.print("  vacio.ifPresent():      ");
        vacio.ifPresent(v -> System.out.println("Valor = " + v));
        System.out.println("(no se ejecuta)");

        // map en Optional
        Optional<Integer> longitud = conValor.map(String::length);
        System.out.println("  conValor.map(length):   " + longitud.orElse(0));

        // filter en Optional
        Optional<String> filtrado = conValor.filter(v -> v.startsWith("Hola"));
        System.out.println("  conValor.filter(Hola):  " + filtrado.orElse("No cumple"));

        System.out.println();

        // Optional con streams
        System.out.println("  ── Optional con Streams:");
        List<Integer> listaVacia = new ArrayList<>();
        Optional<Integer> primero = listaVacia.stream().findFirst();
        System.out.println("  findFirst() en lista vacía: " + primero.orElse(-1));

        Optional<Integer> maxNum = numeros.stream().max(Integer::compareTo);
        System.out.println("  max() de " + numeros + ": " + maxNum.orElse(0));

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 6: ESTADÍSTICAS CON STREAMS
        // -------------------------------------------------
        System.out.println("━━━ 6. ESTADÍSTICAS CON STREAMS ━━━\n");

        List<Double> temperaturas = Arrays.asList(
            22.5, 28.3, 19.7, 31.2, 25.8, 17.4, 33.1, 26.9, 20.5, 29.6,
            18.3, 24.7, 30.0, 21.8, 27.4
        );

        System.out.println("  Temperaturas registradas: " + temperaturas);

        // Estadísticas con DoubleSummaryStatistics
        DoubleSummaryStatistics stats = temperaturas.stream()
                .mapToDouble(Double::doubleValue)
                .summaryStatistics();

        System.out.println();
        System.out.println("  ┌─────────────────────────────────────┐");
        System.out.println("  │     RESUMEN ESTADÍSTICO             │");
        System.out.println("  ├─────────────────────────────────────┤");
        System.out.printf("  │  Cantidad:  %6d registros        │%n", stats.getCount());
        System.out.printf("  │  Suma:      %9.2f °C            │%n", stats.getSum());
        System.out.printf("  │  Promedio:  %9.2f °C            │%n", stats.getAverage());
        System.out.printf("  │  Mínima:    %9.2f °C            │%n", stats.getMin());
        System.out.printf("  │  Máxima:    %9.2f °C            │%n", stats.getMax());
        System.out.println("  └─────────────────────────────────────┘");

        // Calcular manualmente con reduce
        System.out.println();
        System.out.println("  ── Cálculos manuales con reduce:");
        double sumaTemps = temperaturas.stream()
                .reduce(0.0, Double::sum);
        System.out.printf("     Suma manual:    %.2f °C%n", sumaTemps);

        double promedioManual = sumaTemps / temperaturas.size();
        System.out.printf("     Promedio manual: %.2f °C%n", promedioManual);

        // Rango
        double rango = stats.getMax() - stats.getMin();
        System.out.printf("     Rango:          %.2f °C%n", rango);

        // Temperaturas por encima del promedio
        long porEncimaDelPromedio = temperaturas.stream()
                .filter(t -> t > stats.getAverage())
                .count();
        System.out.printf("     Sobre promedio: %d de %d registros%n",
            porEncimaDelPromedio, stats.getCount());

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 7: CASO PRÁCTICO — Análisis de ventas
        // -------------------------------------------------
        System.out.println("━━━ 7. CASO PRÁCTICO: ANÁLISIS DE VENTAS ━━━\n");

        List<Venta> ventas = crearListaVentas();

        System.out.println("  ── Registro de ventas:");
        System.out.println("  " + "─".repeat(80));
        System.out.printf("  %-10s | %-18s | %-12s | %10s | %7s | %s%n",
            "Vendedor", "Producto", "Categoría", "Monto", "Cant.", "Mes");
        System.out.println("  " + "─".repeat(80));
        ventas.forEach(v -> System.out.println("  " + v));
        System.out.println("  " + "─".repeat(80));

        System.out.println();

        // a) Total de ventas
        double totalVentas = ventas.stream()
                .mapToDouble(Venta::getMonto)
                .sum();
        System.out.printf("  ── Total de ventas: $%,.2f%n", totalVentas);

        // b) Promedio de venta
        double promedioVenta = ventas.stream()
                .mapToDouble(Venta::getMonto)
                .average()
                .orElse(0);
        System.out.printf("  ── Promedio por venta: $%,.2f%n", promedioVenta);

        // c) Venta más grande
        ventas.stream()
                .max((a, b) -> Double.compare(a.getMonto(), b.getMonto()))
                .ifPresent(v -> System.out.printf("  ── Venta más grande: $%,.2f (%s - %s)%n",
                    v.getMonto(), v.getVendedor(), v.getProducto()));

        // d) Total por vendedor
        System.out.println("\n  ── Total por vendedor:");
        Map<String, Double> totalPorVendedor = ventas.stream()
                .collect(Collectors.groupingBy(
                    Venta::getVendedor,
                    Collectors.summingDouble(Venta::getMonto)
                ));
        totalPorVendedor.entrySet().stream()
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .forEach(e -> System.out.printf("     %-10s → $%,.2f%n",
                    e.getKey(), e.getValue()));

        // e) Total por categoría
        System.out.println("\n  ── Total por categoría:");
        Map<String, DoubleSummaryStatistics> statsPorCategoria = ventas.stream()
                .collect(Collectors.groupingBy(
                    Venta::getCategoria,
                    Collectors.summarizingDouble(Venta::getMonto)
                ));
        statsPorCategoria.forEach((cat, s) ->
            System.out.printf("     %-12s → Ventas: %d | Total: $%,.2f | Prom: $%,.2f%n",
                cat, s.getCount(), s.getSum(), s.getAverage())
        );

        // f) Ventas por mes
        System.out.println("\n  ── Ventas por mes:");
        Map<String, Long> ventasPorMes = ventas.stream()
                .collect(Collectors.groupingBy(
                    Venta::getMes,
                    Collectors.counting()
                ));
        ventasPorMes.forEach((mes, cant) ->
            System.out.printf("     %-10s → %d ventas%n", mes, cant)
        );

        // g) Partición: ventas mayores a $5000
        System.out.println("\n  ── Partición: ventas > $5,000 vs ≤ $5,000:");
        Map<Boolean, List<Venta>> particion = ventas.stream()
                .collect(Collectors.partitioningBy(v -> v.getMonto() > 5000));
        System.out.println("     Ventas grandes (>$5,000):  " + particion.get(true).size());
        System.out.println("     Ventas pequeñas (≤$5,000): " + particion.get(false).size());

        // h) Lista de vendedores únicos
        List<String> vendedoresUnicos = ventas.stream()
                .map(Venta::getVendedor)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("\n  ── Vendedores únicos: " + vendedoresUnicos);

        // i) Top 3 ventas
        System.out.println("\n  ── Top 3 ventas más grandes:");
        ventas.stream()
                .sorted((a, b) -> Double.compare(b.getMonto(), a.getMonto()))
                .limit(3)
                .forEach(v -> System.out.printf("     🏆 $%,.2f — %s (%s)%n",
                    v.getMonto(), v.getProducto(), v.getVendedor()));

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 8: STREAMS NUMÉRICOS ESPECIALIZADOS
        // -------------------------------------------------
        System.out.println("━━━ 8. STREAMS NUMÉRICOS ESPECIALIZADOS ━━━\n");

        // IntStream.range y rangeClosed
        System.out.print("  IntStream.range(1, 6):       ");
        IntStream.range(1, 6).forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.print("  IntStream.rangeClosed(1, 6): ");
        IntStream.rangeClosed(1, 6).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Suma de 1 a 100
        int sumaCien = IntStream.rangeClosed(1, 100).sum();
        System.out.println("  Suma de 1 a 100: " + sumaCien);

        // Estadísticas con IntStream
        IntSummaryStatistics statsEnteros = IntStream.of(45, 78, 23, 91, 56, 34, 87, 12, 67, 99)
                .summaryStatistics();
        System.out.println("  Estadísticas de notas:");
        System.out.printf("     Promedio: %.1f | Mín: %d | Máx: %d%n",
            statsEnteros.getAverage(), statsEnteros.getMin(), statsEnteros.getMax());

        // Números primos hasta N
        int n = 50;
        List<Integer> primos = IntStream.rangeClosed(2, n)
                .filter(StreamsAvanzados::esPrimo)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("  Primos hasta " + n + ": " + primos);

        System.out.println();
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("  RESUMEN:");
        System.out.println("  • reduce() combina todos los elementos en uno");
        System.out.println("  • sorted() y distinct() organizan el stream");
        System.out.println("  • flatMap() aplana estructuras anidadas");
        System.out.println("  • Optional evita NullPointerException");
        System.out.println("  • summaryStatistics() da estadísticas completas");
        System.out.println("  • groupingBy() y partitioningBy() agrupan datos");
        System.out.println("═══════════════════════════════════════════════════");
    }

    // =====================================================
    // MÉTODOS AUXILIARES
    // =====================================================

    /**
     * Verifica si un número es primo.
     * @param numero el número a verificar
     * @return true si es primo, false en caso contrario
     */
    private static boolean esPrimo(int numero) {
        if (numero < 2) return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(numero))
                .noneMatch(i -> numero % i == 0);
    }

    /**
     * Crea una lista de ventas para los ejemplos.
     * @return lista con datos de prueba de ventas
     */
    private static List<Venta> crearListaVentas() {
        List<Venta> lista = new ArrayList<>();
        lista.add(new Venta("Ana",    "Laptop HP",        "Electrónica", 12999.99, 1,  "Enero"));
        lista.add(new Venta("Pedro",  "Mouse Logitech",   "Electrónica",   699.00, 2,  "Enero"));
        lista.add(new Venta("Ana",    "Silla Ergonómica", "Muebles",      4500.00, 1,  "Febrero"));
        lista.add(new Venta("Luis",   "Monitor Samsung",  "Electrónica",  5499.00, 1,  "Febrero"));
        lista.add(new Venta("Pedro",  "Escritorio",       "Muebles",      3200.00, 1,  "Marzo"));
        lista.add(new Venta("Ana",    "Teclado Mecánico", "Electrónica",  1798.00, 2,  "Marzo"));
        lista.add(new Venta("Luis",   "Lámpara LED",      "Hogar",         569.97, 3,  "Enero"));
        lista.add(new Venta("Pedro",  "Laptop HP",        "Electrónica", 12999.99, 1,  "Abril"));
        lista.add(new Venta("Ana",    "Cable HDMI",       "Electrónica",   387.00, 3,  "Abril"));
        lista.add(new Venta("Luis",   "Librero",          "Muebles",      2800.00, 1,  "Febrero"));
        lista.add(new Venta("Pedro",  "Silla Ergonómica", "Muebles",      9000.00, 2,  "Marzo"));
        lista.add(new Venta("Ana",    "Monitor Samsung",  "Electrónica", 10998.00, 2,  "Abril"));
        lista.add(new Venta("Luis",   "Organizador",      "Hogar",         268.50, 3,  "Marzo"));
        lista.add(new Venta("Pedro",  "Teclado Mecánico", "Electrónica",   899.00, 1,  "Enero"));
        lista.add(new Venta("Ana",    "Escritorio",       "Muebles",      6400.00, 2,  "Febrero"));
        return lista;
    }
}
