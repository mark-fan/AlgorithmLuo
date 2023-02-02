package operation;

/**
 * @author luofan
 */
public class 整数转罗马数字 {
    public String intToRoman(int num) {
        int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < ints.length; i++) {
            int value = ints[i];
            String roman = romans[i];
            while(num>=value){
                num = num -value;
                bf.append(roman);
            }
            if(value ==0){
                break;
            }
        }
        return bf.toString();
    }
}
