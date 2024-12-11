package LinkedList.Practice;

import LinkedList.SinglyLinkedList;

/**
 * Dùng thuật toán "Tortoise and Hare".
 * Sử dụng hai con trỏ: slow và fast.
 * slow di chuyển một bước mỗi lần, trong khi fast di chuyển hai bước.
 * Nếu có chu kỳ, fast sẽ "bắt kịp" slow tại một điểm nào đó trong chu kỳ.
 * Nếu không có chu kỳ, fast sẽ đạt đến cuối danh sách (null).
 */
public class KiemTraChuKi {
    public static boolean hasCycle(SinglyLinkedList.Node head) {
        // nếu danh sách rỗng hoặc chỉ có 1 phần tử trả về false.
        if(head == null || head.next == null) {
            return false;
        }

        SinglyLinkedList.Node slow = head;
        SinglyLinkedList.Node fast = head.next;

        // nếu slow bằng fast thì có chu kì.
        // nếu fast chạy đến cuối thì không có chu kì.
        //slow tăng lên 1 bước, fast tăng lên 2 bước.
        //nếu slow = fast có chu kì, chạy hết vòng while.
        while(slow != fast) {
            if(fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

