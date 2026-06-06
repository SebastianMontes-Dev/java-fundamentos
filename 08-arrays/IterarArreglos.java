/**
 * ============================================================
 *  TEMA: Arreglos (Arrays) Unidimensionales en Java
 *  SECCIÓN: 08 — Arrays
 *  ARCHIVO: IterarArreglos.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Recorrer (iterar) un arreglo significa visitar cada uno de sus elementos
 *  secuencialmente. Aquí usamos un bucle `for` clásico combinado con la propiedad
 *  `.length` para procesar todos los elementos sin conocer su cantidad exacta
 *  de antemano. Esta técnica es la base del procesamiento de datos en Java.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Propiedad length: devuelve el número de elementos del arreglo.
 *  - Bucle for con índice: `for (var i = 0; i < arreglo.length; i++)`
 *  - Relación índice-valor: cada posición i contiene un dato accesible con arreglo[i].
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  for (var i = 0; i < arreglo.length; i++) {
 *      System.out.println("Posición " + i + " = " + arreglo[i]);
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar `<=` en la condición del for: el último índice es length - 1, no length.
 *  - Intentar acceder a arreglo[arreglo.length] (fuera de rango).
 *  - Olvidar declarar la variable de iteración dentro del for.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html
 * ============================================================
 */
public class IterarArreglos {

    public static void main(String[] args) {

        // Inicializamos un arreglo con 5 valores predefinidos
        var enteros = new int[]{100, 200, 300, 400, 500};

        System.out.println("=== Recorriendo un arreglo con bucle for ===\n");

        // i empieza en 0 y avanza hasta el último índice (length - 1)
        for (var i = 0; i < enteros.length; i++) {
            // Por cada posición mostramos el índice y el valor almacenado
            System.out.println("Índice [" + i + "] contiene el número: " + enteros[i]);
        }

        System.out.println("\nTotal de elementos en el arreglo: " + enteros.length);
    }
}
