package Stack.Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GameOfTwoStacks {
    public class MyQueue {
        public class Node {
            int item;
            Node next;
            public Node(int item) {
                this.item = item;
                this.next = null;
            }
        }

        private Node first;
        private Node last;

        public MyQueue() {
            first = null;
            last = null;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public void enqueue(int item) {
            Node oldLast = last;
            last = new Node(item);
            if(isEmpty()) {
                first = last;
            } else {
                oldLast.next = last;
            }
        }

        public int dequeue() {
            int item = first.item;
            first = first.next;
            if(first == null) {
                last = null;
            }
            return item;
        }

        public void print() {
            if(isEmpty()) {
                System.out.println("queue is null!");
            } else {
                Node curNode = first;
                while(curNode != null) {
                    System.out.print(curNode.item + "->");
                    curNode = curNode.next;
                }
                System.out.println("null");
            }
        }
    }

    public int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        MyQueue qe = new MyQueue();
        int count = 0;
        int sum = 0;

        int i = 0;
        while (i < a.size() && sum + a.get(i) <= maxSum) {
            sum += a.get(i);
            qe.enqueue(a.get(i));
            count++;
            i++;
        }

        int j = 0;
        while (j < b.size() && i >= 0) {
            sum += b.get(j);
            j++;

            while (sum > maxSum && i > 0) {
                i--;
                sum -= qe.dequeue();
            }

            if (sum <= maxSum) {
                count = Math.max(count, i + j);
            }
        }

        return count;
    }

    public int twoStacks2(int maxSum, List<Integer> a, List<Integer> b) {
        int sum = 0;
        int cnt = 0;

        int i = 0;
        while (i < a.size() && sum + a.get(i) <= maxSum) {
            sum += a.get(i);
            i++;
        }

        cnt = i;

        int j = 0;
        while (j < b.size() && i >= 0) {
            sum += b.get(j);
            j++;

            while (sum > maxSum && i > 0) {
                i--;
                sum -= a.get(i);
            }

            if (sum <= maxSum) {
                cnt = Math.max(cnt, i + j);
            }
        }

        return cnt;
    }



    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(2);
        list1.add(4);
        list1.add(6);
        list1.add(1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(1);
        list2.add(8);
        list2.add(5);

        GameOfTwoStacks g = new GameOfTwoStacks();
        System.out.println(g.twoStacks(10, list1, list2));
    }
}


