package Stack;

public class StackLinkedListImplementation {
    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Trả về Node sau Node đầu tiên.
     */
    public String pop() {
        if(isEmpty()) {
            return null;
        }

        String item = first.item;
        first = first.next;
        return item;
    }

    /**
     * Tạo Node oldFirst lưu first cũ.
     * Cho First trỏ vào null.
     * Cho item của First là item.
     * Cho First trỏ tới oldFirst.
     */
    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public void show() {
        if(isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        Node curNode = first;
        while (curNode != null) {
            System.out.print(curNode.item + "->");
            curNode = curNode.next;
        }
        System.out.println("null");
    }

}
