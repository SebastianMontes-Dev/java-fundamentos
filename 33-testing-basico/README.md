# Sección 33 — Testing con JUnit 5

## ¿Qué vas a aprender en esta sección?

Escribir código es una cosa; escribir código que SABES que funciona es otra. El testing automatizado es la red de seguridad que te permite dormir tranquilo después de hacer cambios. JUnit 5 es el framework de testing estándar para Java, usado en prácticamente todas las empresas y proyectos open source.

Aprenderás la estructura AAA (Arrange-Act-Assert), las anotaciones fundamentales (`@Test`, `@BeforeEach`, `@AfterEach`), los assertions más comunes (`assertEquals`, `assertTrue`, `assertThrows`), y la potencia de los tests parametrizados para probar el mismo método con múltiples entradas sin duplicar código. También verás cómo usar `@DisplayName` para hacer los reportes de test más legibles.

## Archivos de la sección

| Archivo | Descripción | Conceptos que enseña |
|---------|-------------|---------------------|
| `Calculadora.java` | Clase a testear (suma, resta, división con excepciones) | Código limpio y testeable, lanzar excepciones para casos inválidos |
| `TestCalculadora.java` | Tests unitarios con JUnit 5 | `@Test`, `@BeforeEach`, `assertEquals`, `assertThrows`, `@DisplayName`, `assertTrue`, nombres descriptivos |
| `TestParametrizado.java` | Tests parametrizados y edge cases | `@ParameterizedTest`, `@CsvSource`, `@ValueSource`, `@NullSource`, probar múltiples entradas |

## Cómo ejecutar los tests

Esta sección requiere **JUnit 5** en el classpath. La forma más fácil es usando un IDE (IntelliJ detecta JUnit automáticamente) o con el JAR standalone:

```bash
# 1. Descarga el JAR de JUnit 5 Console Launcher
# https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.0/

# 2. Compila todo
javac -cp junit-platform-console-standalone-1.10.0.jar Calculadora.java TestCalculadora.java

# 3. Ejecuta los tests
java -jar junit-platform-console-standalone-1.10.0.jar --class-path . --scan-class-path
```

## Ejemplo de salida esperada

```
[INFO] TestCalculadora:
[INFO]   ├─ suma de dos positivos da resultado correcto ✔
[INFO]   ├─ suma con cero como identidad ✔
[INFO]   ├─ división por cero lanza excepción ✔
[INFO]   ├─ resta con números negativos ✔
[INFO]
[INFO] TestParametrizado:
[INFO]   ├─ [1] 1+2=3
[INFO]   ├─ [2] -1+1=0
[INFO]   ├─ [3] 100+200=300
[INFO]
[INFO] Tests: 7, Passed: 7, Failed: 0
```

## Tip profesional

> El nombre del test es documentación viva. Nómbralo como `suma_conCero_retornaMismoNumero()` en vez de `testSuma1()`. Si un test falla dentro de 6 meses, el nombre te dice exactamente QUÉ se rompió y POR QUÉ. Sigue siempre AAA: Arrange (prepara datos), Act (ejecuta el método), Assert (verifica el resultado). Y recuerda: los tests NO cuestan tiempo, te AHORRAN tiempo. Cada bug que encuentra un test es un bug que no llega a producción.
