package Sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MergeSort {
    private static boolean less(Comparator c, Object v, Object w) {
        return c.compare(v, w) < 0;
    }

    private static void Merge1(Object[] a, Comparator comparator, int l, int m, int r) {
        Object[] x = new Object[m - l + 1];
        Object[] y = new Object[r - m];

        for(int i = 0; i < x.length; i++) {
            x[i] = a[i + l];
        }
        for(int i = 0; i < y.length; i++) {
            y[i] = a[i + m + 1];
        }

        int cntx = 0, cnty = 0;
        while (cntx < x.length && cnty < y.length) {
            if(less(comparator, x[cntx], y[cnty])) {
                a[l++] = x[cntx++];
            } else {
                a[l++] = y[cnty++];
            }
        }
        while (cntx < x.length) {
            a[l++] = x[cntx++];
        }
        while (cnty < y.length) {
            a[l++] = y[cnty++];
        }
    }

    private static void Sort1(Object[] a, Comparator comparator, int l, int r) {
        if(r <= l) {
            return;
        }
        int m = (l + r) / 2;
        Sort1(a, comparator, l, m);
        Sort1(a, comparator, m + 1, r);
        Merge1(a, comparator, l, m, r);
    }

    private static void Merge2(Object[] a, Object[] aux, Comparator comparator, int l, int m, int r) {
        for(int k = l; k <= r; k++) {
            aux[k] = a[k];
        }

        int i = l, j = m + 1;
        for(int k = l; k <= r; k++) {
            if(i > m) {
                a[k] = aux[j++];
            } else if(j > r) {
                a[k] = aux[i++];
            } else if(less(comparator, aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static void Sort2(Object[] a, Object[] aux, Comparator comparator, int l, int r) {
        if(r <= l) {
            return;
        }
        int m = (l + r) / 2;
        Sort2(a, aux, comparator, l, m);
        Sort2(a, aux, comparator, m + 1, r);
        Merge2(a, aux, comparator, l, m, r);
    }

    private static void Sort3(Object[] a, Comparator comparator) {
        int n = a.length;
        Object[] aux = new Object[n];
        for(int sz = 1; sz < n; sz = sz + sz) {
            for(int l = 0; l < n - sz; l += sz + sz) {
                Merge2(a, aux, comparator, l, l + sz - 1, Math.min(l + sz + sz - 1, n - 1));
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("D:\\UET\\DSA\\bai tap\\val.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }

        Integer[] arr = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        long startTime = System.nanoTime();
        Comparator<Integer> comparator = Integer::compareTo;
        Integer[] aux = new  Integer[arr.length];
        Sort2(arr, aux, comparator, 0, arr.length - 1);
        long endTime = System.nanoTime();

        System.out.println("Mảng sau khi sắp xếp:");
        for(Integer it : arr) {
            System.out.print(it + " ");
        }
        System.out.println();

        long duration = (endTime - startTime) / 1000000;
        System.out.println("Thời gian chạy của MergeSort: " + duration + " ms");
    }
}
