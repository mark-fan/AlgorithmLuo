package codeing;

import java.util.HashMap;
import java.util.Map;

/**
 * 205
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * @author luofan
 */
public class Isomorphic {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("ab", "cd"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (!s2t.containsKey(sChar)) {
                s2t.put(sChar, tChar);
            }
            if (!t2s.containsKey(tChar)) {
                t2s.put(tChar, sChar);
            }
            if (s2t.get(sChar) != tChar || t2s.get(tChar) != sChar) {
                return false;
            }
        }
        return true;

    }
}
