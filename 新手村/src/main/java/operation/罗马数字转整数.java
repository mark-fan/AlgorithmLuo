package operation;

import java.util.HashMap;

/**
 * @author luofan
 */
public class 罗马数字转整数 {
    public int romanToInt(String s) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        map.put('a',4);
        map.put('b',9);
        map.put('c',40);
        map.put('d',90);
        map.put('e',400);
        map.put('f',900);

        s = s.replace("IV", "a");
        s = s.replace("IX", "b");
        s = s.replace("XL", "c");
        s = s.replace("XC", "d");
        s = s.replace("CD", "e");
        s = s.replace("CM", "f");
        for (int i = 0; i < s.length(); i++) {
             result += map.get(s.charAt(i));

        }
         return result;
    }
}
