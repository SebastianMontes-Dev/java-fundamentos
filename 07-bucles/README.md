# Sección 07 — Bucles (Loops)

## ¿Qué vas a aprender en esta sección?

Los bucles son el mecanismo que permite a una computadora hacer en segundos lo que a un humano le tomaría horas: REPETIR. Procesar mil registros, imprimir los primeros cien números pares, o mantener un menú funcionando hasta que el usuario decida salir —todo eso son bucles.

Java ofrece tres estructuras de repetición, cada una diseñada para un escenario distinto. `for` es el rey cuando sabes exactamente cuántas iteraciones necesitas (recorrer un arreglo, generar una secuencia). `while` es para cuando la condición de parada depende de algo externo (leer hasta que el archivo termine, esperar una respuesta del usuario). `do-while` garantiza que el bloque se ejecute al menos una vez —perfecto para menús.

El ejercicio del cajero automático (`MenuIterativo.java`) es probablemente el más importante de esta sección: combina `while` con una variable centinela booleana, `if-else if`, `Scanner` y operadores aritméticos en un solo programa. Si puedes leer y entender ese archivo, ya tienes las bases para construir aplicaciones de consola reales.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `CicloFor.java` | Bucle for clásico | Inicialización, condición, actualización, cuerpo |
| `CicloWhile.java` | Bucle while (condición al inicio) | Evaluación previa, post-incremento |
| `DoWhile.java` | Bucle do-while (condición al final) | Ejecución garantizada, punto y coma final |
| `NumerosParesWhile.java` | Filtro de pares con while e if | Módulo `%`, filtro dentro de bucle, Scanner |
| `MenuIterativo.java` | Cajero automático interactivo | Centinela booleano, text blocks, acumulador |

## Ejemplo de salida esperada

Ejecutando `MenuIterativo.java`:

```
*** Cajero Automático ***
Menú:
1. Saldo actual
2. Depositar dinero
3. Retirar dinero
4. Salir
Opción: 1
Saldo actual: $10000.00

*** Cajero Automático ***
Menú:
...
Opción: 4
Gracias por usar el cajero automático. ¡Hasta pronto!
```

## Tip profesional

> Tres cosas que salvan vidas con bucles: (1) siempre asegúrate de que la condición de parada sea ALCANZABLE, (2) evita modificar la variable de control dentro del cuerpo del for (confunde y es propenso a bugs), y (3) si necesitas eliminar elementos mientras iteras una colección, usa un `Iterator` en vez de un for-each. El for-each lanza `ConcurrentModificationException` si la colección se modifica durante la iteración.
