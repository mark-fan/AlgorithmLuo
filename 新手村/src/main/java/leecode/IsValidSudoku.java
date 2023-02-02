package leecode;


/**
 * 有效的数独
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] column = new int[9][9];
        int[][][] squre = new int[3][3][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char aChar = board[i][j];
                if (aChar != '.') {
                    int index = aChar - '0' - 1;
                    row[i][index]++;
                    column[j][index]++;
                    squre[i / 3][j / 3][index]++;
                    if (row[i][index] > 1 || column[j][index] > 1 || squre[i / 3][j / 3][index] > 1) {
                        return false;
                    }


                }


            }

        }
        return true;
    }
}
