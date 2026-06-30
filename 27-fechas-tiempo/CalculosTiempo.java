/**
 * ============================================================
 *  TEMA: Cálculos de Tiempo y Diferencias
 *  SECCIÓN: 27 — Fechas y Tiempo
 *  ARCHIVO: CalculosTiempo.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás a manipular fechas sumando o restando tiempo.
 *  Conocerás las clases Period (para manipular días, meses, años)
 *  y Duration (para horas, minutos, segundos), además de la clase
 *  ChronoUnit para calcular la diferencia exacta entre dos fechas.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - .plus() / .minus(): Métodos para añadir o restar tiempo a una fecha.
 *  - Period: Representa una cantidad de tiempo basada en fecha (ej. 2 meses y 5 días).
 *  - Duration: Representa una cantidad de tiempo basada en horas/segundos.
 *  - ChronoUnit: Enum útil para calcular la diferencia de unidades (ej. total de días) entre dos instantes.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  LocalDate mañana = LocalDate.now().plusDays(1);
 *  Period periodo = Period.between(fechaInicio, fechaFin);
 *  long diasDiferencia = ChronoUnit.DAYS.between(fecha1, fecha2);
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar que las clases de java.time son inmutables (métodos como plusDays retornan un NUEVO objeto).
 *  - Usar Period para calcular tiempo (horas/minutos) o Duration para fechas (años/meses).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/8/docs/api/java/time/Period.html
 * ============================================================
 */

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class CalculosTiempo {
    
    /**
     * Método principal que ejecuta los ejemplos de cálculos temporales.
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        System.out.println("--- CÁLCULOS Y MANIPULACIÓN DE TIEMPO ---\n");

        LocalDate hoy = LocalDate.now();
        System.out.println("Fecha actual: " + hoy);

        // 1. Sumar y Restar tiempo (métodos directos)
        // Recordar: Los objetos son inmutables, hay que reasignarlos o guardarlos en nuevas variables
        LocalDate enUnaSemana = hoy.plusDays(7);
        LocalDate haceUnMes = hoy.minusMonths(1);
        
        System.out.println("En 7 días será: " + enUnaSemana);
        System.out.println("Hace un mes fue: " + haceUnMes);

        // 2. Uso de Period (Periodos basados en fechas: años, meses, días)
        LocalDate fechaInicio = LocalDate.of(2020, 1, 1);
        Period periodo = Period.between(fechaInicio, hoy);
        
        System.out.println("\nDesde el 01/01/2020 han pasado:");
        System.out.println(periodo.getYears() + " años, " + 
                           periodo.getMonths() + " meses y " + 
                           periodo.getDays() + " días.");

        // 3. Uso de Duration (Periodos basados en tiempo exacto: horas, minutos, segundos)
        LocalTime inicioClase = LocalTime.of(8, 0); // 08:00 AM
        LocalTime finClase = LocalTime.of(10, 30);  // 10:30 AM
        
        Duration duracion = Duration.between(inicioClase, finClase);
        System.out.println("\nLa clase dura: " + duracion.toHours() + " horas y " + 
                           (duracion.toMinutes() % 60) + " minutos.");

        // 4. Uso de ChronoUnit para obtener totales exactos
        // A diferencia de Period, ChronoUnit nos da el total absoluto en la unidad especificada
        LocalDate eventoFuturo = LocalDate.of(2026, 12, 31);
        long diasFaltantes = ChronoUnit.DAYS.between(hoy, eventoFuturo);
        long mesesFaltantes = ChronoUnit.MONTHS.between(hoy, eventoFuturo);
        
        System.out.println("\nPara el 31/12/2026 faltan exactamente:");
        System.out.println("- " + diasFaltantes + " días en total");
        System.out.println("- " + mesesFaltantes + " meses en total");
    }
}
