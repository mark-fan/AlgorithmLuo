package codeing;

/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中
 * 简单的二分法查找  从右上角值开始判断 假如等于 那就true, 假如目标值大 那就向下移动 反之向右移动
 *
 * @author luofan
 */
public class 二维数组中的查找 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array[0].length == 0 || array.length == 0) {
            return false;
        }
        int rows = array.length;
        int cols = array[0].length;
        int r = 0;
        int c = cols - 1;
        while (r < rows - 1 && c >= 0) {
            if (target == array[r][c]) {
                return true;
            } else if (target > array[r][c]) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }
}
