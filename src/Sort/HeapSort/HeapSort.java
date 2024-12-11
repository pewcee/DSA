package Sort.HeapSort;

import java.util.Scanner;

public class HeapSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for(int k = N/2; k >= 1; k--) {
            sink(a, k, N);
        }
        while(N - 1 > 0) {
            exch(a, 0, N - 1);
            sink(a, 1, --N);
        }
    }

    private static void sink(Comparable[] a, int k, int N) {
        while(2*k <= N) {
            int j = 2*k;
            if(j < N && less(a, j - 1, j)) j++;
            if(less(a, j - 1, k - 1)) break;
            exch(a, j - 1, k - 1);
            k = j;
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] a = new Integer[n];

        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        scanner.close();

        sort(a);

        for(Integer it : a) {
            System.out.print(it + " ");
        }
    }
}
