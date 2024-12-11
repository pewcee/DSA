package Stack;

public class StackResizingArrayImplementtation {
    private String s[];
    private int N = 0;
    public StackResizingArrayImplementtation() {
        s = new String[1];
    }

    /**
     * Dùng kĩ thuật repeated doubling.
     * Mảng đầy thì tạo ra mảng mới có kích thước gấp đôi mảng cũ.
     * Và copy các phần tử của mảng cũ sang mảng mới.
     * Rồi làm giống mảng thường.
     */
    public void push(String item) {
        if(N == s.length) {
            resize(2 * s.length);
        }
        s[N++] = item;
    }

    /**
     * Điều chỉnh kích thước mảng.
     */
    public void resize(int capacity) {
        String[] copy = new String[capacity];
        for(int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    /**
     * Khi mảng chỉ còn 1/4 thì giảm 1 nửa kích thước của nó.
     * Rồi làm giống như mảng thường.
     */
    public String pop() {
        String item = s[--N];
        s[N] = null;
        if(N > 0 && N == s.length / 4) {
            resize(s.length / 2);
        }
        return item;
    }
}
