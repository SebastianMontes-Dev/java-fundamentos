# Sección 19: Fechas y Tiempo (java.time)

En esta sección aprenderemos a utilizar la moderna API de fechas y tiempo introducida en Java 8 (paquete `java.time`). Esta API reemplaza a las antiguas y problemáticas clases `java.util.Date` y `java.util.Calendar`.

## Archivos en esta sección

1. **[FechasBasicas.java](./FechasBasicas.java)**
   - Introducción a las clases base: `LocalDate`, `LocalTime` y `LocalDateTime`.
   - Obtención de fechas/horas actuales (`now()`).
   - Creación de fechas y horas específicas (`of()`).

2. **[FormatoFechas.java](./FormatoFechas.java)**
   - Uso de `DateTimeFormatter` para dar formato a las fechas (ej. dd/MM/yyyy).
   - Conversión de `String` a objetos de fecha (proceso conocido como "parsing").
   - Manejo de excepciones `DateTimeParseException`.

3. **[CalculosTiempo.java](./CalculosTiempo.java)**
   - Suma y resta de fechas (métodos `plus` y `minus`).
   - Uso de `Period` para medir la diferencia en años, meses y días.
   - Uso de `Duration` para medir la diferencia en horas, minutos y segundos.
   - Uso de `ChronoUnit` para calcular totales absolutos entre instantes.

## Puntos importantes
- Todos los objetos de la API `java.time` son **inmutables**. Si sumas un día a una fecha, se crea un *nuevo* objeto fecha; el original no cambia.
- `LocalDate` y `LocalTime` no tienen información de zonas horarias. Si requieres manejar ubicaciones geográficas, se utiliza `ZonedDateTime`.
