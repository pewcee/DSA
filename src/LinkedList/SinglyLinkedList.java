package LinkedList;

public class SinglyLinkedList {
    /**
     * Định nghĩa Node.
     */
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * In ra danh sách liên kết.
     */
    public static void printLinkedList(Node head) {
        if(head == null) {
            System.out.println("List is empty");
        } else {
            Node tmp = head;
            while(tmp != null) {
                System.out.print(tmp.value);
                tmp = tmp.next;
                if(tmp != null) {
                    System.out.print("->");
                }
                else {
                    System.out.println();
                }
            }

        }
    }

    /**
     * Thêm Node vào đầu danh sách liên kết.
     */
    public static Node addToHead(Node headNode, int val) {
        Node newNode = new Node(val);
        if(headNode != null) {
            newNode.next = headNode;
        }
        return newNode;
    }

    /**
     * Thêm Node vào cuối danh sách liên kết.
     */
    public static Node addToTail(Node headNode, int val) {
        Node newNode = new Node(val);
        Node lastNode = headNode;
        if(headNode == null) {
            return newNode;
        } else {
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        return headNode;
    }

    /**
     * Thêm Node vào giữa danh sách liên kết.
     */
    public static Node addToIndex(Node headNode, int val, int index) {
        Node newNode = new Node(val);
        if(index == 0) {
            return addToHead(headNode, val);
        } else {
            Node currentNode =  headNode;
            int cnt =0;
            while (currentNode != null) {
                cnt++;
                if(cnt == index) {
                    newNode.next = currentNode.next;
                    currentNode.next = newNode;
                    break;
                }
                currentNode = currentNode.next;
            }
        }
        return headNode;
    }

    /**
     * Xóa Node ở đầu danh sách liên kết.
     */
    public static Node removeAtHead(Node headNode) {
        if(headNode != null) {
            return headNode.next;
        }
        return headNode;
    }

    /**
     * Xóa Node ở cuối danh sách liên kết
     */
    public static Node removeAtTail(Node headNode) {
        Node prevNode = null;
        Node lastNode = headNode;
        while(lastNode.next != null) {
            prevNode = lastNode;
            lastNode = lastNode.next;
        }
        if(prevNode == null) {
            return null;
        }
        prevNode.next = lastNode.next;
        return headNode;
    }

    /**
     * Xóa Node ở giữa danh sách liên kết.
     */
    public static Node removeToIndex(Node headNode, int index) {
        Node curNode = headNode;
        Node prevNode = null;
        if(index ==0) {
            return removeAtHead(headNode);
        } else {
            int cnt = 0;
            while(curNode.next != null) {
                cnt++;
                prevNode = curNode;
                curNode = curNode.next;
                if(cnt == index) {
                    prevNode.next = curNode.next;
                    break;
                }
            }
        }
        return headNode;
    }

    /**
     * Đảo ngược danh sách liên kết.
     */
    public static Node reverse(Node headNode) {
        Node prevNode = null;
        Node curNode = headNode;
        Node nextNode = curNode.next;
        while(curNode != null) {
            //lưu nút tiếp theo
            nextNode = curNode.next;
            //đảo ngược lại node hiện tại
            curNode.next = prevNode;
            //tiến node ln 1 bước
            prevNode = curNode;
            curNode = nextNode;
        }
        return prevNode;
    }

    /**
     * Hợp hai danh sách liên kết đã sắp xếp.
     */
    public static Node mergeTwoLinkedList(Node head1, Node head2) {
        Node mergeNode;
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        if(head1.value < head2.value) {
            mergeNode = head1;
            mergeNode.next = mergeTwoLinkedList(head1.next, head2);
        } else {
            mergeNode = head2;
            mergeNode.next = mergeTwoLinkedList(head1, head2.next);
        }

        return mergeNode;
    }

    /**
     * Xóa các Node trùng lặp.
     */
    public static Node removeDuplicates(Node headNode) {
        if (headNode == null || headNode.next == null) {
            return headNode;
        }

        Node curNode = headNode;
        while (curNode != null && curNode.next != null) {
            if (curNode.value == curNode.next.value) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
        }

        return headNode;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        addToTail(n1, 2);
        addToTail(n1, 3);
        addToTail(n1, 5);
        addToTail(n1, 7);
        Node n6 = new Node(9);

        Node n2 = new Node(4);
        addToTail(n2, 5);
        addToTail(n2, 6);
        addToTail(n2, 8);
        addToTail(n2, 10);
        addToTail(n2, 11);

        printLinkedList(n1);
        System.out.println();
        printLinkedList(n2);
        System.out.println();

        Node n3 = mergeTwoLinkedList(n1, n2);
        printLinkedList(n3);
        System.out.println();

        n3 = removeDuplicates(n3);
        printLinkedList(n3);
    }
}


