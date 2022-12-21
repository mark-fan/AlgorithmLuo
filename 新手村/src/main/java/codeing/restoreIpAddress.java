package codeing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luofan
 */
public class restoreIpAddress {
    List res = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {
        restoreIP(s, 0, 0, new StringBuffer());
        return res;
    }

    private void restoreIP(String s, int startIndex, int num, StringBuffer stringBuffer) {
        // 当startIndex跑到最后一个字符 且 已经切割了四组  那就加进去
        if (startIndex == s.length() && num == 4) {
            res.add(stringBuffer.toString());
            return;
        }
        // 剪枝
        // 当跑到最后一个字符 或者已经四组了  但是两个条件却没有同时满足 那他就不是一个合格的字符串
        if (startIndex == s.length() || num == 4) {
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i + 1);
            if (!isValidNum(substring)) {
                continue;
            }
            stringBuffer.append(substring);
            if (num < 3) {
                stringBuffer.append('.');
            }
            restoreIP(s, i + 1, num + 1, stringBuffer);
            stringBuffer.delete(startIndex + num, i + num + 2);
        }
    }

    private boolean isValidNum(String substring) {
        if (substring.length() > 1 && substring.charAt(0) == '0') {
            return false;
        }
        if (Long.valueOf(substring) > 255) {
            return false;
        }
        return true;
    }
}
