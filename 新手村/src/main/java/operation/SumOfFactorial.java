package operation;

/**
 * 阶乘
 * 1！+2！+3!+......+N! = ?
 */
public class SumOfFactorial {

    public static void main(String[] args) {
        int num = 4;
        System.out.println(factorial(num));
    }

    private static int factorial(int num) {
        int cur = 1;
        int count = 0;
        for (int i = 1; i < num + 1; i++) {
            cur = cur * i;
            count += cur;
        }
        return count;
    }
}
