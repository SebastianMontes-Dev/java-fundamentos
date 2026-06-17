/**
 * ============================================================
 *  TEMA: Enumeraciones (Enums) en Java
 *  SECCIÓN: 15 — Enums
 *  ARCHIVO: EnumBasico.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás qué es un enum y por qué es útil para representar
 *  un conjunto fijo de valores constantes. Verás cómo declarar
 *  enums, usarlos en estructuras switch, iterar sobre sus valores
 *  con values() y buscar valores con valueOf(). Trabajaremos con
 *  ejemplos de días de la semana y estaciones del año.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Un enum es un tipo que define un conjunto fijo de constantes
 *  - Cada constante del enum es una instancia única (singleton)
 *  - values() devuelve un arreglo con todos los valores del enum
 *  - valueOf(String) convierte un String al valor del enum
 *  - ordinal() devuelve la posición (empezando en 0)
 *  - name() devuelve el nombre como String
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *      enum NombreEnum {
 *          VALOR1, VALOR2, VALOR3
 *      }
 *
 *      // Uso:
 *      NombreEnum variable = NombreEnum.VALOR1;
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Intentar crear instancias con new: new DiaSemana() → ERROR
 *  - Usar valueOf() con un String que no coincide exactamente
 *    (es sensible a mayúsculas): valueOf("lunes") lanza excepción
 *  - Olvidar que ordinal() empieza en 0, no en 1
 *  - Comparar enums con .equals() cuando se puede usar == directamente
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
 *  - Java Language Spec (Enums): https://docs.oracle.com/javase/specs/jls/se17/html/jls-8.html#jls-8.9
 * ============================================================
 */

/**
 * Clase que demuestra los fundamentos de los enums en Java.
 * Incluye declaración, uso en switch, iteración y métodos integrados.
 */
public class EnumBasico {

    // ─────────────────────────────────────────────
    //  1. DECLARACIÓN DE ENUMS
    // ─────────────────────────────────────────────

    /**
     * Enum que representa los días de la semana.
     * Por convención, los valores se escriben en MAYÚSCULAS.
     */
    enum DiaSemana {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }

    /**
     * Enum que representa las estaciones del año.
     */
    enum Estacion {
        PRIMAVERA, VERANO, OTONO, INVIERNO
    }

    /**
     * Enum que representa niveles de prioridad.
     */
    enum Prioridad {
        BAJA, MEDIA, ALTA, CRITICA
    }

    // ─────────────────────────────────────────────
    //  2. MÉTODO PRINCIPAL
    // ─────────────────────────────────────────────

    /**
     * Punto de entrada del programa. Ejecuta todas las demostraciones.
     *
     * @param args argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║      ENUMS BÁSICOS EN JAVA               ║");
        System.out.println("╚══════════════════════════════════════════╝\n");

        demostrarDeclaracionYUso();
        demostrarSwitch();
        demostrarIteracion();
        demostrarMetodosIntegrados();
        demostrarComparacion();
        demostrarValueOf();
    }

    // ─────────────────────────────────────────────
    //  3. DECLARACIÓN Y USO BÁSICO
    // ─────────────────────────────────────────────

    /**
     * Demuestra cómo declarar variables de tipo enum y asignarles valores.
     */
    public static void demostrarDeclaracionYUso() {
        System.out.println("── 1. Declaración y Uso Básico ──\n");

        // Asignar un valor del enum a una variable
        DiaSemana hoy = DiaSemana.MIERCOLES;
        Estacion estacionActual = Estacion.VERANO;
        Prioridad nivelTarea = Prioridad.ALTA;

        System.out.println("Hoy es: " + hoy);
        System.out.println("Estación actual: " + estacionActual);
        System.out.println("Prioridad de la tarea: " + nivelTarea);

        // Los enums se imprimen con su nombre automáticamente (toString)
        // No necesitas hacer .name() para imprimirlos

        System.out.println();
    }

    // ─────────────────────────────────────────────
    //  4. USO EN SWITCH
    // ─────────────────────────────────────────────

