package codeing;

/**
 * 今天看抖音上说两个贼大的数值怎么相加 不能用int 这类强转的那种
 * like:123455668445574444+923465868495574845
 *
 * @author luofan
 */
public class 两串之和 {
    public static void main(String[] args) {
        String a = "123455668445574444";
        String b = "923465868495574845";
        System.out.println(sumTwoString(a, b));
    }

    private static String sumTwoString(String num1, String num2) {
        //两个字符相加  按每位 先对齐  左补零  然后依次倒叙相加拼接
        String res = "";
        int len = Math.max(num1.length(), num2.length());
        String num1P0 = leftpengZero(num1, len);
        String num2P0 = leftpengZero(num2, len);
        int carry = 0;
        for (int i = len - 1; i >= 0; i--) {
            int temp = Integer.valueOf(String.valueOf(num1P0.charAt(i))) + Integer.valueOf(String.valueOf(num2P0.charAt(i)));
            res = ((temp + carry) % 10) + res;
            carry = (temp + carry) / 10;
        }
        if (carry != 0) {
            res = "1" + res;
        }
        return res.toString();
    }

    /**
     * 字符串根据长度左补0
     *
     * @param num
     * @param len
     * @return
     */
    private static String leftpengZero(String num, int len) {
        StringBuffer buffer = new StringBuffer(num);
        while (buffer.length() < len) {
            buffer = new StringBuffer("0").append(buffer);
        }
        return buffer.toString();
    }

}
