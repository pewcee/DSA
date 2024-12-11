package UnionFind;

public class QuickFind {
    private int[] id;

    //O(N)
    public QuickFind(int N) {
        id = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    //O(1)
    //chỉ cần trả về id của i.
    public int find(int i) {
        return id[i];
    }

    //O(N)
    //duyệt cả mảng để đổi id những ci từ p thành q.
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for(int i = 0; i< id.length; i++) {
            if(id[i] == pid) {
                id[i] = qid;
            }
        }
    }

    //O(1)
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }
}
