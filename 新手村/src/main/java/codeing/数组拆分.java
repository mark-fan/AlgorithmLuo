package codeing;

import java.util.Arrays;

/**
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。
 * <p>
 * 返回该 最大总和 。
 *
 * @author luofan
 */
public class 数组拆分 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = nums[1];
        if (nums.length == 2) {
            return Math.min(nums[0], nums[1]);
        }
        for (int i = 3; i < nums.length; i = i + 2) {
            result += nums[i];
        }
        return result;
    }
}
