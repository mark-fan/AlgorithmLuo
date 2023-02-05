package operation;

/**
 * @author luofan
 */
public class Excel表列序号 {
    public static  int titleToNumber(String columnTitle) {
        int length = columnTitle.length();
        int sum = 0;
        int j = 1;
        for (int i = length-1; i >= 0; i--) {
            // 1 26()
            int temp = columnTitle.charAt(i) - 'A'+1;
            sum  =  sum  + (temp)*j;
            j= j*26;
        }
        return sum;
    }

    public static void main(String[] args) {
        titleToNumber("AB");
    }

}
