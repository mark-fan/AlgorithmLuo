package operation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luofan
 */
public class N字形 {

    public static void main(String[] args) {
        convert("ab",1);
    }
    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        List<StringBuffer> rows = new ArrayList<StringBuffer>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuffer());
        }
        int flag = -1;
        int i = 0;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuffer result = new StringBuffer();
        for (StringBuffer row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}