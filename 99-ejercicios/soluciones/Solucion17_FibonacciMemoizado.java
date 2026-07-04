import java.util.HashMap;
import java.util.Map;

public class Solucion17_FibonacciMemoizado {
    static Map<Integer, Long> cache = new HashMap<>();
    static long fibMemo(int n) {
        if (n <= 1) return n;
        if (cache.containsKey(n)) return cache.get(n);
        long res = fibMemo(n - 1) + fibMemo(n - 2);
        cache.put(n, res);
        return res;
    }
    public static void main(String[] args) {
        int n = 45;
        long t1 = System.nanoTime();
        long r = fibMemo(n);
        long t2 = System.nanoTime();
        System.out.printf("fib(%d) = %d (memoizado: %.2f ms)%n", n, r, (t2 - t1) / 1_000_000.0);
    }
}
