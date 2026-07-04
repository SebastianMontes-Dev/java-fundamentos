import java.util.Arrays;

public class Solucion10_BusquedaBinaria {
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72};
        int buscar = 23;
        int izquierda = 0, derecha = arr.length - 1, resultado = -1;
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (arr[medio] == buscar) { resultado = medio; break; }
            else if (arr[medio] < buscar) izquierda = medio + 1;
            else derecha = medio - 1;
        }
        System.out.println("Arreglo: " + Arrays.toString(arr));
        System.out.println("Buscar " + buscar + ": indice " + resultado);
    }
}
