package operation;

/**
 * @author luofan
 */
public class 字符串转换整数 {
    public int myAtoi(String s) {
        if(s==null || s.length() ==0 ||s.trim().length() ==0){
            return 0;
        }
        String replace = s.trim().replace("\\s+", "");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < replace.length(); i++) {
             if((replace.charAt(i)>='0'&&replace.charAt(i)<='9')||replace.charAt(i)=='-'){
                 sb.append(replace.charAt(i));
             }

        }
        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
