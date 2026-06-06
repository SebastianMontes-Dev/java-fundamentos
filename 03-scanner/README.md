# Sección 03 — Entrada de Datos por Consola (Scanner)

## ¿Qué vas a aprender en esta sección?

Hasta ahora, si querías que tu programa hiciera algo diferente, tenías que cambiar el código y volver a compilar. Eso no escala. `Scanner` es la puerta de entrada a la **interactividad**: permite que tu programa lea lo que el usuario escribe en la consola y actúe en consecuencia.

Pero Scanner tiene una curva de aprendizaje inesperada. El problema más común —y el que más horas de debugging consume a principiantes— es el "salto de línea pendiente": cuando mezclas `nextInt()` o `nextDouble()` con `nextLine()`, el salto de línea que deja el método numérico es leído por el siguiente `nextLine()`, dando la impresión de que "se salta una pregunta". Esta sección te enseña ambos enfoques (directo y robusto) para que nunca pierdas tiempo con este bug.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `EntradaConsola.java` | Lectura básica de texto con Scanner | `new Scanner(System.in)`, `nextLine()`, `close()` |
| `LecturaTiposDatos.java` | Lectura de enteros, decimales y texto | `nextInt()`, `nextDouble()`, `parseInt()`, limpieza de buffer |

## Ejemplo de salida esperada

Ejecutando `EntradaConsola.java`:

```
Ingrese su nombre: Sebastián
Su nombre es: Sebastián
```

## Tip profesional

> Acostúmbrate a usar el ENFOQUE ROBUSTO desde el principio: lee SIEMPRE con `nextLine()` y convierte manualmente con `Integer.parseInt()`, `Double.parseDouble()`, etc. Este hábito te ahorrará años de frustración. El enfoque directo (`nextInt()`) es más corto pero frágil. En producción, el código robusto siempre gana.
