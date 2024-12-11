package LinkedList;

public class DoublyLinkedList {
    private static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * Thêm một nút vào đầu danh sách
     */
    public Node addFirst(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }
    }

    /**
     * Thêm một nút vào cuối danh sách
     * @param head
     * @param data
     * @return
     */
    public Node addLast(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
        return head;
    }

    /**
     * Thêm một nút vào vị trí index
     * @param head
     * @param index
     * @param data
     * @return
     */
    public Node addAtIndex(Node head, int index, int data) {
        if (index == 0) {
            return addFirst(head, data);
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        if (current.next == null) {
            current.next = newNode;
            newNode.prev = current;
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
        return head;
    }

    /**
     * Xóa nút đầu tiên trong danh sách
     * @param head
     * @return
     */
    public Node removeFirst(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        head = head.next;
        head.prev = null;
        return head;
    }

    /**
     * Xóa nút cuối cùng trong danh sách
     * @param head
     * @return
     */
    public Node removeLast(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
         
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.prev.next = null;
        return head;
    }

    /**
     * Xóa nút tại vị trí index
     * @param head
     * @param index
     * @return
     */
    public Node removeAtIndex(Node head, int index) {
        if (head == null) {
            return null;
        }
        if (index == 0) {
            return removeFirst(head);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current.next == null) {
            current.prev.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        return head;
    }

    public void reverse(Node head) {
        Node current = head;
        Node temp = null;

        // Duyệt qua danh sách và hoán đổi các con trỏ prev và next của mỗi nút
        while (current != null) {
            // Hoán đổi prev và next của nút hiện tại
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            // Di chuyển đến nút tiếp theo (theo hướng ngược lại)
            current = current.prev;
        }

        // Nếu danh sách không rỗng, cập nhật lại head
        if (temp != null) {
            head = temp.prev;
        }
    }

    /**
     *  Duyệt danh sách từ đầu đến cuối
     * @param head
     */
    public void printForward(Node head) {
        Node current = head;
        System.out.print("Danh sách từ đầu đến cuối: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     *  Duyệt danh sách từ cuối đến đầu
     * @param head
     */
    public void printBackward(Node head) {
        if (head == null) {
            return;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        System.out.print("Danh sách từ cuối đến đầu: ");
        while (tail != null) {
            System.out.print(tail.data + " ");
            tail = tail.prev;
        }
        System.out.println();
    }
}
