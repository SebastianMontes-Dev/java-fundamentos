# Java Fundamentos

Repositorio educativo público (también publicado como sitio con GitHub Pages, `_config.yml`) para aprender Java desde cero: 33 secciones numeradas (`01-tipos-primitivos` … `33-testing-basico`) más `99-ejercicios/`, con unos 148 archivos `.java`.

## Build y comprobación

- **No hay Maven ni Gradle.** Cada `.java` se compila y ejecuta por sí solo: `javac Archivo.java && java Archivo`.
- El CI (`.github/workflows/compile.yml`, Java 17) compila cada `.java` por separado, excepto `99-ejercicios/` y `33-testing-basico/`. Esta última se compila completa en un paso propio con el JAR de JUnit 5 (1.10.0, verificado con su sha1), porque sus archivos dependen entre sí. Tras un cambio, compila los archivos tocados y, para no ensuciar el repo, manda la salida fuera de él: `javac --release 17 -d <carpeta_temporal> Archivo.java`. El mínimo del proyecto es Java 17.
- Los `.class` están en `.gitignore`; no los versiones.

## Estructura y estilo (de `CONTRIBUTING.md`)

- Cada sección es una carpeta `NN-nombre/` (dos dígitos) con un `README.md` y sus `.java`. El README de sección lleva el título `# Sección XX — Nombre` y las partes «¿Qué vas a aprender?», «Archivos de la sección» (tabla), «Ejemplo de salida» y «Consejo profesional» (un consejo práctico real).
- Cada `.java` lleva un encabezado Javadoc (TEMA, SECCIÓN, ARCHIVO, ¿QUÉ APRENDERÁS?, CONCEPTOS CLAVE, SINTAXIS BÁSICA, ERRORES COMUNES, RECURSOS ADICIONALES), clases en PascalCase y métodos en camelCase, separadores `===` y `---` en las salidas de `System.out.println`, `Scanner.close()` si usa `Scanner`, y debe compilar de forma independiente.

## Qué hace fallar al CI

El CI está en verde desde el commit `1fa1120`. Para mantenerlo así:

- **Sin BOM.** `javac` rechaza la marca BOM UTF-8 (`illegal character: '﻿'`). Se quitó de los 72 `.java` que la tenían (commit `4c958d1`); los archivos nuevos van en UTF-8 **sin** BOM. Los `README.md` de algunas secciones aún la llevan y no rompe nada.
- **Nada posterior a Java 17.** El CI compila con Java 17 y el README declara «Java 17+». Por eso `RecordsYSellados` despacha con `instanceof` y no con el `switch` con patrones de Java 21.
- **Cada `.java` compila solo.** Si necesita un tipo de otro archivo, incluye una copia anidada, como hace `ReflexionBasica` con `Columna` y `Usuario`.
- **El bucle del CI se detiene en el primer fallo.** Un CI rojo puede esconder más errores detrás del que ves, así que compila todos los archivos en local antes de dar algo por arreglado.

## Commits (desajuste con `CONTRIBUTING.md`)

`CONTRIBUTING.md` pide a los colaboradores externos ramas `caracteristica/…` y tipos en español (`caracteristica:`, `correccion:`, `documentacion:`). El historial del dueño usa Conventional Commits con tipos en inglés (`feat`, `docs`, `chore`, `refactor`, `ci`), así que para los commits del dueño se sigue la convención global. Si el usuario prefiere lo contrario, actualiza esta sección.

## Documentación

`README.md` (mapa de aprendizaje), `ROADMAP.md` y `CHANGELOG.md` deben reflejar las secciones que existen: al agregar o renombrar una sección, actualízalos en el mismo cambio.
