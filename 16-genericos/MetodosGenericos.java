/**
 * ============================================================
 *  TEMA: Genéricos en Java
 *  SECCIÓN: 16 — Genéricos
 *  ARCHIVO: MetodosGenericos.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás a crear métodos genéricos que funcionan con cualquier
 *  tipo de dato. Verás cómo usar tipos acotados (bounded types) con
 *  "extends" para restringir los tipos aceptados, y cómo utilizar
 *  el comodín "?" (wildcard) para mayor flexibilidad al recibir
 *  parámetros genéricos.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Método genérico: método que declara su propio parámetro de tipo
 *    independiente de la clase
 *  - Tipo acotado (bounded type): restringe T a un tipo o sus
 *    subclases usando <T extends Tipo>
 *  - Comodín (?): representa un tipo desconocido, útil en parámetros
 *    de métodos
 *  - Comodín acotado superior (? extends Tipo): acepta Tipo y
 *    subclases
 *  - Comodín acotado inferior (? super Tipo): acepta Tipo y
 *    superclases
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  // Método genérico:
 *  public static <T> void metodo(T parametro) { ... }
 *
 *  // Tipo acotado:
 *  public static <T extends Number> double sumar(T a, T b) { ... }
 *
 *  // Comodín:
 *  public static void imprimir(List<?> lista) { ... }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Confundir <T> con <?>: T se puede referenciar dentro del
 *    método, ? no
 *  - Olvidar declarar <T> antes del tipo de retorno en métodos
 *    genéricos
 *  - Intentar añadir elementos a una List<?> (solo se puede leer)
 *  - Usar extends cuando se necesita super y viceversa
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial:
 *    https://docs.oracle.com/javase/tutorial/java/generics/methods.html
 * ============================================================
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MetodosGenericos {

    // ========================================================
    //  MÉTODOS GENÉRICOS BÁSICOS
    // ========================================================

    /**
     * Método genérico que imprime cualquier elemento con su tipo.
     * El parámetro de tipo <T> se declara ANTES del tipo de retorno.
     *
     * @param <T>      el tipo del elemento
     * @param elemento el elemento a imprimir
     */
    public static <T> void imprimirConTipo(T elemento) {
        System.out.println("Valor: " + elemento
                + " | Tipo: " + elemento.getClass().getSimpleName());
    }

    /**
     * Método genérico que intercambia dos posiciones en un arreglo.
     *
     * @param <T>     el tipo de los elementos del arreglo
     * @param arreglo el arreglo donde se hará el intercambio
     * @param i       índice de la primera posición
     * @param j       índice de la segunda posición
     */
    public static <T> void intercambiar(T[] arreglo, int i, int j) {
        T temporal = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temporal;
    }

    /**
     * Método genérico que cuenta cuántas veces aparece un elemento
     * en un arreglo. Funciona con cualquier tipo que tenga equals().
     *
     * @param <T>      el tipo de los elementos
     * @param arreglo  el arreglo donde buscar
     * @param objetivo el elemento a contar
     * @return la cantidad de apariciones del elemento
     */
    public static <T> int contarOcurrencias(T[] arreglo, T objetivo) {
        int contador = 0;
        for (T elemento : arreglo) {
            if (elemento.equals(objetivo)) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Método genérico que devuelve el primer elemento no nulo
     * de un arreglo, o null si todos son nulos.
     *
     * @param <T>     el tipo de los elementos
     * @param arreglo el arreglo donde buscar
     * @return el primer elemento no nulo, o null
     */
    public static <T> T primerNoNulo(T[] arreglo) {
        for (T elemento : arreglo) {
            if (elemento != null) {
                return elemento;
            }
        }
        return null;
    }

    // ========================================================
    //  TIPOS ACOTADOS (BOUNDED TYPES) CON extends
    // ========================================================

    /**
     * Método genérico con tipo acotado: T DEBE ser Number o subclase.
     * Esto permite usar métodos de Number como doubleValue().
     *
     * @param <T> el tipo numérico (Integer, Double, Float, etc.)
     * @param a   primer número
     * @param b   segundo número
     * @return la suma de ambos números como double
     */
    public static <T extends Number> double sumar(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    /**
     * Encuentra el máximo entre tres valores comparables.
     * T extends Comparable<T> asegura que T implementa compareTo().
     *
     * @param <T> el tipo comparable
     * @param a   primer valor
     * @param b   segundo valor
     * @param c   tercer valor
     * @return el valor máximo de los tres
     */
    public static <T extends Comparable<T>> T maximo(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }

    /**
     * Calcula el promedio de una lista de números.
     * Usa tipo acotado para aceptar cualquier tipo numérico.
     *
     * @param <T>     el tipo numérico
     * @param numeros la lista de números
     * @return el promedio como double
     */
    public static <T extends Number> double promedio(List<T> numeros) {
        if (numeros.isEmpty()) {
            return 0.0;
        }
        double suma = 0.0;
        for (T numero : numeros) {
            suma += numero.doubleValue();
        }
        return suma / numeros.size();
    }

    // ========================================================
    //  COMODINES (WILDCARDS) CON ?
    // ========================================================

    /**
     * Imprime los elementos de cualquier lista usando comodín (?).
     * Con ? no sabemos el tipo exacto, pero podemos leer elementos
     * como Object.
     *
     * @param lista la lista a imprimir (de cualquier tipo)
     */
    public static void imprimirLista(List<?> lista) {
        System.out.print("  [");
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.get(i));
            if (i < lista.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Suma los elementos de una lista de números usando comodín
     * acotado superior (? extends Number).
     * Acepta List<Integer>, List<Double>, List<Float>, etc.
     *
     * @param numeros la lista de números (cualquier subtipo de Number)
     * @return la suma total como double
     */
    public static double sumarLista(List<? extends Number> numeros) {
        double suma = 0.0;
        for (Number numero : numeros) {
            suma += numero.doubleValue();
        }
        return suma;
    }

    /**
     * Agrega un Integer a una lista que acepta Integer o sus
     * superclases usando comodín acotado inferior (? super Integer).
     * Acepta List<Integer>, List<Number>, List<Object>.
     *
     * @param lista  la lista donde agregar
     * @param numero el número a agregar
     */
    public static void agregarNumero(List<? super Integer> lista, Integer numero) {
        lista.add(numero);
        System.out.println("  Se agregó " + numero + " a la lista");
    }

    // ========================================================
    //  MÚLTIPLES TIPOS ACOTADOS
    // ========================================================

    /**
     * Método con múltiples restricciones: T debe ser Number Y
     * también implementar Comparable.
     * Se usa & para combinar restricciones.
     *
     * @param <T>     el tipo que es Number y Comparable
     * @param numeros la lista de números comparables
     * @return el número mínimo de la lista
     */
    public static <T extends Number & Comparable<T>> T minimo(List<T> numeros) {
        if (numeros.isEmpty()) {
            throw new IllegalArgumentException("La lista no puede estar vacía");
        }
        T min = numeros.get(0);
        for (T numero : numeros) {
            if (numero.compareTo(min) < 0) {
                min = numero;
            }
        }
        return min;
    }

    // ========================================================
    //  MÉTODO PRINCIPAL: demostración
    // ========================================================

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║     MÉTODOS GENÉRICOS EN JAVA            ║");
        System.out.println("╚══════════════════════════════════════════╝\n");

        // ---- EJEMPLO 1: Método genérico básico ----
        System.out.println("── EJEMPLO 1: Método genérico imprimirConTipo() ──");
        imprimirConTipo("Hola");         // T = String
        imprimirConTipo(42);             // T = Integer
        imprimirConTipo(3.14);           // T = Double
        imprimirConTipo(true);           // T = Boolean
        imprimirConTipo('A');            // T = Character
        System.out.println();

        // ---- EJEMPLO 2: Intercambiar elementos ----
        System.out.println("── EJEMPLO 2: Intercambiar elementos en arreglo ──");
        String[] nombres = {"Ana", "Luis", "María"};
        System.out.println("Antes:   " + Arrays.toString(nombres));
        intercambiar(nombres, 0, 2);
        System.out.println("Después: " + Arrays.toString(nombres));
        System.out.println();

        // ---- EJEMPLO 3: Contar ocurrencias ----
        System.out.println("── EJEMPLO 3: Contar ocurrencias ──");
        Integer[] numeros = {1, 3, 5, 3, 7, 3, 9};
        int veces = contarOcurrencias(numeros, 3);
        System.out.println("El 3 aparece " + veces + " veces en "
                + Arrays.toString(numeros));
        System.out.println();

        // ---- EJEMPLO 4: Primer no nulo ----
        System.out.println("── EJEMPLO 4: Primer elemento no nulo ──");
        String[] conNulos = {null, null, "¡Encontrado!", "Otro"};
        String resultado = primerNoNulo(conNulos);
        System.out.println("Primer no nulo: " + resultado);
        System.out.println();

        // ---- EJEMPLO 5: Tipos acotados con Number ----
        System.out.println("── EJEMPLO 5: Tipos acotados (extends Number) ──");
        System.out.println("sumar(10, 20)     = " + sumar(10, 20));
        System.out.println("sumar(3.5, 2.1)   = " + sumar(3.5, 2.1));
        System.out.println("sumar(10, 3.14)   = " + sumar(10, 3.14));
        // sumar("Hola", "Mundo"); // ✗ NO compila: String no es Number
        System.out.println();

        // ---- EJEMPLO 6: Máximo con Comparable ----
        System.out.println("── EJEMPLO 6: Máximo con Comparable ──");
        System.out.println("Máximo de 3, 7, 5: " + maximo(3, 7, 5));
        System.out.println("Máximo de 'a', 'z', 'm': " + maximo('a', 'z', 'm'));
        System.out.println("Máximo de \"Ana\", \"Zoe\", \"Luis\": "
                + maximo("Ana", "Zoe", "Luis"));
        System.out.println();

        // ---- EJEMPLO 7: Promedio con tipo acotado ----
        System.out.println("── EJEMPLO 7: Promedio de lista numérica ──");
        List<Integer> enteros = Arrays.asList(10, 20, 30, 40, 50);
        List<Double> decimales = Arrays.asList(1.5, 2.5, 3.5);
        System.out.println("Promedio enteros:  " + promedio(enteros));
        System.out.println("Promedio decimales: " + promedio(decimales));
        System.out.println();

        // ---- EJEMPLO 8: Comodín (?) sin acotar ----
        System.out.println("── EJEMPLO 8: Comodín (?) - imprimir cualquier lista ──");
        List<String> listaTextos = Arrays.asList("Java", "Python", "C++");
        List<Integer> listaEnteros = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> listaDobles = Arrays.asList(1.1, 2.2, 3.3);

        System.out.println("Lista de textos:");
        imprimirLista(listaTextos);
        System.out.println("Lista de enteros:");
        imprimirLista(listaEnteros);
        System.out.println("Lista de doubles:");
        imprimirLista(listaDobles);
        System.out.println();

        // ---- EJEMPLO 9: Comodín acotado superior (? extends) ----
        System.out.println("── EJEMPLO 9: ? extends Number (lectura) ──");
        System.out.println("Suma de enteros: " + sumarLista(listaEnteros));
        System.out.println("Suma de doubles: " + sumarLista(listaDobles));
        // Ambas listas funcionan porque Integer y Double extienden Number
        System.out.println();

        // ---- EJEMPLO 10: Comodín acotado inferior (? super) ----
        System.out.println("── EJEMPLO 10: ? super Integer (escritura) ──");
        List<Number> listaNumber = new ArrayList<>();
        agregarNumero(listaNumber, 10);
        agregarNumero(listaNumber, 20);
        System.out.println("Lista resultante: " + listaNumber);
        System.out.println();

        // ---- EJEMPLO 11: Múltiples restricciones ----
        System.out.println("── EJEMPLO 11: Múltiples restricciones ──");
        List<Integer> numerosParaMin = Arrays.asList(15, 3, 8, 1, 22);
        System.out.println("Mínimo de " + numerosParaMin + ": " + minimo(numerosParaMin));
        System.out.println();

        // ---- RESUMEN: Diferencia entre T, ?, ? extends, ? super ----
        System.out.println("── RESUMEN DE COMODINES ──");
        System.out.println("┌──────────────────────┬──────────────────────────────────┐");
        System.out.println("│ Sintaxis             │ Significado                      │");
        System.out.println("├──────────────────────┼──────────────────────────────────┤");
        System.out.println("│ <T>                  │ Tipo concreto, reutilizable      │");
        System.out.println("│ <?>                  │ Tipo desconocido (solo lectura)  │");
        System.out.println("│ <? extends Tipo>     │ Tipo o subclases (productor)     │");
        System.out.println("│ <? super Tipo>       │ Tipo o superclases (consumidor)  │");
        System.out.println("│ <T extends A & B>    │ T debe cumplir A y B             │");
        System.out.println("└──────────────────────┴──────────────────────────────────┘");
        System.out.println();

        System.out.println("💡 Regla PECS (Producer Extends, Consumer Super):");
        System.out.println("   - Si LEES de una estructura → usa ? extends");
        System.out.println("   - Si ESCRIBES en una estructura → usa ? super");
    }
}
