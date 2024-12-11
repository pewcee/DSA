package Sort.HeapSort.Practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demtu {
    public static List<Integer> action(List<Character> a) {
        List<Integer> val = new ArrayList<>();

        return  val;
    }

    public static void main(String[] args) {
        File file = new File("D:\\UET\\algs4\\algs4-data\\16Kints.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Character> charslist = new ArrayList<>();
        String input = scanner.nextLine();
        for (String s : input.split(" ")) {
            charslist.add(s.charAt(0));
        }

        long startTime = System.nanoTime();
        List<Integer> val = action(charslist);
        long endTime = System.nanoTime();

        System.out.println("Đếm từ:");
        for(int i = 0, j = 0; i < charslist.size() && j < val.size(); i++, j++) {
            System.out.println(charslist.get(i) + "(" + val.get(j) + ") ");
        }
        System.out.println();

        long duration = (endTime - startTime) / 1000000;
        System.out.println("Thời gian chạy của QuickSort: " + duration + " ms");
    }
}
