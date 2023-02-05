package operation;

import java.util.HashMap;

/**
 * @author luofan
 */
public class 字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> charToInt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charToInt.put(s.charAt(i), charToInt.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
             if(charToInt.get(s.charAt(i))==1){
                 return i;
             }
        }
        return -1;
    }

    public int firstUniqChar1(String s) {
        for (int i = 0; i < s.length(); i++) {
             if(s.indexOf(s.charAt(i))==s.lastIndexOf(s.charAt(i))){
                 return i;
             }
        }
        return -1;
    }
}
