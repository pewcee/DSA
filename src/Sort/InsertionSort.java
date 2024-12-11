package Sort;

public class InsertionSort {
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] =tmp;
    }

    public static void Insertion_Sort(Comparable[] a) {
        for(int i = 1;i < a.length; i++) {
            Comparable x = a[i];
            int pos = i - 1;
            while(pos >= 0 && less(x, a[pos])) {
                a[pos + 1] = a[pos];
                pos--;
            }
            a[pos + 1] = x;
        }
    }
}
