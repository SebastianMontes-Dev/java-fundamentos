/**
 * ============================================================
 *  TEMA: Estructuras de Control — Bucles en Java
 *  SECCIÓN: 07 — Bucles
 *  ARCHIVO: CicloWhile.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  El bucle `while` evalúa una condición ANTES de cada iteración. Si la condición
 *  es false desde el principio, el cuerpo del bucle no se ejecuta ni una sola vez.
 *  Es perfecto para situaciones donde no sabes cuántas iteraciones necesitas,
 *  como leer datos hasta que el usuario ingrese un valor específico.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Condición de entrada: se verifica al inicio de cada vuelta.
 *  - Contador o variable de control: debe actualizarse DENTRO del bucle para evitar bucles infinitos.
 *  - Post-incremento (num++): usa el valor actual y LUEGO incrementa.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  while (condición) {
 *      // código que se repite mientras la condición sea true
 *  }
 *  // Ejemplo: while (contador <= 10) { System.out.println(contador++); }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Bucle infinito: olvidar modificar la variable de control dentro del cuerpo.
 *  - Condición que nunca se vuelve false por un error lógico en la comparación.
 *  - Confundir while (se ejecuta 0 o más veces) con do-while (se ejecuta 1 o más veces).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html
 * ============================================================
 */
public class CicloWhile {

    public static void main(String[] args) {

        // Inicializamos la variable de control antes del while
        var numero = 1;

        // Mientras numero sea menor o igual a 10, se ejecuta el bloque
        while (numero <= 10) {
            // Imprime el valor actual de numero y LUEGO lo incrementa en 1
            System.out.println("Número: " + numero);
            numero++; // ¡Importante! Sin esta línea el bucle sería infinito
        }

        System.out.println("¡El while terminó! numero ahora vale: " + numero);
    }
}