    /**
     * Demuestra el uso de enums en estructuras switch.
     * Los enums son especialmente útiles con switch porque el compilador
     * puede verificar que se cubran todos los casos.
     */
    public static void demostrarSwitch() {
        System.out.println("── 2. Enums en Switch ──\n");

        DiaSemana dia = DiaSemana.VIERNES;

        // Switch clásico con enum
        // NOTA: Dentro del switch NO se escribe DiaSemana.VIERNES,
        //       solo se escribe VIERNES
        switch (dia) {
            case LUNES:
            case MARTES:
            case MIERCOLES:
            case JUEVES:
                System.out.println(dia + " → Día laboral regular");
                break;
            case VIERNES:
                System.out.println(dia + " → ¡Último día laboral!");
                break;
            case SABADO:
            case DOMINGO:
                System.out.println(dia + " → ¡Fin de semana!");
                break;
        }

        System.out.println();

        // Otro ejemplo con estaciones
        Estacion estacion = Estacion.INVIERNO;
        String recomendacion;

        switch (estacion) {
            case PRIMAVERA:
                recomendacion = "Disfruta las flores y el buen clima 🌸";
                break;
            case VERANO:
                recomendacion = "Protégete del sol e hidrátate ☀️";
                break;
            case OTONO:
                recomendacion = "Lleva un abrigo ligero 🍂";
                break;
            case INVIERNO:
                recomendacion = "Abrígate bien y toma bebidas calientes ❄️";
                break;
            default:
                recomendacion = "Estación desconocida";
        }

        System.out.println("Estación: " + estacion);
        System.out.println("Recomendación: " + recomendacion);
        System.out.println();
    }

    // ─────────────────────────────────────────────
    //  5. ITERACIÓN CON values()
    // ─────────────────────────────────────────────

    /**
     * Demuestra cómo recorrer todos los valores de un enum
     * usando el método values().
     */
    public static void demostrarIteracion() {
        System.out.println("── 3. Iteración con values() ──\n");

        // values() devuelve un arreglo con TODOS los valores del enum
        System.out.println("Días de la semana:");
        for (DiaSemana dia : DiaSemana.values()) {
            System.out.println("  • " + dia);
        }

        System.out.println();

        // Iterar mostrando posición y nombre
        System.out.println("Estaciones con su posición (ordinal):");
        for (Estacion estacion : Estacion.values()) {
            System.out.printf("  [%d] %s%n", estacion.ordinal(), estacion);
        }

        System.out.println();

        // Contar cuántos valores tiene un enum
        int totalDias = DiaSemana.values().length;
        int totalEstaciones = Estacion.values().length;
        int totalPrioridades = Prioridad.values().length;

        System.out.println("Total de días: " + totalDias);
        System.out.println("Total de estaciones: " + totalEstaciones);
        System.out.println("Total de prioridades: " + totalPrioridades);
        System.out.println();
    }

    // ─────────────────────────────────────────────
    //  6. MÉTODOS INTEGRADOS
    // ─────────────────────────────────────────────

    /**
     * Demuestra los métodos que todo enum hereda automáticamente:
     * name(), ordinal(), toString().
     */
    public static void demostrarMetodosIntegrados() {
        System.out.println("── 4. Métodos Integrados de Enum ──\n");

        DiaSemana dia = DiaSemana.JUEVES;

        // name()    → devuelve el nombre exacto como String
        // ordinal() → devuelve la posición (empieza en 0)
        // toString()→ por defecto, igual que name()

        System.out.println("Valor:      " + dia);
        System.out.println("name():     " + dia.name());
        System.out.println("ordinal():  " + dia.ordinal());
        System.out.println("toString(): " + dia.toString());

        System.out.println();

        // Tabla completa de prioridades
        System.out.println("┌──────────┬──────────┬─────────┐");
        System.out.println("│ Valor    │ name()   │ ordinal │");
        System.out.println("├──────────┼──────────┼─────────┤");
        for (Prioridad p : Prioridad.values()) {
            System.out.printf("│ %-8s │ %-8s │    %d    │%n",
                    p, p.name(), p.ordinal());
        }
        System.out.println("└──────────┴──────────┴─────────┘");
        System.out.println();
    }

