import java.util.ArrayList;
import java.util.NoSuchElementException;

class Cola<T> {
    private ArrayList<T> elementos = new ArrayList<>();
    void encolar(T e) { elementos.add(e); }
    T desencolar() { if(estaVacia()) throw new NoSuchElementException(); return elementos.remove(0); }
    T frente() { if(estaVacia()) throw new NoSuchElementException(); return elementos.get(0); }
    boolean estaVacia() { return elementos.isEmpty(); }
    int tamano() { return elementos.size(); }
}

public class Solucion20_ColaGenerica {
    public static void main(String[] args) {
        Cola<Integer> colaInt = new Cola<>(); colaInt.encolar(1); colaInt.encolar(2); System.out.println("Desencolar: "+colaInt.desencolar());
        Cola<String> colaStr = new Cola<>(); colaStr.encolar("Hola"); colaStr.encolar("Mundo"); System.out.println("Frente: "+colaStr.frente()+" | Tamaño: "+colaStr.tamano());
    }
}
