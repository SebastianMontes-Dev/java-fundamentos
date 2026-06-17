/**
 * ============================================================
 *  TEMA: Creación de Anotaciones Personalizadas
 *  SECCIÓN: 23 — Anotaciones y Reflexión
 *  ARCHIVO: AnotacionPersonalizada.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás a crear tus propias anotaciones desde cero usando @interface.
 *  Entenderás el uso de las meta-anotaciones @Retention y @Target para 
 *  definir dónde y por cuánto tiempo estará disponible tu anotación (ej. Runtime).
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - @interface: Palabra clave para definir una anotación.
 *  - @Retention: Define si la anotación está disponible en el código fuente, clase o tiempo de ejecución (RUNTIME).
 *  - @Target: Define en qué elementos (clases, métodos, campos) se puede usar la anotación.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  @Retention(RetentionPolicy.RUNTIME)
 *  @Target(ElementType.FIELD)
 *  public @interface MiAnotacion {
 *      String valor() default "";
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar establecer la política de retención a RUNTIME si quieres leerla por reflexión.
 *  - Aplicar la anotación en un elemento no permitido por su @Target.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/annotations/custom.html
 * ============================================================
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotación personalizada que simula cómo funcionan los ORM (como Hibernate o JPA)
 * para mapear el campo de una clase a una columna de base de datos.
 */
@Retention(RetentionPolicy.RUNTIME) // Disponible durante la ejecución del programa (necesario para Reflexión)
@Target(ElementType.FIELD)          // Solo se puede aplicar a atributos (campos) de una clase
@interface Columna {
    String nombre();
    boolean esClavePrimaria() default false;
}

// Clase de ejemplo que utiliza nuestra anotación personalizada
class Usuario {
    @Columna(nombre = "id_usuario", esClavePrimaria = true)
    private int id;

    @Columna(nombre = "nombre_completo")
    private String nombre;

    private String datoTemporal; // Este campo no está anotado

    /**
     * Constructor de Usuario.
     * @param id El ID del usuario.
     * @param nombre El nombre del usuario.
     */
    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }
}

public class AnotacionPersonalizada {
    public static void main(String[] args) {
        System.out.println("=== CREACIÓN DE ANOTACIONES PERSONALIZADAS ===");
        System.out.println("En este archivo hemos definido la anotación @Columna.");
        System.out.println("Y la hemos aplicado a la clase Usuario.");
        
        Usuario usuario = new Usuario(1, "Ana García");
        System.out.println("Usuario creado: " + usuario.getNombre());
        System.out.println("\nNota: La anotación @Columna por sí sola no hace nada.");
        System.out.println("Para leer y procesar estas anotaciones en tiempo de ejecución,");
        System.out.println("necesitamos usar 'Reflexión', lo cual veremos en el archivo ReflexionBasica.java.");
    }
}
