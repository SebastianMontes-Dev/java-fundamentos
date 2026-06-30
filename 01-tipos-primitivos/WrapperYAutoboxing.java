/**
 * ============================================================
 *  TEMA: Clases Envolventes (Wrappers) y Autoboxing
 *  SECCIÓN: 01 — Tipos Primitivos, Casting y Wrappers
 *  ARCHIVO: WrapperYAutoboxing.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Los primitivos son rápidos, pero no son objetos. Las CLASES ENVOLVENTES
 *  (wrappers) resuelven esto: Integer envuelve a int, Double a double, etc.
 *  Aprenderás a crear wrappers, convertir entre primitivo y objeto (autoboxing
 *  y unboxing), y a usar los métodos utilitarios que viven en estas clases:
 *  parseInt, valueOf, compare, MAX_VALUE, MIN_VALUE, y más.
 *
 *  El autoboxing es la magia que te permite escribir `Integer x = 5` sin
 *  quejarte. Java automáticamente "envuelve" el int en un Integer y lo
 *  "desenvuelve" cuando necesitas el primitivo. Pero hay trampas: los
 *  wrappers pueden ser null, y compararlos con == puede fallar.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Cada primitivo tiene su wrapper: int→Integer, double→Double, etc.
 *  - Autoboxing: conversión automática primitivo → wrapper.
 *  - Unboxing: conversión automática wrapper → primitivo.
 *  - parseInt / parseDouble: convierten String a primitivo.
 *  - valueOf: convierten a wrapper (usa caché para -128 a 127 en Integer).
 *  - Wrappers pueden ser null (los primitivos no).
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  Integer edad = 25;                    // autoboxing
 *  int valor = edad;                     // unboxing
 *  int numero = Integer.parseInt("42");  // String → int
 *  Integer obj = Integer.valueOf(42);    // int → Integer (con caché)
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Comparar wrappers con == en vez de .equals().
 *  - NullPointerException al hacer unboxing de un wrapper null.
 *  - Usar wrappers en bucles intensivos (el boxing/unboxing cuesta).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html
 * ============================================================
 */
public class WrapperYAutoboxing {

    public static void main(String[] args) {
        System.out.println("=== Wrappers y Autoboxing/Unboxing ===");
        System.out.println();

        // --- TABLA DE WRAPPERS ---
        System.out.println("--- Clases Envolventes (Wrappers) ---");
        System.out.println("Primitivo   →   Wrapper");
        System.out.println("byte        →   Byte");
        System.out.println("short       →   Short");
        System.out.println("int         →   Integer");
        System.out.println("long        →   Long");
        System.out.println("float       →   Float");
        System.out.println("double      →   Double");
        System.out.println("char        →   Character");
        System.out.println("boolean     →   Boolean");
        System.out.println();

        // --- AUTOBOXING ---
        System.out.println("--- Autoboxing (primitivo → wrapper) ---");

        Integer edad = 25;                  // Java envuelve 25 en Integer
        Double precio = 99.99;              // Java envuelve 99.99 en Double
        Character inicial = 'S';            // Java envuelve 'S' en Character
        Boolean activo = true;              // Java envuelve true en Boolean

        System.out.println("Integer edad = " + edad + "  (autoboxing de int)");
        System.out.println("Double precio = " + precio + "  (autoboxing de double)");
        System.out.println("Character inicial = " + inicial + "  (autoboxing de char)");
        System.out.println("Boolean activo = " + activo + "  (autoboxing de boolean)");
        System.out.println();

        // --- UNBOXING ---
        System.out.println("--- Unboxing (wrapper → primitivo) ---");

        int edadPrimitiva = edad;           // Java desenvuelve Integer → int
        double precioPrimitivo = precio;    // Java desenvuelve Double → double

        System.out.println("int edadPrimitiva = " + edadPrimitiva + "  (unboxing)");
        System.out.println("double precioPrimitivo = " + precioPrimitivo + "  (unboxing)");
        System.out.println("Suma con wrappers: " + (edad + 10) + "  (unboxing automático en operaciones)");
        System.out.println();

        // --- MÉTODOS ÚTILES DE LOS WRAPPERS ---
        System.out.println("--- Métodos Estáticos Útiles ---");

        // Parseo de String a primitivo
        int numero = Integer.parseInt("42");
        double decimal = Double.parseDouble("3.14");
        boolean flag = Boolean.parseBoolean("true");

        System.out.println("Integer.parseInt(\"42\") = " + numero);
        System.out.println("Double.parseDouble(\"3.14\") = " + decimal);
        System.out.println("Boolean.parseBoolean(\"true\") = " + flag);

        // Constantes
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE);

        // Métodos de Character
        System.out.println("Character.isDigit('7') = " + Character.isDigit('7'));
        System.out.println("Character.isLetter('A') = " + Character.isLetter('A'));
        System.out.println("Character.isWhitespace(' ') = " + Character.isWhitespace(' '));
        System.out.println("Character.toUpperCase('a') = " + Character.toUpperCase('a'));
        System.out.println();

        // --- CACHÉ DE INTEGER ---
        System.out.println("--- Caché de Integer (¡importante!) ---");

        Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;

        System.out.println("100 == 100: " + (a == b) + "  ← mismo objeto (caché -128 a 127)");
        System.out.println("200 == 200: " + (c == d) + "  ← objetos distintos (fuera del caché)");
        System.out.println("Regla: usa .equals() para comparar wrappers, nunca ==");
        System.out.println("200.equals(200): " + c.equals(d));
        System.out.println();

        // --- PELIGRO: WRAPPER NULL ---
        System.out.println("--- Peligro: Wrapper null ---");

        Integer nulo = null;
        // int valor = nulo;  // NullPointerException! Unboxing de null
        System.out.println("Integer nulo = null; // ¡cuidado al hacer unboxing!");
    }
}
