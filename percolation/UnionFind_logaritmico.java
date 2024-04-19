import java.util.HashMap;
import java.util.Map;

public class UnionFind_logaritmico {
    private Map<Integer, Integer> root;
    private Map<Integer, Integer> weight;

    public UnionFind_logaritmico(int n) {
        root = new HashMap<>();
        weight = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            root.put(i, i); // inicialmente, cada elemento é pai de si mesmo
            weight.put(i, 0); // inicialmente, cada família tem peso 0
        }
    }

    public int find(int x) {
        // se x é pai de si mesmo, ele é o patriarca
        if (x != root.get(x)) {
            root.put(x, find(root.get(x)));
        }
        return root.get(x);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);

        // se x e y já estão na mesma família, não precisamos fazer nada
        if (x == y) {
            return;
        }

        // se x e y não estão na mesma família, vamos juntar as duas
        // fazendo com que o patriarca da maior família seja o pai do patriarca da menor família
        if (weight.get(x) < weight.get(y)) {
            root.put(x, y);
        } else if (weight.get(x) > weight.get(y)) {
            root.put(y, x);
        } else {
            root.put(x, y);
            weight.put(y, weight.get(y) + 1);
        }
    }

    public static void main(String[] args) {
        int n = 10; // exemplo de uso
        UnionFind_logaritmico uf = new UnionFind_logaritmico(n);

        // exemplo de operações de união e busca
        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(1, 3);
        System.out.println(uf.find(2)); // saída esperada: 4
    }
}
