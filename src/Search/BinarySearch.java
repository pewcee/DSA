package Search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    private static int search(int V, List<Integer> arr) {
        int l = 0;
        int r = arr.size() - 1;


        while (l <= r) {
            int m = (l + r) / 2;
            if(arr.get(m) == V) {
                return m;
            }
            if(arr.get(m) < V) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }                                         
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(search(6, list));
    }
}
