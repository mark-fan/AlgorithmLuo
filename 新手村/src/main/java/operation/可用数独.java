package operation;

/**
 * @author luofan
 */
public class 可用数独 {
    public boolean isValidSudoku(char[][] board) {
        int rowarr[][] = new int[9][9];
        int columnarr[][] = new int[9][9];
        int sarr[][][] = new int[3][3][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < sarr.length; j++) {
                char c = board[i][j];
                int index = c - '0' - 1;
                if (c != '.') {
                    rowarr[i][index]++;
                    columnarr[j][index]++;
                    sarr[i / 3][j / 3][index]++;
                }
                if (rowarr[i][index] > 1 || columnarr[i][index] > 1 || sarr[i / 3][j / 3][index] > 1) {
                    return false;
                }


            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('9'-'0'-1);
    }
}
