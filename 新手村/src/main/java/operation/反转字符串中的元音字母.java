package operation;

/**
 * @author luofan
 */
public class 反转字符串中的元音字母 {
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while(left<right){
            while(left<right&&!isYuan(chars[left])){
                left++;
            }
            while(left<right&&!isYuan(chars[right])){
                right--;
            }
            if(left<right){
                swap(chars,left,right);
                left++;
                right--;
            }
        }
        return new String(chars);
    }

    private  static void swap(char[] chars, int left, int right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }


    private static boolean isYuan(char c){
        return "aeiouAEIOU".indexOf(c)>=0;
    }

    public static void main(String[] args) {
        reverseVowels("a.b,.");
    }

}
