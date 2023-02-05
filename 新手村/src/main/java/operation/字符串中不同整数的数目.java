package operation;

import java.math.BigDecimal;
import java.util.Arrays;


/**
 * @author luofan
 */
public class 字符串中不同整数的数目 {
    public static int numDifferentIntegers(String word) {
        return (int)Arrays.asList(word.split("[a-zA-Z]+")).stream().filter(s -> !s.isEmpty()).map(Integer::new).distinct().count();
    }


    public static void main(String[] args) {
        System.out.println(numDifferentIntegers("a123bc34d8ef34"));
    }
}
