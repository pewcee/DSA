package Queue;

public class QueueLinkedListImplementation {
    public class Node {
        String item;
        Node next;

        public Node(String item) {
            this.item = item;
            this.next = null;
        }
    }

    private Node first, last;

    public QueueLinkedListImplementation() {
        this.first = this.last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Thêm phần tử.
     */
    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node(item);
        if(isEmpty()) first = last;
        else oldLast.next = last;
    }

    /**
     * Xóa phần tử.
     */
    public String dequeue() {
        String item = first.item;
        first = first.next;
        if(first == null) {
            last = null;
        }
        return item;
    }

    /**
     * xem phần tử ở đầu mà không xóa nó.
     */
    public String peak() {
        if(isEmpty()) {
            return "queue is empty!";
        }
        return first.item;
    }

    /**
     * in.
     */
    public void show() {
        if(isEmpty()) {
            System.out.println("queue is null!");
            return;
        }
        Node curNode = first;
        while(curNode != null) {
            System.out.print(curNode.item + "->");
            curNode = curNode.next;
        }
        System.out.println("null");
    }

}
