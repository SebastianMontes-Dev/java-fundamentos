/**
 * ============================================================
 *  TEMA: StringBuilder en Casos Prácticos Reales
 *  SECCIÓN: 20 — StringBuilder y Regex
 *  ARCHIVO: StringBuilderPractico.java
 * ============================================================
 *
 *  ¿QUÉ APRENDERÁS EN ESTE ARCHIVO?
 *  ----------------------------------
 *  StringBuilder brilla en escenarios reales donde construyes strings
 *  dinámicamente: generar un reporte de ventas, crear un archivo CSV,
 *  producir HTML o JSON manualmente, o formatear una tabla alineada.
 *  Estas son tareas cotidianas en cualquier aplicación backend o de
 *  procesamiento de datos, y StringBuilder es la herramienta correcta.
 *
 *  CONCEPTOS CLAVE:
 *  ----------------------------------
 *  - Generar CSV: filas separadas por coma, con cabecera.
 *  - Generar reportes: combinar datos con formato.
 *  - Formatear tablas: alinear columnas con String.format() y append.
 *  - HTML/JSON simples: construir markup sin librerías externas.
 *  - Patrón: usar StringBuilder como "acumulador" de output.
 *
 *  SINTAXIS BÁSICA:
 *  ----------------------------------
 *  StringBuilder sb = new StringBuilder();
 *  sb.append("Nombre,Edad\n");  // Cabecera CSV
 *  sb.append("Ana,25\n");       // Datos
 *
 *  ERRORES COMUNES:
 *  ----------------------------------
 *  - Concatenar con + dentro de append(): `sb.append(a + b)` derrota el
 *    propósito. Usa `sb.append(a).append(b)`.
 *  - Olvidar los saltos de línea en reportes (usa \n o System.lineSeparator()).
 *
 *  RECURSOS ADICIONALES:
 *  ----------------------------------
 *  - Documentación oficial: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/StringBuilder.html
 * ============================================================
 */
public class StringBuilderPractico {

    public static void main(String[] args) {
        System.out.println("=== StringBuilder: Casos Prácticos ===");
        System.out.println();

        // --- GENERAR CSV ---
        System.out.println("--- 1. Generar CSV ---");
        String csv = generarCSV();
        System.out.println(csv);
        System.out.println();

        // --- GENERAR REPORTE ---
        System.out.println("--- 2. Reporte de Ventas ---");
        String reporte = generarReporteVentas();
        System.out.println(reporte);
        System.out.println();

        // --- TABLA FORMATEADA ---
        System.out.println("--- 3. Tabla Alineada ---");
        String tabla = generarTablaProductos();
        System.out.println(tabla);
        System.out.println();

        // --- HTML SIMPLE ---
        System.out.println("--- 4. HTML Dinámico ---");
        String html = generarHTML();
        System.out.println(html);
    }

    static String generarCSV() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre,Email,Edad,Puntaje\n"); // Cabecera
        sb.append("Ana López,ana@email.com,25,92.5\n");
        sb.append("Carlos Ruiz,carlos@email.com,30,87.0\n");
        sb.append("María Gómez,maria@email.com,22,95.3\n");
        sb.append("Pedro Díaz,pedro@email.com,28,78.9\n");
        return sb.toString();
    }

    static String generarReporteVentas() {
        String[] vendedores = {"Ana", "Carlos", "María", "Pedro"};
        double[] ventas = {15000.50, 22300.00, 18750.75, 9200.30};

        StringBuilder sb = new StringBuilder();
        sb.append("===================================\n");
        sb.append("  REPORTE DE VENTAS - Julio 2026\n");
        sb.append("===================================\n\n");

        double total = 0;
        for (int i = 0; i < vendedores.length; i++) {
            sb.append(String.format("  %-10s  $%,.2f%n", vendedores[i], ventas[i]));
            total += ventas[i];
        }

        sb.append("  --------------------------\n");
        sb.append(String.format("  %-10s  $%,.2f%n", "TOTAL", total));
        sb.append("\n  Mejor vendedor: ").append(vendedores[1]);
        sb.append(" ($").append(String.format("%,.2f", ventas[1])).append(")");

        return sb.toString();
    }

    static String generarTablaProductos() {
        String[] productos = {"Laptop", "Mouse", "Teclado Mecánico", "Monitor 27\"", "Hub USB-C"};
        double[] precios = {999.99, 25.50, 149.00, 329.99, 45.00};
        int[] stock = {15, 200, 45, 8, 120};

        StringBuilder sb = new StringBuilder();
        sb.append("+-------------------+----------+-------+\n");
        sb.append(String.format("| %-17s | %8s | %5s |%n", "Producto", "Precio", "Stock"));
        sb.append("+-------------------+----------+-------+\n");

        for (int i = 0; i < productos.length; i++) {
            sb.append(String.format("| %-17s | $%7.2f | %5d |%n",
                    productos[i], precios[i], stock[i]));
        }
        sb.append("+-------------------+----------+-------+\n");

        return sb.toString();
    }

    static String generarHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html>\n");
        sb.append("<head><title>Recibo</title></head>\n");
        sb.append("<body>\n");
        sb.append("  <h1>Recibo de Compra</h1>\n");
        sb.append("  <table border='1'>\n");
        sb.append("    <tr><th>Item</th><th>Precio</th></tr>\n");
        sb.append("    <tr><td>Laptop</td><td>$999.99</td></tr>\n");
        sb.append("    <tr><td>Mouse</td><td>$25.50</td></tr>\n");
        sb.append("    <tr><td><strong>Total</strong></td>");
        sb.append("<td><strong>$1,025.49</strong></td></tr>\n");
        sb.append("  </table>\n");
        sb.append("</body>\n");
        sb.append("</html>");

        return sb.toString();
    }
}
