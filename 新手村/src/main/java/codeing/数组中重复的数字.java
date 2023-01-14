package codeing;

/**
 * @author luofan
 */
public class 数组中重复的数字 {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(duplicate(numbers));
    }

    public static int duplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
            swap(nums, i, nums[i]);
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
