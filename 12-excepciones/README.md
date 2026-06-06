# Sección 12 — Manejo de Excepciones

## ¿Qué vas a aprender en esta sección?

Los errores ocurren. El usuario ingresa texto donde esperabas un número, el archivo que intentas leer no existe, la conexión de red se cae a mitad de una operación. La diferencia entre una aplicación profesional y un script de principiante es cómo MANEJA esos errores. Las excepciones son el mecanismo de Java para detectar, propagar y manejar situaciones anómalas sin que el programa crashee.

El modelo es elegante: el código "riesgoso" va en un bloque `try`, el código que maneja el error va en bloques `catch` (uno por cada tipo de excepción que quieras tratar), y el código de limpieza —que se ejecuta SIEMPRE— va en `finally`. Puedes tener múltiples `catch` para dar respuestas específicas a cada tipo de error: no es lo mismo una división entre cero que un índice fuera de rango.

También aprenderás a crear tus PROPIAS excepciones. Cuando ninguna excepción predefinida captura bien tu error de negocio (ej: "SaldoInsuficienteException"), creas una clase que extiende `Exception` y la lanzas con `throw`. Esto hace tu código expresivo y semánticamente rico.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `TryCatchBasico.java` | Estructura básica try-catch | `try`, `catch`, `ArithmeticException`, `ArrayIndexOutOfBoundsException` |
| `MultiplesCatch.java` | Múltiples catch + finally + jerarquía | Catch específicos, `InputMismatchException`, `finally`, cierre de recursos |
| `FinallyBloque.java` | El bloque finally en detalle | `finally`, ejecución con y sin excepción, `return` + `finally` |
| `ExcepcionPersonalizada.java` | Creación y lanzamiento de excepciones propias | `extends Exception`, `throw`, `throws`, excepciones de negocio |
| `ThrowsEjemplo.java` | Propagación de excepciones en cadena | `throws`, delegación, cadena de llamadas |

## Ejemplo de salida esperada

Ejecutando `ExcepcionPersonalizada.java`:

```
=== Excepciones Personalizadas en Java ===

Cuenta: ES001
Saldo inicial: $500.00

Intentando retirar $200.00...
Retiro exitoso. Saldo actual: $300.00

Intentando retirar $1000.00...
ERROR: No se puede retirar $1000.0. Saldo disponible: $300.0
Saldo disponible: $300.00 — fondos insuficientes.

Programa finalizado. La cuenta no quedó en negativo.
```

## Tip profesional

> NUNCA dejes un bloque `catch` vacío. Un `catch (Exception e) {}` silencioso es uno de los peores pecados en programación: esconde errores, hace imposible depurar y da falsa sensación de que todo funciona. Como mínimo, imprime el stack trace durante desarrollo: `e.printStackTrace()`. En producción, registra el error en un log. Y recuerda: las excepciones son para situaciones EXCEPCIONALES, no las uses como control de flujo normal.
