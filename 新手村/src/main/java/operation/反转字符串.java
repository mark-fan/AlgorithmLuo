package operation;

/**
 * @author luofan
 */
public class 反转字符串 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length;

        while(right>=left){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left ++;
            right--;
        }

    }
}
