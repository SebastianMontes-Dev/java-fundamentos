/**
 * ============================================================
 *  TEMA: Programación Funcional en Java
 *  SECCIÓN: 26 — Programación Funcional
 *  ARCHIVO: ReferenciasMetodos.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás a usar referencias a métodos (method references),
 *  una forma abreviada de expresiones lambda cuando la lambda
 *  simplemente llama a un método existente. Verás los cuatro
 *  tipos de referencias y cuándo usar cada una. También
 *  compararás cada referencia con su equivalente lambda.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Referencia a método estático: Clase::metodoEstatico
 *  - Referencia a método de instancia particular: objeto::metodo
 *  - Referencia a método de instancia arbitraria: Clase::metodo
 *  - Referencia a constructor: Clase::new
 *  - El operador :: (doble dos puntos)
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  // Referencia a método estático
 *  Function<String, Integer> f = Integer::parseInt;
 *
 *  // Referencia a método de instancia particular
 *  Consumer<String> c = System.out::println;
 *
 *  // Referencia a método de instancia arbitraria
 *  Function<String, String> g = String::toUpperCase;
 *
 *  // Referencia a constructor
 *  Supplier<ArrayList<String>> s = ArrayList::new;
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Confundir Clase::metodo con objeto::metodo
 *  - Intentar usar :: cuando la lambda tiene lógica adicional
 *  - No entender que String::toUpperCase requiere un String de entrada
 *  - Olvidar que :: no permite pasar argumentos explícitos
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
 * ============================================================
 */

