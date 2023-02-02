package operation;

import java.util.HashMap;

/**
 * @author luofan
 */
public class 单词规律 {
    public boolean wordPattern(String pattern, String s) {
        String[] s1 = s.split(" ");
        int length = pattern.length();
        if (s1.length != length) {
            return false;
        }
        HashMap<String, Character> StringtoChar = new HashMap<>();
        HashMap<Character, String> ctoString = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (ctoString.containsKey(pattern.charAt(i)) && !ctoString.get(pattern.charAt(i)).equals(s1[i])) {
                return false;
            }

            if (StringtoChar.containsKey(s1[i])&&!StringtoChar.get(s1[i]).equals(pattern.charAt(i))) {
                    return false;
            }

            ctoString.put(pattern.charAt(i), s1[i]);
            StringtoChar.put(s1[i], pattern.charAt(i));
        }
        return true;
    }
}
