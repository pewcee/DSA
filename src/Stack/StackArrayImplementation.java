package Stack;

public class StackArrayImplementation {
    private String[] s;
    private int N = 0;

    /**
     * Kích cỡ của stack
     */
    public StackArrayImplementation(int capacity) {
        s = new String[capacity];
    }

    /**
     * Gán item vào vị trí N và tăng N lên 1 đơn vị.
     */
    public void push(String item) {
        s[N++] = item;
    }

    /**
     * Truy cập vào phần tử có vị trí N-1 trong mảng.
     */
    public String pop() {
        return s[--N];
    }
}
