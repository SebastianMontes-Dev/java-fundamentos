/**
 * ============================================================
 *  TEMA: Programación Orientada a Objetos — Fundamentos
 *  SECCIÓN: 10 — POO Básica
 *  ARCHIVO: Constructores.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Un constructor es un método especial que se ejecuta AUTOMÁTICAMENTE al crear
 *  un objeto con `new`. Su función principal es inicializar los atributos del
 *  objeto con valores iniciales. Aprenderás a crear constructores con y sin
 *  parámetros, y la sobrecarga de constructores (múltiples formas de crear
 *  el mismo tipo de objeto).
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Constructor por defecto: si no defines ninguno, Java provee uno sin parámetros.
 *  - Constructor personalizado: mismo nombre que la clase, sin tipo de retorno.
 *  - Sobrecarga de constructores: varios constructores con distinto número/tipo de parámetros.
 *  - this(): invoca otro constructor de la misma clase (debe ser la primera línea).
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  public class Coche {
 *      String modelo;
 *      public Coche(String modelo) {  // constructor con parámetro
 *          this.modelo = modelo;
 *      }
 *  }
 *  Coche c = new Coche("Toyota");  // el constructor se invoca automáticamente
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Poner tipo de retorno al constructor (ej: `public void Coche()`) — lo convierte en método.
 *  - No definir un constructor sin parámetros si se necesita (Java deja de proveerlo
 *    automáticamente en cuanto defines cualquier otro constructor).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html
 * ============================================================
 */
public class Constructores {

    public static void main(String[] args) {

        System.out.println("=== Constructores en Java ===\n");

        // Usamos el constructor con parámetros: pasamos nombre y edad
        Estudiante estudiante1 = new Estudiante("Laura Sánchez", 22);
        estudiante1.mostrarDatos();

        // Usamos el constructor sin parámetros (valores por defecto)
        Estudiante estudiante2 = new Estudiante();
        estudiante2.mostrarDatos();

        // Usamos el constructor con solo el nombre
        Estudiante estudiante3 = new Estudiante("Pedro Ramírez");
        estudiante3.mostrarDatos();
    }
}

class Estudiante {

    String nombre;
    int edad;

    // Constructor sin parámetros: asigna valores por defecto
    Estudiante() {
        nombre = "Sin nombre";
        edad = 0;
    }

    // Constructor con un parámetro: solo recibe el nombre
    Estudiante(String nombre) {
        this.nombre = nombre; // 'this.nombre' = atributo, 'nombre' = parámetro
        edad = 18;            // valor por defecto para la edad
    }

    // Constructor con dos parámetros: recibe nombre y edad
    Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    void mostrarDatos() {
        System.out.println("Estudiante: " + nombre + " | Edad: " + edad);
    }
}
