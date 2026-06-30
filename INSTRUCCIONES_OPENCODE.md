# Instrucciones para OpenCode - Proyecto Java Fundamentos

> **Lee este archivo cuando el usuario diga:** _"sube los cambios", "actualiza el repo", "revisa el proyecto", "organiza los .java", "sincroniza con GitHub", etc._

---

## 1. Verificar cuenta de Git

```powershell
git config --global user.name
git config --global user.email
```

**Cuenta esperada:**
- Nombre: `Sebastian Montes Olivera`
- Email: `sebastianmontesolivera@gmail.com`

---

## 2. Ubicaciones importantes

| Qué | Ruta |
|---|---|
| Carpeta local del proyecto | `C:\Users\sabas\Documentos\Proyectos_java` |
| Repo remoto | `https://github.com/SebastianMontes-Dev/java-fundamentos` |
| Carpeta temporal para clonar | `C:\Users\sabas\AppData\Local\Temp\opencode\java-fundamentos` |

---

## 3. Clonar el repositorio (si no existe en temp)

```powershell
git clone https://github.com/SebastianMontes-Dev/java-fundamentos "C:\Users\sabas\AppData\Local\Temp\opencode\java-fundamentos"
```

---

## 4. Comparar archivos locales vs repositorio

### Opción A — Usar robocopy (dry-run, más rápido)

```powershell
robocopy "C:\Users\sabas\Documentos\Proyectos_java" "C:\Users\sabas\AppData\Local\Temp\opencode\java-fundamentos" /E /XF *.class /XD .git /L | Select-String -Pattern "(Nuevo arch|EXTRA|Anterior)"
```

- `Nuevo arch` = archivos en local que NO están en el repo (hay que subirlos)
- `EXTRA` = archivos en el repo que NO están en local
- `Anterior` = archivos con versión más vieja en local que en el repo

### Opción B — Copiar todo al repo clone y hacer git diff

```powershell
robocopy "C:\Users\sabas\Documentos\Proyectos_java" "C:\Users\sabas\AppData\Local\Temp\opencode\java-fundamentos" /E /XO /XF *.class /XD .git
```

Luego dentro del repo clone:
```bash
git status
git diff --stat
```

---

## 5. Estilo de comentarios (formato del repo)

Todos los archivos `.java` deben seguir este formato de comentario al inicio:

```java
/**
 * ============================================================
 *  TEMA: [título del tema]
 *  SECCIÓN: [número] — [nombre sección]
 *  ARCHIVO: [NombreArchivo.java]
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  [Explicación de 3-5 líneas]
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - [concepto 1]
 *  - [concepto 2]
 *  - [concepto 3]
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  [ejemplo de código]
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - [error 1]
 *  - [error 2]
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: [URL]
 * ============================================================
 */
```

**Reglas de nombres:**
- Archivos: `PascalCase.java` (ej: `FuncionSumar.java`, `AritmeticaPoo.java`)
- Variables/métodos: `camelCase` (ej: `resultadoSuma`, `confirmarPar()`)
- Siempre cerrar `Scanner` con `sc.close()`
- Usar `@param` y `@return` en Javadoc de métodos

---

## 6. Organización de carpetas

| Carpeta | Tema | Qué va aquí |
|---|---|---|
| `01-cadenas/` | Manejo de Strings | substring, indexOf, replace, equals |
| `02-ejercicios/` | Ejercicios integradores | Varios temas combinados |
| `03-scanner/` | Entrada de consola | Scanner, nextInt, nextLine |
| `04-random/` | Números aleatorios | Random, Math.random |
| `05-operadores/` | Operadores | Aritméticos, unitarios, compuestos |
| `06-condicionales/` | Condicionales | if, else, switch, ternario |
| `07-bucles/` | Bucles | for, while, do-while |
| `08-arrays/` | Arreglos | Declaración, iteración, introducción |
| `09-metodos/` | Métodos/Funciones | static, return, parámetros, boolean |
| `10-poo-basica/` | POO Básica | Clases, objetos, atributos, métodos de instancia |
| `11-herencia/` | Herencia | extends, abstract, interfaces, polimorfismo |
| `12-excepciones/` | Excepciones | try-catch, finally, throw, throws |
| `13-colecciones/` | Colecciones | ArrayList, HashMap, HashSet, LinkedList |
| `14-archivos/` | Archivos | FileReader, FileWriter, BufferedReader |

---

## 7. Procesar archivos nuevos NO comentados

