/**
 * ============================================================
 *  TEMA: Colecciones en Java — LinkedList
 *  SECCIÓN: 13 — Colecciones
 *  ARCHIVO: LinkedListEjemplo.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  `LinkedList` implementa una lista DOBLEMENTE enlazada. A diferencia de ArrayList
 *  (basado en arreglo), LinkedList brilla en operaciones de inserción y eliminación
 *  en los extremos o en el medio de la lista (O(1) vs O(n)). También implementa
 *  las interfaces `Queue` y `Deque`, permitiendo usarla como cola FIFO o pila LIFO.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Nodos enlazados: cada elemento apunta al anterior y al siguiente.
 *  - addFirst() / addLast(): insertan al inicio o final.
 *  - removeFirst() / removeLast(): eliminan del inicio o final.
 *  - Queue: add/offer encola, poll/remove desencola.
 *  - ¿Cuándo LinkedList vs ArrayList?: inserciones frecuentes al inicio → LinkedList.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  LinkedList<String> lista = new LinkedList<>();
 *  lista.addFirst("Primero"); // inserta al inicio
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar get(indice) frecuentemente en LinkedList (O(n) vs O(1) de ArrayList).
 *  - Usar LinkedList para acceso aleatorio (es más lento que ArrayList).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html
 * ============================================================
 */
import java.util.LinkedList;

public class LinkedListEjemplo {

    public static void main(String[] args) {

        System.out.println("=== LinkedList en Java ===\n");

        LinkedList<String> tareas = new LinkedList<>();

        // Agregar elementos al final (comportamiento de lista normal)
        tareas.add("Revisar correos");
        tareas.add("Preparar informe");
        tareas.add("Reunión con el equipo");

        System.out.println("--- Lista de tareas inicial ---");
        mostrarLista(tareas);

        // Insertar al INICIO de la lista (ventaja de LinkedList)
        tareas.addFirst("Urgente: Llamar al cliente");
        System.out.println("\nDespués de addFirst():");
        mostrarLista(tareas);

        // Insertar al FINAL (equivalente a add())
        tareas.addLast("Archivar documentos");
        System.out.println("\nDespués de addLast():");
        mostrarLista(tareas);

        // Obtener primer y último elemento sin remover
        System.out.println("\n--- Consultando extremos ---");
        System.out.println("Primera tarea: " + tareas.getFirst());
        System.out.println("Última tarea: " + tareas.getLast());

        // Eliminar del inicio y del final
        System.out.println("\n--- Eliminando extremos ---");
        String tareaEliminada = tareas.removeFirst();
        System.out.println("Eliminada (inicio): " + tareaEliminada);
        tareaEliminada = tareas.removeLast();
        System.out.println("Eliminada (final): " + tareaEliminada);
        System.out.println("\nLista resultante:");
        mostrarLista(tareas);

        // Usar LinkedList como COLA (FIFO: primero en entrar, primero en salir)
        System.out.println("\n--- LinkedList como Cola (FIFO) ---");
        LinkedList<String> cola = new LinkedList<>();
        cola.offer("Cliente 1"); // encolar
        cola.offer("Cliente 2");
        cola.offer("Cliente 3");
        System.out.println("Atendiendo: " + cola.poll()); // desencolar: Cliente 1
        System.out.println("Atendiendo: " + cola.poll()); // Cliente 2
        System.out.println("Quedan en cola: " + cola);
    }

    static void mostrarLista(LinkedList<String> lista) {
        int i = 1;
        for (String tarea : lista) {
            System.out.println("  " + (i++) + ". " + tarea);
        }
    }
}
