/**
 * ============================================================
 *  TEMA: Fechas y Tiempo (java.time API)
 *  SECCIÓN: 19 — Fechas y Tiempo
 *  ARCHIVO: FechasBasicas.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás a utilizar la API moderna de fechas y tiempo introducida
 *  en Java 8 (paquete java.time). Veremos cómo obtener la fecha y hora
 *  actual, así como crear fechas y horas específicas utilizando las
 *  clases LocalDate, LocalTime y LocalDateTime.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - LocalDate: Representa una fecha sin tiempo (año, mes, día).
 *  - LocalTime: Representa un tiempo sin fecha (horas, minutos, segundos).
 *  - LocalDateTime: Representa fecha y tiempo combinados.
 *  - .now(): Método estático para obtener la fecha/hora actual.
 *  - .of(): Método estático para crear una fecha/hora específica.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  LocalDate fechaActual = LocalDate.now();
 *  LocalDate fechaEspecifica = LocalDate.of(2023, 10, 15);
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar la clase antigua java.util.Date en lugar de la moderna java.time.*.
 *  - Confundir los meses (en java.time los meses van de 1 a 12, a diferencia de Date que empezaba en 0).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html
 * ============================================================
 */

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class FechasBasicas {
    
    /**
     * Método principal que ejecuta los ejemplos de fechas básicas.
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        System.out.println("--- FECHAS Y TIEMPO: CONCEPTOS BÁSICOS ---\n");

        // 1. Trabajando con LocalDate (Solo fecha)
        LocalDate fechaActual = LocalDate.now();
        System.out.println("Fecha actual (LocalDate.now()): " + fechaActual);

        LocalDate fechaEspecifica = LocalDate.of(1995, 5, 23); // Año, Mes, Día
        System.out.println("Fecha específica (LocalDate.of()): " + fechaEspecifica);

        // 2. Trabajando con LocalTime (Solo tiempo)
        LocalTime horaActual = LocalTime.now();
        System.out.println("\nHora actual (LocalTime.now()): " + horaActual);

        LocalTime horaEspecifica = LocalTime.of(14, 30, 0); // Hora, Minuto, Segundo
        System.out.println("Hora específica (LocalTime.of()): " + horaEspecifica);

        // 3. Trabajando con LocalDateTime (Fecha y Tiempo)
        LocalDateTime fechaYHoraActual = LocalDateTime.now();
        System.out.println("\nFecha y Hora actual (LocalDateTime.now()): " + fechaYHoraActual);

        LocalDateTime fechaYHoraEspecifica = LocalDateTime.of(fechaEspecifica, horaEspecifica);
        System.out.println("Fecha y hora combinadas: " + fechaYHoraEspecifica);
        
        // Podemos acceder a partes específicas de la fecha
        System.out.println("\nExtrayendo información de la fecha:");
        System.out.println("Año actual: " + fechaActual.getYear());
        System.out.println("Mes actual: " + fechaActual.getMonthValue() + " (" + fechaActual.getMonth() + ")");
        System.out.println("Día del mes: " + fechaActual.getDayOfMonth());
    }
}
