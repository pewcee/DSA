package Stack.Practice;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    private Stack<String> st;

    public SimpleTextEditor() {
        st = new Stack<>();
    }

    public String append(String w, String s) {
        st.push(s);
        return s.concat(w);
    }

    public String delete(int k, String s) {
        st.push(s);
        return s.substring(0, s.length() - k);
    }

    public void print(int k, String s) {
        System.out.println(s.charAt(k - 1));
    }

    public String undo(String s) {
        if(!st.isEmpty()) {
            return st.pop();
        } else {
            return null;
        }
    }

    public boolean stIsNull() {
        return st.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Stack<String> ops = new Stack<>();
        for (int i = 0; i < n; i++) {
            String tmp = scanner.nextLine();
            ops.push(tmp);
        }
        SimpleTextEditor sp = new SimpleTextEditor();
        String value = new String();
        for(String it : ops) {
            String[] a = it.split(" ");
            int op = Integer.parseInt(a[0]);
            switch (op) {
                case 1:
                    value = sp.append(a[1], value);
                    break;
                case 2:
                    int k2 = Integer.parseInt(a[1]);
                    value = sp.delete(k2, value);
                    break;
                case 3:
                    int k3 = Integer.parseInt(a[1]);
                    sp.print(k3, value);
                    break;
                case 4:
                    if(!sp.stIsNull()) {
                        value = sp.undo(value);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
