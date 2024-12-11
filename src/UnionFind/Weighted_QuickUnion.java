package UnionFind;

public class Weighted_QuickUnion {
    private int[] id;
    private int[] sz;

    //O(N)
    public Weighted_QuickUnion(int N) {
        id = new int[N];
        sz = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    //O(logN) trong trường hợp xấu nhất.
    //vì độ sâu 1 nút không vượt quá logN.
    public int find(int i) {
        while(i != id[i]) i = id[i];
        return i;
    }

    //cây thấp hơn làm con của cây cao hơn.
    //find đỡ duyệt nhiều
    //O(logN) trong trường hợp xấu nhất.
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);

        if(i == j) return;

        //sửa ở đây...
        if(sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    //O(logN) trong trường hợp tệ nhất.
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
