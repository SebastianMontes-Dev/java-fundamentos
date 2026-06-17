/**
 * ============================================================
 *  TEMA: Introducción a Hilos (Threads) y Multihilos
 *  SECCIÓN: 20 — Concurrencia
 *  ARCHIVO: HilosBasicos.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás los conceptos básicos para ejecutar tareas en paralelo.
 *  Veremos las dos formas principales de crear hilos en Java: extendiendo
 *  la clase Thread y, la más recomendada, implementando la interfaz Runnable.
 *  También exploraremos métodos básicos como start() y sleep().
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Hilo (Thread): Un flujo de ejecución independiente dentro de un programa.
 *  - Interfaz Runnable: La forma estándar de definir el trabajo que hará un hilo.
 *  - start() vs run(): start() crea un nuevo hilo, run() ejecuta en el hilo actual.
 *  - InterruptedException: Excepción común al pausar hilos con sleep().
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  Thread hilo = new Thread(new MiRunnable());
 *  hilo.start(); // Inicia la ejecución en paralelo
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Llamar al método run() en lugar de start() (no crea un hilo nuevo).
 *  - No manejar la interrupción (InterruptedException) al usar Thread.sleep().
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Thread.html
 * ============================================================
 */
public class HilosBasicos {

    /**
     * Clase interna que implementa Runnable.
     * Esta es la forma recomendada de definir una tarea para un hilo.
     */
    static class MiTareaRunnable implements Runnable {
        private String nombre;

        /**
         * Constructor de la tarea.
         *
         * @param nombre Nombre descriptivo de la tarea.
         */
        public MiTareaRunnable(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Runnable [" + nombre + "] ejecutando paso " + i);
                try {
                    // Pausa el hilo por 500 milisegundos
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("El hilo fue interrumpido.");
                    Thread.currentThread().interrupt(); // Restablece el estado de interrupción
                }
            }
            System.out.println("Runnable [" + nombre + "] ha terminado.");
        }
    }

    /**
     * Clase interna que extiende Thread.
     * Esta es la forma menos recomendada, ya que en Java no hay herencia múltiple.
     */
    static class MiHiloThread extends Thread {
        
        /**
         * Constructor del hilo.
         *
         * @param nombre Nombre del hilo.
         */
        public MiHiloThread(String nombre) {
            super(nombre);
        }

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread [" + getName() + "] ejecutando paso " + i);
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    System.out.println("El hilo fue interrumpido.");
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Thread [" + getName() + "] ha terminado.");
        }
    }

    /**
     * Método principal donde se inicia la ejecución del programa.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        System.out.println("Iniciando el hilo principal (Main)...");

        // 1. Crear e iniciar un hilo usando Runnable (RECOMENDADO)
        MiTareaRunnable tarea1 = new MiTareaRunnable("Tarea-1");
        Thread hilo1 = new Thread(tarea1);
        hilo1.start(); // ¡Importante usar start(), NO run()!

        // 2. Crear e iniciar un hilo extendiendo Thread
        MiHiloThread hilo2 = new MiHiloThread("Thread-2");
        hilo2.start();

        System.out.println("El hilo principal (Main) ha terminado sus instrucciones iniciales.");
        // Aunque el hilo Main termine aquí sus instrucciones, el programa Java
        // seguirá ejecutándose hasta que los hilos hijos (hilo1 e hilo2) finalicen.
    }
}