import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ReferenciasMetodos {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║        REFERENCIAS A MÉTODOS EN JAVA                ║");
        System.out.println("╚══════════════════════════════════════════════════════╝\n");

        // ─────────────────────────────────────────────
        // 1. ¿QUÉ SON LAS REFERENCIAS A MÉTODOS?
        // ─────────────────────────────────────────────
        System.out.println("═══ 1. ¿QUÉ SON LAS REFERENCIAS A MÉTODOS? ═══\n");

        /*
         * Una referencia a método es una forma ABREVIADA de una
         * expresión lambda cuando esa lambda simplemente llama a
         * un método existente, sin lógica adicional.
         *
         * Lambda:              s -> System.out.println(s)
         * Referencia a método: System.out::println
         *
         * Ambas hacen exactamente lo mismo, pero la referencia
         * es más concisa y legible.
         *
         * Hay 4 tipos de referencias a métodos:
         *   1. Referencia a método estático:           Clase::metodoEstatico
         *   2. Referencia a método de instancia (obj):  objeto::metodo
         *   3. Referencia a método de instancia (tipo): Clase::metodo
         *   4. Referencia a constructor:                Clase::new
         */

        System.out.println("Referencia a método = forma abreviada de lambda");
        System.out.println("Se usa el operador :: (doble dos puntos)\n");

        // ─────────────────────────────────────────────
        // 2. TIPO 1: Referencia a método ESTÁTICO
        // ─────────────────────────────────────────────
        System.out.println("═══ 2. Referencia a método ESTÁTICO ═══\n");
        System.out.println("Sintaxis: NombreClase::metodoEstatico\n");

        /*
         * Se usa cuando la lambda llama a un método estático.
         *
         * Lambda equivalente:
         *   (args) -> Clase.metodoEstatico(args)
         *
         * Referencia:
         *   Clase::metodoEstatico
         */

        // --- Ejemplo 1: Integer.parseInt ---
        // Lambda:
        Function<String, Integer> parsearLambda = s -> Integer.parseInt(s);
        // Referencia a método:
        Function<String, Integer> parsearRef = Integer::parseInt;

        System.out.println("Lambda:     " + parsearLambda.apply("42"));  // 42
        System.out.println("Referencia: " + parsearRef.apply("42"));     // 42

        // --- Ejemplo 2: Math.abs ---
        // Lambda:
        Function<Integer, Integer> absLambda = n -> Math.abs(n);
        // Referencia a método:
        Function<Integer, Integer> absRef = Math::abs;

        System.out.println("\nMath.abs(-7) lambda:     " + absLambda.apply(-7));  // 7
        System.out.println("Math.abs(-7) referencia: " + absRef.apply(-7));      // 7

        // --- Ejemplo 3: String.valueOf ---
        Function<Integer, String> aTextoLambda = n -> String.valueOf(n);
        Function<Integer, String> aTextoRef = String::valueOf;

        System.out.println("\nString.valueOf(100) lambda:     " + aTextoLambda.apply(100));
        System.out.println("String.valueOf(100) referencia: " + aTextoRef.apply(100));

        // --- Ejemplo 4: Método estático personalizado ---
        Predicate<Integer> esMayorDeEdadLambda = edad -> esMayorDeEdad(edad);
        Predicate<Integer> esMayorDeEdadRef = ReferenciasMetodos::esMayorDeEdad;

        System.out.println("\n¿20 es mayor de edad? (lambda):     " + esMayorDeEdadLambda.test(20));
        System.out.println("¿20 es mayor de edad? (referencia): " + esMayorDeEdadRef.test(20));
        System.out.println("¿15 es mayor de edad? (referencia): " + esMayorDeEdadRef.test(15));

        // --- Uso en streams ---
        System.out.println("\n--- Uso en streams ---");
        List<String> numerosTexto = Arrays.asList("10", "20", "30", "40");

        // Con lambda:
        List<Integer> numerosLambda = numerosTexto.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        // Con referencia a método:
        List<Integer> numerosRef = numerosTexto.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Con lambda:     " + numerosLambda);
        System.out.println("Con referencia: " + numerosRef);

        // ─────────────────────────────────────────────
        // 3. TIPO 2: Referencia a método de INSTANCIA PARTICULAR
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 3. Referencia a método de INSTANCIA PARTICULAR ═══\n");
        System.out.println("Sintaxis: objetoExistente::metodo\n");

        /*
         * Se usa cuando la lambda llama a un método de un
         * objeto específico que ya existe.
         *
         * Lambda equivalente:
         *   (args) -> objeto.metodo(args)
         *
         * Referencia:
         *   objeto::metodo
         */

        // --- Ejemplo 1: System.out::println ---
        // Lambda:
        Consumer<String> imprimirLambda = s -> System.out.println(s);
        // Referencia (System.out es el objeto existente):
        Consumer<String> imprimirRef = System.out::println;

        imprimirLambda.accept("Impreso con lambda");
        imprimirRef.accept("Impreso con referencia a método");

        // --- Ejemplo 2: Método de un objeto propio ---
        String prefijo = "ALERT: ";
        // Lambda:
        Function<String, String> conPrefijoLambda = msg -> prefijo.concat(msg);
        // Referencia (prefijo es el objeto existente):
        Function<String, String> conPrefijoRef = prefijo::concat;

        System.out.println("\nCon lambda:     " + conPrefijoLambda.apply("Error detectado"));
        System.out.println("Con referencia: " + conPrefijoRef.apply("Error detectado"));

        // --- Ejemplo 3: Usar un objeto con instancia propia ---
        Formateador formateador = new Formateador("***");

        // Lambda:
        Function<String, String> formatearLambda = t -> formateador.formatear(t);
        // Referencia:
        Function<String, String> formatearRef = formateador::formatear;

        System.out.println("\nCon lambda:     " + formatearLambda.apply("importante"));
        System.out.println("Con referencia: " + formatearRef.apply("importante"));

        // --- Uso en forEach ---
        System.out.println("\n--- Uso en forEach ---");
        List<String> mensajes = Arrays.asList("Hola", "Mundo", "Java");

        System.out.println("Con lambda:");
        mensajes.forEach(m -> System.out.println("  → " + m));

        System.out.println("Con referencia directa:");
        mensajes.forEach(System.out::println);

        // ─────────────────────────────────────────────
        // 4. TIPO 3: Referencia a método de INSTANCIA ARBITRARIA
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 4. Referencia a método de INSTANCIA ARBITRARIA ═══\n");
        System.out.println("Sintaxis: NombreClase::metodoDeInstancia\n");

        /*
         * Se usa cuando la lambda recibe un objeto como primer
         * parámetro y llama a un método DE ese mismo objeto.
         *
         * Lambda equivalente:
         *   (objeto, args) -> objeto.metodo(args)
         *   o simplemente: (s) -> s.metodo()
         *
         * Referencia:
         *   Clase::metodo
         *
         * ¡OJO! Se parece a la referencia estática, pero se
         * diferencia porque el método NO es estático.
         */

        // --- Ejemplo 1: String::toUpperCase ---
        // Lambda:
        Function<String, String> mayusculasLambda = s -> s.toUpperCase();
        // Referencia:
        Function<String, String> mayusculasRef = String::toUpperCase;

        System.out.println("Lambda:     " + mayusculasLambda.apply("java"));  // JAVA
        System.out.println("Referencia: " + mayusculasRef.apply("java"));     // JAVA

        // --- Ejemplo 2: String::length ---
        Function<String, Integer> longitudLambda = s -> s.length();
        Function<String, Integer> longitudRef = String::length;

        System.out.println("\nLongitud 'Hola' lambda:     " + longitudLambda.apply("Hola"));
        System.out.println("Longitud 'Hola' referencia: " + longitudRef.apply("Hola"));

        // --- Ejemplo 3: String::isEmpty ---
        Predicate<String> estaVaciaLambda = s -> s.isEmpty();
        Predicate<String> estaVaciaRef = String::isEmpty;

        System.out.println("\n¿'' está vacía? lambda:     " + estaVaciaLambda.test(""));
        System.out.println("¿'' está vacía? referencia: " + estaVaciaRef.test(""));
        System.out.println("¿'abc' está vacía? ref:     " + estaVaciaRef.test("abc"));

        // --- Ejemplo 4: Con dos parámetros (BiFunction) ---
        // String::compareTo es un método de instancia que recibe un parámetro
        // Lambda: (s1, s2) -> s1.compareTo(s2)
        Comparator<String> compararLambda = (s1, s2) -> s1.compareTo(s2);
        Comparator<String> compararRef = String::compareTo;

        System.out.println("\nComparar 'a' con 'b' lambda:     " + compararLambda.compare("a", "b"));
        System.out.println("Comparar 'a' con 'b' referencia: " + compararRef.compare("a", "b"));

        // --- Uso en streams: ordenar ---
        System.out.println("\n--- Ordenar con referencia a instancia arbitraria ---");
        List<String> ciudades = Arrays.asList("Zapopan", "Monterrey", "Acapulco", "Bogotá");

        // Con lambda:
        List<String> ordenadasLambda = ciudades.stream()
                .sorted((a, b) -> a.compareToIgnoreCase(b))
                .collect(Collectors.toList());

        // Con referencia:
        List<String> ordenadasRef = ciudades.stream()
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());

        System.out.println("Lambda:     " + ordenadasLambda);
        System.out.println("Referencia: " + ordenadasRef);

        // ─────────────────────────────────────────────
        // 5. TIPO 4: Referencia a CONSTRUCTOR
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 5. Referencia a CONSTRUCTOR ═══\n");
        System.out.println("Sintaxis: NombreClase::new\n");

        /*
         * Se usa cuando la lambda simplemente crea un nuevo objeto.
         *
         * Lambda equivalente:
         *   () -> new Clase()               → Supplier<Clase>
         *   (arg) -> new Clase(arg)          → Function<Arg, Clase>
         *   (arg1, arg2) -> new Clase(a, b)  → BiFunction<A, B, Clase>
         *
         * Referencia:
         *   Clase::new
         *
         * Java infiere qué constructor usar basándose en el
         * contexto (la interfaz funcional target).
         */

        // --- Ejemplo 1: Constructor sin parámetros ---
        // Lambda:
        Supplier<ArrayList<String>> crearListaLambda = () -> new ArrayList<>();
        // Referencia:
        Supplier<ArrayList<String>> crearListaRef = ArrayList::new;

        ArrayList<String> lista1 = crearListaLambda.get();
        ArrayList<String> lista2 = crearListaRef.get();
        System.out.println("Lista con lambda:     " + lista1);
        System.out.println("Lista con referencia: " + lista2);

        // --- Ejemplo 2: Constructor con un parámetro ---
        // Lambda:
        Function<String, StringBuilder> crearSbLambda = s -> new StringBuilder(s);
        // Referencia:
        Function<String, StringBuilder> crearSbRef = StringBuilder::new;

        System.out.println("\nStringBuilder lambda:     " + crearSbLambda.apply("Hola"));
        System.out.println("StringBuilder referencia: " + crearSbRef.apply("Hola"));

        // --- Ejemplo 3: Constructor con clase personalizada ---
        // Lambda:
        Function<String, Producto> crearProductoLambda = nombre -> new Producto(nombre);
        // Referencia:
        Function<String, Producto> crearProductoRef = Producto::new;

        Producto p1 = crearProductoLambda.apply("Laptop");
        Producto p2 = crearProductoRef.apply("Teclado");
        System.out.println("\nProducto lambda:     " + p1);
        System.out.println("Producto referencia: " + p2);

        // --- Ejemplo 4: Constructor con dos parámetros ---
        BiFunction<String, Double, Producto> crearConPrecioLambda =
                (nombre, precio) -> new Producto(nombre, precio);
        BiFunction<String, Double, Producto> crearConPrecioRef = Producto::new;

        Producto p3 = crearConPrecioLambda.apply("Monitor", 299.99);
        Producto p4 = crearConPrecioRef.apply("Mouse", 49.99);
        System.out.println("\nCon precio lambda:     " + p3);
        System.out.println("Con precio referencia: " + p4);

        // --- Uso en streams: convertir lista de Strings a objetos ---
        System.out.println("\n--- Crear objetos desde un stream ---");
        List<String> nombresProductos = Arrays.asList("CPU", "RAM", "SSD", "GPU");

        // Con lambda:
        List<Producto> productosLambda = nombresProductos.stream()
                .map(n -> new Producto(n))
                .collect(Collectors.toList());

        // Con referencia:
        List<Producto> productosRef = nombresProductos.stream()
                .map(Producto::new)
                .collect(Collectors.toList());

        System.out.println("Con lambda:     " + productosLambda);
        System.out.println("Con referencia: " + productosRef);

        // ─────────────────────────────────────────────
        // 6. CUÁNDO USAR Y CUÁNDO NO
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 6. ¿CUÁNDO USAR REFERENCIAS A MÉTODOS? ═══\n");

        /*
         * ✓ USAR referencia cuando la lambda solo llama a un método:
         *   s -> s.toUpperCase()      →  String::toUpperCase    ✓
         *   s -> System.out.println(s) → System.out::println    ✓
         *   s -> Integer.parseInt(s)  →  Integer::parseInt      ✓
         *
         * ✗ NO USAR cuando hay lógica adicional:
         *   s -> s.toUpperCase() + "!"     ← lógica extra, no se puede
         *   n -> n > 0 ? n : -n            ← condicional, no se puede
         *   s -> { log(s); process(s); }   ← múltiples operaciones
         */

        System.out.println("✓ Usar cuando la lambda SOLO llama a un método existente");
        System.out.println("✗ No usar cuando hay lógica adicional en la lambda");

        // Ejemplo de cuándo NO se puede usar referencia:
        Function<String, String> conLogica = s -> s.toUpperCase() + "!";
        // NO se puede convertir a referencia porque hay concatenación extra
        System.out.println("\nCon lógica extra (solo lambda): " + conLogica.apply("hola"));

        // ─────────────────────────────────────────────
        // 7. EJEMPLO INTEGRADOR
        // ─────────────────────────────────────────────
        System.out.println("\n═══ 7. EJEMPLO INTEGRADOR ═══\n");

        List<String> datos = Arrays.asList("  Java  ", "  python  ", "", "  C++  ", "  ", "  Rust  ");

        System.out.println("Datos originales: " + datos);

        // Pipeline usando referencias a métodos donde sea posible
        List<String> procesados = datos.stream()
                .map(String::trim)                    // Referencia instancia arbitraria
                .filter(Predicate.not(String::isEmpty)) // Referencia instancia arbitraria
                .map(String::toUpperCase)             // Referencia instancia arbitraria
                .sorted(String::compareTo)            // Referencia instancia arbitraria
                .collect(Collectors.toList());

        System.out.println("Procesados: " + procesados);

        // Imprimir cada uno
        System.out.println("\nImpresión con referencia:");
        procesados.forEach(System.out::println);  // Referencia instancia particular

        // ─────────────────────────────────────────────
        // TABLA RESUMEN
        // ─────────────────────────────────────────────
        System.out.println("\n╔══════════════════════════════════════════════════════════════════════╗");
        System.out.println("║          TABLA RESUMEN — REFERENCIAS A MÉTODOS                     ║");
        System.out.println("╠══════════════════════════╦════════════════════╦═════════════════════╣");
        System.out.println("║ Tipo                     ║ Sintaxis           ║ Lambda equivalente  ║");
        System.out.println("╠══════════════════════════╬════════════════════╬═════════════════════╣");
        System.out.println("║ Método estático          ║ Clase::metodo      ║ x -> Clase.metodo(x)║");
        System.out.println("║ Instancia particular     ║ obj::metodo        ║ x -> obj.metodo(x)  ║");
        System.out.println("║ Instancia arbitraria     ║ Clase::metodo      ║ x -> x.metodo()     ║");
        System.out.println("║ Constructor              ║ Clase::new         ║ x -> new Clase(x)   ║");
        System.out.println("╚══════════════════════════╩════════════════════╩═════════════════════╝");
    }

    // ─────────────────────────────────────────────
    // MÉTODOS Y CLASES AUXILIARES
    // ─────────────────────────────────────────────

    /**
     * Verifica si una edad corresponde a un mayor de edad (>= 18).
     *
     * @param edad la edad a verificar
     * @return true si la edad es 18 o mayor
     */
    public static boolean esMayorDeEdad(int edad) {
        return edad >= 18;
    }

    /**
     * Clase auxiliar para demostrar referencia a método de instancia particular.
     */
    static class Formateador {
        private String decorador;

        /**
         * Crea un formateador con el decorador especificado.
         *
         * @param decorador el texto decorador a usar
         */
        public Formateador(String decorador) {
            this.decorador = decorador;
        }

        /**
         * Formatea el texto rodeándolo con el decorador.
         *
         * @param texto el texto a formatear
         * @return el texto formateado con decoradores
         */
        public String formatear(String texto) {
            return decorador + " " + texto.toUpperCase() + " " + decorador;
        }
    }

    /**
     * Clase auxiliar para demostrar referencia a constructores.
     */
    static class Producto {
        private String nombre;
        private double precio;

        /**
         * Crea un producto solo con nombre (precio por defecto 0).
         *
         * @param nombre el nombre del producto
         */
        public Producto(String nombre) {
            this.nombre = nombre;
            this.precio = 0.0;
        }

        /**
         * Crea un producto con nombre y precio.
         *
         * @param nombre el nombre del producto
         * @param precio el precio del producto
         */
        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        /**
         * Representación en texto del producto.
         *
         * @return cadena con nombre y precio del producto
         */
        @Override
        public String toString() {
            return precio > 0
                    ? nombre + "($" + String.format("%.2f", precio) + ")"
                    : nombre;
        }
    }
}
