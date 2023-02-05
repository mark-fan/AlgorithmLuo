package operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author luofan
 */
public class 括号生成 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> strings = new ArrayList<>();
        getP(strings,new StringBuffer(),0,0,n);
        return strings.stream().filter(s -> isValid(s)).collect(Collectors.toList());
    }

    private static void getP(List<String> strings, StringBuffer stringBuffer, int start, int end, int n) {

        if(2*n == stringBuffer.length()){
            strings.add(stringBuffer.toString());
        }

        if(start<n){
            stringBuffer.append("(");
            getP(strings,stringBuffer,start+1,end,n);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
        if(end<n){
            stringBuffer.append(")");
            getP(strings,stringBuffer,start,end+1,n);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }

    }

    public static boolean isValid(String s) {
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '[':
                case '{':
                case '(':
                    characters.push(s.charAt(i));
                    break;
                case '}':
                    if (characters.isEmpty()||characters.peek() != '{') {
                        return false;
                    }
                    characters.pop();
                    break;
                case ']':
                    if (characters.isEmpty()||characters.peek() != '[') {
                        return false;
                    }
                    characters.pop();
                    break;
                case ')':
                    if (characters.isEmpty()||characters.peek() != '(') {
                        return false;
                    }
                    characters.pop();
                    break;
            }
        }
        if (!characters.isEmpty()) {
            return false;
        }
        return true;
    }
}
