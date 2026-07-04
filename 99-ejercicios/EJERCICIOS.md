# Enunciados de Ejercicios

Intenta resolver cada ejercicio SIN mirar la solución. Usa `javac` y `java` para probar tu código.

---

## Nivel Básico

### 01 — Palíndromo
Escribe un programa que pida una palabra al usuario y determine si es un palíndromo (se lee igual al derecho y al revés). Ignora mayúsculas/minúsculas.

**Ejemplo:** "Reconocer" → true. "Hola" → false.

**Conceptos:** Strings, `charAt()`, bucles, `Scanner`.

---

### 02 — FizzBuzz
Imprime los números del 1 al 100. Pero:
- Si el número es múltiplo de 3, imprime "Fizz".
- Si es múltiplo de 5, imprime "Buzz".
- Si es múltiplo de ambos, imprime "FizzBuzz".
- En otro caso, imprime el número.

**Conceptos:** Bucles, condicionales, módulo `%`.

---

### 03 — Contador de vocales
Pide al usuario una frase y cuenta cuántas vocales (`a, e, i, o, u`) contiene. Ignora mayúsculas/minúsculas.

**Ejemplo:** "Hola Mundo" → 4 vocales.

**Conceptos:** Strings, `charAt()`, `Character.toLowerCase()`, contador.

---

### 04 — Número primo
Pide un número entero y determina si es primo. Un número es primo si solo es divisible por 1 y por sí mismo.

**Ejemplo:** 17 → true (primo). 15 → false (divisible por 3 y 5).

**Conceptos:** Bucles, módulo `%`, banderas `boolean`, optimización (solo hasta √n).

---

### 05 — Invertir número
Pide un número entero positivo y devuelve el número con sus dígitos invertidos.

**Ejemplo:** 12345 → 54321. 100 → 1.

**Conceptos:** Módulo `%`, división entera `/`, while.

---

### 06 — Tabla de multiplicar
Pide un número N al usuario e imprime su tabla de multiplicar del 1 al 10 con formato alineado.

**Ejemplo (N=7):**
```
7 x  1 =  7
7 x  2 = 14
...
7 x 10 = 70
```

**Conceptos:** Bucles for, `Scanner`, `printf()` o `String.format()`.

---

### 07 — Adivina el número
El programa genera un número aleatorio entre 1 y 100. El usuario intenta adivinarlo. Después de cada intento, el programa dice "más alto" o "más bajo". Al final muestra el número de intentos.

**Conceptos:** `Random`, `Scanner`, `do-while`, condicionales.

---

### 08 — Calculadora de IMC
Pide peso (kg) y altura (m). Calcula IMC = peso / (altura²). Clasifica según la OMS:
- < 18.5: Bajo peso
- 18.5 - 24.9: Normal
- 25 - 29.9: Sobrepeso
- >= 30: Obesidad

**Conceptos:** `Scanner`, `double`, condicionales anidados.

---

## Nivel Intermedio

### 09 — Ordenar arreglo (algoritmo burbuja)
Implementa el algoritmo de ordenamiento burbuja (Bubble Sort) manualmente, sin usar `Arrays.sort()`. Recibe un arreglo de enteros y devuélvelo ordenado de menor a mayor.

**Conceptos:** Arrays, bucles anidados, intercambio de variables (swap).

---

### 10 — Búsqueda binaria
Implementa la búsqueda binaria manualmente, sin usar `Arrays.binarySearch()`. Recibe un arreglo ORDENADO y un número a buscar. Devuelve el índice o -1 si no existe.

**Conceptos:** Arrays ordenados, while, índices `izquierda`/`derecha`, `medio`.

---

### 11 — Validador de contraseñas
Pide una contraseña y verifica que cumpla TODOS estos requisitos:
- Al menos 8 caracteres
- Al menos una mayúscula
- Al menos una minúscula
- Al menos un dígito
- Al menos un carácter especial (`!@#$%^&*`)

**Conceptos:** `Character.isUpperCase()`, `isLowerCase()`, `isDigit()`, expresiones regulares opcionales.

---

### 12 — Cifrado César
Implementa el cifrado César: desplaza cada letra N posiciones en el alfabeto. Si llegas a 'Z', vuelves a 'A'. Mantén mayúsculas/minúsculas y no modifiques caracteres que no sean letras.

**Ejemplo:** "Hola, Mundo!" con desplazamiento 3 → "Krod, Pxqgr!"

**Conceptos:** Strings, `char`, casting, módulo `%`, `Character.isLetter()`.

---

### 13 — Conversor de números romanos
Convierte un número romano (String) a número decimal (int). Soporta I=1, V=5, X=10, L=50, C=100, D=500, M=1000.

**Ejemplo:** "XIV" → 14. "MMXXVI" → 2026.

**Conceptos:** `HashMap`, Strings, bucles, lógica de resta (IV=4, IX=9).

---

### 14 — Serializador CSV manual
Crea una clase `Persona` con nombre, email y edad. Crea una lista de 5 personas. Genera un archivo CSV con cabecera y datos usando `StringBuilder` y `FileWriter`.

