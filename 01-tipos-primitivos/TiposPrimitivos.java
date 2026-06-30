/**
 * ============================================================
 *  TEMA: Tipos Primitivos en Java
 *  SECCIÓN: 01 — Tipos Primitivos, Casting y Wrappers
 *  ARCHIVO: TiposPrimitivos.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Java tiene 8 tipos primitivos, y esta es probablemente la lección más
 *  importante del curso. Aprenderás cada uno: su tamaño en bits, rango de
 *  valores, sufijos necesarios para literales long/float, y qué pasa cuando
 *  intentas asignar un valor fuera de rango. Los primitivos NO son objetos:
 *  viven en el stack, no tienen métodos, y son la base de todo en Java.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Enteros: byte (8 bits), short (16), int (32), long (64, sufijo L).
 *  - Decimales: float (32, sufijo f), double (64, el más usado).
 *  - Carácter: char (16 bits, Unicode). Usa comillas simples 'A'.
 *  - Booleano: boolean (true/false). NO es 0/1 como en C.
 *  - Literales: 100 (int), 100L (long), 3.14 (double), 3.14f (float).
 *  - Overflow: si superas el rango, el valor "da la vuelta".
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  int edad = 25;
 *  long poblacionMundial = 8_000_000_000L;
 *  double precio = 99.99;
 *  float temperatura = 36.5f;
 *  char letra = 'A';
 *  boolean activo = true;
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar el sufijo L en long grandes: 8_000_000_000 es error.
 *  - Escribir float sin f: float f = 3.14; // error, 3.14 es double.
 *  - Usar double para dinero: pierdes precisión. Mejor BigDecimal.
 *  - Asignar int a byte sin casting cuando el valor es > 127.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
 * ============================================================
 */
public class TiposPrimitivos {

    public static void main(String[] args) {
        System.out.println("=== Los 8 Tipos Primitivos de Java ===");
        System.out.println();

        // --- ENTEROS ---
        System.out.println("--- Enteros ---");

        byte edad = 25;
        System.out.println("byte:  edad = " + edad
                + " | Tamaño: 8 bits | Rango: [-128 a 127]");

        short anio = 2026;
        System.out.println("short: anio = " + anio
                + " | Tamaño: 16 bits | Rango: [-32768 a 32767]");

        int poblacion = 2_147_483_647;
        System.out.println("int:   poblacion = " + poblacion
                + " | Tamaño: 32 bits | Rango: [-2.1M a 2.1M]");

        long estrellas = 9_223_372_036_854_775_807L;
        System.out.println("long:  estrellas = " + estrellas
                + " | Tamaño: 64 bits | Sufijo: L");

        System.out.println();

        // --- DECIMALES ---
        System.out.println("--- Decimales ---");

        float piCorto = 3.1415927f;
        System.out.println("float:  piCorto = " + piCorto
                + " | Tamaño: 32 bits | Sufijo: f | Precisión: ~7 dígitos");

        double piLargo = 3.141592653589793;
        System.out.println("double: piLargo = " + piLargo
                + " | Tamaño: 64 bits | Precisión: ~15 dígitos | Es el DEFAULT");

        // Diferencia de precisión entre float y double
        float tercioFloat = 1.0f / 3.0f;
        double tercioDouble = 1.0 / 3.0;
        System.out.println();
        System.out.println("1/3 en float:  " + tercioFloat);
        System.out.println("1/3 en double: " + tercioDouble);
        System.out.println("(double tiene más dígitos de precisión)");

        System.out.println();

        // --- CARACTER ---
        System.out.println("--- Carácter ---");

        char inicial = 'S';
        char digito = '7';
        char simbolo = '@';
        System.out.println("char: inicial = " + inicial
                + " | Tamaño: 16 bits | Unicode (soporta ñ, 漢字, emojis)");
        System.out.println("char: digito  = " + digito + " (NO es el número 7)");
        System.out.println("char: simbolo = " + simbolo);

        // Valor numérico Unicode de un char
        char letraA = 'A';
        System.out.println("'A' como int (Unicode): " + (int) letraA);

        System.out.println();

        // --- BOOLEANO ---
        System.out.println("--- Booleano ---");

        boolean esJavaDivertido = true;
        boolean esJavaDificil = false;
        System.out.println("boolean: esJavaDivertido = " + esJavaDivertido);
        System.out.println("boolean: esJavaDificil = " + esJavaDificil);
        System.out.println("(En Java, boolean NO es 0/1. Solo true o false)");

        System.out.println();

        // --- OVERFLOW ---
        System.out.println("--- Demostración de Overflow ---");

        int maximoInt = Integer.MAX_VALUE;
        System.out.println("Valor máximo de int: " + maximoInt);
        System.out.println("Máximo + 1: " + (maximoInt + 1) + " (overflow: da la vuelta al mínimo)");

        byte maximoByte = Byte.MAX_VALUE;
        System.out.println("Valor máximo de byte: " + maximoByte);
        System.out.println("Máximo + 1: " + (byte)(maximoByte + 1) + " (overflow en byte)");
    }
}
