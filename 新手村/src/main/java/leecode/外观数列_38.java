package leecode;

/**
 * @author luofan
 */
public class 外观数列_38 {
    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int end = 0;
            while (end < str.length()) {
                while(end <str.length()&&str.charAt(end) == str.charAt(start)){
                    end++;
                }
                sb.append((end - start)).append(str.charAt(start));
                start = end;
            }
            str = sb.toString();
        }
        return str;
    }
}
