package codeing;

/**
 * 将一个字符串中的空格替换成 "%20"。
 * 定义最开始长度 先判断其中有多少空格,然后给补两个空格（空格替换为02%，增量为2）。
 * 然后补充长度 可以指导最后串长度是多少
 *
 * @author luofan
 */
public class 替换空格 {
    public String replaceSpace(StringBuffer str) {
        int p1 = str.length() - 1;
        for (int i = 0; i < p1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int p2 = str.length() - 1;
        while (p1 >= 0 && p2 > p1) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }
}
