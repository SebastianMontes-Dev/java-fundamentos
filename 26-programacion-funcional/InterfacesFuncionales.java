/**
 * ============================================================
 *  TEMA: Programación Funcional en Java
 *  SECCIÓN: 26 — Programación Funcional
 *  ARCHIVO: InterfacesFuncionales.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás a utilizar las interfaces funcionales integradas
 *  del paquete java.util.function. Estas interfaces son la base
 *  de la programación funcional en Java y se usan ampliamente
 *  con lambdas y streams. Verás cómo Predicate, Function,
 *  Consumer y Supplier simplifican tu código.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Interfaz funcional: interfaz con UN solo método abstracto
 *  - Predicate<T>: recibe un valor y devuelve boolean
 *  - Function<T,R>: recibe un valor de tipo T y devuelve tipo R
 *  - Consumer<T>: recibe un valor y no devuelve nada (void)
 *  - Supplier<T>: no recibe nada y devuelve un valor de tipo T
 *  - UnaryOperator<T>: caso especial de Function donde T == R
 *  - BinaryOperator<T>: recibe dos T y devuelve un T
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  Predicate<String>  esMayor = s -> s.length() > 5;
 *  Function<String, Integer> longitud = s -> s.length();
 *  Consumer<String>   imprimir = s -> System.out.println(s);
 *  Supplier<Double>   aleatorio = () -> Math.random();
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Confundir Function con Consumer (Function devuelve, Consumer no)
 *  - Olvidar que Predicate siempre devuelve boolean
 *  - Usar tipos primitivos directamente (usar IntPredicate, etc.)
 *  - No entender que @FunctionalInterface es opcional pero recomendado
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
 *  - Tutorial Oracle Lambda: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 * ============================================================
 */

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;
import java.util.function.BiFunction;
import java.util.function.BiConsumer;
import java.util.function.IntPredicate;
import java.util.function.DoubleSupplier;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class InterfacesFuncionales {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║     INTERFACES FUNCIONALES EN JAVA                  ║");
        System.out.println("╚══════════════════════════════════════════════════════╝\n");

        // ─────────────────────────────────────────────
        // 1. ¿QUÉ ES UNA INTERFAZ FUNCIONAL?
        // ─────────────────────────────────────────────
        System.out.println("═══ 1. ¿QUÉ ES UNA INTERFAZ FUNCIONAL? ═══\n");

        /*
         * Una interfaz funcional es una interfaz que tiene
         * EXACTAMENTE UN método abstracto. Puede tener métodos
         * default y static adicionales.
         *
         * La anotación @FunctionalInterface es opcional pero
         * ayuda al compilador a verificar que solo haya un
         * método abstracto.
         *
         * Ejemplos del JDK:
         *   - Runnable        → void run()
         *   - Comparable<T>   → int compareTo(T o)
         *   - Predicate<T>    → boolean test(T t)
         *   - Function<T,R>   → R apply(T t)
         *   - Consumer<T>     → void accept(T t)
         *   - Supplier<T>     → T get()
         */

        System.out.println("Una interfaz funcional = una interfaz con UN método abstracto");
        System.out.println("Se puede asignar una expresión lambda a ella.\n");

        // ─────────────────────────────────────────────
        // 2. PREDICATE<T> — Evaluar condiciones
        // ─────────────────────────────────────────────
        System.out.println("═══ 2. PREDICATE<T> — Evaluar condiciones ═══\n");

        /*
         * Predicate<T> define:
         *   boolean test(T t)
         *
         * Recibe un valor y devuelve true o false.
         * Es ideal para filtrar datos, validar entradas,
         * y definir condiciones reutilizables.
         */

        // --- Ejemplo básico: verificar si un número es par ---
        Predicate<Integer> esPar = numero -> numero % 2 == 0;

        System.out.println("¿10 es par? " + esPar.test(10));   // true
        System.out.println("¿7 es par?  " + esPar.test(7));    // false

        // --- Ejemplo: verificar longitud de cadena ---
        Predicate<String> esCorta = texto -> texto.length() <= 5;
        Predicate<String> noEstaVacia = texto -> !texto.isEmpty();

        System.out.println("¿'Hola' es corta? " + esCorta.test("Hola"));             // true
        System.out.println("¿'Programación' es corta? " + esCorta.test("Programación")); // false

        // --- Encadenar Predicates con and(), or(), negate() ---
        Predicate<String> esValida = noEstaVacia.and(esCorta);

        System.out.println("\n--- Encadenamiento de Predicates ---");
        System.out.println("¿'' es válida (no vacía Y corta)? " + esValida.test(""));      // false
        System.out.println("¿'Hi' es válida? " + esValida.test("Hi"));                     // true
        System.out.println("¿'MuyLargaEsta' es válida? " + esValida.test("MuyLargaEsta")); // false

        // --- Uso práctico: filtrar una lista ---
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> pares = filtrar(numeros, esPar);
        System.out.println("\nNúmeros pares: " + pares);  // [2, 4, 6, 8, 10]

        Predicate<Integer> mayorQueCinco = n -> n > 5;
        List<Integer> paresYMayoresQueCinco = filtrar(numeros, esPar.and(mayorQueCinco));
        System.out.println("Pares y > 5: " + paresYMayoresQueCinco);  // [6, 8, 10]

        // ─────────────────────────────────────────────
        // 3. FUNCTION<T, R> — Transformar datos
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 3. FUNCTION<T, R> — Transformar datos ═══\n");

        /*
         * Function<T, R> define:
         *   R apply(T t)
         *
         * Recibe un valor de tipo T y devuelve uno de tipo R.
         * Es ideal para transformar datos de un tipo a otro.
         */

        // --- Ejemplo básico: obtener la longitud de un String ---
        Function<String, Integer> longitud = texto -> texto.length();
        System.out.println("Longitud de 'Java': " + longitud.apply("Java"));  // 4

        // --- Ejemplo: convertir a mayúsculas ---
        Function<String, String> aMayusculas = texto -> texto.toUpperCase();
        System.out.println("Mayúsculas de 'hola': " + aMayusculas.apply("hola")); // HOLA

        // --- Ejemplo: parsear String a Integer ---
        Function<String, Integer> aEntero = texto -> Integer.parseInt(texto);
        System.out.println("Parsear '42': " + aEntero.apply("42")); // 42

        // --- Ejemplo: crear un saludo personalizado ---
        Function<String, String> crearSaludo = nombre -> "¡Hola, " + nombre + "! Bienvenido.";
        System.out.println(crearSaludo.apply("Carlos")); // ¡Hola, Carlos! Bienvenido.

        // --- Composición con andThen() ---
        Function<String, Integer> longitudDeMayusculas = aMayusculas.andThen(longitud);
        System.out.println("\nLongitud después de mayúsculas de 'java': "
                + longitudDeMayusculas.apply("java")); // 4

        // --- Transformar una lista ---
        List<String> nombres = Arrays.asList("Ana", "Carlos", "Beatriz", "David");
        List<Integer> longitudes = transformar(nombres, longitud);
        System.out.println("Longitudes: " + longitudes); // [3, 6, 7, 5]

        // ─────────────────────────────────────────────
        // 4. CONSUMER<T> — Consumir datos (sin retorno)
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 4. CONSUMER<T> — Consumir datos ═══\n");

        /*
         * Consumer<T> define:
         *   void accept(T t)
         *
         * Recibe un valor pero NO devuelve nada.
         * Es ideal para operaciones con efectos secundarios:
         * imprimir, guardar en base de datos, enviar emails, etc.
         */

        // --- Ejemplo básico: imprimir ---
        Consumer<String> imprimir = mensaje -> System.out.println(">> " + mensaje);
        imprimir.accept("Este es un Consumer");

        // --- Ejemplo: formatear e imprimir ---
        Consumer<String> imprimirEnMayusculas = mensaje ->
                System.out.println(">> " + mensaje.toUpperCase());
        imprimirEnMayusculas.accept("texto en minúsculas");

        // --- Encadenar Consumers con andThen() ---
        Consumer<String> imprimirFormateado = imprimir.andThen(imprimirEnMayusculas);
        System.out.println("\n--- Consumer encadenado ---");
        imprimirFormateado.accept("prueba");
        // Imprime: >> prueba
        //          >> PRUEBA

        // --- Uso práctico: procesar cada elemento ---
        System.out.println("\n--- Procesar lista de nombres ---");
        Consumer<String> procesarNombre = nombre -> {
            String formateado = nombre.substring(0, 1).toUpperCase()
                    + nombre.substring(1).toLowerCase();
            System.out.println("  Procesado: " + formateado);
        };

        List<String> nombresDesordenados = Arrays.asList("ANA", "carlos", "BEATRIZ");
        nombresDesordenados.forEach(procesarNombre);

        // ─────────────────────────────────────────────
        // 5. SUPPLIER<T> — Proveer datos (sin entrada)
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 5. SUPPLIER<T> — Proveer datos ═══\n");

        /*
         * Supplier<T> define:
         *   T get()
         *
         * No recibe nada pero DEVUELVE un valor.
         * Es ideal para generar valores: valores por defecto,
         * objetos nuevos, valores aleatorios, timestamps, etc.
         */

        // --- Ejemplo básico: generar un número aleatorio ---
        Supplier<Double> aleatorio = () -> Math.random();
        System.out.println("Aleatorio 1: " + aleatorio.get());
        System.out.println("Aleatorio 2: " + aleatorio.get());

        // --- Ejemplo: proveer un valor por defecto ---
        Supplier<String> mensajePorDefecto = () -> "Sin datos disponibles";
        System.out.println("Default: " + mensajePorDefecto.get());

        // --- Ejemplo: crear objetos nuevos ---
        Supplier<List<String>> crearLista = () -> new ArrayList<>();
        List<String> nuevaLista = crearLista.get();
        nuevaLista.add("Elemento 1");
        System.out.println("Lista creada: " + nuevaLista);

        // --- Ejemplo: generar timestamps ---
        Supplier<Long> timestamp = () -> System.currentTimeMillis();
        System.out.println("Timestamp: " + timestamp.get());

        // --- Uso práctico: obtener valor o default ---
        String resultado = obtenerODefault(null, mensajePorDefecto);
        System.out.println("Con null: " + resultado);  // Sin datos disponibles

        resultado = obtenerODefault("Valor real", mensajePorDefecto);
        System.out.println("Con valor: " + resultado);  // Valor real

        // ─────────────────────────────────────────────
        // 6. UnaryOperator<T> y BinaryOperator<T>
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 6. UnaryOperator y BinaryOperator ═══\n");

        /*
         * UnaryOperator<T> extiende Function<T, T>:
         *   T apply(T t)
         *   → Entrada y salida del MISMO tipo.
         *
         * BinaryOperator<T> extiende BiFunction<T, T, T>:
         *   T apply(T t1, T t2)
         *   → Dos entradas y salida del MISMO tipo.
         */

        // --- UnaryOperator: transformación del mismo tipo ---
        UnaryOperator<String> agregarExclamacion = texto -> texto + "!";
        UnaryOperator<Integer> duplicar = n -> n * 2;

        System.out.println(agregarExclamacion.apply("Hola"));  // Hola!
        System.out.println("Duplicar 5: " + duplicar.apply(5)); // 10

        // --- BinaryOperator: combinar dos valores del mismo tipo ---
        BinaryOperator<Integer> sumar = (a, b) -> a + b;
        BinaryOperator<String> concatenar = (a, b) -> a + " " + b;

        System.out.println("Sumar 3 + 7: " + sumar.apply(3, 7));       // 10
        System.out.println(concatenar.apply("Hola", "Mundo"));          // Hola Mundo

        // --- Uso con replaceAll en listas ---
        List<String> frutas = new ArrayList<>(Arrays.asList("manzana", "pera", "uva"));
        frutas.replaceAll(texto -> texto.toUpperCase());
        System.out.println("Frutas en mayúsculas: " + frutas);

        // ─────────────────────────────────────────────
        // 7. BiFunction y BiConsumer
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 7. BiFunction y BiConsumer ═══\n");

        /*
         * BiFunction<T, U, R>:
         *   R apply(T t, U u)
         *   → Recibe DOS parámetros de diferente tipo, devuelve R.
         *
         * BiConsumer<T, U>:
         *   void accept(T t, U u)
         *   → Recibe DOS parámetros, no devuelve nada.
         */

        // --- BiFunction: combinar nombre y edad ---
        BiFunction<String, Integer, String> crearPresentacion =
                (nombre, edad) -> nombre + " tiene " + edad + " años";

        System.out.println(crearPresentacion.apply("Ana", 25));

        // --- BiFunction: calcular precio con descuento ---
        BiFunction<Double, Double, Double> aplicarDescuento =
                (precio, porcentaje) -> precio * (1 - porcentaje / 100);

        System.out.println("Precio con 20% desc: $" +
                String.format("%.2f", aplicarDescuento.apply(100.0, 20.0)));

        // --- BiConsumer: agregar entrada a un mapa ---
        BiConsumer<Map<String, Integer>, String> agregarConLongitud =
                (mapa, texto) -> mapa.put(texto, texto.length());

        Map<String, Integer> mapaLongitudes = new HashMap<>();
        agregarConLongitud.accept(mapaLongitudes, "Java");
        agregarConLongitud.accept(mapaLongitudes, "Python");
        agregarConLongitud.accept(mapaLongitudes, "Go");
        System.out.println("Mapa de longitudes: " + mapaLongitudes);

        // ─────────────────────────────────────────────
        // 8. VERSIONES PRIMITIVAS (evitar autoboxing)
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 8. Versiones primitivas ═══\n");

        /*
         * Para evitar el costo de autoboxing/unboxing, Java
         * provee versiones especializadas para primitivos:
         *
         *   IntPredicate    → boolean test(int value)
         *   LongPredicate   → boolean test(long value)
         *   DoublePredicate → boolean test(double value)
         *   IntFunction<R>  → R apply(int value)
         *   IntConsumer     → void accept(int value)
         *   IntSupplier     → int getAsInt()
         *   DoubleSupplier  → double getAsDouble()
         *   etc.
         */

        IntPredicate esPositivo = n -> n > 0;
        System.out.println("¿5 es positivo? " + esPositivo.test(5));   // true
        System.out.println("¿-3 es positivo? " + esPositivo.test(-3)); // false

        DoubleSupplier pi = () -> Math.PI;
        System.out.println("PI: " + pi.getAsDouble());

        // ─────────────────────────────────────────────
        // 9. EJEMPLO INTEGRADOR: Sistema de validación
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 9. EJEMPLO INTEGRADOR ═══\n");

        // Crear validadores reutilizables
        Predicate<String> noVacia = s -> !s.isEmpty();
        Predicate<String> longitudMinima = s -> s.length() >= 3;
        Predicate<String> longitudMaxima = s -> s.length() <= 20;
        Predicate<String> sinEspacios = s -> !s.contains(" ");

        // Combinar validadores
        Predicate<String> validadorUsuario = noVacia
                .and(longitudMinima)
                .and(longitudMaxima)
                .and(sinEspacios);

        // Transformador
        Function<String, String> normalizar = s -> s.trim().toLowerCase();

        // Consumer para reportar
        Consumer<String> reportar = usuario -> {
            String normalizado = normalizar.apply(usuario);
            boolean valido = validadorUsuario.test(normalizado);
            System.out.println("  Usuario: '" + usuario + "' → Normalizado: '"
                    + normalizado + "' → " + (valido ? "✓ VÁLIDO" : "✗ INVÁLIDO"));
        };

        System.out.println("--- Validación de nombres de usuario ---");
        List<String> usuarios = Arrays.asList(
                "Carlos", "AB", " ana ", "usuario con espacios",
                "JavaDeveloper2024", "estoEstienenMuchoMasDe20Caracteres", "Dev"
        );
        usuarios.forEach(reportar);

        // ─────────────────────────────────────────────
        // TABLA RESUMEN
        // ─────────────────────────────────────────────
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║              TABLA RESUMEN — INTERFACES FUNCIONALES           ║");
        System.out.println("╠═══════════════════╦═══════════════╦════════════╦═══════════════╣");
        System.out.println("║ Interfaz          ║ Entrada       ║ Salida     ║ Método        ║");
        System.out.println("╠═══════════════════╬═══════════════╬════════════╬═══════════════╣");
        System.out.println("║ Predicate<T>      ║ T             ║ boolean    ║ test(T)       ║");
        System.out.println("║ Function<T,R>     ║ T             ║ R          ║ apply(T)      ║");
        System.out.println("║ Consumer<T>       ║ T             ║ void       ║ accept(T)     ║");
        System.out.println("║ Supplier<T>       ║ (ninguna)     ║ T          ║ get()         ║");
        System.out.println("║ UnaryOperator<T>  ║ T             ║ T          ║ apply(T)      ║");
        System.out.println("║ BinaryOperator<T> ║ T, T          ║ T          ║ apply(T,T)    ║");
        System.out.println("║ BiFunction<T,U,R> ║ T, U          ║ R          ║ apply(T,U)    ║");
        System.out.println("║ BiConsumer<T,U>   ║ T, U          ║ void       ║ accept(T,U)   ║");
        System.out.println("╚═══════════════════╩═══════════════╩════════════╩═══════════════╝");
    }

    // ─────────────────────────────────────────────
    // MÉTODOS AUXILIARES
    // ─────────────────────────────────────────────

    /**
     * Filtra una lista usando un Predicate genérico.
     *
     * @param lista     la lista de elementos a filtrar
     * @param condicion el predicado que define la condición de filtrado
     * @param <T>       el tipo de elementos en la lista
     * @return una nueva lista con los elementos que cumplen la condición
     */
    public static <T> List<T> filtrar(List<T> lista, Predicate<T> condicion) {
        List<T> resultado = new ArrayList<>();
        for (T elemento : lista) {
            if (condicion.test(elemento)) {
                resultado.add(elemento);
            }
        }
        return resultado;
    }

    /**
     * Transforma una lista aplicando una Function a cada elemento.
     *
     * @param lista       la lista de elementos a transformar
     * @param transformar la función de transformación
     * @param <T>         el tipo de entrada
     * @param <R>         el tipo de salida
     * @return una nueva lista con los elementos transformados
     */
    public static <T, R> List<R> transformar(List<T> lista, Function<T, R> transformar) {
        List<R> resultado = new ArrayList<>();
        for (T elemento : lista) {
            resultado.add(transformar.apply(elemento));
        }
        return resultado;
    }

    /**
     * Devuelve el valor si no es null, o el valor por defecto del Supplier.
     *
     * @param valor         el valor que puede ser null
     * @param porDefecto    el proveedor del valor por defecto
     * @param <T>           el tipo del valor
     * @return el valor original o el valor por defecto
     */
    public static <T> T obtenerODefault(T valor, Supplier<T> porDefecto) {
        return valor != null ? valor : porDefecto.get();
    }
}
