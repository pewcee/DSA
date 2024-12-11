package Stack.Practice;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//stack con lớn nhất có độ dài bằng nhau.
public class EqualStacks {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for(int it : h1) {
            sum1 += it;
        }
        for(int it : h2) {
            sum2 += it;
        }
        for(int it : h3) {
            sum3 += it;
        }

        while(sum1 != sum2 || sum2 != sum3) {
            int max = Math.max(sum1, sum2);
            max = Math.max(max, sum3);

            if(max == sum1) {
                int tmp = h1.get(0);
                h1.remove(0);
                sum1 -= tmp;
            } else if(max == sum2) {
                int tmp = h2.get(0);
                h2.remove(0);
                sum2 -= tmp;
            } if(max == sum3) {
                int tmp = h3.get(0);
                h3.remove(0);
                sum3 -= tmp;
            }
        }
        return sum1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        List<Integer> h1 = new Stack<>();
        List<Integer> h2 = new Stack<>();
        List<Integer> h3 = new Stack<>();

        for(int i = 0; i < n1; i++) {
            h1.add(scanner.nextInt());
        }
        for(int i = 0; i < n2; i++) {
            h2.add(scanner.nextInt());
        }
        for(int i = 0; i < n3; i++) {
            h3.add(scanner.nextInt());
        }

        System.out.println(equalStacks(h1, h2, h3));
    }
}
