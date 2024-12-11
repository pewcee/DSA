package Sort;

public class SelectionSort {
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] =tmp;
    }

    public static void Selection_Sort(Comparable[] a) {
        for(int i = 0;i < a.length - 1;i++) {
            int min_pos = i;
            for(int j = i + 1;j < a.length - 1;j++) {
                if(less(a[j], a[min_pos])) {
                    min_pos = j;
                }
            }
            if(min_pos != i) {
                exch(a, i, min_pos);
            }
        }
    }
}
