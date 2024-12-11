package Practice;

import edu.princeton.cs.algs4.StdIn;

// dùng đệ quy để tính giá trị biểu thức
public class Evaluate {
    public static double evaluate() {
        String token = StdIn.readString();

        //1 giá trị
        //nếu token không phải là dấu ngoặc mở, coi đó là một số và trả về giá trị của nó
        //nếu là dấu ngoặc mở thì cho đi qua, coi nó là một biểu thức
        if(!token.equals("(")) {
            return Double.valueOf(token);
        }

        //2 biểu thức đôi

        // Đệ quy tính giá trị của biểu thức bên trái
        double left = evaluate();

        // Đọc toán tử
        String operator = StdIn.readString();

        // Đệ quy tính giá trị của biểu thức bên phải
        double right = evaluate();

        // Đọc dấu ngoặc đóng
        String closingbraket = StdIn.readString();

        // Thực hiện phép toán dựa trên operator
        return operator.equals("+") ? (left + right) : (left * right);

    }
    public static void main(String[] args) {
        System.out.println(evaluate());
    }
}
