import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ============================================================
 *  TEMA: Expresiones Regulares (Regex) en Java
 *  SECCIÓN: 20 — StringBuilder y Regex
 *  ARCHIVO: RegexBasico.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Las expresiones regulares (regex) son un mini-lenguaje para describir
 *  PATRONES en texto. Con ellas puedes validar si un string es un email
 *  válido, extraer todos los números de un párrafo, dividir texto por
 *  múltiples delimitadores, o reemplazar patrones complejos — todo en
 *  pocas líneas. En Java usas `Pattern` para compilar la expresión y
 *  `Matcher` para aplicarla contra un texto. Aprenderás los metacaracteres
 *  más útiles, cuantificadores, clases de caracteres y grupos de captura.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Pattern.compile(regex): compila la expresión regular.
 *  - Matcher: aplica el pattern a un string.
 *  - matches(): el string ENTERO coincide con el pattern.
 *  - find(): busca la PRÓXIMA ocurrencia del pattern.
 *  - group(): devuelve el texto que coincidió.
 *  - Clases de caracteres: \d (dígito), \w (letra/digito/_),
 *    \s (whitespace), [abc] (a, b o c), [^abc] (ni a, b ni c).
 *  - Cuantificadores: + (1+), * (0+), ? (0 o 1), {n} (exacto n),
 *    {n,m} (entre n y m).
 *  - split(regex): divide un string por el patrón.
 *  - replaceAll(regex, replacement): reemplaza coincidencias.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  Pattern p = Pattern.compile("\\d+");    // uno o más dígitos
 *  Matcher m = p.matcher("Tengo 25 años"); // texto a analizar
 *  while (m.find()) { System.out.println(m.group()); }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar escapar \ en Java: \\d en vez de \d.
 *  - Usar matches() cuando querías find() (matches exige coincidencia total).
 *  - Crear un nuevo Pattern en cada iteración de un bucle (compílalo una vez).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Regex tester online: https://regex101.com/
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/regex/Pattern.html
 * ============================================================
 */
public class RegexBasico {

    public static void main(String[] args) {
        System.out.println("=== Expresiones Regulares (Regex) en Java ===");
        System.out.println();

        // --- MATCHES: Coincidencia total ---
        System.out.println("--- 1. matches(): Coincidencia Total ---");

        Pattern patronDigitos = Pattern.compile("\\d+");
        System.out.println("\"12345\".matches(\"\\\\d+\"): " + "12345".matches("\\d+"));
        System.out.println("\"abc123\".matches(\"\\\\d+\"): " + "abc123".matches("\\d+"));
        System.out.println("(matches() requiere que TODO el string coincida)");
        System.out.println();

        // --- FIND: Búsqueda parcial ---
        System.out.println("--- 2. find(): Buscar Ocurrencias ---");

        String texto = "Mi teléfono es 555-1234 y nací en 1998. Precio: $49.99";
        Pattern patronNumeros = Pattern.compile("\\d+");
        Matcher matcher = patronNumeros.matcher(texto);

        System.out.println("Texto: \"" + texto + "\"");
        System.out.print("Números encontrados: ");
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
        System.out.println();
        System.out.println();

        // --- GRUPOS DE CAPTURA ---
        System.out.println("--- 3. Grupos de Captura con () ---");

        String datos = "Nombre: Ana, Edad: 25, Email: ana@ejemplo.com";
        Pattern patronEmail = Pattern.compile("Email: (\\w+@\\w+\\.\\w+)");
        Matcher mEmail = patronEmail.matcher(datos);

        if (mEmail.find()) {
            System.out.println("Match completo: " + mEmail.group(0));
            System.out.println("Grupo 1 (email): " + mEmail.group(1));
        }
        System.out.println();

        // --- CLASES DE CARACTERES ---
        System.out.println("--- 4. Clases de Caracteres ---");

        String[] tests = {"abc", "123", "ABC", "a1b", "   ", "abc123"};

        for (String s : tests) {
            System.out.printf("  \"%-6s\" -> soloLetras=%s, soloDigitos=%s, alfanumérico=%s%n",
                    s,
                    s.matches("[a-zA-Z]+"),
                    s.matches("[0-9]+"),
                    s.matches("[a-zA-Z0-9]+"));
        }
        System.out.println();

        // --- CUANTIFICADORES ---
        System.out.println("--- 5. Cuantificadores ---");

        String[] codigos = {"A1", "ABC12", "XYZ999", "X", "AB1234"};

        Pattern patronCodigo = Pattern.compile("[A-Z]{1,3}\\d{1,4}");

        for (String codigo : codigos) {
            System.out.printf("  \"%-6s\" -> %s%n",
                    codigo,
                    patronCodigo.matcher(codigo).matches());
        }
        System.out.println("(Patrón: 1-3 letras mayúsculas + 1-4 dígitos)");
        System.out.println();

        // --- SPLIT CON REGEX ---
        System.out.println("--- 6. split() con Regex ---");

        String csv = "Manzana, Banana;Naranja|Uva";
        String[] frutas = csv.split("[,;|]");
        System.out.println("Original: \"" + csv + "\"");
        System.out.print("Split por [,;|]: ");
        for (String f : frutas) {
            System.out.print("[" + f.trim() + "] ");
        }
        System.out.println();
        System.out.println();

        // --- REPLACEALL ---
        System.out.println("--- 7. replaceAll() ---");

        String frase = "El   rápido   zorro    marrón";
        String sinEspaciosMultiples = frase.replaceAll("\\s+", " ");
        System.out.println("Antes: \"" + frase + "\"");
        System.out.println("Después (\\s+ → ' '): \"" + sinEspaciosMultiples + "\"");

        String telefono = "Tel: 555-123-4567";
        String soloNumeros = telefono.replaceAll("[^0-9]", "");
        System.out.println("\"" + telefono + "\" → solo dígitos: \"" + soloNumeros + "\"");
        System.out.println();

        // --- VALIDADOR DE EMAIL ---
        System.out.println("--- 8. Validador de Email ---");

        String emailRegex = "^[\\w.-]+@[\\w.-]+\\.\\w{2,}$";
        String[] emails = {
            "usuario@ejemplo.com",
            "ana.lopez@empresa.co",
            "invalido@",
            "@sinusuario.com",
            "correcto@dominio.org"
        };

        for (String email : emails) {
            System.out.printf("  %-25s -> %s%n",
                    email,
                    email.matches(emailRegex) ? "VÁLIDO" : "INVÁLIDO");
        }
    }
}