**Conceptos:** POO, `StringBuilder`, `FileWriter`, formato CSV, `try-with-resources`.

---

### 15 — Agenda de contactos CRUD
Crea un programa con menú interactivo que permita:
1. Agregar contacto (nombre, teléfono, email)
2. Buscar contacto por nombre
3. Listar todos los contactos
4. Eliminar contacto por nombre
5. Salir

Usa `ArrayList` para almacenar los contactos.

**Conceptos:** POO, `ArrayList`, `Scanner`, menú con `do-while`, `switch`.

---

### 16 — Contador de palabras en archivo
Lee un archivo de texto y cuenta cuántas veces aparece cada palabra (ignora mayúsculas/minúsculas y puntuación básica). Muestra las 10 palabras más frecuentes.

**Conceptos:** Archivos (`Scanner` con `File`), `HashMap`, `Collections.sort()`, expresiones regulares para limpiar.

---

### 17 — Fibonacci con memoización
Implementa Fibonacci (fib(0)=0, fib(1)=1, fib(n)=fib(n-1)+fib(n-2)) usando memoización con `HashMap`. Mide el tiempo para fib(45) con y sin memoización.

**Conceptos:** Recursividad, `HashMap` para caché, `System.nanoTime()`.

---

### 18 — Matriz identidad NxN
Pide un número N y genera una matriz identidad de NxN (1 en la diagonal principal, 0 en el resto) usando arrays bidimensionales.

**Ejemplo (N=4):**
```
1 0 0 0
0 1 0 0
0 0 1 0
0 0 0 1
```

**Conceptos:** Arrays 2D, bucles anidados, índice de diagonal.

---

## Nivel Avanzado

### 19 — Sistema bancario simple
Modela un sistema bancario con:
- Clase abstracta `Cuenta` (titular, saldo, depositar, retirar)
- Subclases: `CuentaAhorro` (tasa de interés, aplicarInteres()) y `CuentaCorriente` (sobregiro permitido)
- Excepción personalizada `SaldoInsuficienteException`
- Método `main` que demuestre depósitos, retiros y cálculo de interés

**Conceptos:** POO, herencia, clases abstractas, excepciones personalizadas, `BigDecimal` (opcional).

---

### 20 — Cola genérica (FIFO)
Implementa una clase genérica `Cola<T>` con los métodos `encolar(T elemento)`, `desencolar()` (devuelve y elimina el primero), `frente()` (devuelve sin eliminar), `estaVacia()` y `tamano()`.

Úsala con `Integer`, `String` y una clase propia.

**Conceptos:** Genéricos, `ArrayList`, interfaces, encapsulamiento.

---

### 21 — Ordenar objetos por múltiples campos
Crea una clase `Producto` (nombre, precio, calificación). Ordena una lista de productos por:
1. Categoría alfabéticamente
2. Luego por precio ascendente
3. Luego por calificación descendente

Usa `Comparator.comparing()` y `thenComparing()`. Muestra ANTES y DESPUÉS del ordenamiento.

**Conceptos:** `Comparable`, `Comparator`, `comparing()`, `thenComparing()`, `reversed()`, lambdas.

---

### 22 — Buscador de archivos recursivo
Escribe un programa que busque archivos recursivamente en un directorio. Parámetros: ruta del directorio y extensión del archivo (ej. `.java`). Muestra la ruta absoluta y el tamaño de cada archivo encontrado.

**Conceptos:** `java.nio.file.Files`, `Path`, recursividad, `Files.walk()` o recursión manual.

---

### 23 — Simulador de dados con hilos
Crea 3 hilos. Cada uno simula un dado (1-6). Los hilos "tiran" el dado cada segundo. El programa termina cuando los 3 dados muestran el mismo número. Usa `synchronized` para coordinar la verificación.

**Conceptos:** `Thread` / `Runnable`, `synchronized`, `Random`, `Thread.sleep()`.

---

### 24 — Mini ORM con JDBC
Crea una clase genérica `Repositorio<T>` que mapee objetos Java a una tabla SQL:
- `guardar(T entidad)` → INSERT
- `buscarPorId(Class<T>, Long id)` → SELECT
- `listarTodos(Class<T>)` → SELECT *
- Usa reflexión para leer campos anotados con `@Columna`

**Conceptos:** JDBC, genéricos, reflexión, anotaciones personalizadas, `PreparedStatement`.

---

### 25 — Analizador de logs con Streams
Procesa una lista de strings simulando líneas de log (`"[INFO] Usuario login exitoso"`, `"[ERROR] Conexión fallida"`, etc.). Usa Streams para:
1. Contar errores, warnings e infos
2. Filtrar solo errores y mostrarlos
3. Agrupar por nivel de log
4. Encontrar el mensaje de error más largo

**Conceptos:** Lambdas, Streams (`filter`, `map`, `collect`, `groupingBy`, `max`), `Collectors`.
