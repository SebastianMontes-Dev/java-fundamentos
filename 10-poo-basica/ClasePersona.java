/**
 * ============================================================
 *  TEMA: Programación Orientada a Objetos — Fundamentos
 *  SECCIÓN: 10 — POO Básica
 *  ARCHIVO: ClasePersona.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Una clase es la plantilla o "molde" a partir del cual se crean objetos. Define
 *  los ATRIBUTOS (datos) y MÉTODOS (comportamiento) que tendrán todas las instancias.
 *  Aquí crearás tu primera clase `Persona` con atributos como nombre y edad, y un
 *  método para mostrar información. Es el concepto más fundamental de la POO.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Clase: estructura que agrupa atributos (campos) y métodos.
 *  - Atributos (campos): variables que pertenecen a cada objeto de la clase.
 *  - Instancia (objeto): ejemplar concreto creado con `new Clase()`.
 *  - Operador punto (.): accede a atributos y métodos de un objeto.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  public class Persona {
 *      String nombre;  // atributo
 *      int edad;       // atributo
 *      void mostrarInfo() { System.out.println(nombre + ", " + edad); }
 *  }
 *  Persona p = new Persona();  // crear objeto
 *  p.nombre = "Ana";           // asignar atributo
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar la clase sin crear una instancia con `new` (NullPointerException).
 *  - Confundir clase (el molde) con objeto (la instancia concreta).
 *  - Acceder a atributos sin asignarles valor previamente.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html
 * ============================================================
 */
public class ClasePersona {

    public static void main(String[] args) {

        System.out.println("=== Creando objetos a partir de una clase ===\n");

        // Creamos una instancia (objeto) de la clase Persona con new
        Persona persona1 = new Persona();

        // Asignamos valores a los atributos usando el operador punto
        persona1.nombre = "Carlos Mendoza";
        persona1.edad = 28;

        // Invocamos el método mostrarInfo() del objeto
        persona1.mostrarInfo();

        // Podemos crear múltiples objetos independientes de la misma clase
        Persona persona2 = new Persona();
        persona2.nombre = "María García";
        persona2.edad = 34;
        persona2.mostrarInfo();
    }
}

/**
 * Clase Persona: plantilla para crear objetos que representan personas.
 * Contiene atributos (datos) y un método (comportamiento).
 */
class Persona {

    // Atributos: características que definen a una persona
    String nombre;
    int edad;

    // Método: comportamiento que muestra la información de la persona
    void mostrarInfo() {
        System.out.println("Nombre: " + nombre + " | Edad: " + edad + " años");
    }
}
