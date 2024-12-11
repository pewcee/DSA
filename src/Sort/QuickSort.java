package Sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    // Hàm so sánh hai phần tử
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // Hàm hoán đổi hai phần tử
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // Hàm phân đoạn
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable pivot = a[lo];

        while (true) {
            // Tìm phần tử bên trái lớn hơn hoặc bằng pivot
            while (less(a[++i], pivot)) if(i == hi) break;
            // Tìm phần tử bên phải nhỏ hơn hoặc bằng pivot
            while (less(pivot, a[--j])) if(j == lo) break;
            // Kiểm tra xem hai chỉ số có giao nhau
            if(i >= j) break;
            // Hoán đổi phần tử a[i] và a[j]
            exch(a, i, j);
        }
        // Đặt pivot vào đúng vị trí của nó
        exch(a, lo, j);
        return j; // Trả về vị trí của pivot
    }

    // Hàm đệ quy Quick Sort
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return; // Điều kiện dừng
        int j = partition(a, lo, hi); // Phân đoạn mảng
        sort(a, lo, j - 1); // Sắp xếp phần bên trái
        sort(a, j + 1, hi); // Sắp xếp phần bên phải
    }

    // Hàm xáo trộn mảng ngẫu nhiên
    private static void shuffle(Object[] a) {
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = i + rand.nextInt(a.length - i); // Tạo số ngẫu nhiên trong phạm vi còn lại của mảng
            exch(a, i, r); // Hoán đổi phần tử
        }
    }

    // Hàm chính để sắp xếp mảng
    public static void sort(Comparable[] a) {
        // Xáo trộn mảng để cải thiện hiệu suất
        shuffle(a);
        // Gọi hàm sort đệ quy
        sort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        File file = new File("D:\\UET\\algs4\\algs4-data\\16Kints.txt");
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
        sort(arr, 0, arr.length - 1);
        //sort(arr);
        long endTime = System.nanoTime();

        System.out.println("Mảng sau khi sắp xếp:");
        for(Integer it : arr) {
            System.out.print(it + " ");
        }
        System.out.println();

        long duration = (endTime - startTime) / 1000000;
        System.out.println("Thời gian chạy của QuickSort: " + duration + " ms");
    }

}
