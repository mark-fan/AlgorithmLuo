package operation;

/**
 * @author luofan
 */
public class 零矩阵 {
    public void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(rows[i]||columns[j]){
                    matrix[i][j] = 0;
                }

            }

        }
    }
}
