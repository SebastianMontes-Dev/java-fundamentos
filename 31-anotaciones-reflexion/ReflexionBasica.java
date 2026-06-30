/**
 * ============================================================
 *  TEMA: Reflexión (Reflection API)
 *  SECCIÓN: 31 — Anotaciones y Reflexión
 *  ARCHIVO: ReflexionBasica.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás a usar la API de Reflexión para inspeccionar clases, atributos 
 *  y métodos en tiempo de ejecución. Leeremos la anotación @Columna creada 
 *  anteriormente y ejecutaremos métodos dinámicamente. Así es como frameworks 
 *  como Spring Boot o Hibernate funcionan por debajo.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Reflexión: Capacidad de un programa para examinar y modificar su propia estructura y comportamiento en tiempo de ejecución.
 *  - Class<?>, Field, Method: Clases principales de la API de reflexión.
 *  - getDeclaredFields(): Obtiene todos los atributos de una clase, incluso los privados.
 *  - invoke(): Ejecuta un método dinámicamente.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  Class<?> clase = MiObjeto.class;
 *  Method metodo = clase.getDeclaredMethod("miMetodo");
 *  metodo.invoke(instancia);
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - No manejar las excepciones de reflexión (IllegalAccessException, InvocationTargetException).
 *  - Olvidar usar setAccessible(true) si se necesita modificar campos privados directamente (no cubierto aquí).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/reflect/
 * ============================================================
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Creamos una anotación para demostrar la ejecución dinámica de métodos (como en Spring Boot)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Endpoint {
    String ruta();
}

class ControladorWeb {
    
    @Endpoint(ruta = "/inicio")
    public void mostrarInicio() {
        System.out.println("Ejecutando método mostrarInicio(): ¡Bienvenido a la página principal!");
    }

    @Endpoint(ruta = "/perfil")
    public void mostrarPerfil() {
        System.out.println("Ejecutando método mostrarPerfil(): Perfil del usuario cargado.");
    }
    
    public void metodoComun() {
        System.out.println("Este método no tiene anotación y no debe ejecutarse automáticamente.");
    }
}

public class ReflexionBasica {
    public static void main(String[] args) {
        System.out.println("=== API DE REFLEXIÓN ===\n");

        // 1. LEER LA ANOTACIÓN DEL ARCHIVO ANTERIOR (@Columna en la clase Usuario)
        System.out.println("1. Inspeccionando campos y anotaciones (Simulación de ORM):");
        
        // Obtenemos la estructura de la clase Usuario (definida en AnotacionPersonalizada.java)
        Class<Usuario> claseUsuario = Usuario.class;
        Field[] campos = claseUsuario.getDeclaredFields();

        System.out.println("Analizando la clase: " + claseUsuario.getSimpleName());
        for (Field campo : campos) {
            // Comprobamos si el campo tiene la anotación @Columna
            if (campo.isAnnotationPresent(Columna.class)) {
                Columna anotacion = campo.getAnnotation(Columna.class);
                System.out.println("- Atributo privado '" + campo.getName() + "' mapeado a columna SQL: '" + anotacion.nombre() + "'");
                if (anotacion.esClavePrimaria()) {
                    System.out.println("  (Este campo es una Clave Primaria)");
                }
            } else {
                System.out.println("- Atributo privado '" + campo.getName() + "' NO está mapeado (ignorado por ORM).");
            }
        }

        System.out.println("\n----------------------------------------------------\n");

        // 2. EJECUTAR MÉTODOS DINÁMICAMENTE BASADOS EN ANOTACIONES (Simulación de Spring Boot)
        System.out.println("2. Ejecución dinámica de métodos (Simulación de Spring Boot):");
        ControladorWeb controlador = new ControladorWeb();
        Class<?> claseControlador = controlador.getClass();

        System.out.println("Buscando métodos mapeados con @Endpoint...");
        // Simulamos que el usuario visita la ruta "/perfil"
        String rutaSolicitada = "/perfil";
        System.out.println("Petición web recibida para la ruta: " + rutaSolicitada);

        boolean encontrado = false;

        for (Method metodo : claseControlador.getDeclaredMethods()) {
            if (metodo.isAnnotationPresent(Endpoint.class)) {
                Endpoint endpoint = metodo.getAnnotation(Endpoint.class);
                if (endpoint.ruta().equals(rutaSolicitada)) {
                    try {
                        System.out.println("¡Ruta encontrada! Invocando el método dinámicamente...");
                        // Ejecutamos el método
                        metodo.invoke(controlador);
                        encontrado = true;
                    } catch (Exception e) {
                        System.out.println("Error al ejecutar el método: " + e.getMessage());
                    }
                }
            }
        }

        if (!encontrado) {
            System.out.println("Error 404: Ruta no encontrada.");
        }
    }
}
