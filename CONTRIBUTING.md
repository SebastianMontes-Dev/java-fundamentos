# Contribuir a Java Fundamentos

Gracias por querer mejorar este recurso. Todas las contribuciones son bienvenidas: correcciones, nuevos ejercicios, mejoras en la documentación y nuevas secciones.

## Guía de estilo

### Archivos Java

Cada archivo `.java` debe:
- Tener el encabezado Javadoc con: TEMA, SECCIÓN, ARCHIVO, ¿QUÉ APRENDERÁS?, CONCEPTOS CLAVE, SINTAXIS BÁSICA, ERRORES COMUNES, RECURSOS ADICIONALES
- Compilar y ejecutarse de forma independiente con `javac` y `java`
- Usar nombres en PascalCase para clases, camelCase para métodos
- Incluir `System.out.println()` con separadores `===` y `---`
- Tener `Scanner.close()` si usa Scanner

### README de sección

Cada `README.md` debe:
- Título: `# Sección XX — Nombre`
- Secciones: ¿Qué vas a aprender?, Archivos de la sección (tabla), Ejemplo de salida, Consejo profesional
- El consejo profesional debe ser un consejo práctico del mundo real

### Estructura de carpetas

```
XX-nombre/
├── README.md
├── Archivo1.java
├── Archivo2.java
└── ...
```

Usar dos dígitos para el número de sección (`01`, `02`, ..., `33`).

## Cómo contribuir

1. Haz una bifurcación (fork) del repositorio
2. Crea una rama: `git checkout -b caracteristica/nombre-mejora`
3. Haz tus cambios siguiendo la guía de estilo
4. Asegúrate de que todo compile: `javac Archivo.java`
5. Confirma tus cambios (commit): `git commit -m "caracteristica: descripcion del cambio"`
6. Empuja tus cambios (push): `git push origin caracteristica/nombre-mejora`
7. Abre una Solicitud de Extracción (Pull Request)

## Tipos de contribuciones

| Tipo | Commit | Descripción |
|------|--------|-------------|
| Nueva sección | `caracteristica: añadir seccion XX-nombre` | Carpeta completa con README + archivos .java |
| Nuevo ejercicio | `caracteristica: añadir ejercicio NN-nombre` | Enunciado en EJERCICIOS.md + solución en soluciones/ |
| Corrección | `correccion: corregir X en Y` | Errores, errores tipográficos, errores conceptuales |
| Mejora | `documentacion: mejorar documentacion de X` | Mejoras en README, comentarios, explicaciones |
| Refactorización | `refactorizacion: simplificar X` | Mejoras de código sin cambiar comportamiento |

## Preguntas

Si tienes dudas, abre un Problema (Issue) con la etiqueta `pregunta`. Revisa primero si ya existe un Problema similar.
