package leecode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 */
public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 4 || null == nums) {
            return result;
        }
        //排序
        Arrays.sort(nums);
        //剪枝
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            //当前数字最小集合都挂了  那没得聊了 break;
            if ((long)nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }

            if ((long)nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                //当前数字最小集合都挂了  那没得聊了 break;
                if ((long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

                if ((long)nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long temp = nums[i] + nums[j] + nums[left] + nums[right];
                    if (temp > target) {
                        right--;
                    } else if (temp < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                    }
                }


            }

        }

        return result;
    }
}
