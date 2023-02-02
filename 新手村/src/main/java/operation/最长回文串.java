package operation;

/**
 * @author luofan
 */
public class 最长回文串 {
    public String longestPalindrome(String s) {
        if(s==null||s.length()<1){
            return "";
        }
        int start = 0, end =0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = longestSubPalindrome(s, i, i);
            int len2 = longestSubPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            // 拿到当前子串最长的串长
            // 更新开始值（当前i减去长度的一半） 和结束位置（当前i加上长度的一半）
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start,end+1);
    }

    private int longestSubPalindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

}
