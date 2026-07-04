import java.util.*;
import java.util.stream.Collectors;

public class Solucion25_AnalizadorLogs {
    public static void main(String[] args) {
        List<String> logs = Arrays.asList(
            "[INFO] Usuario login exitoso",
            "[ERROR] Conexion fallida al servidor de base de datos",
            "[WARN] Memoria al 85% de uso",
            "[INFO] Archivo procesado correctamente",
            "[ERROR] Timeout en la solicitud HTTP",
            "[INFO] Sesion cerrada",
            "[ERROR] NullPointerException en modulo de facturacion"
        );
        Map<String, Long> conteo = logs.stream().collect(Collectors.groupingBy(l -> l.substring(1, l.indexOf("]")), Collectors.counting()));
        System.out.println("Conteo: " + conteo);
        System.out.println("\nErrores:");
        logs.stream().filter(l -> l.startsWith("[ERROR]")).forEach(System.out::println);
        Optional<String> masLargo = logs.stream().filter(l -> l.startsWith("[ERROR]")).max(Comparator.comparingInt(String::length));
        masLargo.ifPresent(l -> System.out.println("\nError mas largo: " + l));
    }
}
