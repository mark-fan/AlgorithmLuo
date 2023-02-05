package operation;

/**
 * @author luofan
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 */
public class 回文串个数 {
    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
             int num1 = checkSubString(s,i,i);
             int num2 = checkSubString(s,i,i+1);
             result = Math.max(num1,num2);
        }
        return result;
    }

    private int checkSubString(String s,int i, int i1) {
        int result = 0;
        while(i>=0&&i<i1&&s.charAt(i)==s.charAt(i1)){
            i--;
            i1++;
            result++;
        }
        return result;
    }

}
