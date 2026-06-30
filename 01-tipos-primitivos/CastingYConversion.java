/**
 * ============================================================
 *  TEMA: Casting y Conversión de Tipos en Java
 *  SECCIÓN: 01 — Tipos Primitivos, Casting y Wrappers
 *  ARCHIVO: CastingYConversion.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  En Java no puedes simplemente asignar un double a un int sin más. El
 *  CASTING es el mecanismo para convertir entre tipos, y se divide en dos
 *  categorías: widening (implícito, seguro) y narrowing (explícito, puede
 *  perder datos). Aprenderás cuándo Java hace la conversión automáticamente
 *  y cuándo te obliga a ser explícito. También verás cómo convertir Strings
 *  a números con Integer.parseInt() y viceversa con String.valueOf().
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Widening (ampliación): byte → short → int → long → float → double.
 *    Es automático porque no hay pérdida de datos.
 *  - Narrowing (estrechamiento): requiere casting explícito con (tipo).
 *    Puede perder precisión o causar overflow.
 *  - Promoción aritmética: en operaciones, byte/short se promueven a int.
 *  - Parseo: Integer.parseInt(), Double.parseDouble() convierten String → número.
 *  - String.valueOf() convierte cualquier tipo a String.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  double d = 9.78;
 *  int i = (int) d;         // 9 (pierde los decimales)
 *  int numero = Integer.parseInt("42");  // String → int
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Dividir enteros y esperar decimales: 5 / 2 = 2, no 2.5.
 *  - NumberFormatException al parsear strings con espacios o letras.
 *  - Casting de double a int trunca, NO redondea: (int) 9.9 = 9.
 *  - Asignar un literal grande a un tipo pequeño sin casting.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/specs/jls/se17/html/jls-5.html
 * ============================================================
 */
public class CastingYConversion {

    public static void main(String[] args) {
        System.out.println("=== Casting y Conversión de Tipos ===");
        System.out.println();

        // --- WIDENING (Implícito) ---
        System.out.println("--- 1. Widening (Ampliación - Automático) ---");

        byte b = 50;
        short s = b;       // byte → short: automático
        int i = s;         // short → int: automático
        long l = i;        // int → long: automático
        float f = l;       // long → float: automático
        double d = f;      // float → double: automático

        System.out.println("byte → short → int → long → float → double");
        System.out.println("byte " + b + " → double " + d + " (sin pérdida)");
        System.out.println();

        // --- NARROWING (Explícito) ---
        System.out.println("--- 2. Narrowing (Estrechamiento - Manual) ---");

        double pi = 3.141592653589793;
        System.out.println("double original: " + pi);

        float piFloat = (float) pi;
        System.out.println("(float) pi:       " + piFloat + " (pierde precisión)");

        long piLong = (long) pi;
        System.out.println("(long) pi:        " + piLong + " (pierde decimales)");

        int piInt = (int) pi;
        System.out.println("(int) pi:         " + piInt + " (trunca, NO redondea)");

        byte piByte = (byte) pi;
        System.out.println("(byte) pi:        " + piByte + " (solo queda el byte bajo)");
        System.out.println();

        // --- PÉRDIDA DE DATOS ---
        System.out.println("--- 3. Pérdida de Datos ---");

        int grande = 300;
        byte pequeno = (byte) grande;
        System.out.println("int 300 → byte: " + pequeno + " (overflow: 300 - 256 = 44)");
        System.out.println();

        // --- PROMOCIÓN ARITMÉTICA ---
        System.out.println("--- 4. Promoción Aritmética ---");

        byte a = 10;
        byte c = 20;
        // byte suma = a + c;  // ERROR: a + c se promueve a int
        int suma = a + c;      // Correcto: el resultado es int
        System.out.println("byte + byte = int: " + a + " + " + c + " = " + suma);

        int x = 5;
        int y = 2;
        double division = (double) x / y;  // Convierte UNO de los operandos
        System.out.println("5 / 2 (int/int)   = " + (x / y) + "  (división entera, truncada)");
        System.out.println("5 / 2 (double/int) = " + division + "  (casting de un operando)");
        System.out.println();

        // --- CONVERSIÓN STRING ↔ NÚMERO ---
        System.out.println("--- 5. Conversión String ↔ Número ---");

        // String → número (parseo)
        String textoEdad = "25";
        String textoPrecio = "99.99";
        String textoVerdad = "true";

        int edad = Integer.parseInt(textoEdad);
        double precio = Double.parseDouble(textoPrecio);
        boolean verdad = Boolean.parseBoolean(textoVerdad);

        System.out.println("\"" + textoEdad + "\" → int: " + edad);
        System.out.println("\"" + textoPrecio + "\" → double: " + precio);
        System.out.println("\"" + textoVerdad + "\" → boolean: " + verdad);

        // Número → String
        String desdeInt = String.valueOf(42);
        String desdeDouble = String.valueOf(3.14);
        String desdeBoolean = String.valueOf(true);
        String concatenado = "" + 42;  // Alternativa más corta

        System.out.println("String.valueOf(42): " + desdeInt);
        System.out.println("\"\" + 42: " + concatenado + " (alternativa concisa)");
    }
}
