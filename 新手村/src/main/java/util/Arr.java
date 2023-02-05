package util;

public class Arr {

    // 排序对数器
    // 返回一个数组arr  arr长度为[0,maxLen-1] 每个值大小[0,maxValue]
    public static int[] getLenRandomValueRandom(int maxLen, int maxValue) {
        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = (int) (Math.random() * maxValue);
        }
        return ans;
    }

    /**
     * 判断一个数组是否有序
     *
     * @param arr
     * @return
     */
    public static boolean isSorted(int[] arr) {
        if (arr.length < 2) {
            return true;
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max > arr[i]) {
                return false;
            }
            max = Math.max(max, arr[i]);
        }
        return true;
    }
}
