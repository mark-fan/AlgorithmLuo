package leecode;

/**
 * @author luofan
 */
public class 旋转图像_48 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        System.out.println(matrix);
        int a = 3;
        int b = 4;
        swap(a, b);
        System.out.println(a);
        System.out.println(b);
    }


    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = 0; j < len; j++) {
//                swap(matrix[i][j],matrix[len-i-1][j]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-i-1][j];
                matrix[len-i-1][j] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
//                swap(matrix[i][j],matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i] ;
                matrix[j][i] = temp;
            }
        }
    }

    //不能使用这种交换方式 （成员变量修改  其实没有做任何变化）
    public static void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }
}
