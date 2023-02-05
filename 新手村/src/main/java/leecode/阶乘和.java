package leecode;

/**
 * @author luofan
 */
public class 阶乘和 {
    public static void main(String[] args) {
        int n = 1;
       domethod(n);
    }

    private static void domethod(int n) {
        int sum = 0;
        int cur = 1;
        for (int i = 1; i <= n; i++) {
            cur = cur * i;
            sum += cur;
        }
        System.out.println(sum);
    }
}
