package LinkedList.Practice;

import LinkedList.SinglyLinkedList;

import java.util.HashSet;

/**
 * Có thể dùng cách lưu vào HashSet.
 * Đầu tiên ta chạy list A, lưu các phần tử vào HashSet.
 * Sau đó chạy list B, Node đầu tiên trùng lặp là điểm hợp nhất.
 */
public class TimDiemHopNhat {
    public static int findMergePoint(SinglyLinkedList.Node head1, SinglyLinkedList.Node head2) {
        HashSet<SinglyLinkedList.Node> hashnode = new HashSet<>();

        while(head1 != null) {
            hashnode.add(head1);
            head1 = head1.next;
        }

        while(head2 != null) {
            if(hashnode.contains(head2)) {
                return head2.value;
            }
            head2 = head2.next;
        }

        return -1;
    }

    public static void main(String[] args) {
        SinglyLinkedList.Node n1 = new SinglyLinkedList.Node(1);
        SinglyLinkedList.Node n2 = new SinglyLinkedList.Node(2);
        SinglyLinkedList.Node n3 = new SinglyLinkedList.Node(3);

        n1.next = n3;
        n2.next = n3;

        System.out.println(findMergePoint(n1, n2));

    }
}
