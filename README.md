# Java Fundamentos

Colección de ejercicios prácticos para aprender los fundamentos de programación en Java.
Cada ejercicio está comentado y enfocado en un concepto específico del lenguaje.

---

## Estructura del proyecto

```
java-fundamentos/
├── 01-cadenas/          # Métodos de la clase String
│   ├── BuscarSubcadenas.java
│   ├── CaracterEnCadena.java
│   ├── ComparacionCadenas.java
│   ├── ManejoSubcadena.java
│   ├── MetodosCadenas.java
│   └── ReemplazarSubcadenas.java
├── 02-ejercicios/       # Ejercicios aplicados
│   ├── TablaMultiplicar.java
│   ├── GeneradorEmail.java
│   ├── RegistroEmpleado.java
│   ├── GeneradorIdUsuario.java
│   └── RegistroReceta.java
├── 03-scanner/          # Lectura de datos con Scanner
│   ├── EntradaConsola.java
│   └── LecturaTiposDatos.java
└── 04-random/           # Números aleatorios con Random
    └── NumeroAleatorio.java
```

---

## Temas

### 01 - Manipulación de Cadenas (`String`)

Ejercicios sobre los métodos más usados de la clase `String` en Java.

| Archivo | Concepto | Métodos |
|---------|----------|---------|
| `BuscarSubcadenas.java` | Buscar subcadenas | `indexOf()`, `lastIndexOf()` |
| `CaracterEnCadena.java` | Acceder a caracteres | `charAt()`, `length()` |
| `ComparacionCadenas.java` | Comparar cadenas | `equals()`, `equalsIgnoreCase()` |
| `ManejoSubcadena.java` | Extraer partes | `substring()`, `length()` |
| `MetodosCadenas.java` | Métodos generales | `replace()`, `toUpperCase()`, `toLowerCase()`, `trim()` |
| `ReemplazarSubcadenas.java` | Reemplazar texto | `replace()` |

### 02 - Ejercicios Aplicados

Ejercicios que combinan múltiples conceptos en un caso de uso real.

| Archivo | Descripción |
|---------|-------------|
| `TablaMultiplicar.java` | Genera una tabla de multiplicar con entrada del usuario y un bucle `for` |
| `GeneradorEmail.java` | Construye un correo corporativo manipulando cadenas |
| `RegistroEmpleado.java` | Registro de datos de un empleado con distintos tipos de datos |
| `GeneradorIdUsuario.java` | Genera un ID único combinando iniciales, año de nacimiento y un número aleatorio |
| `RegistroReceta.java` | Registro de receta de cocina con nombre, ingredientes, tiempo y dificultad |

### 03 - Lectura de datos con `Scanner`

Ejercicios enfocados en la entrada de datos por consola usando la clase `Scanner`.

| Archivo | Concepto | Métodos |
|---------|----------|---------|
| `EntradaConsola.java` | Lectura básica de cadenas | `nextLine()` |
| `LecturaTiposDatos.java` | Lectura de distintos tipos | `nextInt()`, `nextDouble()`, `nextLine()`, `Integer.parseInt()` |

### 04 - Números aleatorios con `Random`

Ejercicios sobre generación de valores pseudoaleatorios con la clase `Random`.

| Archivo | Concepto | Métodos |
|---------|----------|---------|
| `NumeroAleatorio.java` | Enteros y flotantes aleatorios | `nextInt(limite)`, `nextFloat(origen, limite)` |

---

## Cómo ejecutar

Cada archivo es independiente. Para compilar y ejecutar cualquier ejercicio desde la terminal:

```bash
# Moverse a la carpeta del ejercicio
cd 01-cadenas

# Compilar
javac BuscarSubcadenas.java

# Ejecutar
java BuscarSubcadenas
```

---

## Requisitos

- Java 17 o superior
- JDK instalado ([descargar aquí](https://adoptium.net/))
- IDE recomendado: IntelliJ IDEA / VS Code / Eclipse
