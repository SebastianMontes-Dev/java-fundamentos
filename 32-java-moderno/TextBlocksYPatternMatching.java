/**
 * ============================================================
 *  TEMA: Text Blocks y Pattern Matching para instanceof
 *  SECCIÓN: 32 — Java Moderno
 *  ARCHIVO: TextBlocksYPatternMatching.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Dos features que limpian código ruidoso en Java moderno:
 *
 *  TEXT BLOCKS (Java 15): Strings multilínea delimitados por """...""".
 *  Adiós a concatenar \n, escapar comillas y lidiar con indentación
 *  manual. Perfectos para SQL, JSON, HTML y cualquier texto multilínea.
 *
 *  PATTERN MATCHING para instanceof (Java 16): En vez de hacer
 *  `if (obj instanceof String) { String s = (String) obj; ... }`,
 *  ahora escribes `if (obj instanceof String s) { ... usa s ... }`.
 *  El casting y la declaración de variable ocurren en una sola línea.
 *  Funciona con &&, || y en expresiones condicionales.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Text Blocks: """...""" para strings multilínea.
 *  - La indentación se maneja automáticamente (se elimina la indentación común).
 *  - \ al final de línea: ignora el salto de línea (une líneas).
 *  - Pattern matching: `obj instanceof Tipo variable`.
 *  - La variable está en scope en todo el bloque donde el instanceof es true.
 *  - Funciona con flujo condicional: && después del instanceof.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  // Text Block
 *  String json = """
 *      {
 *          "nombre": "Sebastián",
 *          "edad": 25
 *      }
 *      """;
 *
 *  // Pattern Matching
 *  if (obj instanceof String s && s.length() > 3) {
 *      System.out.println(s.toUpperCase());
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Espacios al final de las líneas en text blocks (son significativos).
 *  - La variable del pattern matching no es final (puedes reasignarla).
 *  - Confundir el scope: la variable vive en TODO el bloque donde instanceof
 *    es true, no solo dentro del if.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - JEP 378 (Text Blocks): https://openjdk.org/jeps/378
 *  - JEP 394 (Pattern Matching): https://openjdk.org/jeps/394
 * ============================================================
 */
public class TextBlocksYPatternMatching {

    public static void main(String[] args) {
        System.out.println("=== Text Blocks y Pattern Matching (Java 15-16) ===");
        System.out.println();

        // ============================================
        //  TEXT BLOCKS
        // ============================================
        System.out.println("--- 1. Text Blocks (\""\""\"...\""\""\") ---");
        System.out.println();

        // ANTES: concatenación manual (horrible)
        String jsonAntes = "{\n" +
                "  \"nombre\": \"Sebastián\",\n" +
                "  \"edad\": 25,\n" +
                "  \"lenguajes\": [\"Java\", \"Kotlin\"]\n" +
                "}";

        // AHORA: text block
        String jsonAhora = """
                {
                  "nombre": "Sebastián",
                  "edad": 25,
                  "lenguajes": ["Java", "Kotlin"]
                }
                """;

        System.out.println("--- JSON (con text block) ---");
        System.out.println(jsonAhora);
        System.out.println();

        // SQL con text block
        String sql = """
                SELECT id, nombre, email
                FROM usuarios
                WHERE activo = true
                  AND edad >= 18
                ORDER BY nombre ASC
                """;

        System.out.println("--- SQL (con text block) ---");
        System.out.println(sql);

        // HTML con text block
        String html = """
                <div class="usuario">
                    <h2>%s</h2>
                    <p>Email: %s</p>
                </div>
                """.formatted("Sebastián", "sabas@ejemplo.com");

        System.out.println("--- HTML (con text block + formatted) ---");
        System.out.println(html);

        // \ al final: ignora salto de línea
        String fraseUnida = """
                Esta es una frase \
                que continúa en la misma línea \
                aunque en el código se vea en varias.
                """;
        System.out.println("Frase unida con \\: " + fraseUnida);

        // ============================================
        //  PATTERN MATCHING
        // ============================================
        System.out.println("--- 2. Pattern Matching para instanceof ---");

        Object[] objetos = {
                "Hola Mundo",
                42,
                3.14,
                "Java",
                true
        };

        for (Object obj : objetos) {
            // ANTES: verificación + casting manual
            // if (obj instanceof String) {
            //     String s = (String) obj;
            //     System.out.println(s.toUpperCase());
            // }

            // AHORA: pattern matching (todo en uno)
            if (obj instanceof String s) {
                System.out.println("  String: \"" + s + "\" → \"" + s.toUpperCase() + "\"");
            } else if (obj instanceof Integer i) {
                System.out.println("  Integer: " + i + " → cuadrado = " + (i * i));
            } else if (obj instanceof Double d) {
                System.out.println("  Double: " + d + " → redondeado = " + Math.round(d));
            } else {
                System.out.println("  Otro tipo: " + obj.getClass().getSimpleName());
            }
        }
        System.out.println();

        // Pattern matching con && (la variable está en scope después)
        System.out.println("--- 3. Pattern Matching con && ---");

        Object[] pruebas = {"corto", "esto es un texto largo", null, 123, "ok"};

        for (Object obj : pruebas) {
            if (obj instanceof String s && s.length() > 5) {
                System.out.println("  \"" + s + "\" es String largo (len=" + s.length() + ")");
            } else if (obj instanceof String s) {
                System.out.println("  \"" + s + "\" es String corto (len=" + s.length() + ")");
            } else {
                System.out.println("  " + obj + " → no es String");
            }
        }
        System.out.println();

        // Método con pattern matching
        System.out.println("--- 4. Método con Pattern Matching ---");
        System.out.println("Procesar \"Java 2026\": " + procesarObjeto("Java 2026"));
        System.out.println("Procesar 3.14159:       " + procesarObjeto(3.14159));
        System.out.println("Procesar null:          " + procesarObjeto(null));
    }

    static String procesarObjeto(Object obj) {
        if (obj instanceof String s && s.contains("Java")) {
            return "String que contiene 'Java': " + s.toUpperCase();
        } else if (obj instanceof String s) {
            return "String normal: " + s;
        } else if (obj instanceof Number n) {
            return "Número: " + n.doubleValue();
        } else {
            return "Tipo desconocido o null";
        }
    }
}
