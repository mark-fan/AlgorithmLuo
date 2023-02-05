package operation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author luofan
 */
public class 翻转字符串里的单词 {
    public static String reverseWords(String s) {
        String trim = s.trim();
        List<String> strings = Arrays.asList(trim.split("\\s+"));
        Collections.reverse(strings);
        return String.join(" ",strings);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }
}
