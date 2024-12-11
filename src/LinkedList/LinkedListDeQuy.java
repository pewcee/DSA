package LinkedList;

public class LinkedListDeQuy {
    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Hàm thêm phần tử vào cuối danh sách
    public void append(String data) {
        head = appendDQ(head, data);
    }

    private Node appendDQ(Node current, String data) {
        if (current == null) {
            return new Node(data);
        }
        current.next = appendDQ(current.next, data);
        return current;
    }

    // Hàm xóa nút đầu tiên có dữ liệu giống tham số
    public void removeFirst(String data) {
        head = removeFirstDQ(head, data);
    }

    private Node removeFirstDQ(Node current, String data) {
        if (current == null) return null;
        if (current.data.equals(data)) return current.next;
        current.next = removeFirstDQ(current.next, data);
        return current;
    }

    // Hàm xóa tất cả các nút có dữ liệu giống tham số
    public void removeAll(String data) {
        head = removeAllDQ(head, data);
    }

    private Node removeAllDQ(Node current, String data) {
        if (current == null) return null;
        current.next = removeAllDQ(current.next, data);
        return current.data.equals(data) ? current.next : current;
    }

    // Hàm đảo ngược danh sách
    public void reverse() {
        head = reverseDQ(null, head);
    }

    private Node reverseDQ(Node prev, Node current) {
        if (current == null) return prev;
        Node nextNode = current.next;
        current.next = prev;
        return reverseDQ(current, nextNode);
    }
}
