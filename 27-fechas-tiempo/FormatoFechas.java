/**
 * ============================================================
 *  TEMA: Formateo y Análisis de Fechas
 *  SECCIÓN: 27 — Fechas y Tiempo
 *  ARCHIVO: FormatoFechas.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás a convertir fechas en cadenas de texto con formatos
 *  específicos y viceversa. Utilizarás la clase DateTimeFormatter
 *  para definir patrones personalizados (como dd/MM/yyyy) y
 *  aprenderás sobre el proceso de "parsing" (análisis).
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - DateTimeFormatter: Clase utilizada para formatear (fecha a texto) y analizar (texto a fecha).
 *  - .format(): Convierte un objeto LocalDate/Time en un String.
 *  - .parse(): Convierte un String en un objeto LocalDate/Time.
 *  - Patrones: Símbolos como 'd' (día), 'M' (mes), 'y' (año).
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 *  String texto = fecha.format(formato);
 *  LocalDate fechaAnalizada = LocalDate.parse("15/10/2023", formato);
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar 'm' minúscula (minutos) en lugar de 'M' mayúscula (meses) en el patrón.
 *  - Intentar hacer parse de un texto que no coincide exactamente con el formato definido (lanza DateTimeParseException).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
 * ============================================================
 */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class FormatoFechas {
    
    /**
     * Método principal que ejecuta los ejemplos de formateo.
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        System.out.println("--- FORMATEO Y PARSEO DE FECHAS ---\n");

        // Fecha actual para los ejemplos
        LocalDateTime ahora = LocalDateTime.now();
        System.out.println("Fecha y hora sin formato: " + ahora);

        // 1. Formateo (Fecha a Texto)
        // Patrón común en Latinoamérica y España: día/mes/año
        DateTimeFormatter formatoEstandar = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = ahora.format(formatoEstandar);
        System.out.println("Formato estándar (dd/MM/yyyy): " + fechaFormateada);

        // Patrón con mes en texto y hora
        DateTimeFormatter formatoCompleto = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy, HH:mm:ss");
        String fechaCompleta = ahora.format(formatoCompleto);
        System.out.println("Formato completo: " + fechaCompleta);

        // 2. Análisis o "Parseo" (Texto a Fecha)
        String textoFecha = "25/12/2023";
        System.out.println("\nIntentando analizar el texto: " + textoFecha);
        
        try {
            // Usamos el mismo formato "dd/MM/yyyy" para leer el texto
            LocalDate fechaParseada = LocalDate.parse(textoFecha, formatoEstandar);
            System.out.println("Objeto LocalDate creado exitosamente: " + fechaParseada);
            System.out.println("El año de esta fecha es: " + fechaParseada.getYear());
        } catch (DateTimeParseException e) {
            System.out.println("Error al analizar la fecha. Verifica el formato.");
        }

        // Ejemplo interactivo con Scanner
        Scanner sc = new Scanner(System.in);
        System.out.print("\nIngresa tu fecha de nacimiento (dd/MM/yyyy): ");
        String inputUsuario = sc.nextLine();

        try {
            LocalDate fechaNacimiento = LocalDate.parse(inputUsuario, formatoEstandar);
            System.out.println("¡Fecha registrada! Naciste un día " + fechaNacimiento.getDayOfWeek());
        } catch (DateTimeParseException e) {
            System.out.println("El formato ingresado no es correcto. Debía ser dd/MM/yyyy.");
        }

        sc.close();
    }
}
