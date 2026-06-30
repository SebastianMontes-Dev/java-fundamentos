/**
 * ============================================================
 *  TEMA: Programación Funcional en Java
 *  SECCIÓN: 26 — Programación Funcional
 *  ARCHIVO: ComposicionFunciones.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás a componer funciones para construir operaciones
 *  complejas a partir de piezas simples. Verás cómo encadenar
 *  Function con andThen() y compose(), combinar Predicate con
 *  and(), or() y negate(), y cómo construir un pipeline de
 *  procesamiento de datos paso a paso.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - andThen(): ejecutar DESPUÉS (f.andThen(g) = primero f, luego g)
 *  - compose(): ejecutar ANTES (f.compose(g) = primero g, luego f)
 *  - Predicate.and(): combinar con AND lógico
 *  - Predicate.or(): combinar con OR lógico
 *  - Predicate.negate(): invertir el resultado
 *  - Pipeline: cadena de transformaciones secuenciales
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  // Function composition
 *  Function<A,B> f = ...;
 *  Function<B,C> g = ...;
 *  Function<A,C> fg = f.andThen(g);  // primero f, luego g
 *  Function<A,C> gf = g.compose(f);  // primero f, luego g (mismo resultado)
 *
 *  // Predicate chaining
 *  Predicate<T> p1 = ...;
 *  Predicate<T> p2 = ...;
 *  Predicate<T> ambos   = p1.and(p2);
 *  Predicate<T> alguno  = p1.or(p2);
 *  Predicate<T> ninguno = p1.negate();
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Confundir el orden de andThen() vs compose()
 *  - No considerar que compose() es "al revés" del orden de lectura
 *  - Olvidar que cada paso devuelve una NUEVA función (inmutable)
 *  - Encadenar demasiadas operaciones sin nombres descriptivos
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
 * ============================================================
 */

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ComposicionFunciones {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║       COMPOSICIÓN DE FUNCIONES EN JAVA              ║");
        System.out.println("╚══════════════════════════════════════════════════════╝\n");

        // ─────────────────────────────────────────────
        // 1. andThen() — Encadenar funciones en orden
        // ─────────────────────────────────────────────
        System.out.println("═══ 1. andThen() — Encadenar funciones ═══\n");

        /*
         * f.andThen(g) crea una nueva función que:
         *   1. Primero aplica f
         *   2. Luego aplica g al resultado de f
         *
         * Es decir: andThen ejecuta en el ORDEN DE LECTURA.
         *
         * Ejemplo visual:
         *   entrada → [f] → resultado intermedio → [g] → resultado final
         */

        Function<String, String> recortar = String::trim;
        Function<String, String> aMayusculas = String::toUpperCase;
        Function<String, Integer> obtenerLongitud = String::length;

        // Encadenar: primero recortar, luego a mayúsculas
        Function<String, String> recortarYMayusculas = recortar.andThen(aMayusculas);

        System.out.println("Entrada:  '  hola mundo  '");
        System.out.println("Recortar + Mayúsculas: '"
                + recortarYMayusculas.apply("  hola mundo  ") + "'");
        // Resultado: 'HOLA MUNDO'

        // Encadenar 3 funciones: recortar → mayúsculas → longitud
        Function<String, Integer> recortarMayusculasLongitud =
                recortar.andThen(aMayusculas).andThen(obtenerLongitud);

        System.out.println("Recortar + Mayúsculas + Longitud: "
                + recortarMayusculasLongitud.apply("  hola mundo  "));
        // Resultado: 10

        // --- Ejemplo numérico ---
        Function<Integer, Integer> duplicar = n -> n * 2;
        Function<Integer, Integer> sumarDiez = n -> n + 10;
        Function<Integer, String> aTexto = n -> "Resultado: " + n;

        // 5 → duplicar (10) → sumarDiez (20) → aTexto ("Resultado: 20")
        Function<Integer, String> pipeline = duplicar.andThen(sumarDiez).andThen(aTexto);

        System.out.println("\n5 → duplicar → sumarDiez → aTexto: " + pipeline.apply(5));
        System.out.println("3 → duplicar → sumarDiez → aTexto: " + pipeline.apply(3));

        // ─────────────────────────────────────────────
        // 2. compose() — Componer en orden inverso
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 2. compose() — Componer en orden inverso ═══\n");

        /*
         * f.compose(g) crea una nueva función que:
         *   1. Primero aplica g
         *   2. Luego aplica f al resultado de g
         *
         * ¡Es el INVERSO de andThen!
         *
         *   f.andThen(g) = g.compose(f)
         *
         * compose se lee como en matemáticas: f∘g significa "f después de g".
         */

        Function<Integer, Integer> cuadrado = n -> n * n;
        Function<Integer, Integer> incrementar = n -> n + 1;

        // andThen: primero cuadrado, luego incrementar
        // 3 → cuadrado (9) → incrementar (10)
        Function<Integer, Integer> cuadradoLuegoIncrementar = cuadrado.andThen(incrementar);

        // compose: f.compose(g) = primero g, luego f
        // incrementar.compose(cuadrado) = primero cuadrado, luego incrementar
        Function<Integer, Integer> incrementarDespuesDeCuadrado = incrementar.compose(cuadrado);

        System.out.println("3 → cuadrado → incrementar (andThen):  "
                + cuadradoLuegoIncrementar.apply(3));       // 10
        System.out.println("3 → cuadrado → incrementar (compose):  "
                + incrementarDespuesDeCuadrado.apply(3));   // 10

        // compose invierte el orden:
        // 3 → incrementar (4) → cuadrado (16)
        Function<Integer, Integer> incrementarLuegoCuadrado = cuadrado.compose(incrementar);

        System.out.println("\n3 → incrementar → cuadrado (compose): "
                + incrementarLuegoCuadrado.apply(3));  // 16

        // --- Comparación visual ---
        System.out.println("\n--- Comparación andThen vs compose ---");
        System.out.println("f = cuadrado, g = incrementar");
        System.out.println("f.andThen(g).apply(3): primero f(3)=9, luego g(9)=10  → "
                + cuadrado.andThen(incrementar).apply(3));
        System.out.println("f.compose(g).apply(3): primero g(3)=4, luego f(4)=16  → "
                + cuadrado.compose(incrementar).apply(3));

        // ─────────────────────────────────────────────
        // 3. Encadenamiento de Predicate
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 3. Encadenamiento de Predicate ═══\n");

        /*
         * Los Predicate se pueden combinar con:
         *   - and(): ambas condiciones deben ser true (AND lógico)
         *   - or():  al menos una debe ser true (OR lógico)
         *   - negate(): invierte el resultado (NOT lógico)
         *
         * Esto permite construir condiciones complejas a partir
         * de predicados simples y reutilizables.
         */

        // Predicados simples
        Predicate<Integer> esPositivo = n -> n > 0;
        Predicate<Integer> esPar = n -> n % 2 == 0;
        Predicate<Integer> esMenorQueCien = n -> n < 100;

        // --- and(): ambas condiciones ---
        Predicate<Integer> positivoYPar = esPositivo.and(esPar);
        System.out.println("--- and() ---");
        System.out.println("¿6 es positivo Y par?  " + positivoYPar.test(6));    // true
        System.out.println("¿7 es positivo Y par?  " + positivoYPar.test(7));    // false
        System.out.println("¿-4 es positivo Y par? " + positivoYPar.test(-4));   // false

        // --- or(): al menos una condición ---
        Predicate<Integer> positivoOPar = esPositivo.or(esPar);
        System.out.println("\n--- or() ---");
        System.out.println("¿6 es positivo O par?  " + positivoOPar.test(6));    // true
        System.out.println("¿7 es positivo O par?  " + positivoOPar.test(7));    // true
        System.out.println("¿-4 es positivo O par? " + positivoOPar.test(-4));   // true
        System.out.println("¿-3 es positivo O par? " + positivoOPar.test(-3));   // false

        // --- negate(): invertir ---
        Predicate<Integer> esImpar = esPar.negate();
        System.out.println("\n--- negate() ---");
        System.out.println("¿5 es impar? " + esImpar.test(5));   // true
        System.out.println("¿4 es impar? " + esImpar.test(4));   // false

        // --- Combinar múltiples predicados ---
        Predicate<Integer> positivoParYMenorQueCien =
                esPositivo.and(esPar).and(esMenorQueCien);

        System.out.println("\n--- Combinación compleja ---");
        System.out.println("¿50 es positivo, par y < 100? "
                + positivoParYMenorQueCien.test(50));    // true
        System.out.println("¿150 es positivo, par y < 100? "
                + positivoParYMenorQueCien.test(150));   // false
        System.out.println("¿-2 es positivo, par y < 100? "
                + positivoParYMenorQueCien.test(-2));    // false

        // --- Filtrar lista con predicados compuestos ---
        System.out.println("\n--- Filtrar con predicados compuestos ---");
        List<Integer> numeros = Arrays.asList(-10, -5, 0, 1, 2, 3, 4, 15, 22, 50, 101, 200);

        List<Integer> filtrados = numeros.stream()
                .filter(positivoParYMenorQueCien)
                .collect(Collectors.toList());

        System.out.println("Números: " + numeros);
        System.out.println("Positivos, pares y < 100: " + filtrados);  // [2, 4, 22, 50]

        // ─────────────────────────────────────────────
        // 4. Encadenamiento de Consumer con andThen()
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 4. Encadenamiento de Consumer ═══\n");

        /*
         * Consumer también soporta andThen() para ejecutar
         * múltiples acciones en secuencia sobre el mismo dato.
         *
         * Consumer NO tiene compose() porque no devuelve valor.
         */

        Consumer<String> imprimirOriginal = s ->
                System.out.println("  Original:   " + s);
        Consumer<String> imprimirMayusculas = s ->
                System.out.println("  Mayúsculas: " + s.toUpperCase());
        Consumer<String> imprimirLongitud = s ->
                System.out.println("  Longitud:   " + s.length());

        // Encadenar los 3 consumers
        Consumer<String> imprimirCompleto = imprimirOriginal
                .andThen(imprimirMayusculas)
                .andThen(imprimirLongitud);

        System.out.println("Procesando 'Java':");
        imprimirCompleto.accept("Java");

        System.out.println("\nProcesando 'Programación Funcional':");
        imprimirCompleto.accept("Programación Funcional");

        // ─────────────────────────────────────────────
        // 5. Predicate.not() — Método estático (Java 11+)
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 5. Predicate.not() — Java 11+ ═══\n");

        /*
         * Desde Java 11, existe Predicate.not() como alternativa
         * más legible a .negate(), especialmente con referencias
         * a métodos.
         */

        List<String> palabras = Arrays.asList("Hola", "", "Mundo", "", "Java", "");

        // Con negate():
        Predicate<String> noVacia = ((Predicate<String>) String::isEmpty).negate();

        // Con Predicate.not() — más limpio:
        List<String> sinVacias = palabras.stream()
                .filter(Predicate.not(String::isEmpty))
                .collect(Collectors.toList());

        System.out.println("Original:  " + palabras);
        System.out.println("Sin vacías: " + sinVacias);

        // ─────────────────────────────────────────────
        // 6. Function.identity() — Función identidad
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 6. Function.identity() ═══\n");

        /*
         * Function.identity() devuelve una función que retorna
         * su propia entrada sin modificarla.
         *
         *   Function.identity().apply(x) → x
         *
         * Parece inútil, pero es útil como valor por defecto
         * o en operaciones de composición condicional.
         */

        Function<String, String> identidad = Function.identity();
        System.out.println("identity('Hola'): " + identidad.apply("Hola")); // Hola

        // Uso práctico: transformación condicional
        boolean activarMayusculas = true;
        Function<String, String> transformacion = activarMayusculas
                ? String::toUpperCase
                : Function.identity();

        System.out.println("Con flag activado: " + transformacion.apply("prueba"));

        // ─────────────────────────────────────────────
        // 7. PIPELINE DE PROCESAMIENTO DE DATOS
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 7. PIPELINE DE PROCESAMIENTO DE DATOS ═══\n");

        /*
         * Un pipeline funcional es una cadena de transformaciones
         * donde la salida de cada paso es la entrada del siguiente.
         *
         * Ventajas:
         *   - Cada paso es una función simple y testeable
         *   - Se pueden reordenar, agregar o quitar pasos
         *   - El código es declarativo y legible
         */

        System.out.println("--- Pipeline de procesamiento de usuarios ---\n");

        // Datos de entrada (simulan datos de un formulario)
        List<String> datosFormulario = Arrays.asList(
                "  CARLOS GONZÁLEZ  ",
                "  ana   MARTÍNEZ ",
                "",
                "  pedro   ",
                "  AB  ",
                "  MARÍA FERNANDA LÓPEZ  ",
                "   ",
                "  juan   PABLO  "
        );

        System.out.println("Datos crudos del formulario:");
        datosFormulario.forEach(s -> System.out.println("  '" + s + "'"));

        // PASO 1: Definir funciones de transformación individuales
        UnaryOperator<String> paso1Recortar = String::trim;

        UnaryOperator<String> paso2Normalizar = s -> {
            // Reducir espacios múltiples a uno solo
            return s.replaceAll("\\s+", " ");
        };

        UnaryOperator<String> paso3Capitalizar = s -> {
            // Convertir cada palabra a formato título
            if (s.isEmpty()) return s;
            String[] partes = s.toLowerCase().split(" ");
            StringBuilder resultado = new StringBuilder();
            for (int i = 0; i < partes.length; i++) {
                if (i > 0) resultado.append(" ");
                if (!partes[i].isEmpty()) {
                    resultado.append(Character.toUpperCase(partes[i].charAt(0)));
                    resultado.append(partes[i].substring(1));
                }
            }
            return resultado.toString();
        };

        // PASO 2: Definir predicados de validación
        Predicate<String> noEstaVacia = Predicate.not(String::isEmpty);
        Predicate<String> longitudMinima = s -> s.length() >= 3;
        Predicate<String> validadorCompleto = noEstaVacia.and(longitudMinima);

        // PASO 3: Componer la función de transformación
        Function<String, String> transformarNombre =
                ((Function<String, String>) paso1Recortar)
                        .andThen(paso2Normalizar)
                        .andThen(paso3Capitalizar);

        // PASO 4: Ejecutar el pipeline completo
        List<String> nombresLimpios = datosFormulario.stream()
                .map(transformarNombre)       // Aplicar transformaciones
                .filter(validadorCompleto)    // Filtrar inválidos
                .distinct()                   // Eliminar duplicados
                .sorted()                     // Ordenar alfabéticamente
                .collect(Collectors.toList());

        System.out.println("\nDespués del pipeline:");
        nombresLimpios.forEach(n -> System.out.println("  ✓ " + n));

        // ─────────────────────────────────────────────
        // 8. CONSTRUIR PIPELINES DINÁMICOS
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 8. Pipelines dinámicos ═══\n");

        /*
         * Podemos construir pipelines a partir de una lista de
         * funciones, combinándolas dinámicamente con reduce().
         */

        // Lista de transformaciones
        List<UnaryOperator<String>> transformaciones = Arrays.asList(
                String::trim,
                String::toLowerCase,
                s -> s.replaceAll("[^a-záéíóúñ\\s]", ""),  // Solo letras y espacios
                s -> s.replaceAll("\\s+", "_")             // Espacios a guiones bajos
        );

        // Combinar todas las transformaciones en una sola función
        Function<String, String> pipelineCompleto = transformaciones.stream()
                .map(op -> (Function<String, String>) op)
                .reduce(Function.identity(), Function::andThen);

        System.out.println("Pipeline dinámico aplicado:");
        List<String> entradas = Arrays.asList(
                "  ¡Hola Mundo!  ",
                "  JAVA 2024 Rocks!  ",
                "  Programación  Funcional  "
        );

        for (String entrada : entradas) {
            System.out.println("  '" + entrada + "' → '" + pipelineCompleto.apply(entrada) + "'");
        }

        // ─────────────────────────────────────────────
        // 9. EJEMPLO AVANZADO: Procesador configurable
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 9. Procesador configurable ═══\n");

        // Crear un procesador de productos con pasos configurables
        List<Producto> inventario = Arrays.asList(
                new Producto("Laptop Gaming", 1500.0, "Electrónica", 5),
                new Producto("Mouse Inalámbrico", 35.0, "Accesorios", 100),
                new Producto("Teclado Mecánico", 120.0, "Accesorios", 0),
                new Producto("Monitor 4K", 450.0, "Electrónica", 3),
                new Producto("Cable HDMI", 15.0, "Cables", 200),
                new Producto("Webcam HD", 80.0, "Accesorios", 15),
                new Producto("SSD 1TB", 90.0, "Almacenamiento", 50),
                new Producto("Hub USB", 25.0, "Accesorios", 0)
        );

        System.out.println("Inventario completo:");
        inventario.forEach(p -> System.out.println("  " + p));

        // Definir filtros como predicados reutilizables
        Predicate<Producto> enStock = p -> p.getCantidad() > 0;
        Predicate<Producto> precioAccesible = p -> p.getPrecio() < 100;
        Predicate<Producto> esAccesorio = p -> p.getCategoria().equals("Accesorios");

        // Combinar filtros
        Predicate<Producto> filtroFinal = enStock.and(precioAccesible).and(esAccesorio);

        // Definir transformación: aplicar 10% de descuento
        Function<Producto, String> formatearConDescuento = p -> {
            double precioConDescuento = p.getPrecio() * 0.9;
            return String.format("  → %s: $%.2f (antes $%.2f) - %d unidades",
                    p.getNombre(), precioConDescuento, p.getPrecio(), p.getCantidad());
        };

        // Ejecutar pipeline
        System.out.println("\nAccesorios en stock y accesibles (con 10% de descuento):");
        inventario.stream()
                .filter(filtroFinal)
                .map(formatearConDescuento)
                .forEach(System.out::println);

        // Demostrar flexibilidad: cambiar filtros fácilmente
        Predicate<Producto> sinStock = enStock.negate();
        System.out.println("\nProductos sin stock:");
        inventario.stream()
                .filter(sinStock)
                .forEach(p -> System.out.println("  ⚠ " + p.getNombre() + " - SIN STOCK"));

        // ─────────────────────────────────────────────
        // TABLA RESUMEN
        // ─────────────────────────────────────────────
        System.out.println("\n╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║         TABLA RESUMEN — COMPOSICIÓN DE FUNCIONES               ║");
        System.out.println("╠══════════════════════╦═════════════════════════════════════════╣");
        System.out.println("║ Método               ║ Descripción                             ║");
        System.out.println("╠══════════════════════╬═════════════════════════════════════════╣");
        System.out.println("║ f.andThen(g)         ║ Primero f, luego g                      ║");
        System.out.println("║ f.compose(g)         ║ Primero g, luego f (inverso de andThen) ║");
        System.out.println("║ p1.and(p2)           ║ true si AMBOS predicados son true        ║");
        System.out.println("║ p1.or(p2)            ║ true si AL MENOS UNO es true             ║");
        System.out.println("║ p.negate()           ║ Invierte el resultado del predicado      ║");
        System.out.println("║ Predicate.not(p)     ║ Igual que negate() pero estático (11+)   ║");
        System.out.println("║ Function.identity()  ║ Devuelve la entrada sin cambios          ║");
        System.out.println("║ c1.andThen(c2)       ║ Ejecutar dos consumers en secuencia      ║");
        System.out.println("╚══════════════════════╩═════════════════════════════════════════╝");
    }

    // ─────────────────────────────────────────────
    // CLASE AUXILIAR
    // ─────────────────────────────────────────────

    /**
     * Clase que representa un producto del inventario.
     */
    static class Producto {
        private String nombre;
        private double precio;
        private String categoria;
        private int cantidad;

        /**
         * Crea un producto con toda su información.
         *
         * @param nombre    el nombre del producto
         * @param precio    el precio unitario
         * @param categoria la categoría del producto
         * @param cantidad  la cantidad en stock
         */
        public Producto(String nombre, double precio, String categoria, int cantidad) {
            this.nombre = nombre;
            this.precio = precio;
            this.categoria = categoria;
            this.cantidad = cantidad;
        }

        /**
         * Obtiene el nombre del producto.
         *
         * @return el nombre del producto
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Obtiene el precio del producto.
         *
         * @return el precio del producto
         */
        public double getPrecio() {
            return precio;
        }

        /**
         * Obtiene la categoría del producto.
         *
         * @return la categoría del producto
         */
        public String getCategoria() {
            return categoria;
        }

        /**
         * Obtiene la cantidad en stock.
         *
         * @return la cantidad disponible
         */
        public int getCantidad() {
            return cantidad;
        }

        /**
         * Representación en texto del producto.
         *
         * @return cadena con la información del producto
         */
        @Override
        public String toString() {
            return String.format("%s [$%.2f] (%s) - %d uds.",
                    nombre, precio, categoria, cantidad);
        }
    }
}
