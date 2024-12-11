package Queue;

public class QueueResizingArrayImplementation {
    private String[] queue;
    private int first;
    private int last;
    private int size;

    public QueueResizingArrayImplementation() {
        queue = new String[2];
        first = 0;
        last = 0;
        size = 0;
    }

    public boolean isEmpty() {return size == 0;}

    /**
     * Thêm phần tử.
     */
    public void enqueue(String item) {
        if (size == queue.length) { // Nếu mảng đầy, tăng kích thước gấp đôi
            resize(2 * queue.length);
        }
        queue[last++] = item; // Thêm phần tử vào vị trí last, sau đó tăng last
        if (last == queue.length) { // Quay vòng lại đầu mảng nếu last đạt đến cuối mảng
            last = 0;
        }
        size++;
    }

    /**
     * Điều chỉnh kích thước mảng.
     */
    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = queue[(first + i) % queue.length];
        }
        queue = copy;
        first = 0;
        last = size;
    }

    /**
     * Xóa phần tử.
     */
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("hang doi rong");
        }
        String item = queue[first];
        queue[first] = null; // Đặt vị trí first là null để giải phóng bộ nhớ
        first++;
        if (first == queue.length) { // Quay vòng lại đầu mảng nếu first đạt đến cuối mảng
            first = 0;
        }
        size--;
        // Giảm kích thước mảng nếu số phần tử còn 1/4 kích thước mảng
        if (size > 0 && size == queue.length / 4) {
            resize(queue.length / 2);
        }
        return item;
    }

    /**
     * Xem phần tử ở đầu hàng đợi mà không xóa nó.
     */
    public String peek() {
        if (isEmpty()) {
            return "hang doi rong";
        }
        return queue[first];
    }

    /**
     * in.
     */
    public void show() {
        if (isEmpty()) {
            System.out.println("hang doi rong");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(first + i) % queue.length] + " ");
        }
        System.out.println();
    }
}
