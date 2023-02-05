package operation;

import java.util.*;

/**
 * @author luofan
 */
public class 最大子串 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            //当sum为负数，从下个数开始重新取子数组
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public int method2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = nums[i] + dp[i - 1];
            } else {
                dp[i] = nums[i];
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 < 0) {
                nums1[tail--] = nums2[p2--];
            } else if (p2 < 0) {
                nums1[tail--] = nums1[p1--];
            } else if (nums1[p1] < nums2[p2]) {
                nums1[tail--] = nums2[p2--];
            } else {
                nums1[tail--] = nums1[p1--];
            }
        }
    }


    //动态规划
    public void mergeArr(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 < 0) {
                nums1[tail--] = nums2[p2--];
            } else if (p2 < 0) {
                nums1[tail--] = nums1[p1--];
            } else if (nums1[p1] < nums2[p2]) {
                nums1[tail--] = nums2[p2--];
            } else {
                nums1[tail--] = nums1[p1--];
            }
        }
    }


    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (isPalindNum(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        String s2 = sb.toString().toLowerCase();
        int left = 0;
        int right = s2.length() - 1;
        while (left < right) {
            if (s2.charAt(left) != s2.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindNum(char cha) {
        return 'a' <= cha && 'z' >= cha || 'A' <= cha && 'Z' >= cha || '0' <= cha && '9' >= cha;
    }

    //回文子串
    public boolean isPalindrome1(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !isPalindNum(s.charAt(left))) {
                left++;
            }
            while (left < right && !isPalindNum(s.charAt(right))) {
                right--;
            }
            if (left <= right && s.charAt(right) == s.charAt(left) || (s.charAt(left) | 0x20) == (s.charAt(right) | 0x20)) {
                left++;
                right--;
            } else {
                return false;
            }

        }
        return true;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ints = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, ints, 0, nums1.length);
        System.arraycopy(nums2, 0, ints, nums1.length, nums2.length);
        Arrays.sort(ints);
        if (ints.length % 2 == 1) {
            return ints[ints.length / 2];
        } else {
            return (ints[ints.length / 2] + ints[(ints.length / 2) - 1] + 0.0) / 2;
        }
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int cur = 0;
        while (left < right) {
            cur = Math.max(Math.min(height[left], height[right]) * (right - left), cur);
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return cur;

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int end = nums.length - 1;
            while (j < end) {
                if (nums[i] + nums[j] + nums[end] == 0) {
                    hashSet.add(Arrays.asList(nums[i], nums[j], nums[end]));
                    j++;
                    end--;
                } else if (nums[i] + nums[j] + nums[end] < 0) {
                    j++;
                } else {
                    end--;
                }
            }

        }
        List<List<Integer>> lists = new ArrayList<>(hashSet);
        return lists;
    }

    //回文子串
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return validSkipOnePalindrome(s, left + 1, right) || validSkipOnePalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    private boolean validSkipOnePalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    //移除元素
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }

        }
        return slow;
    }

    //两数之和
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == 9) {
                    return new int[]{i, j};
                }

            }

        }
        return new int[0];
    }

    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (sumMap.containsKey(target - nums[i])) {
                return new int[]{sumMap.get(target - nums[i]), i};
            }
            sumMap.put(nums[i], i);
        }
        return new int[0];
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int end = nums.length - 1;
            while (left < end) {
            int temp = nums[i] + nums[left] + nums[end];
                if(target == temp){
                    return temp;
                }

                if (Math.abs(target - temp) < Math.abs(target-ans)){
                  ans = temp;
                }

                if (temp > target){
                    end--;
                } else {
                    left++;
                }
            }
        }
        return ans;
    }

    public int searchInsert(int[] nums, int target) {
        int[] ints = new int[nums.length + 1];
        System.arraycopy(nums, 0, ints, 0, nums.length);
        ints[ints.length - 1] = target;
        Arrays.sort(ints);
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == target) {
                return i;
            }

        }
        return 0;
    }

    public int searchInsert1(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left + right) >> 1;
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target) {
                right = mid-1;
            }else{
                return mid;
            }
        }
        return right +1;
    }

}

