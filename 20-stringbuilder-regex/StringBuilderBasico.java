/**
 * ============================================================
 *  TEMA: StringBuilder para Construcción Eficiente de Strings
 *  SECCIÓN: 20 — StringBuilder y Regex
 *  ARCHIVO: StringBuilderBasico.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  String es INMUTABLE: cada vez que usas `+` para concatenar, Java
 *  crea un nuevo objeto String y descarta el anterior. En un bucle de
 *  10,000 iteraciones, eso significa 10,000 objetos basura. StringBuilder
 *  resuelve esto con un buffer mutable: haces `append()` todas las veces
 *  que quieras sobre el MISMO objeto, y solo al final lo conviertes a
 *  String con `toString()`. Aprenderás las operaciones principales y
 *  medirás la diferencia de rendimiento.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - String es inmutable: cada concatenación crea un nuevo objeto.
 *  - StringBuilder es mutable: modifica el mismo buffer sin crear objetos.
 *  - append(str): añade al final.
 *  - insert(pos, str): inserta en una posición.
 *  - delete(inicio, fin): elimina un rango.
 *  - reverse(): invierte el contenido.
 *  - capacity() vs length(): capacidad reservada vs contenido real.
 *  - StringBuffer = StringBuilder sincronizado (thread-safe, más lento).
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  StringBuilder sb = new StringBuilder();
 *  sb.append("Hola");
 *  sb.append(" Mundo");
 *  String resultado = sb.toString(); // "Hola Mundo"
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar String con + en bucles (problema de rendimiento).
 *  - Olvidar llamar .toString() al final (pasar StringBuilder donde se
 *    espera String).
 *  - Usar StringBuffer cuando no hay concurrencia (es más lento).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/StringBuilder.html
 * ============================================================
 */
public class StringBuilderBasico {

    public static void main(String[] args) {
        System.out.println("=== StringBuilder: Construcción Eficiente de Strings ===");
        System.out.println();

        // --- RENDIMIENTO: String vs StringBuilder ---
        System.out.println("--- 1. Rendimiento: String vs StringBuilder ---");

        int iteraciones = 50_000;

        // Con String (crea 50,000 objetos descartables)
        long inicioStr = System.currentTimeMillis();
        String resultadoStr = "";
        for (int i = 0; i < iteraciones; i++) {
            resultadoStr += "a";
        }
        long finStr = System.currentTimeMillis();

        // Con StringBuilder (un solo buffer mutable)
        long inicioSB = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iteraciones; i++) {
            sb.append("a");
        }
        String resultadoSB = sb.toString();
        long finSB = System.currentTimeMillis();

        System.out.println("String (+):       " + (finStr - inicioStr) + " ms");
        System.out.println("StringBuilder:     " + (finSB - inicioSB) + " ms");
        System.out.println("¡StringBuilder es mucho más rápido!");
        System.out.println();

        // --- OPERACIONES BÁSICAS ---
        System.out.println("--- 2. Operaciones con StringBuilder ---");

        StringBuilder builder = new StringBuilder();
        builder.append("Hola");
        builder.append(" ");
        builder.append("Mundo");
        builder.append(" ");
        builder.append("Java");
        System.out.println("append:        " + builder);

        builder.insert(0, "¡");
        System.out.println("insert(0, ¡):  " + builder);

        builder.delete(6, 12); // Elimina "Mundo "
        System.out.println("delete(6, 12): " + builder);

        builder.reverse();
        System.out.println("reverse():     " + builder);
        builder.reverse(); // Volver
        System.out.println();

        // --- CAPACITY vs LENGTH ---
        System.out.println("--- 3. Capacity vs Length ---");

        StringBuilder sb2 = new StringBuilder();
        System.out.println("Vacío: length=" + sb2.length() + ", capacity=" + sb2.capacity());

        sb2.append("12345678901234567890"); // 20 caracteres
        System.out.println("20 chars: length=" + sb2.length() + ", capacity=" + sb2.capacity());
        System.out.println("(capacity crece automáticamente: (old*2)+2)");
        System.out.println();

        // --- setCharAt y replace ---
        System.out.println("--- 4. Modificar caracteres específicos ---");

        StringBuilder sb3 = new StringBuilder("Java es genial");
        sb3.setCharAt(0, 'L');      // Cambia 'J' por 'L'
        System.out.println("setCharAt(0, 'L'): " + sb3);

        sb3.replace(5, 7, "no es"); // Reemplaza "es" por "no es"
        System.out.println("replace(5,7):      " + sb3);
        System.out.println();

        // --- ENCADENAMIENTO ---
        System.out.println("--- 5. Encadenamiento de Métodos ---");

        String frase = new StringBuilder()
                .append("Me gusta ")
                .append("programar ")
                .append("en ")
                .append("Java")
                .append("!")
                .toString();

        System.out.println(frase);
        System.out.println("(Todos los métodos devuelven 'this' para encadenar)");
    }
}
