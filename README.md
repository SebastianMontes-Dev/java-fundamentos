# Java Fundamentos: Guía de Aprendizaje Práctica

[![Java 17+](https://img.shields.io/badge/Java-17%2B-orange?logo=openjdk&logoColor=white)](https://adoptium.net/)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Estado: En desarrollo activo](https://img.shields.io/badge/Estado-En%20desarrollo%20activo-brightgreen)]()
[![PRs Welcome](https://img.shields.io/badge/PRs-Welcome-ff69b4.svg)](https://github.com/SebastianMontes-Dev/java-fundamentos/pulls)

> La guía definitiva para aprender Java desde cero, construida con ejercicios reales y documentación en español. Cada archivo `.java` es una lección independiente que explica un concepto, su sintaxis, errores comunes y aplicación práctica. Pensada para principiantes que quieren un mapa claro y para universitarios que necesitan reforzar fundamentos con ejemplos que funcionan.

---

## ¿Para quién es esto?

Estás empezando con Java y te pierdes entre tutoriales que asumen demasiado o son demasiado básicos. Este repositorio recorre el camino completo: desde tu primer `System.out.println()` hasta interfaces, colecciones y manejo de archivos. Cada sección contiene archivos listos para compilar y ejecutar, documentados línea por línea en español, como si tuvieras un mentor explicándote cada detalle.

Si eres estudiante universitario de ingeniería informática, autodidacta o vienes de otro lenguaje, aquí encontrarás una ruta clara, progresiva y sin saltos.

---

## Mapa de Aprendizaje

| # | Sección | Tema | Archivos | Concepto Principal |
|---|---------|------|----------|-------------------|
| 01 | [01-cadenas](./01-cadenas/) | Manipulación de Strings | 6 | `length()`, `charAt()`, `substring()`, `equals()`, `replace()`, `indexOf()` |
| 02 | [02-ejercicios](./02-ejercicios/) | Ejercicios Aplicados | 6 | Integración de Scanner, cadenas, bucles y números aleatorios |
| 03 | [03-scanner](./03-scanner/) | Entrada de Datos por Consola | 2 | `nextLine()`, `nextInt()`, `nextDouble()`, `Integer.parseInt()` |
| 04 | [04-random](./04-random/) | Números Aleatorios | 1 | `Random.nextInt()`, `nextFloat()`, límites exclusivos |
| 05 | [05-operadores](./05-operadores/) | Operadores | 4 | Aritméticos, unitarios (++a vs a++), compuestos (+=), aplicación práctica |
| 06 | [06-condicionales](./06-condicionales/) | Condicionales | 7 | `if`, `else-if`, `switch`, operador ternario, `&&`, `\|\|` |
| 07 | [07-bucles](./07-bucles/) | Bucles | 5 | `for`, `while`, `do-while`, centinelas, menú interactivo |
| 08 | [08-arrays](./08-arrays/) | Arreglos (Arrays) | 4 | Declaración, inicialización, índices, recorrido con `for`, `Scanner` + arrays |
| 09 | [09-metodos](./09-metodos/) | Métodos | 1 | Declaración, parámetros, `static`, `void`, invocación desde `main` |
| 10 | [10-poo-basica](./10-poo-basica/) | POO Básica | 5 | Clases, objetos, constructores, `this`, encapsulamiento, getters/setters |
| 11 | [11-herencia](./11-herencia/) | Herencia y Polimorfismo | 5 | `extends`, `@Override`, polimorfismo, interfaces, clases abstractas |
| 12 | [12-excepciones](./12-excepciones/) | Excepciones | 5 | `try-catch`, múltiples `catch`, `finally`, excepciones personalizadas, `throws` |
| 13 | [13-colecciones](./13-colecciones/) | Colecciones | 5 | `ArrayList`, `HashMap`, `LinkedList`, `Iterator`, `HashSet` |
| 14 | [14-archivos](./14-archivos/) | Archivos | 3 | `File`, `Scanner` con archivos, `FileWriter`, `BufferedReader` |

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

1. **[03-scanner](./03-scanner/)** — Aprende a leer datos del usuario (tu primer programa interactivo)
2. **[01-cadenas](./01-cadenas/)** — Domina el procesamiento de texto con la clase String
3. **[05-operadores](./05-operadores/)** — Aritmética, comparaciones y asignaciones
4. **[06-condicionales](./06-condicionales/)** — Toma de decisiones con if, else-if, switch
5. **[04-random](./04-random/)** — Genera valores aleatorios
6. **[07-bucles](./07-bucles/)** — Repite tareas con for, while, do-while
7. **[02-ejercicios](./02-ejercicios/)** — Pon en práctica todo lo anterior con ejercicios integrados
8. **[08-arrays](./08-arrays/)** — Almacena múltiples valores en arreglos
9. **[09-metodos](./09-metodos/)** — Organiza tu código en bloques reutilizables
10. **[10-poo-basica](./10-poo-basica/)** — Clases, objetos, constructores y encapsulamiento
11. **[11-herencia](./11-herencia/)** — Herencia, polimorfismo, interfaces y clases abstractas
12. **[12-excepciones](./12-excepciones/)** — Escribe código robusto que no crashea
13. **[13-colecciones](./13-colecciones/)** — Listas dinámicas, mapas, conjuntos
14. **[14-archivos](./14-archivos/)** — Lee y escribe archivos en disco

---

## Conceptos Cubiertos

- [x] Variables, tipos de datos y operadores
- [x] Entrada y salida por consola con Scanner
- [x] Manipulación de cadenas (String)
- [x] Estructuras condicionales (if, else-if, switch, ternario)
- [x] Operadores lógicos (&&, ||) y relacionales
- [x] Bucles (for, while, do-while) y centinelas
- [x] Arreglos unidimensionales y bidimensionales
- [x] Métodos, parámetros, retorno y sobrecarga
- [x] Programación Orientada a Objetos: clases, objetos, constructores, this, encapsulamiento
- [x] Herencia, sobrescritura (@Override), polimorfismo
- [x] Interfaces y clases abstractas
- [x] Manejo de excepciones (try-catch, finally, excepciones personalizadas)
- [x] Colecciones (ArrayList, LinkedList, HashMap, HashSet)
- [x] Lectura y escritura de archivos (FileWriter, BufferedReader)
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
