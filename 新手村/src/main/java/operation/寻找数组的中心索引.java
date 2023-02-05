package operation;

import java.util.Arrays;

/**
 * @author luofan
 */
public class 寻找数组的中心索引 {
    public int pivotIndex(int[] nums) {
        int left = 0;
        int right = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            left = nums[i] + left;
            if (left == right) {
                return i;
            }
            right = right - nums[i];

        }
        return 0;
    }
}
