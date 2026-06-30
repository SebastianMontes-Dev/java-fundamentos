# Java Fundamentos: Guía de Aprendizaje Práctica

[![Java 17+](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk&logoColor=white)](https://adoptium.net/)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Estado: En desarrollo activo](https://img.shields.io/badge/Estado-En%20desarrollo%20activo-brightgreen)]()
[![PRs Welcome](https://img.shields.io/badge/PRs-Welcome-ff69b4.svg)](https://github.com/SebastianMontes-Dev/java-fundamentos/pulls)

> La guía definitiva para aprender Java desde cero, construida con ejercicios reales y documentación en español. Cada archivo `.java` es una lección independiente que explica un concepto, su sintaxis, errores comunes y aplicación práctica. Pensada para principiantes que quieren un mapa claro y para universitarios que necesitan reforzar fundamentos con ejemplos que funcionan.

---

## ¿Para quién es esto?

Estás empezando con Java y te pierdes entre tutoriales que asumen demasiado o son demasiado básicos. Este repositorio recorre el camino completo con 33 secciones: desde tipos primitivos y variables hasta Java moderno (records, pattern matching) y testing con JUnit. Cada sección contiene archivos listos para compilar y ejecutar, documentados línea por línea en español, como si tuvieras un mentor explicándote cada detalle.

Si eres estudiante universitario de ingeniería informática, autodidacta o vienes de otro lenguaje, aquí encontrarás una ruta clara, progresiva y sin saltos.

---

## Mapa de Aprendizaje

| # | Sección | Tema | Archivos | Concepto Principal |
|---|---------|------|----------|-------------------|
| 01 | [01-tipos-primitivos](./01-tipos-primitivos/) | Tipos Primitivos y Wrappers | 3 | `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`, casting, autoboxing |
| 02 | [02-cadenas](./02-cadenas/) | Manipulación de Strings | 6 | `length()`, `charAt()`, `substring()`, `equals()`, `replace()`, `indexOf()` |
| 03 | [03-scanner](./03-scanner/) | Entrada de Datos por Consola | 2 | `nextLine()`, `nextInt()`, `nextDouble()`, `Integer.parseInt()` |
| 04 | [04-random](./04-random/) | Números Aleatorios | 1 | `Random.nextInt()`, `nextFloat()`, límites exclusivos |
| 05 | [05-operadores](./05-operadores/) | Operadores | 4 | Aritméticos, unitarios (++a vs a++), compuestos (+=), aplicación práctica |
| 06 | [06-condicionales](./06-condicionales/) | Condicionales | 7 | `if`, `else-if`, `switch`, operador ternario, `&&`, `\|\|` |
| 07 | [07-bucles](./07-bucles/) | Bucles | 5 | `for`, `while`, `do-while`, centinelas, menú interactivo |
| 08 | [08-ejercicios](./08-ejercicios/) | Ejercicios Aplicados | 6 | Integración de Scanner, cadenas, bucles y números aleatorios |
| 09 | [09-arrays](./09-arrays/) | Arreglos (Arrays) | 4 | Declaración, inicialización, índices, recorrido con `for`, `Scanner` + arrays |
| 10 | [10-metodos](./10-metodos/) | Métodos | 3 | Declaración, parámetros, `static`, `void`, invocación desde `main` |
| 11 | [11-static-final](./11-static-final/) | Static y Final | 3 | Variables/métodos `static`, bloques, constantes `final` |
| 12 | [12-utilidades-java](./12-utilidades-java/) | Utilidades de Java | 4 | `Math`, `Arrays`, `Collections`, `Character`, `System` — métodos que simplifican |
| 13 | ⏳ Recursividad | Recursividad | 3 | Factorial, Fibonacci, Torres de Hanoi |
| 14 | ⏳ Arrays 2D | Matrices (Arrays 2D) | 3 | Declaración, recorrido, operaciones, arrays escalonados |
| 15 | [15-poo-basica](./15-poo-basica/) | POO Básica | 9 | Clases, objetos, constructores, `this`, encapsulamiento, getters/setters |
| 16 | [16-herencia](./16-herencia/) | Herencia y Polimorfismo | 5 | `extends`, `@Override`, polimorfismo, interfaces, clases abstractas |
| 17 | ⏳ Clases Internas | Clases Internas | 3 | Static nested, inner classes, anónimas y locales |
| 18 | [18-excepciones](./18-excepciones/) | Excepciones | 5 | `try-catch`, múltiples `catch`, `finally`, excepciones personalizadas, `throws` |
| 19 | [19-colecciones](./19-colecciones/) | Colecciones | 5 | `ArrayList`, `HashMap`, `LinkedList`, `Iterator`, `HashSet` |
| 20 | ⏳ StringBuilder y Regex | StringBuilder y Regex | 3 | `append()`, `insert()`, `Pattern`, `Matcher` |
| 21 | ⏳ Ordenamiento | Ordenamiento y Optional | 3 | `Comparable`, `Comparator`, `Optional<T>` |
| 22 | [22-archivos](./22-archivos/) | Archivos | 3 | `File`, `Scanner` con archivos, `FileWriter`, `BufferedReader` |
| 23 | [23-enums](./23-enums/) | Enums | 3 | Declaración, atributos, constructores, switch |
| 24 | [24-genericos](./24-genericos/) | Genéricos | 3 | Clases genéricas, métodos, comodines (wildcards), PECS |
| 25 | [25-lambdas-streams](./25-lambdas-streams/) | Expresiones Lambda y Streams | 3 | Interfaces funcionales, filter, map, reduce |
| 26 | [26-programacion-funcional](./26-programacion-funcional/) | Programación Funcional | 3 | Predicate, Function, referencias a métodos, composición |
| 27 | [27-fechas-tiempo](./27-fechas-tiempo/) | Fechas y Tiempo | 3 | `LocalDate`, `LocalDateTime`, `DateTimeFormatter`, `Duration` |
| 28 | [28-concurrencia](./28-concurrencia/) | Concurrencia y Multihilos | 3 | `Thread`, `Runnable`, `synchronized`, `CompletableFuture` |
| 29 | [29-bases-de-datos](./29-bases-de-datos/) | Bases de Datos (JDBC) | 3 | `Connection`, `PreparedStatement`, `ResultSet`, transacciones |
| 30 | [30-patrones-diseno](./30-patrones-diseno/) | Patrones de Diseño | 3 | Singleton, Factory, Builder |
| 31 | [31-anotaciones-reflexion](./31-anotaciones-reflexion/) | Anotaciones y Reflexión | 3 | `@Retention`, `@Target`, API `Class`, métodos dinámicos |
| 32 | ⏳ Java Moderno | Java Moderno (14-17) | 4 | `var`, switch expressions, text blocks, records, pattern matching |
| 33 | ⏳ Testing | Testing con JUnit | 3 | `@Test`, assertions, parametrizados |

---

## Cómo Usar Este Repositorio

### Desde la terminal

```bash
# 1. Clona el repositorio
git clone https://github.com/SebastianMontes-Dev/java-fundamentos.git
cd java-fundamentos

# 2. Muévete a la sección que quieras estudiar
cd 01-cadenas

# 3. Compila el archivo que te interese
javac BuscarSubcadenas.java

# 4. Ejecútalo
java BuscarSubcadenas
```

### Desde IntelliJ IDEA

1. Abre IntelliJ y selecciona **File → Open**
2. Navega hasta la carpeta `java-fundamentos` y ábrela
3. En el panel izquierdo, expande la sección que quieras estudiar (ej: `01-cadenas`)
4. Haz clic derecho sobre cualquier archivo `.java` y elige **Run 'NombreDelArchivo.main()'**

Cada archivo es completamente independiente. No necesitas herramientas externas, Maven, Gradle ni dependencias adicionales. Solo Java 17+.

---

## Ruta de Aprendizaje Sugerida

Estudia las secciones en este orden. Cada una construye sobre lo aprendido en la anterior:

1. **[01-tipos-primitivos](./01-tipos-primitivos/)** — Conoce los 8 tipos de datos, casting y wrappers
2. **[02-cadenas](./02-cadenas/)** — Domina el procesamiento de texto con la clase String
3. **[03-scanner](./03-scanner/)** — Aprende a leer datos del usuario (tu primer programa interactivo)
4. **[04-random](./04-random/)** — Genera valores aleatorios
5. **[05-operadores](./05-operadores/)** — Aritmética, comparaciones y asignaciones
6. **[06-condicionales](./06-condicionales/)** — Toma de decisiones con if, else-if, switch
7. **[07-bucles](./07-bucles/)** — Repite tareas con for, while, do-while
8. **[08-ejercicios](./08-ejercicios/)** — Pon en práctica todo lo anterior con ejercicios integrados
9. **[09-arrays](./09-arrays/)** — Almacena múltiples valores en arreglos
10. **[10-metodos](./10-metodos/)** — Organiza tu código en bloques reutilizables
11. **[11-static-final](./11-static-final/)** — Variables de clase, constantes y bloques static
12. **[12-utilidades-java](./12-utilidades-java/)** — Math, Arrays, Collections: los atajos que todo dev debe conocer
13. **⏳ Recursividad** — Resuelve problemas con funciones que se llaman a sí mismas
14. **⏳ Arrays 2D** — Matrices, tablas y arrays multidimensionales
15. **[15-poo-basica](./15-poo-basica/)** — Clases, objetos, constructores y encapsulamiento
16. **[16-herencia](./16-herencia/)** — Herencia, polimorfismo, interfaces y clases abstractas
17. **⏳ Clases Internas** — Clases dentro de clases: static, miembro, anónimas
18. **[18-excepciones](./18-excepciones/)** — Escribe código robusto que no crashea
19. **[19-colecciones](./19-colecciones/)** — Listas dinámicas, mapas, conjuntos
20. **⏳ StringBuilder y Regex** — Concatenación eficiente y expresiones regulares
21. **⏳ Ordenamiento** — Comparable, Comparator y Optional para evitar nulls
22. **[22-archivos](./22-archivos/)** — Lee y escribe archivos en disco
23. **[23-enums](./23-enums/)** — Representa conjuntos fijos de constantes
24. **[24-genericos](./24-genericos/)** — Crea código reutilizable y seguro con tipos
25. **[25-lambdas-streams](./25-lambdas-streams/)** — Escribe código conciso y procesa colecciones
26. **[26-programacion-funcional](./26-programacion-funcional/)** — Domina funciones, predicados y composición
27. **[27-fechas-tiempo](./27-fechas-tiempo/)** — Maneja de forma moderna fechas, horas y zonas horarias
28. **[28-concurrencia](./28-concurrencia/)** — Ejecuta múltiples tareas a la vez sin errores
29. **[29-bases-de-datos](./29-bases-de-datos/)** — Conecta tu código con bases de datos usando JDBC
30. **[30-patrones-diseno](./30-patrones-diseno/)** — Resuelve problemas comunes con arquitectura probada
31. **[31-anotaciones-reflexion](./31-anotaciones-reflexion/)** — Entiende la "magia" detrás de frameworks como Spring Boot
32. **⏳ Java Moderno** — var, switch expressions, records, text blocks
33. **⏳ Testing con JUnit** — Escribe pruebas unitarias como un profesional

---

## Conceptos Cubiertos

- [x] Tipos primitivos, casting, wrappers y autoboxing
- [x] Variables, tipos de datos y operadores
- [x] Entrada y salida por consola con Scanner
- [x] Manipulación de cadenas (String)
- [x] Estructuras condicionales (if, else-if, switch, ternario)
- [x] Operadores lógicos (&&, ||) y relacionales
- [x] Bucles (for, while, do-while) y centinelas
- [x] Arreglos unidimensionales
- [x] Métodos, parámetros, retorno y sobrecarga
- [x] Static, final, bloques de inicialización y constantes
- [x] Clases utilitarias: Math, Arrays, Collections, Character, System
- [ ] Recursividad: factorial, Fibonacci, Torres de Hanoi
- [ ] Arreglos bidimensionales (matrices) y arrays escalonados
- [x] Programación Orientada a Objetos: clases, objetos, constructores, this, encapsulamiento
- [x] Herencia, sobrescritura (@Override), polimorfismo
- [x] Interfaces y clases abstractas
- [ ] Clases internas: static nested, miembro, anónimas, locales
- [x] Manejo de excepciones (try-catch, finally, excepciones personalizadas)
- [x] Colecciones (ArrayList, LinkedList, HashMap, HashSet)
- [ ] StringBuilder, StringBuffer y expresiones regulares (Regex)
- [ ] Comparable, Comparator y Optional&lt;T&gt;
- [x] Lectura y escritura de archivos (FileWriter, BufferedReader)
- [x] Enumeraciones (Enums) con atributos y métodos
- [x] Tipos Genéricos, métodos genéricos y comodines (Wildcards)
- [x] Expresiones Lambda y API Streams (filter, map, reduce)
- [x] Programación Funcional en Java (Interfaces funcionales, referencias de métodos)
- [x] Manejo de Fechas y Tiempos con API `java.time`
- [x] Concurrencia, hilos, sincronización y programación asíncrona
- [x] Conexión a bases de datos con JDBC, CRUD y Transacciones
- [x] Patrones de Diseño Creacionales (Singleton, Factory, Builder)
- [x] Creación de Anotaciones Personalizadas y uso de API de Reflexión
- [ ] Java Moderno: var, switch expressions, text blocks, records, pattern matching
- [ ] Testing con JUnit 5
- [x] Buenas prácticas: PascalCase, camelCase, nombres descriptivos, cierre de recursos

---

## Requisitos

| Componente | Versión Mínima | Enlace |
|-----------|---------------|--------|
| Java (JDK) | 17 o superior | [Adoptium](https://adoptium.net/) |
| IDE recomendado | IntelliJ IDEA Community Edition | [JetBrains](https://www.jetbrains.com/idea/download/) |
| Git (opcional) | Cualquier versión reciente | [git-scm.com](https://git-scm.com/) |

---

## Autor

Creado y mantenido con dedicación por **[SebastianMontes-Dev](https://github.com/SebastianMontes-Dev)**.

Cada archivo fue escrito y documentado como parte de un proceso real de aprendizaje. Si este material te ayudó, una estrella en el repositorio es la mejor forma de agradecerlo.

---

**Licencia MIT** — Eres libre de usar, modificar y compartir este material. Atribución es bienvenida pero no obligatoria.
