# Java Fundamentos

Repositorio educativo público (también publicado como sitio con GitHub Pages, `_config.yml`) para aprender Java desde cero: 33 secciones numeradas (`01-tipos-primitivos` … `33-testing-basico`) más `99-ejercicios/`, con unos 148 archivos `.java`.

## Build y comprobación

- **No hay Maven ni Gradle.** Cada `.java` se compila y ejecuta por sí solo: `javac Archivo.java && java Archivo`.
- El CI (`.github/workflows/compile.yml`, Java 17) compila todos los `.java` excepto los de `99-ejercicios/`. Tras un cambio, compila los archivos tocados y, para no ensuciar el repo, manda la salida fuera de él: `javac --release 17 -d <carpeta_temporal> Archivo.java`. El mínimo del proyecto es Java 17.
- Los `.class` están en `.gitignore`; no los versiones.

## Estructura y estilo (de `CONTRIBUTING.md`)

- Cada sección es una carpeta `NN-nombre/` (dos dígitos) con un `README.md` y sus `.java`. El README de sección lleva el título `# Sección XX — Nombre` y las partes «¿Qué vas a aprender?», «Archivos de la sección» (tabla), «Ejemplo de salida» y «Consejo profesional» (un consejo práctico real).
- Cada `.java` lleva un encabezado Javadoc (TEMA, SECCIÓN, ARCHIVO, ¿QUÉ APRENDERÁS?, CONCEPTOS CLAVE, SINTAXIS BÁSICA, ERRORES COMUNES, RECURSOS ADICIONALES), clases en PascalCase y métodos en camelCase, separadores `===` y `---` en las salidas de `System.out.println`, `Scanner.close()` si usa `Scanner`, y debe compilar de forma independiente.

## Problema conocido: BOM en los `.java`

**72 de los 148 `.java` versionados empiezan con una marca BOM UTF-8**, y `javac` la rechaza (`illegal character: '﻿'`). Por eso el workflow de compilación falla: lleva 11 de 11 ejecuciones en rojo, y la última se detiene en `31-anotaciones-reflexion/ReflexionBasica.java`, que además tiene un segundo error de sintaxis en la línea 39.

- Los archivos **nuevos** van en UTF-8 **sin** BOM.
- No lo arregles de paso: quitarlo es un cambio masivo (72 archivos) que va en su propio commit y hay que pedirlo.

## Commits (desajuste con `CONTRIBUTING.md`)

`CONTRIBUTING.md` pide a los colaboradores externos ramas `caracteristica/…` y tipos en español (`caracteristica:`, `correccion:`, `documentacion:`). El historial del dueño usa Conventional Commits con tipos en inglés (`feat`, `docs`, `chore`, `refactor`, `ci`), así que para los commits del dueño se sigue la convención global. Si el usuario prefiere lo contrario, actualiza esta sección.

## Documentación

`README.md` (mapa de aprendizaje), `ROADMAP.md` y `CHANGELOG.md` deben reflejar las secciones que existen: al agregar o renombrar una sección, actualízalos en el mismo cambio.
