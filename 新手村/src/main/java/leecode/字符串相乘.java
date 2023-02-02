package leecode;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 */
public class 字符串相乘 {

    public static void main(String[] args) {
        System.out.println(multiply("90", "10"));
    }

    public static String multiply(String num1, String num2) {

        int l1 = num1.length();
        int l2 = num2.length();

        // 两个数字相乘 结果长度不会超过两个数字的长度和
        int tempArr[] = new int[l1 + l2];


        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int temp = (tempArr[i + j + 1]) + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                tempArr[i + j + 1] = temp % 10;
                tempArr[i + j] += temp / 10;
            }
        }
        StringBuilder bu = new StringBuilder();

        for (int i = 0; i < tempArr.length; i++) {
            bu.append(tempArr[i]);
        }

        for (int i = 0; i < bu.length(); i++) {
            if (bu.charAt(i) != '0') {
                return bu.substring(i);
            }

        }
        return "0";
    }
}
