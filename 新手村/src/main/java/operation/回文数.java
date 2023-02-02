package operation;

/**
 * @author luofan
 */
public class 回文数 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x == 0) {
            return true;
        }
        int num = 0;
        int y = x;
        while (y != 0) {
            num = y % 10 + num * 10;
            y = y / 10;
        }
        return num == x;
    }
}
