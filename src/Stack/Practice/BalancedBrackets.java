package Stack.Practice;

import java.util.Scanner;
import java.util.Stack;

//check xem dấu {[()]} có đặt đúng chỗ không.
public class BalancedBrackets {
    public static String isBalanced(String s) {
        Stack<Character> st = new Stack<>();

        for(char it : s.toCharArray()) {
            if(it == '(' || it == '[' || it == '{') {
                st.push(it);
            } else if(st.isEmpty()) {
                return "NO";
            }
            else if(it == ')' && st.peek() == '(' ||
                    it == ']' && st.peek() == '[' ||
                    it == '}' && st.peek() == '{') {
                st.pop();
            } else {
                return "NO";
            }
        }

        if(st.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(isBalanced(s));
    }
}
