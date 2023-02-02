package operation;

/**
 * @author luofan
 */
public class Excel表列名称 {
    public static String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            stringBuilder.append((char) (columnNumber % 26 + 'A'));
            columnNumber = (columnNumber) / 26;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
}
