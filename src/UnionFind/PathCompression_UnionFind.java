package UnionFind;

public class PathCompression_UnionFind {
    private int[] id;

    public PathCompression_UnionFind(int N) {
        id = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    //nối nút đang duyệt với nút ông của nó.
    public int find(int i) {
        while(i != id[i]) {
            id[i] = id[id[i]];//sửa đây...
            i = id[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        id[i] = j;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
