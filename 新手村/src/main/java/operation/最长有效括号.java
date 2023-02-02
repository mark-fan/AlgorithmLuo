package operation;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author luofan
 */
public class 最长有效括号 {
    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }


    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
//        Deque<Integer> stack = new LinkedList<>();
//        stack.push(2);
//        System.out.println(stack.peek());
//        System.out.println(stack);
//        stack.pop();
//        System.out.println(stack);
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

    public int longestValidParentheses2(String s) {
        Stack<Integer> stacks = new Stack<>();
        stacks.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
             if(s.charAt(i)=='('){
                 stacks.push(i);
             }else {
                 stacks.pop();
                 if(stacks.isEmpty()){
                     stacks.push(i);
                 }else {
                     max = Math.max(max,i-stacks.peek());
                 }
             }

        }
        return max;
    }
}
