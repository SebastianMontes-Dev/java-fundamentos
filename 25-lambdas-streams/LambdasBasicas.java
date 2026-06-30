/**
 * ============================================================
 *  TEMA: Expresiones Lambda y Streams
 *  SECCIÓN: 25 — Lambdas y Streams
 *  ARCHIVO: LambdasBasicas.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás qué son las expresiones lambda en Java y cómo
 *  simplifican el código al reemplazar clases anónimas. Verás
 *  la sintaxis básica, cómo usar interfaces funcionales como
 *  Runnable y Comparator, y compararás el estilo tradicional
 *  con el estilo moderno usando lambdas.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Expresión lambda: función anónima con sintaxis reducida
 *  - Interfaz funcional: interfaz con un solo método abstracto
 *  - @FunctionalInterface: anotación que marca una interfaz funcional
 *  - Interfaces funcionales del JDK: Runnable, Comparator,
 *    Predicate, Function, Consumer, Supplier
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *      // Sin parámetros
 *      () -> System.out.println("Hola");
 *
 *      // Un parámetro (paréntesis opcionales)
 *      x -> x * 2
 *      (x) -> x * 2
 *
 *      // Múltiples parámetros
 *      (a, b) -> a + b
 *
 *      // Cuerpo con varias líneas
 *      (a, b) -> {
 *          int suma = a + b;
 *          return suma;
 *      }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar lambdas con interfaces que tienen más de un método abstracto
 *  - Olvidar el return en lambdas con cuerpo de varias líneas
 *  - Intentar modificar variables locales no finales desde una lambda
 *  - Confundir la sintaxis: (int a, b) -> ... (ambos deben tener tipo o ninguno)
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 *  - java.util.function: https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
 * ============================================================
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdasBasicas {

    // =====================================================
    // 1. INTERFAZ FUNCIONAL PERSONALIZADA
    // =====================================================

    /**
     * Interfaz funcional personalizada que realiza una operación
     * matemática entre dos números.
     */
    @FunctionalInterface
    interface OperacionMatematica {
        /**
         * Ejecuta una operación entre dos números.
         * @param a primer operando
         * @param b segundo operando
         * @return resultado de la operación
         */
        double ejecutar(double a, double b);
    }

    /**
     * Interfaz funcional para saludar a una persona.
     */
    @FunctionalInterface
    interface Saludo {
        /**
         * Genera un mensaje de saludo.
         * @param nombre nombre de la persona
         * @return mensaje de saludo
         */
        String saludar(String nombre);
    }

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║     EXPRESIONES LAMBDA - CONCEPTOS BÁSICOS      ║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");

        // -------------------------------------------------
        // EJEMPLO 1: ANTES vs DESPUÉS — Runnable
        // -------------------------------------------------
        System.out.println("━━━ 1. ANTES vs DESPUÉS: Runnable ━━━\n");

        // ❌ ANTES: Clase anónima (verbosa)
        System.out.println("  ── Estilo tradicional (clase anónima):");
        Runnable tareaAntigua = new Runnable() {
            @Override
            public void run() {
                System.out.println("     → Ejecutando tarea con clase anónima");
            }
        };
        tareaAntigua.run();

        // ✅ DESPUÉS: Lambda (concisa)
        System.out.println("  ── Estilo moderno (lambda):");
        Runnable tareaModerna = () -> System.out.println("     → Ejecutando tarea con lambda");
        tareaModerna.run();

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 2: ANTES vs DESPUÉS — Comparator
        // -------------------------------------------------
        System.out.println("━━━ 2. ANTES vs DESPUÉS: Comparator ━━━\n");

        List<String> frutas = new ArrayList<>(Arrays.asList(
            "Manzana", "Cereza", "Banana", "Durazno", "Arándano"
        ));

        // ❌ ANTES: Comparator con clase anónima
        System.out.println("  ── Ordenar con clase anónima:");
        List<String> frutasCopia1 = new ArrayList<>(frutas);
        Collections.sort(frutasCopia1, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        System.out.println("     " + frutasCopia1);

        // ✅ DESPUÉS: Comparator con lambda
        System.out.println("  ── Ordenar con lambda:");
        List<String> frutasCopia2 = new ArrayList<>(frutas);
        Collections.sort(frutasCopia2, (a, b) -> a.compareTo(b));
        System.out.println("     " + frutasCopia2);

        // ✅✅ AÚN MÁS SIMPLE: Referencia a método
        System.out.println("  ── Ordenar con referencia a método:");
        List<String> frutasCopia3 = new ArrayList<>(frutas);
        frutasCopia3.sort(String::compareTo);
        System.out.println("     " + frutasCopia3);

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 3: SINTAXIS DE LAMBDAS
        // -------------------------------------------------
        System.out.println("━━━ 3. VARIANTES DE SINTAXIS LAMBDA ━━━\n");

        // Sin parámetros
        Runnable sinParametros = () -> System.out.println("     → Lambda sin parámetros");
        sinParametros.run();

        // Un parámetro (paréntesis opcionales)
        Saludo unParametro = nombre -> "¡Hola, " + nombre + "!";
        System.out.println("     → Un parámetro: " + unParametro.saludar("María"));

        // Múltiples parámetros
        OperacionMatematica suma = (a, b) -> a + b;
        System.out.println("     → Dos parámetros: 5 + 3 = " + suma.ejecutar(5, 3));

        // Cuerpo con múltiples líneas
        OperacionMatematica divisionSegura = (a, b) -> {
            if (b == 0) {
                System.out.println("     ⚠ ¡No se puede dividir entre cero!");
                return 0;
            }
            return a / b;
        };
        System.out.println("     → Multilínea: 10 / 3 = " + divisionSegura.ejecutar(10, 3));
        System.out.print("     → Multilínea: 10 / 0 = ");
        System.out.println(divisionSegura.ejecutar(10, 0));

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 4: INTERFAZ FUNCIONAL PERSONALIZADA
        // -------------------------------------------------
        System.out.println("━━━ 4. INTERFAZ FUNCIONAL PERSONALIZADA ━━━\n");

        OperacionMatematica sumar      = (a, b) -> a + b;
        OperacionMatematica restar     = (a, b) -> a - b;
        OperacionMatematica multiplicar = (a, b) -> a * b;
        OperacionMatematica dividir    = (a, b) -> b != 0 ? a / b : 0;
        OperacionMatematica potencia   = (a, b) -> Math.pow(a, b);

        double x = 12, y = 4;
        System.out.println("     Operaciones con " + x + " y " + y + ":");
        System.out.println("     Suma:           " + ejecutarOperacion(sumar, x, y));
        System.out.println("     Resta:          " + ejecutarOperacion(restar, x, y));
        System.out.println("     Multiplicación: " + ejecutarOperacion(multiplicar, x, y));
        System.out.println("     División:       " + ejecutarOperacion(dividir, x, y));
        System.out.println("     Potencia:       " + ejecutarOperacion(potencia, x, y));

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 5: INTERFACES FUNCIONALES DEL JDK
        // -------------------------------------------------
        System.out.println("━━━ 5. INTERFACES FUNCIONALES DEL JDK ━━━\n");

        // Predicate<T>: recibe T, devuelve boolean
        System.out.println("  ── Predicate<T> (prueba una condición):");
        Predicate<Integer> esPar = n -> n % 2 == 0;
        Predicate<Integer> esPositivo = n -> n > 0;
        System.out.println("     ¿4 es par?      " + esPar.test(4));
        System.out.println("     ¿7 es par?      " + esPar.test(7));
        // Combinación de predicados con and(), or(), negate()
        Predicate<Integer> esParYPositivo = esPar.and(esPositivo);
        System.out.println("     ¿4 es par Y positivo?  " + esParYPositivo.test(4));
        System.out.println("     ¿-2 es par Y positivo? " + esParYPositivo.test(-2));

        System.out.println();

        // Function<T, R>: recibe T, devuelve R
        System.out.println("  ── Function<T, R> (transforma un valor):");
        Function<String, Integer> longitud = s -> s.length();
        Function<String, String> mayusculas = s -> s.toUpperCase();
        System.out.println("     Longitud de 'Lambda': " + longitud.apply("Lambda"));
        System.out.println("     Mayúsculas de 'lambda': " + mayusculas.apply("lambda"));
        // Composición de funciones
        Function<String, String> procesarTexto = mayusculas.andThen(s -> "<<" + s + ">>");
        System.out.println("     Compuesta ('hola'): " + procesarTexto.apply("hola"));

        System.out.println();

        // Consumer<T>: recibe T, no devuelve nada
        System.out.println("  ── Consumer<T> (consume un valor):");
        Consumer<String> imprimir = s -> System.out.println("     → " + s);
        Consumer<String> imprimirGritando = s -> System.out.println("     → ¡¡" + s.toUpperCase() + "!!");
        imprimir.accept("Mensaje normal");
        imprimirGritando.accept("Mensaje con énfasis");

        System.out.println();

        // Supplier<T>: no recibe nada, devuelve T
        System.out.println("  ── Supplier<T> (genera un valor):");
        Supplier<Double> aleatorio = () -> Math.random();
        Supplier<String> saludo = () -> "¡Buenos días!";
        System.out.println("     Número aleatorio: " + aleatorio.get());
        System.out.println("     Saludo: " + saludo.get());

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 6: LAMBDAS CON LISTAS
        // -------------------------------------------------
        System.out.println("━━━ 6. LAMBDAS CON LISTAS ━━━\n");

        List<Integer> numeros = Arrays.asList(15, 3, 42, 7, 28, 11, 36, 1, 50, 23);
        System.out.println("  Lista original: " + numeros);

        // forEach con lambda
        System.out.print("  Cada número × 2: ");
        numeros.forEach(n -> System.out.print(n * 2 + " "));
        System.out.println();

        // removeIf con Predicate
        List<Integer> numerosModificable = new ArrayList<>(numeros);
        numerosModificable.removeIf(n -> n < 10);
        System.out.println("  Solo mayores a 9: " + numerosModificable);

        // sort con Comparator lambda
        List<Integer> numerosOrdenados = new ArrayList<>(numeros);
        numerosOrdenados.sort((a, b) -> b - a); // Orden descendente
        System.out.println("  Orden descendente: " + numerosOrdenados);

        // replaceAll con UnaryOperator
        List<Integer> numerosTransformados = new ArrayList<>(numeros);
        numerosTransformados.replaceAll(n -> n * n); // Elevar al cuadrado
        System.out.println("  Elevados al cuadrado: " + numerosTransformados);

        System.out.println();

        // -------------------------------------------------
        // EJEMPLO 7: VARIABLES EFECTIVAMENTE FINALES
        // -------------------------------------------------
        System.out.println("━━━ 7. VARIABLES EFECTIVAMENTE FINALES ━━━\n");

        String prefijo = "Resultado"; // Efectivamente final (no se modifica)
        OperacionMatematica operacionConPrefijo = (a, b) -> {
            // Podemos LEER 'prefijo' pero NO modificarlo
            System.out.println("     " + prefijo + ": " + (a + b));
            return a + b;
        };
        operacionConPrefijo.ejecutar(10, 20);

        // ❌ Esto NO compilaría:
        // prefijo = "Otro"; // Error: variable usada en lambda debe ser final
        System.out.println("     (Las lambdas solo pueden usar variables locales que no cambien)");

        System.out.println();
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("  RESUMEN:");
        System.out.println("  • Las lambdas simplifican código con interfaces funcionales");
        System.out.println("  • Sintaxis: (parámetros) -> expresión/bloque");
        System.out.println("  • El JDK provee Predicate, Function, Consumer, Supplier");
        System.out.println("  • Las variables capturadas deben ser efectivamente finales");
        System.out.println("═══════════════════════════════════════════════════");
    }

    // =====================================================
    // MÉTODOS AUXILIARES
    // =====================================================

    /**
     * Ejecuta una operación matemática con los valores dados.
     * Demuestra cómo pasar lambdas como parámetros a métodos.
     *
     * @param operacion la operación a ejecutar (lambda o referencia)
     * @param a         primer operando
     * @param b         segundo operando
     * @return resultado de la operación
     */
    public static double ejecutarOperacion(OperacionMatematica operacion, double a, double b) {
        return operacion.ejecutar(a, b);
    }
}
