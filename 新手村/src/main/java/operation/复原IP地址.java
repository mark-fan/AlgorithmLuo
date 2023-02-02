package operation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luofan
 */
public class 复原IP地址 {
    static List<String> res = new ArrayList<>();
    static StringBuffer stringBuffer = new StringBuffer();

    public static void main(String[] args) {
        restoreIpAddresses("25525511135");
    }


    public static List<String> restoreIpAddresses(String s) {
        getAndSet(s, 0, 0);
        return res;
    }

    private static void getAndSet(String s, int startIndex, int num) {
        if (startIndex == s.length() && num == 4) {
            res.add(stringBuffer.toString());
            return;
        }
        if (startIndex == s.length() || num == 4) {
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i+1);
            if (!isValid(substring)) {
                continue;
            }
            stringBuffer.append(substring);
            if (num < 3) {
                stringBuffer.append('.');
            }
            getAndSet(s, i + 1, num + 1);
            stringBuffer.delete(startIndex + num, i + num + 2);
        }
    }

    private static boolean isValid(String substring) {
        if (substring.charAt(0) == '0' && substring.length() > 1) {
            return false;
        }
        if (Long.valueOf(substring) > 255) {
            return false;
        }
        return true;
    }



}
