/**
 * ============================================================
 *  TEMA: Clases Abstractas en Java
 *  SECCIÓN: 16 — Herencia y Polimorfismo
 *  ARCHIVO: ClasesAbstractas.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Una clase abstracta es un punto intermedio entre una clase normal y una interfaz.
 *  Se declara con `abstract` y puede contener tanto métodos abstractos (sin cuerpo,
 *  que las subclases DEBEN implementar) como métodos concretos (con implementación
 *  heredable). No se puede instanciar directamente. Es ideal cuando tienes
 *  implementación parcial común que quieres compartir entre subclases.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - abstract class: no se puede instanciar con `new`, solo heredar.
 *  - Método abstracto: declarado sin cuerpo, obliga a las subclases a implementarlo.
 *  - Método concreto: tiene implementación, las subclases lo heredan o lo sobrescriben.
 *  - Diferencia con interface: la clase abstracta puede tener atributos y constructores.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  abstract class Empleado {
 *      abstract double calcularSalario(); // sin implementación
 *      void fichar() { System.out.println("Fichando..."); } // con implementación
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Intentar hacer `new ClaseAbstracta()` — no compila.
 *  - Confundir cuándo usar clase abstracta vs interfaz: usa abstracta cuando compartes
 *    estado/comportamiento, usa interfaz cuando defines un contrato puro.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
 * ============================================================
 */
public class ClasesAbstractas {

    public static void main(String[] args) {

        System.out.println("=== Clases Abstractas en Java ===\n");

        // NO podemos hacer: Empleado e = new Empleado(); (es abstracta)
        // Pero podemos referenciar con el tipo abstracto:
        Empleado[] empleados = new Empleado[3];
        empleados[0] = new EmpleadoTiempoCompleto("Ana", 3000);
        empleados[1] = new EmpleadoMedioTiempo("Luis", 15, 80);
        empleados[2] = new EmpleadoTiempoCompleto("María", 4500);

        // Recorremos con polimorfismo: cada uno ejecuta su propia versión
        for (Empleado emp : empleados) {
            emp.fichar(); // método CONCRETO heredado de la clase abstracta
            System.out.printf("Salario de %s: $%.2f%n", emp.nombre, emp.calcularSalario());
            System.out.println();
        }
    }
}

abstract class Empleado {
    String nombre;

    Empleado(String nombre) {
        this.nombre = nombre;
    }

    // Método abstracto: CADA subclase debe proporcionar su propia implementación
    abstract double calcularSalario();

    // Método concreto: todas las subclases heredan esta implementación
    void fichar() {
        System.out.println(nombre + " ha fichado su entrada.");
    }
}

class EmpleadoTiempoCompleto extends Empleado {
    double salarioMensual;

    EmpleadoTiempoCompleto(String nombre, double salarioMensual) {
        super(nombre);
        this.salarioMensual = salarioMensual;
    }

    @Override
    double calcularSalario() {
        return salarioMensual; // salario fijo mensual
    }
}

class EmpleadoMedioTiempo extends Empleado {
    double tarifaPorHora;
    int horasTrabajadas;

    EmpleadoMedioTiempo(String nombre, double tarifaPorHora, int horasTrabajadas) {
        super(nombre);
        this.tarifaPorHora = tarifaPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    double calcularSalario() {
        return tarifaPorHora * horasTrabajadas; // pago por hora
    }
}