Cuando encuentres `.java` nuevos sin comentar:

1. Leer el archivo para entender qué hace
2. Identificar a qué carpeta pertenece según la tabla de arriba
3. Escribir la versión comentada **directamente en el repo clone** con el formato correcto
4. Mejorar nombres de variables/métodos si es necesario (camelCase)
5. Agregar `sc.close()` si usa Scanner

---

## 8. Subir cambios a GitHub

```bash
# Dentro de C:\Users\sabas\AppData\Local\Temp\opencode\java-fundamentos

git status
git add .
git commit -m "Mensaje descriptivo de los cambios"
git push origin main
```

---

## 9. Sincronizar carpeta local con el repositorio

Después de subir, para que la carpeta local quede igual que el repo:

```powershell
# Eliminar archivos .class compilados
Get-ChildItem -LiteralPath "C:\Users\sabas\Documentos\Proyectos_java" -Recurse -File -Filter "*.class" | Remove-Item -Force

# Eliminar archivos .java sueltos en la raíz (ya fueron movidos a sus carpetas)
# Solo deberían quedar .gitignore y README.md en la raíz

# Copiar los nuevos archivos comentados del repo clone al local
Copy-Item -LiteralPath "C:\Users\sabas\AppData\Local\Temp\opencode\java-fundamentos\XX-carpeta\Archivo.java" -Destination "C:\Users\sabas\Documentos\Proyectos_java\XX-carpeta\Archivo.java"
```

---

## 10. Verificación final

```powershell
# La raíz solo debe tener .gitignore y README.md
Get-ChildItem -LiteralPath "C:\Users\sabas\Documentos\Proyectos_java" -File

# Sin archivos .class en ninguna carpeta
Get-ChildItem -LiteralPath "C:\Users\sabas\Documentos\Proyectos_java" -Recurse -File -Filter "*.class"

# Comparar local vs repo (debe salir vacío = sincronizados)
robocopy "C:\Users\sabas\Documentos\Proyectos_java" "C:\Users\sabas\AppData\Local\Temp\opencode\java-fundamentos" /E /XF *.class /XD .git /L | Select-String -Pattern "(Nuevo arch|EXTRA)"
```

---

## 11. Archivos actuales en el repo (referencia)

```
01-cadenas/          BuscarSubcadenas.java, CaracterEnCadena.java, ComparacionCadenas.java,
                     ManejoSubcadena.java, MetodosCadenas.java, ReemplazarSubcadenas.java
02-ejercicios/       GeneradorEmail.java, GeneradorIdUsuario.java, RegistroEmpleado.java,
                     RegistroReceta.java, TablaMultiplicar.java, VerificadorNumero.java
03-scanner/          EntradaConsola.java, LecturaTiposDatos.java
04-random/           NumeroAleatorio.java
05-operadores/       OperadoresAritmeticos.java, OperadoresUnitarios.java,
                     OperadorSimpleYCompuesto.java, TicketVenta.java
06-condicionales/    CondicionalMultiple.java, OperadorTernario.java, SentenciaIf.java,
                     SentenciaSwitch.java, SistemaDescuentoVip.java, SistemaPrestamoLibro.java,
                     ValidacionRango.java
07-bucles/           CicloFor.java, CicloWhile.java, DoWhile.java, MenuIterativo.java,
                     NumerosParesWhile.java
08-arrays/           Arreglos.java, ArreglosSintaxis.java, IntroducirEnterosEnArreglo.java,
                     IterarArreglos.java
09-metodos/          Funciones.java, FuncionSumar.java, ParOImparFunciones.java
10-poo-basica/       AritmeticaPoo.java, ClasePersona.java, ClasePrincipal.java,
                     ClasesPersonaPoo.java, Constructores.java, Encapsulamiento.java, UsoThis.java
11-herencia/         ClasesAbstractas.java, HerenciaBasica.java, Interfaces.java,
                     Polimorfismo.java, SobrescrituraMetodos.java
12-excepciones/      ExcepcionPersonalizada.java, FinallyBloque.java, MultiplesCatch.java,
                     ThrowsEjemplo.java, TryCatchBasico.java
13-colecciones/      ArrayListEjemplo.java, HashMapEjemplo.java, HashSetEjemplo.java,
                     IterarColecciones.java, LinkedListEjemplo.java
14-archivos/         BufferedReaderEjemplo.java, EscribirArchivo.java, LeerArchivo.java
```
