package operation;

/**
 * @author luofan
 */
public class 最长公共前缀 {
    //纵向扫描
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //第一个String的长度
        int len = strs[0].length();
        //总共多少条String
        int count = strs.length;
        //按照第一个数据的长度 变长校验
        for (int i = 0; i < len; i++) {
            //依次获取从小到大长度的字符
            char c = strs[0].charAt(i);
            //从第二行数据开始对比
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }

            }

        }
        return strs[0];
    }

    //横向扫描
    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = getLongestString(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;

    }

    private String getLongestString(String str0, String stri) {
        //对比最小长度
        int min = Math.min(str0.length(), stri.length());
        int index = 0;
        //从0开始到最小长度，假如字符相等那就index++;
        while (index < min && str0.charAt(index) == stri.charAt(index)) {
            index++;
        }
        return str0.substring(0, index);
    }
}
