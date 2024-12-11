package Stack.Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//sô lớn nhất trong stack.
public class MaximunElement {
    public static List<Integer> getMax(List<String> operations) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxstack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        for(String it : operations) {
            String[] part = it.split(" ");

            String tmp = part[0];

            if(tmp.equals("1")) {
                stack.add(Integer.parseInt(part[1]));
                if(maxstack.isEmpty() || maxstack.peek() <= Integer.parseInt(part[1])) {
                    maxstack.add(Integer.parseInt(part[1]));
                }
            } else if(tmp.equals("2")) {
                int x = stack.peek();
                stack.pop();
                if(!maxstack.isEmpty()) {
                    if(maxstack.peek() == x) {
                        maxstack.pop();
                    }
                }
            } else if(tmp.equals("3")) {
                res.add(maxstack.peek());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<String> ops = new ArrayList<>();
        int cnt =0;
        while(cnt < n) {
            ops.add(scanner.nextLine().trim());
            cnt++;
        }
        List<Integer> max = MaximunElement.getMax(ops);
        for(int it : max) {
            System.out.print(it + " ");
        }
    }
}
