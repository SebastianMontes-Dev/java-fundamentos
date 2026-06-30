/**
 * ============================================================
 *  TEMA: Programación Orientada a Objetos — Fundamentos
 *  SECCIÓN: 15 — POO Básica
 *  ARCHIVO: Encapsulamiento.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  El encapsulamiento es uno de los cuatro pilares de la POO. Consiste en ocultar
 *  los detalles internos de una clase y exponer solo lo necesario mediante métodos
 *  públicos (getters y setters). Los atributos se declaran `private` para que solo
 *  puedan ser modificados a través de métodos controlados, protegiendo la integridad
 *  de los datos y permitiendo validaciones.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - private: modificador de acceso que restringe la visibilidad a la misma clase.
 *  - public: modificador que permite el acceso desde cualquier otra clase.
 *  - Getter: método público que devuelve el valor de un atributo privado.
 *  - Setter: método público que modifica un atributo privado (puede incluir validación).
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  private String nombre;
 *  public String getNombre() { return nombre; }
 *  public void setNombre(String nombre) { this.nombre = nombre; }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Hacer los atributos públicos "por comodidad" — rompe el encapsulamiento.
 *  - No validar los datos en los setters, permitiendo valores inválidos.
 *  - Olvidar el getter cuando solo necesitas el setter (o viceversa).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html
 * ============================================================
 */
public class Encapsulamiento {

    public static void main(String[] args) {

        System.out.println("=== Encapsulamiento en Java ===\n");

        CuentaBancaria cuenta = new CuentaBancaria("ES1234567890", 500.00);

        // NO podemos hacer cuenta.saldo = -100 (el atributo es private)
        // Solo podemos modificar mediante los métodos públicos

        System.out.println("--- Estado inicial ---");
        cuenta.mostrarSaldo();

        // Depositamos dinero usando el método público
        cuenta.depositar(250.00);

        // Intentamos retirar más de lo que hay → el setter/validación lo impide
        cuenta.retirar(1000.00);

        // Retiramos una cantidad válida
        cuenta.retirar(150.00);

        System.out.println("\n--- Estado final ---");
        cuenta.mostrarSaldo();
    }
}

class CuentaBancaria {

    // Atributos PRIVADOS: solo accesibles dentro de esta clase
    private String numeroCuenta;
    private double saldo;

    // Constructor público para inicializar la cuenta
    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = (saldoInicial >= 0) ? saldoInicial : 0; // no permite saldo negativo
    }

    // Getter: permite LEER el saldo desde fuera de la clase
    public double getSaldo() {
        return saldo;
    }

    // Getter: permite LEER el número de cuenta
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    // Método público para depositar (con validación)
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.printf("Depósito exitoso de $%.2f%n", cantidad);
        } else {
            System.out.println("La cantidad a depositar debe ser positiva.");
        }
    }

    // Método público para retirar (con validación de saldo suficiente)
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.printf("Retiro exitoso de $%.2f%n", cantidad);
        } else if (cantidad > saldo) {
            System.out.printf("Saldo insuficiente. No se puede retirar $%.2f%n", cantidad);
        } else {
            System.out.println("La cantidad a retirar debe ser positiva.");
        }
    }

    public void mostrarSaldo() {
        System.out.printf("Cuenta %s - Saldo actual: $%.2f%n", numeroCuenta, saldo);
    }
}
