import java.util.Scanner;

/**
 * ============================================================
 *  TEMA: Estructuras Condicionales en Java
 *  SECCIÓN: 06 — Condicionales
 *  ARCHIVO: ValidacionRango.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Validarás si un número se encuentra dentro de un rango específico combinando
 *  operadores relacionales (>=, <=) con el operador lógico && (AND). Usarás
 *  constantes `final` para definir los límites (buena práctica que evita
 *  "números mágicos"), e inferencia de tipos con `var`. Es el patrón clásico
 *  de validación de formularios, rangos de edad, calificaciones y filtros.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - final: declara constantes cuyo valor no puede cambiar (límites del rango).
 *  - Operadores relacionales: >= (mayor o igual), <= (menor o igual).
 *  - Operador lógico && (AND): ambas condiciones deben ser true.
 *  - Inferencia con var: el compilador deduce el tipo automáticamente.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  final int MIN = 0, MAX = 5;
 *  var estaEnRango = (numero >= MIN) && (numero <= MAX);
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar operadores incorrectos: para rango CERRADO [0,5] se usa >= y <= (no > y <).
 *  - No usar constantes (números mágicos): si el límite cambia, hay que buscarlo en todo el código.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/if.html
 * ============================================================
 */
public class ValidacionRango {

    public static void main(String[] args) {
        final int LIMITE_INFERIOR = 0;
        final int LIMITE_SUPERIOR = 5;

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Validación de Rango ===");
        System.out.println("Rango válido: [" + LIMITE_INFERIOR + ", " + LIMITE_SUPERIOR + "]");
        System.out.println();

        System.out.print("Ingrese un número para verificar: ");
        var numero = scanner.nextInt();

        // true solo si número >= 0 Y número <= 5
        var estaEnRango = numero >= LIMITE_INFERIOR && numero <= LIMITE_SUPERIOR;

        System.out.println();
        System.out.println("Número ingresado: " + numero);
        System.out.println("¿Está en el rango [" + LIMITE_INFERIOR + ", " + LIMITE_SUPERIOR + "]? " + estaEnRango);

        scanner.close();
    }
}
