package operation;

/**
 * @author luofan
 */
public class 判断国际象棋棋盘中一个格子的颜色 {
    public boolean squareIsWhite(String coordinates) {
        return ((coordinates.charAt(0)-'a'+1) + coordinates.charAt(1)-'0')%2 ==1;
    }
}
