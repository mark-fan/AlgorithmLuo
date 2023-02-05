package operation;

/**
 * @author luofan
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findNum(nums, target, true), findNum(nums, target, false)};
    }

    private int findNum(int[] nums, int target, boolean flag) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while (right >= left) {
            int mid = (right + left) >> 1;
            if (nums[mid] == target) {
                ans = mid;
                if (flag) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;

            }
        }
        return ans;
    }
}