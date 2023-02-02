package operation;

import java.util.Arrays;

/**
 * @author luofan
 */
public class 搜索要插入的值的位置 {
    public int searchInsert(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = right - left >> 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right + 1;
    }
}
