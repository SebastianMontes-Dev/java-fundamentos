/**
 * ============================================================
 *  TEMA: Operadores en Java
 *  SECCIÓN: 05 — Operadores
 *  ARCHIVO: OperadoresUnitarios.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Los operadores unarios actúan sobre UN SOLO operando. Los más importantes son
 *  el pre-incremento (++a) y post-incremento (a++), cuya diferencia sutil causa
 *  confusión incluso a programadores con experiencia. En PRE, el incremento ocurre
 *  ANTES de usar la variable; en POST, ocurre DESPUÉS. Entender esto es vital
 *  para bucles, contadores y cualquier lógica que dependa del momento del incremento.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - +a: signo positivo (no modifica, solo confirma el valor).
 *  - -a: negación aritmética (invierte el signo).
 *  - ++a (pre-incremento): incrementa a en 1, LUEGO devuelve el nuevo valor.
 *  - a++ (post-incremento): devuelve el valor actual, LUEGO incrementa a en 1.
 *  - --a / a-- (pre/post decremento): análogos pero restando 1.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  int a = 5;
 *  int b = ++a; // a pasa a 6, b recibe 6
 *  int c = a++; // c recibe 6, a pasa a 7
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - No entender cuándo se aplica el incremento: en a++ la variable SÍ se modifica,
 *    solo que el valor DEVUELTO es el antiguo. La variable termina incrementada.
 *  - Usar post-incremento cuando necesitas el valor ya incrementado en la misma línea.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/operators.html
 * ============================================================
 */
public class OperadoresUnitarios {

    public static void main(String[] args) {
        int a;
        int resultado;

        System.out.println("=== Operadores Unitarios ===");
        System.out.println("Valor base: a = 6");
        System.out.println();

        // Signo positivo: devuelve el valor sin modificarlo
        a = 6;
        resultado = +a;
        System.out.println("+a           → resultado = " + resultado + ", a = " + a);

        // Negación: invierte el signo del valor
        a = 6;
        resultado = -a;
        System.out.println("-a           → resultado = " + resultado + ", a = " + a);

        // Pre-incremento: a pasa a 7, resultado recibe 7
        a = 6;
        resultado = ++a;
        System.out.println("resultado = ++a → resultado = " + resultado + ", a = " + a);

        // Pre-decremento: a pasa a 5, resultado recibe 5
        a = 6;
        resultado = --a;
        System.out.println("resultado = --a → resultado = " + resultado + ", a = " + a);

        // Post-incremento: resultado recibe 6 (valor actual), luego a pasa a 7
        a = 6;
        resultado = a++;
        System.out.println("resultado = a++ → resultado = " + resultado + ", a = " + a);

        // Post-decremento: resultado recibe 6 (valor actual), luego a pasa a 5
        a = 6;
        resultado = a--;
        System.out.println("resultado = a-- → resultado = " + resultado + ", a = " + a);
    }
}
