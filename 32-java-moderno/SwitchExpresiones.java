/**
 * ============================================================
 *  TEMA: Switch Expressions y Arrow Switch (Java 14+)
 *  SECCIÓN: 32 — Java Moderno
 *  ARCHIVO: SwitchExpresiones.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  El switch tradicional de Java tenía varios defectos: fall-through
 *  accidental (olvidar un `break`), sintaxis verbosa para asignar
 *  valores, y era una sentencia, no una expresión. Las switch expressions
 *  (Java 14) solucionan TODO esto con dos cambios:
 *
 *  1. Arrow case (`case X ->`): ejecuta solo ESE caso, sin fall-through.
 *  2. Switch como EXPRESIÓN: el switch devuelve un valor que puedes
 *     asignar directamente a una variable.
 *
 *  También puedes agrupar múltiples labels en un solo case (`case A, B, C ->`)
 *  y usar `yield` para devolver valores en bloques de código.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Arrow case: `case X ->` sin break (no hay fall-through).
 *  - Switch como expresión: `var resultado = switch(valor) { ... };`.
 *  - yield: devuelve un valor desde un bloque case (como return pero para switch).
 *  - Múltiples labels: `case LUNES, MARTES, MIERCOLES ->`.
 *  - Cobertura exhaustiva: el compilador verifica que cubras todos los casos.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  String tipo = switch (dia) {
 *      case LUNES, MARTES, MIERCOLES, JUEVES, VIERNES -> "Laboral";
 *      case SABADO, DOMINGO -> "Fin de semana";
 *  };
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Mezclar -> y : en el mismo switch (no permitido).
 *  - Olvidar cubrir todos los casos (el compilador lo exige en expresiones).
 *  - Poner break después de -> (innecesario, ya son non-fall-through).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - JEP 361: https://openjdk.org/jeps/361
 * ============================================================
 */
public class SwitchExpresiones {

    public static void main(String[] args) {
        System.out.println("=== Switch Expressions (Java 14+) ===");
        System.out.println();

        // --- SWITCH TRADICIONAL vs MODERNO ---
        System.out.println("--- 1. Antes vs Ahora ---");
        System.out.println("// Antes (con fall-through):");
        System.out.println("switch (dia) {");
        System.out.println("    case 1: nombre = \"lunes\"; break;");
        System.out.println("    case 2: nombre = \"martes\"; break;");
        System.out.println("}");
        System.out.println();
        System.out.println("// Ahora (arrow case, sin break):");
        System.out.println("switch (dia) {");
        System.out.println("    case 1 -> nombre = \"lunes\";");
        System.out.println("    case 2 -> nombre = \"martes\";");
        System.out.println("}");
        System.out.println();

        // --- ARROW CASE EN ACCIÓN ---
        System.out.println("--- 2. Arrow Case (-→) ---");

        for (int dia = 1; dia <= 7; dia++) {
            String nombre = obtenerNombreDia(dia);
            System.out.println("  Día " + dia + ": " + nombre);
        }
        System.out.println();

        // --- SWITCH COMO EXPRESIÓN ---
        System.out.println("--- 3. Switch como Expresión (devuelve valor) ---");

        String[] dias = {"LUNES", "MARTES", "SABADO", "DOMINGO", "JUEVES"};

        for (String dia : dias) {
            String tipo = switch (dia) {
                case "LUNES", "MARTES", "MIERCOLES", "JUEVES", "VIERNES" -> "DÍA LABORAL";
                case "SABADO", "DOMINGO" -> "FIN DE SEMANA";
                default -> "DESCONOCIDO";
            };
            System.out.println("  " + dia + " → " + tipo);
        }
        System.out.println();

        // --- YIELD (para bloques con lógica) ---
        System.out.println("--- 4. yield: Devolver desde un Bloque ---");

        int[] meses = {1, 4, 6, 9, 12};
        for (int mes : meses) {
            String descripcion = switch (mes) {
                case 1, 2, 3 -> "Q1";
                case 4, 5, 6 -> "Q2";
                case 7, 8, 9 -> {
                    // Bloque de código: necesitas yield para devolver valor
                    String estacion = (mes <= 8) ? "verano boreal" : "otoño";
                    yield "Q3 (" + estacion + ")";
                }
                case 10, 11, 12 -> "Q4";
                default -> "Inválido";
            };
            System.out.println("  Mes " + mes + " → " + descripcion);
        }
        System.out.println();

        // --- EJEMPLO PRÁCTICO: CALCULADORA DE DÍAS POR MES ---
        System.out.println("--- 5. Ejemplo Práctico: Días por Mes ---");
        for (int mes = 1; mes <= 12; mes++) {
            int dias = diasPorMes(mes);
            System.out.printf("  Mes %2d: %d días%n", mes, dias);
        }
    }

    static String obtenerNombreDia(int dia) {
        return switch (dia) {
            case 1 -> "lunes";
            case 2 -> "martes";
            case 3 -> "miércoles";
            case 4 -> "jueves";
            case 5 -> "viernes";
            case 6 -> "sábado";
            case 7 -> "domingo";
            default -> throw new IllegalArgumentException("Día inválido: " + dia);
        };
    }

    static int diasPorMes(int mes) {
        return switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> throw new IllegalArgumentException("Mes inválido");
        };
    }
}
