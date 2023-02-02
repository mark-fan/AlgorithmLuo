package operation;

/**
 * @author luofan
 */
public class 字符串转化后的各位数字之和 {
    public static int getLucky(String s, int k) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            buffer.append((s.charAt(i)-'a'+1)+"");
        }
        while(k-->=1){
            char[] chars = buffer.toString().toCharArray();
           int sum = 0;
            for (int i = 0; i < chars.length; i++) {
                sum += chars[i]-'0';
            }
            buffer = new StringBuffer(String.valueOf(sum));
        }
        return Integer.valueOf(buffer.toString());

    }

    public static int getsum(int sum){
        int res = 0;
        int temp = sum;
        while(temp != 0){
            res = res + temp%10;
            temp = temp/10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getLucky("jjjj",2));
    }
}
