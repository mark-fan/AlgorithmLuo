package operation;

import com.alibaba.fastjson.JSONObject;
import com.mark.common.util.Arr;

/**
 * @author luofan
 */
public class 归并排序 {

    public static void main(String[] args) {

        int len = 8;
        int maxValue = 100;
        int[] arr = Arr.getLenRandomValueRandom(len, maxValue);
        if (arr == null || arr.length < 2) {
            return;
        }
        System.out.println(JSONObject.toJSONString(arr));
        process(arr, 0, arr.length - 1);
        System.out.println(JSONObject.toJSONString(arr));
//        mergeSort2(arr);
        if (!Arr.isSorted(arr)) {
            System.out.println("failed!");
        }
    }


    /**
     * 归并排序
     */
    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }


    public static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }

    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int mergeSize = 1; // 当前有序的 左组长度
        while (mergeSize < N) {
            int L = 0;
            while (L < N) {
                //L~M  左组（mergeSize）
                int M = L + mergeSize - 1;
                if (M >= N) {
                    break;
                }
                // L~M  M+1~R(mergeSize)
                int R = Math.min(M + mergeSize, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

}
