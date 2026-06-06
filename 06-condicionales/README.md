# Sección 06 — Condicionales y Lógica Booleana

## ¿Qué vas a aprender en esta sección?

Hasta ahora tus programas ejecutaban todas las líneas, siempre, en orden. Los condicionales rompen esa linealidad: permiten que tu código TOME DECISIONES. "Si el usuario es mayor de edad, mostrar contenido; si no, mostrar advertencia". "Si el producto está en stock Y el pago fue aprobado, confirmar la compra". Este es el momento donde tus programas empiezan a tener comportamiento dinámico.

Cubrimos el espectro completo de decisiones en Java: desde el `if` simple hasta el `if-else if-else` para múltiples caminos, el `switch` para seleccionar entre muchos valores fijos, y el operador ternario `? :` para asignaciones condicionales compactas. También trabajamos los operadores lógicos `&&` (AND: todas las condiciones deben cumplirse) y `||` (OR: al menos una debe cumplirse), que son el pegamento que une condiciones complejas.

El `switch` merece mención especial: con Java 17 puedes usar tanto la sintaxis clásica (con `break`) como la nueva sintaxis de flecha (`case X ->`), más limpia y menos propensa al error de olvidar un `break`.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `SentenciaIf.java` | Condición simple: si se cumple, ejecuta | `if`, operador relacional `>=` |
| `CondicionalMultiple.java` | Múltiples condiciones en cascada | `if`, `else if`, `else`, orden de evaluación |
| `SentenciaSwitch.java` | Selección entre múltiples valores fijos | `switch`, `case`, `break`, `default` |
| `OperadorTernario.java` | If-else compacto en una línea | `? :`, asignación condicional concisa |
| `SistemaDescuentoVip.java` | Sistema de descuento con && (AND) | `&&`, tabla de verdad, dos condiciones |
| `SistemaPrestamoLibro.java` | Sistema de préstamo con \|\| (OR) | `\|\|`, préstamo si cumple al menos una |
| `ValidacionRango.java` | Validación de rango numérico | Constantes `final`, `&&`, `>=`, `<=`, `var` |

## Ejemplo de salida esperada

Ejecutando `SentenciaSwitch.java`:

```
Ingrese el número de día (1 = Lunes, 2 = Martes, ...): 3

Día miércoles - Mitad de semana
```

## Tip profesional

> Los condicionales tienden a ANIDARSE y volverse ilegibles rápido. Cuando tengas más de 3 niveles de anidación, considera extraer la lógica a un método separado o usar un enfoque diferente (patrón Strategy, mapa de opciones, etc.). Un `if` plano y profundo es una bandera roja en revisiones de código. Y recuerda: `switch` es más rápido que múltiples `if-else if` cuando tienes muchos casos, porque el compilador puede optimizarlo con tablas de salto.
