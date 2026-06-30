/**
 * ============================================================
 *  TEMA: Las Clases Character y System en Java
 *  SECCIÓN: 12 — Utilidades de Java
 *  ARCHIVO: ClaseCharacterYSystem.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Character y System son dos clases utilitarias que usan TODOS los
 *  frameworks y aplicaciones Java. Character te permite inspeccionar
 *  y transformar caracteres individuales: ¿es un dígito? ¿es una
 *  letra? ¿mayúscula? ¿espacio? También convierte entre mayúsculas
 *  y minúsculas.
 *
 *  System es el puente entre tu programa y el sistema operativo:
 *  `System.out` para salida, `System.err` para errores, `System.in`
 *  para entrada, `System.currentTimeMillis()` para medir tiempo (la
 *  base de cualquier benchmark), `System.arraycopy()` para copiar
 *  arreglos a nivel nativo (ultrarrápido), y `System.getProperty()`
 *  para leer configuraciones del sistema.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Character.isDigit(c): ¿es un dígito '0'-'9'?
 *  - Character.isLetter(c): ¿es una letra 'A'-'Z' o 'a'-'z'?
 *  - Character.isLetterOrDigit(c): combinación útil para validar.
 *  - Character.isWhitespace(c): espacio, tab, salto de línea.
 *  - Character.toLowerCase(c) / toUpperCase(c): conversión.
 *  - System.currentTimeMillis(): milisegundos desde 1970 (epoch).
 *  - System.arraycopy(): copia nativa de arreglos (más rápida que for).
 *  - System.getProperty(): leer propiedades del sistema operativo.
 *  - System.nanoTime(): tiempo en nanosegundos para mediciones finas.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  char c = 'A';
 *  boolean esLetra = Character.isLetter(c);  // true
 *  long inicio = System.currentTimeMillis();
 *  // ... código a medir ...
 *  long fin = System.currentTimeMillis();
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - currentTimeMillis() depende del reloj del sistema (puede ajustarse).
 *  - nanoTime() es más preciso pero solo para medir INTERVALOS.
 *  - arraycopy() no verifica límites si le pasas índices incorrectos.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Character: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Character.html
 *  - System: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/System.html
 * ============================================================
 */
public class ClaseCharacterYSystem {

    public static void main(String[] args) {
        System.out.println("=== Character y System: Dos Clases Esenciales ===");
        System.out.println();

        // ========================================
        //  CHARACTER
        // ========================================
        System.out.println("--- Clase Character ---");
        System.out.println();

        // --- CLASIFICACIÓN DE CARACTERES ---
        System.out.println("Clasificación de caracteres:");

        char digito = '7';
        char letra = 'A';
        char minuscula = 'z';
        char espacio = ' ';
        char simbolo = '@';
        char enie = 'ñ';

        System.out.println("  Character.isDigit('" + digito + "')     = " + Character.isDigit(digito));
        System.out.println("  Character.isLetter('" + letra + "')    = " + Character.isLetter(letra));
        System.out.println("  Character.isLetterOrDigit('" + digito + "') = " + Character.isLetterOrDigit(digito));
        System.out.println("  Character.isWhitespace(' ')   = " + Character.isWhitespace(espacio));
        System.out.println("  Character.isUpperCase('" + letra + "') = " + Character.isUpperCase(letra));
        System.out.println("  Character.isLowerCase('" + minuscula + "') = " + Character.isLowerCase(minuscula));
        System.out.println("  Character.isLetter('" + enie + "')   = " + Character.isLetter(enie) + " (¡soporta ñ!)");
        System.out.println();

        // --- CONVERSIÓN ---
        System.out.println("Conversión de caracteres:");
        System.out.println("  toUpperCase('a') = " + Character.toUpperCase('a'));
        System.out.println("  toUpperCase('ñ') = " + Character.toUpperCase('ñ'));
        System.out.println("  toLowerCase('Z') = " + Character.toLowerCase('Z'));
        System.out.println();

        // --- VALIDADOR PRÁCTICO: contraseña ---
        System.out.println("--- Ejemplo: Validador de Contraseña ---");
        String password = "Java2026!";
        boolean tieneMayus = false, tieneDigito = false, tieneEspecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) tieneMayus = true;
            if (Character.isDigit(c)) tieneDigito = true;
            if (!Character.isLetterOrDigit(c)) tieneEspecial = true;
        }

        System.out.println("Contraseña: \"" + password + "\"");
        System.out.println("  Tiene mayúscula: " + tieneMayus);
        System.out.println("  Tiene dígito:    " + tieneDigito);
        System.out.println("  Tiene especial:  " + tieneEspecial);
        boolean esSegura = password.length() >= 8 && tieneMayus && tieneDigito && tieneEspecial;
        System.out.println("  ¿Es segura?      " + esSegura);
        System.out.println();

        // ========================================
        //  SYSTEM
        // ========================================
        System.out.println("--- Clase System ---");
        System.out.println();

        // --- MEDICIÓN DE TIEMPO ---
        System.out.println("Medición de tiempo:");

        long inicio = System.currentTimeMillis();

        // Simulamos trabajo
        int suma = 0;
        for (int i = 0; i < 10_000_000; i++) {
            suma += i;
        }

        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("  Suma de 10 millones de iteraciones: " + suma);
        System.out.println("  Tiempo transcurrido: " + duracion + " ms");
        System.out.println();

        // --- NANO TIME (más preciso) ---
        System.out.println("Tiempo en nanosegundos:");

        long inicioNano = System.nanoTime();

        // Operación muy rápida
        double resultado = Math.sqrt(12345.6789);

        long finNano = System.nanoTime();
        System.out.println("  sqrt(12345.6789) = " + resultado);
        System.out.println("  Tiempo: " + (finNano - inicioNano) + " nanosegundos");
        System.out.println();

        // --- ARRAYCOPY (copia nativa de arreglos) ---
        System.out.println("System.arraycopy(): Copia ultrarrápida");

        int[] origen = {10, 20, 30, 40, 50, 60, 70, 80};
        int[] destino = new int[8];

        System.arraycopy(origen, 0, destino, 0, origen.length);
        System.out.println("  Copia completa: " + java.util.Arrays.toString(destino));

        int[] parcial = new int[5];
        System.arraycopy(origen, 2, parcial, 1, 3);
        System.out.println("  Copia parcial (desde índice 2, 3 elementos → índice 1): "
                + java.util.Arrays.toString(parcial));
        System.out.println();

        // --- PROPIEDADES DEL SISTEMA ---
        System.out.println("Propiedades del sistema:");

        System.out.println("  java.version  = " + System.getProperty("java.version"));
        System.out.println("  java.home     = " + System.getProperty("java.home"));
        System.out.println("  os.name       = " + System.getProperty("os.name"));
        System.out.println("  os.arch       = " + System.getProperty("os.arch"));
        System.out.println("  user.name     = " + System.getProperty("user.name"));
        System.out.println("  user.dir      = " + System.getProperty("user.dir"));
        System.out.println("  file.separator = '" + System.getProperty("file.separator") + "'");
        System.out.println("  line.separator (representación) = '\\n' en Unix, '\\r\\n' en Windows");
        System.out.println();

        // --- GC ---
        System.out.println("System.gc() — Sugiere al Garbage Collector que se ejecute");
        System.gc();
        System.out.println("(No garantiza ejecución inmediata, es una sugerencia)");
    }
}
