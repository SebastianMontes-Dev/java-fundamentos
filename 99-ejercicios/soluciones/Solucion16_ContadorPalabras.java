import java.io.*;
import java.util.*;

public class Solucion16_ContadorPalabras {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> conteo = new HashMap<>();
        try (Scanner sc = new Scanner(new File("texto.txt"))) {
            while (sc.hasNext()) {
                String palabra = sc.next().toLowerCase().replaceAll("[^a-zA-Záéíóúñ]", "");
                if (!palabra.isEmpty()) conteo.put(palabra, conteo.getOrDefault(palabra, 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(conteo.entrySet());
        lista.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        System.out.println("Top 10 palabras:");
        lista.stream().limit(10).forEach(e -> System.out.printf("  %-15s %d%n", e.getKey(), e.getValue()));
    }
}
