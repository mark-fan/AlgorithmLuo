package operation;

import java.util.*;

/**
 * @author luofan
 */
public class 电话号码的字母组合 {
    public static List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        Map<Character, String> numtochar = new HashMap<>();
        numtochar.put('2',"abc");
        numtochar.put('3',"def");
        numtochar.put('4',"ghi");
        numtochar.put('5',"jkl");
        numtochar.put('6',"mno");
        numtochar.put('7',"pqrs");
        numtochar.put('8',"tuv");
        numtochar.put('9',"wxyz");
        List<String> combins = new ArrayList<>();
        getString(combins,numtochar,digits,0,new StringBuffer());
        return combins;
    }

    private static void getString(List<String> combins,Map<Character, String> numtochar, String digits, int i, StringBuffer stringBuffer) {
        if(stringBuffer.toString().length() == digits.length()){
            combins.add(stringBuffer.toString());
        }else{
            char c = digits.charAt(i);
            String s = numtochar.get(c);
            int length = s.length();
            for (int j = 0; j < length; j++) {
                 stringBuffer.append(s.charAt(j));
                 getString(combins,numtochar,digits,i+1,stringBuffer);
                 stringBuffer.deleteCharAt(i);
            }
        }
    }
}
