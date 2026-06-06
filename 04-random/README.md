# Sección 04 — Números Aleatorios (Random)

## ¿Qué vas a aprender en esta sección?

La aleatoriedad está en todas partes en el software: juegos (dados, loot boxes), seguridad (tokens, contraseñas temporales), simulaciones (Monte Carlo, testing), sorteos y hasta en la generación de IDs únicos. La clase `Random` de Java es tu herramienta para generar valores pseudoaleatorios de forma controlada.

El detalle más importante que debes grabar: **el límite superior es EXCLUSIVO**. `nextInt(10)` genera números del 0 al 9, NUNCA el 10. Este comportamiento es consistente en casi toda la API de Java (arrays, substrings, rangos) y entenderlo desde el principio evita los clásicos errores "off-by-one".

Para números aleatorios criptográficamente seguros (contraseñas, tokens de sesión), usarías `SecureRandom` en vez de `Random`. No lo cubrimos en esta sección básica, pero es importante saber que existe.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `NumeroAleatorio.java` | Generación de enteros y flotantes aleatorios | `nextInt(limite)`, `nextFloat(origen, limite)`, límite exclusivo |

## Ejemplo de salida esperada

```
Número entero aleatorio: 7
Número flotante aleatorio: 3.4521
```

(Los valores cambiarán cada vez que ejecutes el programa)

## Tip profesional

> Para generar un número aleatorio en un rango [min, max] (ambos inclusive), usa la fórmula: `min + random.nextInt(max - min + 1)`. Ejemplo: un dado (1-6) sería `1 + random.nextInt(6)`. Crea UNA sola instancia de Random y reutilízala; crear muchas instancias en poco tiempo puede producir secuencias menos aleatorias porque todas se inicializan con la misma semilla (el reloj del sistema).
