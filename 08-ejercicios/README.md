# Sección 08 — Ejercicios Aplicados

## ¿Qué vas a aprender en esta sección?

Los fundamentos aislados son necesarios, pero la magia ocurre cuando los COMBINAS. Esta sección contiene ejercicios que integran múltiples conceptos en programas con sentido práctico: generar un correo corporativo, crear un ID de usuario único, registrar empleados y recetas, y aplicar sistemas de descuento.

Aquí es donde empiezas a pensar como desarrollador: tomas un problema del mundo real y lo resuelves combinando las herramientas que ya conoces (Scanner, String, Random, condicionales, bucles). El objetivo no es solo que el código funcione, sino que entiendas cómo las piezas encajan entre sí.

Cada ejercicio está completamente documentado con comentarios que explican el PORQUÉ de cada decisión, no solo el qué. Esto es intencional: en el mundo laboral, el código se lee mucho más de lo que se escribe.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `TablaMultiplicar.java` | Genera tabla de multiplicar con entrada del usuario | `Scanner.nextInt()`, bucle `for`, `printf()` |
| `GeneradorEmail.java` | Construye correo corporativo desde nombre y empresa | `strip()`, `toLowerCase()`, `replace()`, concatenación |
| `GeneradorIdUsuario.java` | Genera ID único con iniciales, año y número aleatorio | `substring()`, `toUpperCase()`, `Random.nextInt()` |
| `RegistroEmpleado.java` | Registro de datos de empleado con tipos variados | `parseInt()`, `parseDouble()`, `parseBoolean()`, `\t` |
| `RegistroReceta.java` | Registro de receta de cocina | `nextLine()`, `parseDouble()`, formato tabulado |
| `VerificadorNumero.java` | Sistema de descuento escalonado según membresía | `&&`, `if-else if`, operador `%=` para descuento |

## Ejemplo de salida esperada

Ejecutando `GeneradorEmail.java`:

```
Nombre  : Ubaldo Acosta Soto
Empresa : Global Mentoring
Correo  : ubaldo.acosta.soto@globalmentoring.com.mx
```

## Tip profesional

> Cuando escribas código que pide datos al usuario, siempre asume que el usuario PUEDE equivocarse. En estos ejercicios no añadimos validación exhaustiva para mantener el foco en los conceptos, pero en un sistema real deberías validar cada entrada. Por ejemplo: ¿qué pasa si el usuario ingresa texto donde se espera un número? (Pista: `InputMismatchException`). Más adelante, en la sección de excepciones, aprenderás a manejar estos casos.
