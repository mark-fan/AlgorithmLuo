package operation;

/**
 * @author luofan
 */
public class 最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        String trim = s.trim();
        int sum = 0;
        for (int i = trim.length()-1; i >=0; i--) {
            if(trim.charAt(i)==' '){
                break;
            }
            sum++;
        }
        return sum;
    }
}
