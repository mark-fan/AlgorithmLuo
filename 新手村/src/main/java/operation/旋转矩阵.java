package operation;

/**
 * @author luofan
 * 翻转总结：
 * 顺时针90度： 先对角线 在水平翻转
 * 逆时针90度：先水平翻转 再对角线
 * 选择从左上到右下的对角线交换，写起来比较方便，直接将matrix[i][j]和matrix[j][i]交换即可；
 * <p>
 * 如果选择从右上到左下的交换的话，就要写成，matrix[i][j]和matrix[n-1-j][n-1-i]交换
 * <p>
 * 采用异或交换可以代替额外的中间变量
 */
public class 旋转矩阵 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[len - 1 - i][i];
                matrix[len - 1 - i][j] = matrix[i][j] ^ matrix[len - 1 - i][i];
                matrix[i][j] = matrix[i][j] ^ matrix[len - 1 - i][i];
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                matrix[j][i] = matrix[i][j] ^ matrix[j][i];
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
            }
        }

    }
}
