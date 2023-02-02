package operation;

/**
 * @author luofan
 */
public class 对角线遍历 {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] result = new int[n * m];

        for (int i = 0, idx = 0; i < n + m - 1; i++) {
            if (i % 2 == 0) {//偶数对角线 ，从下往上遍历
                for (int x = Math.min(i, n - 1); x >= Math.max(0, i - m + 1); x--) {
                    result[idx++] = mat[x][i - x];
                }
            } else {
                for (int x = Math.max(0, i - m + 1); x <= Math.min(i, n - 1); x++) {
                    result[idx++] = mat[x][i - x];
                }
            }

        }
        return result;
    }
}
