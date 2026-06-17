/**
 * ============================================================
 *  TEMA: Sincronización y Condiciones de Carrera
 *  SECCIÓN: 20 — Concurrencia
 *  ARCHIVO: SincronizacionHilos.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Comprenderás qué es una "condición de carrera" (race condition), que ocurre
 *  cuando varios hilos intentan modificar el mismo recurso al mismo tiempo.
 *  Aprenderás a usar la palabra clave 'synchronized' para proteger el acceso
 *  y evitar la corrupción de datos compartidos.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Condición de carrera: Resultado inesperado por concurrencia no controlada.
 *  - synchronized: Garantiza que solo un hilo a la vez acceda a un bloque o método.
 *  - Monitor / Lock: El mecanismo interno que Java usa para gestionar la sincronización.
 *  - Thread.join(): Espera a que un hilo termine su ejecución.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  public synchronized void incrementar() {
 *      contador++;
 *  }
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Modificar variables compartidas desde múltiples hilos sin sincronización.
 *  - Sincronizar en exceso, lo que puede causar pérdida de rendimiento o "deadlocks" (bloqueos).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/javase/tutorial/essential/concurrency/sync.html
 * ============================================================
 */
public class SincronizacionHilos {

    /**
     * Clase que representa un recurso compartido (un contador).
     */
    static class Contador {
        private int cuenta = 0;

        /**
         * Incrementa el contador.
         * El uso de la palabra clave 'synchronized' asegura que solo un hilo
         * pueda ejecutar este método a la vez, evitando condiciones de carrera.
         */
        public synchronized void incrementar() {
            cuenta++;
        }

        /**
         * Obtiene el valor actual de la cuenta.
         * 
         * @return El valor numérico de la cuenta actual.
         */
        public int getCuenta() {
            return cuenta;
        }
    }

    /**
     * Método principal donde se inicia la ejecución del programa.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        Contador contadorCompartido = new Contador();

        // Creamos una tarea que incrementa el contador 1000 veces
        Runnable tareaIncremento = () -> {
            for (int i = 0; i < 1000; i++) {
                contadorCompartido.incrementar();
            }
        };

        // Creamos múltiples hilos que intentarán modificar el mismo contador concurrentemente
        Thread hilo1 = new Thread(tareaIncremento, "Hilo-1");
        Thread hilo2 = new Thread(tareaIncremento, "Hilo-2");
        Thread hilo3 = new Thread(tareaIncremento, "Hilo-3");

        // Iniciamos los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();

        // Esperamos a que los tres hilos terminen usando join()
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            System.out.println("El hilo principal fue interrumpido.");
            Thread.currentThread().interrupt();
        }

        // El resultado debe ser 3000 porque usamos 'synchronized'
        // Si eliminas 'synchronized' del método incrementar(), es muy probable 
        // que el resultado varíe y sea menor a 3000 debido a la Condición de Carrera.
        System.out.println("Cuenta final esperada: 3000");
        System.out.println("Cuenta final obtenida: " + contadorCompartido.getCuenta());
    }
}
