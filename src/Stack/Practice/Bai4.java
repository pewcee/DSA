package Stack.Practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Bai4 {
    public ArrayList<Integer> sot(ArrayList<Integer> cuong) {
        for(int i = 0; i < cuong.size(); i++) {
            int max = cuong.get(i);
            int indx = i;
            for(int j = i + 1; j < cuong.size(); j++) {
                if (cuong.get(j) > max) {
                    max = cuong.get(j);
                    indx = j;
                }
            }
            if (indx != i) {
                Collections.swap(cuong, i, indx);
            }
        }
        return cuong;
    }

    public static void main(String[] args) {
        ArrayList<Integer> c = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            c.add(scanner.nextInt());
        }
        Bai4 b = new Bai4();
        c = b.sot(c);
        for(int it : c) {
            System.out.print(it + " ");
        }
    }
}

//test ngẫu nhiên thì phải duyệt hết cả mảng để tìm max.
//test gần như được sắp xếp vẫn phải chạy hết cả mảng để tìm max nên vẫn thế.