    // ─────────────────────────────────────────────
    //  7. COMPARACIÓN DE ENUMS
    // ─────────────────────────────────────────────

    /**
     * Demuestra cómo comparar valores de enum.
     * Los enums se pueden comparar con == porque cada valor es un singleton.
     */
    public static void demostrarComparacion() {
        System.out.println("── 5. Comparación de Enums ──\n");

        DiaSemana dia1 = DiaSemana.LUNES;
        DiaSemana dia2 = DiaSemana.LUNES;
        DiaSemana dia3 = DiaSemana.VIERNES;

        // ✅ Comparar con == (RECOMENDADO para enums)
        System.out.println("dia1 == dia2: " + (dia1 == dia2));    // true
        System.out.println("dia1 == dia3: " + (dia1 == dia3));    // false

        // ✅ También funciona con .equals(), pero == es preferido
        System.out.println("dia1.equals(dia2): " + dia1.equals(dia2));  // true

        // ¿Por qué usar == en vez de .equals()?
        // 1. Es null-safe: null == algo no lanza excepción
        // 2. Es más rápido (comparación de referencia)
        // 3. Es seguro porque cada valor del enum es único (singleton)

        DiaSemana diaNulo = null;
        // diaNulo.equals(dia1);  // ❌ NullPointerException
        System.out.println("null == dia1: " + (diaNulo == dia1)); // ✅ false, sin excepción

        System.out.println();
    }

    // ─────────────────────────────────────────────
    //  8. BÚSQUEDA CON valueOf()
    // ─────────────────────────────────────────────

    /**
     * Demuestra el uso de valueOf() para convertir un String a un valor de enum.
     * IMPORTANTE: el String debe coincidir EXACTAMENTE con el nombre del valor.
     */
    public static void demostrarValueOf() {
        System.out.println("── 6. Búsqueda con valueOf() ──\n");

        // valueOf() convierte un String al valor correspondiente del enum
        DiaSemana diaDesdeTexto = DiaSemana.valueOf("LUNES");
        System.out.println("valueOf(\"LUNES\"): " + diaDesdeTexto);

        Estacion estacionDesdeTexto = Estacion.valueOf("VERANO");
        System.out.println("valueOf(\"VERANO\"): " + estacionDesdeTexto);

        // ⚠️ CUIDADO: valueOf es sensible a mayúsculas/minúsculas
        // DiaSemana.valueOf("lunes");  // ❌ IllegalArgumentException
        // DiaSemana.valueOf("Lunes");  // ❌ IllegalArgumentException

        // Forma segura de usar valueOf: con try-catch
        String entrada = "MARTES";
        try {
            DiaSemana diaSeguro = DiaSemana.valueOf(entrada.toUpperCase());
            System.out.println("Conversión exitosa: " + diaSeguro);
        } catch (IllegalArgumentException e) {
            System.out.println("'" + entrada + "' no es un día válido");
        }

        // Ejemplo con entrada inválida
        String entradaMala = "FUNDAY";
        try {
            DiaSemana diaInvalido = DiaSemana.valueOf(entradaMala);
            System.out.println("Día: " + diaInvalido);
        } catch (IllegalArgumentException e) {
            System.out.println("'" + entradaMala + "' no es un día válido ✗");
        }

        System.out.println();

        // ─── Resumen de cuándo usar Enums ───
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║  ¿CUÁNDO USAR ENUMS?                        ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║  ✓ Días, meses, estaciones                  ║");
        System.out.println("║  ✓ Estados (ACTIVO, INACTIVO, PENDIENTE)    ║");
        System.out.println("║  ✓ Niveles (BAJO, MEDIO, ALTO)             ║");
        System.out.println("║  ✓ Direcciones (NORTE, SUR, ESTE, OESTE)   ║");
        System.out.println("║  ✓ Roles (ADMIN, USUARIO, INVITADO)        ║");
        System.out.println("║  ✓ Cualquier conjunto fijo de valores       ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }
}
