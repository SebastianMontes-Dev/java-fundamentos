/**
 * ============================================================
 *  TEMA: Programación Orientada a Objetos — Fundamentos
 *  SECCIÓN: 10 — POO Básica
 *  ARCHIVO: UsoThis.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  La palabra clave `this` es una referencia al objeto ACTUAL dentro de sus propios
 *  métodos. Se usa principalmente para: (1) diferenciar atributos de parámetros
 *  cuando tienen el mismo nombre, (2) invocar otros constructores con `this()`,
 *  y (3) pasar el objeto actual como argumento a otros métodos. Dominar `this`
 *  es esencial para escribir clases limpias y sin ambigüedades.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - this.atributo: se refiere al atributo del objeto actual.
 *  - this(): invoca otro constructor de la misma clase desde un constructor.
 *  - this como parámetro: pasa la referencia del objeto actual a otro método.
 *  - Encadenamiento de constructores: un constructor llama a otro con this().
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  public class Producto {
 *      String nombre;
 *      Producto(String nombre) {
 *          this.nombre = nombre; // this.nombre = atributo, nombre = parámetro
 *      }
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar `this` cuando el parámetro tiene el mismo nombre que el atributo
 *    (se asigna el parámetro a sí mismo, el atributo queda sin inicializar).
 *  - Llamar a `this()` después de otra instrucción en el constructor (debe ser la primera).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html
 * ============================================================
 */
public class UsoThis {

    public static void main(String[] args) {

        System.out.println("=== La palabra clave 'this' en Java ===\n");

        // Caso 1: this para diferenciar atributo de parámetro
        Producto producto1 = new Producto("Laptop", 1200.00);
        producto1.mostrarDetalles();

        // Caso 2: encadenamiento de constructores con this()
        Producto producto2 = new Producto("Teclado"); // usa el constructor con 1 param
        producto2.mostrarDetalles();

        // Caso 3: constructor sin parámetros (valores por defecto)
        Producto producto3 = new Producto();
        producto3.mostrarDetalles();
    }
}

class Producto {

    String nombre;
    double precio;

    // Constructor completo: usa this para distinguir atributo de parámetro
    Producto(String nombre, double precio) {
        this.nombre = nombre; // this.nombre = atributo de la clase
        this.precio = precio; // nombre y precio = parámetros del constructor
    }

    // Constructor con solo nombre: REUTILIZA el constructor completo con this()
    Producto(String nombre) {
        this(nombre, 0.0); // llama al constructor de arriba con precio = 0
    }

    // Constructor sin parámetros: REUTILIZA el constructor de un parámetro con this()
    Producto() {
        this("Producto sin nombre"); // llama al constructor de arriba con nombre por defecto
    }

    void mostrarDetalles() {
        System.out.println("Producto: " + this.nombre + " | Precio: $" + this.precio);
    }
}
