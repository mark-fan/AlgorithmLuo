package operation;

import com.mark.common.util.Arr;

import java.util.Arrays;

public class Find {

    public static void main(String[] args) {
        int maxlen = 50;
        int maxValue = 1000;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Arr.getLenRandomValueRandom(maxlen, maxValue);
            Arrays.sort(arr1);
            int num = (int) Math.random() * maxValue;
            if (find(arr1, num) != test(arr1, num)) {
                System.out.println("二分不对啦");
            }
        }

        System.out.println(mostLeftNoLessNumIndex(new int[]{1, 3, 6, 8, 5, 6}, 6));
        System.out.println(mostRightNoLessNumIndex(new int[]{1, 3, 6, 8, 5, 6}, 6));
    }


    /**
     * 二分
     * 有序数组中找到num
     */
    public static boolean find(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }


    public static boolean test(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }


    // 二分法不一定要有序
    // 有序数组中找到大于等于num最左的位置
    public static int mostLeftNoLessNumIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    // 有序数组中找到大于等于num最右的位置
    public static int mostRightNoLessNumIndex(int[] arr, int num) {
        // TODO
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }


    //局部最小值问题
    // 有一个数组无序，任意相邻的两个数字不等
    // 局部最小
    // 当前值小于两遍，边界小于临边


}
