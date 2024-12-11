package UnionFind;

public class QuickUnion {
    private int[] id;

    //O(N)
    public QuickUnion(int N) {
        id = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    //O(N) trong trường hợp tệ nhất.
    //khi mà cây quá cao.
    public int root(int i) {
        while(i != id[i]) i = id[i];
        return i;
    }

    //phụ thuộc vào find.
    //O(N) trong trường hợp tệ nhất.
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    //phụ thuộc vào find.
    //tệ nhất là O(N).
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }
}
