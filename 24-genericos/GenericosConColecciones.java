/**
 * ============================================================
 *  TEMA: Genéricos en Java
 *  SECCIÓN: 24 — Genéricos
 *  ARCHIVO: GenericosConColecciones.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  Aprenderás a usar genéricos en la práctica con las colecciones
 *  de Java (List, Map, Set). Verás cómo los genéricos hacen que
 *  las colecciones sean seguras y fáciles de usar. Además, crearás
 *  una clase utilitaria genérica para filtrar y procesar listas
 *  de cualquier tipo.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Colecciones genéricas: List<T>, Map<K,V>, Set<T>
 *  - Interfaces funcionales genéricas: Predicate<T> (para filtros)
 *  - Clases utilitarias genéricas: métodos reutilizables para
 *    procesar colecciones de cualquier tipo
 *  - Iteración segura: for-each con tipos verificados
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  List<String> nombres = new ArrayList<>();
 *  Map<String, Integer> edades = new HashMap<>();
 *  Set<Double> precios = new HashSet<>();
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Usar raw types: List lista = new ArrayList(); (sin tipo)
 *  - Confundir List<Object> con List<?> (no son intercambiables)
 *  - No entender que List<Integer> NO es subtipo de List<Number>
 *    (los genéricos son invariantes)
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial:
 *    https://docs.oracle.com/javase/tutorial/collections/index.html
 * ============================================================
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collections;

public class GenericosConColecciones {

    // ========================================================
    //  INTERFAZ GENÉRICA PARA FILTROS (simula Predicate<T>)
    // ========================================================

    /**
     * Interfaz funcional genérica que define un criterio de prueba.
     * Similar a java.util.function.Predicate<T>, pero creada aquí
     * para entender el concepto.
     *
     * @param <T> el tipo del elemento a evaluar
     */
    interface Criterio<T> {
        /**
         * Evalúa si el elemento cumple con el criterio.
         *
         * @param elemento el elemento a evaluar
         * @return true si cumple el criterio
         */
        boolean cumple(T elemento);
    }

    /**
     * Interfaz funcional genérica para transformar un elemento
     * de tipo T a tipo R.
     *
     * @param <T> el tipo de entrada
     * @param <R> el tipo de salida
     */
    interface Transformador<T, R> {
        /**
         * Transforma un elemento de tipo T a tipo R.
         *
         * @param elemento el elemento a transformar
         * @return el resultado de la transformación
         */
        R transformar(T elemento);
    }

    // ========================================================
    //  CLASE UTILITARIA GENÉRICA
    // ========================================================

    /**
     * Clase utilitaria con métodos estáticos genéricos para
     * procesar colecciones de cualquier tipo.
     * Demuestra el poder de combinar genéricos con colecciones.
     */
    static class UtilidadListas {

        /**
         * Filtra una lista según un criterio dado.
         * Devuelve una nueva lista con los elementos que cumplen
         * el criterio.
         *
         * @param <T>      el tipo de los elementos
         * @param lista    la lista original
         * @param criterio el criterio de filtrado
         * @return nueva lista con los elementos que cumplen el criterio
         */
        public static <T> List<T> filtrar(List<T> lista, Criterio<T> criterio) {
            List<T> resultado = new ArrayList<>();
            for (T elemento : lista) {
                if (criterio.cumple(elemento)) {
                    resultado.add(elemento);
                }
            }
            return resultado;
        }

        /**
         * Transforma cada elemento de una lista a otro tipo.
         * Similar a la operación "map" en programación funcional.
         *
         * @param <T>           el tipo de entrada
         * @param <R>           el tipo de salida
         * @param lista         la lista original
         * @param transformador la función de transformación
         * @return nueva lista con los elementos transformados
         */
        public static <T, R> List<R> transformar(List<T> lista,
                                                  Transformador<T, R> transformador) {
            List<R> resultado = new ArrayList<>();
            for (T elemento : lista) {
                resultado.add(transformador.transformar(elemento));
            }
            return resultado;
        }

        /**
         * Imprime una lista con un título descriptivo.
         *
         * @param <T>    el tipo de los elementos
         * @param titulo el título a mostrar
         * @param lista  la lista a imprimir
         */
        public static <T> void imprimirLista(String titulo, List<T> lista) {
            System.out.println("  " + titulo + ":");
            System.out.print("    → ");
            if (lista.isEmpty()) {
                System.out.println("(vacía)");
            } else {
                System.out.println(lista);
            }
        }

        /**
         * Busca el primer elemento que cumple un criterio.
         *
         * @param <T>      el tipo de los elementos
         * @param lista    la lista donde buscar
         * @param criterio el criterio de búsqueda
         * @return el primer elemento que cumple, o null si ninguno cumple
         */
        public static <T> T buscarPrimero(List<T> lista, Criterio<T> criterio) {
            for (T elemento : lista) {
                if (criterio.cumple(elemento)) {
                    return elemento;
                }
            }
            return null;
        }

        /**
         * Cuenta cuántos elementos cumplen un criterio.
         *
         * @param <T>      el tipo de los elementos
         * @param lista    la lista a evaluar
         * @param criterio el criterio de conteo
         * @return la cantidad de elementos que cumplen
         */
        public static <T> int contar(List<T> lista, Criterio<T> criterio) {
            int contador = 0;
            for (T elemento : lista) {
                if (criterio.cumple(elemento)) {
                    contador++;
                }
            }
            return contador;
        }

        /**
         * Verifica si todos los elementos cumplen un criterio.
         *
         * @param <T>      el tipo de los elementos
         * @param lista    la lista a evaluar
         * @param criterio el criterio a verificar
         * @return true si todos cumplen el criterio
         */
        public static <T> boolean todosCumplen(List<T> lista, Criterio<T> criterio) {
            for (T elemento : lista) {
                if (!criterio.cumple(elemento)) {
                    return false;
                }
            }
            return true;
        }
    }

    // ========================================================
    //  CLASE MODELO: Producto (para ejemplos prácticos)
    // ========================================================

    /**
     * Clase que representa un producto con nombre y precio.
     * Se usa para demostrar genéricos con tipos personalizados.
     */
    static class Producto {
        private String nombre;
        private double precio;

        /**
         * Crea un nuevo producto.
         *
         * @param nombre el nombre del producto
         * @param precio el precio del producto
         */
        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        /**
         * Obtiene el nombre del producto.
         *
         * @return el nombre
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Obtiene el precio del producto.
         *
         * @return el precio
         */
        public double getPrecio() {
            return precio;
        }

        @Override
        public String toString() {
            return nombre + " ($" + String.format("%.2f", precio) + ")";
        }
    }

    // ========================================================
    //  MÉTODO PRINCIPAL: demostración completa
    // ========================================================

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║   GENÉRICOS CON COLECCIONES EN JAVA         ║");
        System.out.println("╚══════════════════════════════════════════════╝\n");

        // ---- EJEMPLO 1: List<String> ----
        System.out.println("── EJEMPLO 1: List<String> ──");

        List<String> nombres = new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Carlos");
        nombres.add("Beatriz");
        nombres.add("Diana");
        nombres.add("Eduardo");

        // El for-each sabe que cada elemento es String (sin casting)
        System.out.println("  Nombres en la lista:");
        for (String nombre : nombres) {
            System.out.println("    • " + nombre);
        }
        // nombres.add(42); // ✗ NO compila: 42 no es String
        System.out.println();

        // ---- EJEMPLO 2: Map<String, Integer> ----
        System.out.println("── EJEMPLO 2: Map<String, Integer> ──");

        Map<String, Integer> edades = new HashMap<>();
        edades.put("Ana", 22);
        edades.put("Carlos", 28);
        edades.put("Beatriz", 25);
        edades.put("Diana", 30);

        System.out.println("  Edades registradas:");
        for (Map.Entry<String, Integer> entrada : edades.entrySet()) {
            String nombre = entrada.getKey();     // Ya es String
            Integer edad = entrada.getValue();     // Ya es Integer
            System.out.println("    • " + nombre + ": " + edad + " años");
        }

        // Acceso seguro por clave
        Integer edadAna = edades.get("Ana");
        System.out.println("  Edad de Ana: " + edadAna);
        System.out.println();

        // ---- EJEMPLO 3: Set<String> (sin duplicados) ----
        System.out.println("── EJEMPLO 3: Set<String> ──");

        Set<String> lenguajes = new HashSet<>();
        lenguajes.add("Java");
        lenguajes.add("Python");
        lenguajes.add("Java");      // Duplicado, no se agrega
        lenguajes.add("C++");
        lenguajes.add("Python");    // Duplicado, no se agrega

        System.out.println("  Lenguajes únicos: " + lenguajes);
        System.out.println("  Cantidad: " + lenguajes.size());
        System.out.println();

        // ---- EJEMPLO 4: Filtrar lista de String ----
        System.out.println("── EJEMPLO 4: Filtrar con UtilidadListas ──");

        // Filtrar nombres que empiezan con una letra específica
        Criterio<String> empiezaConB = new Criterio<String>() {
            @Override
            public boolean cumple(String elemento) {
                return elemento.startsWith("B");
            }
        };

        List<String> nombresConB = UtilidadListas.filtrar(nombres, empiezaConB);
        UtilidadListas.imprimirLista("Nombres originales", nombres);
        UtilidadListas.imprimirLista("Nombres con 'B'", nombresConB);

        // Filtrar nombres largos (más de 5 caracteres)
        List<String> nombresLargos = UtilidadListas.filtrar(nombres,
                new Criterio<String>() {
                    @Override
                    public boolean cumple(String elemento) {
                        return elemento.length() > 5;
                    }
                });
        UtilidadListas.imprimirLista("Nombres largos (>5 chars)", nombresLargos);
        System.out.println();

        // ---- EJEMPLO 5: Filtrar lista de Integer ----
        System.out.println("── EJEMPLO 5: Filtrar números ──");

        List<Integer> numeros = new ArrayList<>();
        Collections.addAll(numeros, 3, 15, 7, 22, 8, 41, 12, 5, 30);

        // Filtrar números pares
        List<Integer> pares = UtilidadListas.filtrar(numeros,
                new Criterio<Integer>() {
                    @Override
                    public boolean cumple(Integer elemento) {
                        return elemento % 2 == 0;
                    }
                });

        // Filtrar números mayores a 10
        List<Integer> mayoresA10 = UtilidadListas.filtrar(numeros,
                new Criterio<Integer>() {
                    @Override
                    public boolean cumple(Integer elemento) {
                        return elemento > 10;
                    }
                });

        UtilidadListas.imprimirLista("Números originales", numeros);
        UtilidadListas.imprimirLista("Números pares", pares);
        UtilidadListas.imprimirLista("Números > 10", mayoresA10);
        System.out.println();

        // ---- EJEMPLO 6: Transformar (map) ----
        System.out.println("── EJEMPLO 6: Transformar elementos ──");

        // Transformar nombres a mayúsculas: List<String> → List<String>
        List<String> nombresMayusculas = UtilidadListas.transformar(nombres,
                new Transformador<String, String>() {
                    @Override
                    public String transformar(String elemento) {
                        return elemento.toUpperCase();
                    }
                });
        UtilidadListas.imprimirLista("En mayúsculas", nombresMayusculas);

        // Transformar nombres a sus longitudes: List<String> → List<Integer>
        List<Integer> longitudes = UtilidadListas.transformar(nombres,
                new Transformador<String, Integer>() {
                    @Override
                    public Integer transformar(String elemento) {
                        return elemento.length();
                    }
                });
        UtilidadListas.imprimirLista("Longitudes", longitudes);
        System.out.println();

        // ---- EJEMPLO 7: Genéricos con objetos personalizados ----
        System.out.println("── EJEMPLO 7: Genéricos con Producto ──");

        List<Producto> catalogo = new ArrayList<>();
        catalogo.add(new Producto("Laptop", 15999.99));
        catalogo.add(new Producto("Mouse", 299.50));
        catalogo.add(new Producto("Teclado", 599.00));
        catalogo.add(new Producto("Monitor", 8500.00));
        catalogo.add(new Producto("Cable USB", 49.90));
        catalogo.add(new Producto("Audífonos", 1200.00));

        UtilidadListas.imprimirLista("Catálogo completo", catalogo);

        // Filtrar productos caros (> $1000)
        List<Producto> productosCaros = UtilidadListas.filtrar(catalogo,
                new Criterio<Producto>() {
                    @Override
                    public boolean cumple(Producto elemento) {
                        return elemento.getPrecio() > 1000.0;
                    }
                });
        UtilidadListas.imprimirLista("Productos > $1,000", productosCaros);

        // Filtrar productos baratos (< $500)
        List<Producto> productosBaratos = UtilidadListas.filtrar(catalogo,
                new Criterio<Producto>() {
                    @Override
                    public boolean cumple(Producto elemento) {
                        return elemento.getPrecio() < 500.0;
                    }
                });
        UtilidadListas.imprimirLista("Productos < $500", productosBaratos);

        // Transformar productos a solo sus nombres
        List<String> nombresProductos = UtilidadListas.transformar(catalogo,
                new Transformador<Producto, String>() {
                    @Override
                    public String transformar(Producto elemento) {
                        return elemento.getNombre();
                    }
                });
        UtilidadListas.imprimirLista("Solo nombres", nombresProductos);
        System.out.println();

        // ---- EJEMPLO 8: Métodos buscarPrimero, contar, todosCumplen ----
        System.out.println("── EJEMPLO 8: Buscar, contar, verificar ──");

        // Buscar primer producto con precio > 5000
        Producto caro = UtilidadListas.buscarPrimero(catalogo,
                new Criterio<Producto>() {
                    @Override
                    public boolean cumple(Producto elemento) {
                        return elemento.getPrecio() > 5000;
                    }
                });
        System.out.println("  Primer producto > $5,000: " + caro);

        // Contar productos baratos
        int cantidadBaratos = UtilidadListas.contar(catalogo,
                new Criterio<Producto>() {
                    @Override
                    public boolean cumple(Producto elemento) {
                        return elemento.getPrecio() < 500;
                    }
                });
        System.out.println("  Productos < $500: " + cantidadBaratos);

        // ¿Todos cuestan más de $10?
        boolean todosCaros = UtilidadListas.todosCumplen(catalogo,
                new Criterio<Producto>() {
                    @Override
                    public boolean cumple(Producto elemento) {
                        return elemento.getPrecio() > 10;
                    }
                });
        System.out.println("  ¿Todos cuestan > $10? " + todosCaros);
        System.out.println();

        // ---- EJEMPLO 9: Map con genéricos complejos ----
        System.out.println("── EJEMPLO 9: Map<String, List<String>> ──");

        // Mapa donde cada clave tiene una lista de valores
        Map<String, List<String>> cursosPorEstudiante = new HashMap<>();

        List<String> cursosAna = new ArrayList<>();
        cursosAna.add("Java");
        cursosAna.add("Base de Datos");
        cursosAna.add("Redes");
        cursosPorEstudiante.put("Ana", cursosAna);

        List<String> cursosCarlos = new ArrayList<>();
        cursosCarlos.add("Java");
        cursosCarlos.add("Python");
        cursosPorEstudiante.put("Carlos", cursosCarlos);

        System.out.println("  Cursos por estudiante:");
        for (Map.Entry<String, List<String>> entrada : cursosPorEstudiante.entrySet()) {
            System.out.println("    • " + entrada.getKey() + ": " + entrada.getValue());
        }
        System.out.println();

        // ---- RESUMEN FINAL ----
        System.out.println("── RESUMEN ──");
        System.out.println("✅ List<T>, Set<T>, Map<K,V> usan genéricos para seguridad");
        System.out.println("✅ Las clases utilitarias genéricas son altamente reutilizables");
        System.out.println("✅ Criterio<T> y Transformador<T,R> demuestran interfaces genéricas");
        System.out.println("✅ Los genéricos eliminan casting y previenen errores en ejecución");
    }
}
