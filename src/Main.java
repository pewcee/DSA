import Queue.QueueLinkedListImplementation;
import Stack.StackLinkedListImplementation;

public class Main {
    public static void main(String[] args) {
        QueueLinkedListImplementation qe = new QueueLinkedListImplementation();
        qe.enqueue(Integer.toString(1));
        qe.enqueue(Integer.toString(2));
        qe.enqueue(Integer.toString(3));
        qe.enqueue(Integer.toString(4));
        qe.enqueue(Integer.toString(5));
        qe.show();
        System.out.println("lay duoc" + qe.dequeue());
        System.out.println("lay duoc" + qe.dequeue());
        System.out.println("lay duoc" + qe.dequeue());
        qe.show();
    }
}