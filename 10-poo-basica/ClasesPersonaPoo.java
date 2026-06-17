/**
 * ============================================================
 *  TEMA: Programación Orientada a Objetos — Clases y Objetos
 *  SECCIÓN: 10 — POO Básica
 *  ARCHIVO: ClasesPersonaPoo.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Una clase agrupa atributos (datos) y métodos (comportamiento) en una sola
 *  entidad. En este ejemplo, la clase define a una persona con cuatro atributos
 *  (nombre, apellido, edad, estatura) y un método que imprime toda la información.
 *  Practicarás la creación de objetos, la asignación de atributos y la invocación
 *  de métodos de instancia desde el método main.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Clase autónoma: la propia clase principal contiene los atributos y el main.
 *  - Atributos de instancia: cada objeto tiene su propia copia de los datos.
 *  - Método de instancia: opera sobre los atributos del objeto que lo invoca.
 *  - Operador punto (.): accede a atributos y métodos de una instancia.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  public class Persona {
 *      String nombre;
 *      int edad;
 *      void mostrar() { System.out.println(nombre + " - " + edad); }
 *      public static void main(String[] args) {
 *          Persona p = new Persona();
 *          p.nombre = "Ana";
 *          p.edad = 25;
 *          p.mostrar();
 *      }
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar el `new` al crear el objeto (NullPointerException).
 *  - Acceder a atributos de instancia desde un contexto estático sin un objeto.
 *  - Confundir la clase (el molde) con el objeto (la instancia).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html
 *  - Guía de objetos: https://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html
 * ============================================================
 */
public class ClasesPersonaPoo {

    // Atributos: características que describen a una persona
    String nombre;
    String apellido;
    int edad;
    double estatura;


    /**
     * Método que imprime en consola todos los datos de la persona.
     */
    void mostrarPersona() {
        System.out.println("=== Datos de la persona ===");
        System.out.println("Nombre    : " + nombre);
        System.out.println("Apellido  : " + apellido);
        System.out.println("Edad      : " + edad + " años");
        System.out.println("Estatura  : " + estatura + " m");
    }

    public static void main(String[] args) {

        System.out.println("=== Creación de un objeto Persona ===\n");

        // Creamos una instancia con new
        ClasesPersonaPoo persona1 = new ClasesPersonaPoo();

        // Asignamos valores a los atributos del objeto
        persona1.nombre = "Sebastián";
        persona1.apellido = "Montes";
        persona1.edad = 19;
        persona1.estatura = 1.75;

        // Invocamos el método para mostrar la información
        persona1.mostrarPersona();

        System.out.println("\n=== Creación de un segundo objeto Persona ===\n");

        // Podemos crear múltiples objetos independientes de la misma clase
        ClasesPersonaPoo persona2 = new ClasesPersonaPoo();
        persona2.nombre = "María";
        persona2.apellido = "García";
        persona2.edad = 25;
        persona2.estatura = 1.65;
        persona2.mostrarPersona();
    }
}
