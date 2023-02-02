package operation;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author luofan
 */
public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
             if(map.containsKey(s.charAt(i))){
                 left = Math.max(left,map.get(s.charAt(i))+1);
             }

             map.put(s.charAt(i),i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        HashSet<Character> characters = new HashSet<>();
        int left = 0;
        int rigth = 0;
        int max = 0;
        for (; rigth < s.length(); rigth++) {
            //获取当前右边的指针对应的值
            char c = s.charAt(rigth);
            while(characters.contains(c)){
                characters.remove(s.charAt(left));
                left++;
            }
            characters.add(c);
            max = Math.max(max,rigth-left+1);
        }
        return max;




    }
}
