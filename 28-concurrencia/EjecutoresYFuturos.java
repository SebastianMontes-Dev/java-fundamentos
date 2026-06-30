/**
 * ============================================================
 *  TEMA: Ejecutores y Programación Asíncrona
 *  SECCIÓN: 28 — Concurrencia
 *  ARCHIVO: EjecutoresYFuturos.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás a manejar la concurrencia moderna en Java. En lugar de crear
 *  hilos manualmente, usaremos ExecutorService para gestionar "piscinas de hilos"
 *  (Thread Pools). Además, introduciremos CompletableFuture para la programación
 *  asíncrona y la composición de tareas que retornan resultados.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - ExecutorService: Interfaz para ejecutar tareas asíncronas de manera eficiente.
 *  - ThreadPool: Reutiliza hilos existentes para evitar el costo de crearlos constantemente.
 *  - CompletableFuture: Clase para escribir código asíncrono no bloqueante y encadenable.
 *  - shutdown(): Libera los recursos del Executor cuando ya no se necesitan.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  ExecutorService ejecutor = Executors.newFixedThreadPool(2);
 *  CompletableFuture.supplyAsync(() -> "Hola", ejecutor)
 *                   .thenApply(res -> res + " Mundo");
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Olvidar llamar a shutdown() en el ExecutorService (el programa no terminará).
 *  - Bloquear el hilo principal con .get() de forma innecesaria en CompletableFuture.
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/concurrent/CompletableFuture.html
 * ============================================================
 */
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjecutoresYFuturos {

    /**
     * Método principal donde se inicia la ejecución del programa.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        System.out.println("--- 1. Usando ExecutorService ---");
        // Crea una "piscina" (pool) con un máximo de 2 hilos activos
        ExecutorService ejecutor = Executors.newFixedThreadPool(2);

        // Enviamos 3 tareas al ejecutor. Como hay 2 hilos, la tercera esperará su turno.
        for (int i = 1; i <= 3; i++) {
            int idTarea = i;
            ejecutor.submit(() -> {
                System.out.println("Ejecutando tarea " + idTarea + " en el hilo: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500); // Simulamos procesamiento
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Es MUY importante apagar el ejecutor al finalizar, si no el programa nunca cerrará.
        ejecutor.shutdown();
        try {
            // Esperamos hasta 2 segundos para que las tareas del ejecutor terminen
            ejecutor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n--- 2. Usando CompletableFuture ---");
        // CompletableFuture nos permite ejecutar procesos asíncronos y encadenar resultados
        // de forma elegante, sin bloquear el hilo principal hasta el final.

        CompletableFuture<String> futuro = CompletableFuture.supplyAsync(() -> {
            System.out.println("Obteniendo datos (Simulando DB) en: " + Thread.currentThread().getName());
            try { 
                Thread.sleep(800); 
            } catch (InterruptedException e) { 
                Thread.currentThread().interrupt(); 
            }
            return "Usuario: Sabas";
        }).thenApply(resultado -> {
            System.out.println("Procesando datos en: " + Thread.currentThread().getName());
            return resultado.toUpperCase();
        });

        // Mientras el futuro se procesa en otro hilo, el hilo Main puede seguir trabajando
        System.out.println("El hilo principal puede hacer otras cosas mientras espera...");

        // .join() espera a que termine el CompletableFuture y obtiene el resultado final.
        // Nota: Usar .join() o .get() bloquea la ejecución en ESTE punto hasta que haya un resultado.
        String resultadoFinal = futuro.join();

        System.out.println("Resultado final asíncrono: " + resultadoFinal);
    }
}
