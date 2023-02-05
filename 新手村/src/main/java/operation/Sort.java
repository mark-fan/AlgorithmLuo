package operation;

import util.Arr;

/**
 * 排序
 */
public class Sort {

    public static void main(String[] args) {
//        int[] arr = {7, 4, 6, 3, 9, 1, 2, 8, 5};
//        printArray(arr);
//        insertSort2(arr);
////        insertSort(arr);
////        selectorSort(arr);
////        bubbleSort(arr);
//        printArray(arr);

        int maxlen = 50;
        int maxValue = 1000;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = Arr.getLenRandomValueRandom(maxlen, maxValue);
            int[] arr2 = copyArr(arr1);
            int[] arr3 = copyArr(arr1);
            selectorSort(arr1);
            insertSort(arr2);
            if (!Arr.isSorted(arr1)) {
                System.out.println("选择排序挂了");
            }
            if (!Arr.isSorted(arr2)) {
                System.out.println("插入排序挂了");
            }
        }
    }


    public static int[] copyArr(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public static boolean equalValue(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


    private static void swapArr(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    /**
     * 插入排序1
     *
     * @param arr
     */
    private static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 插入排序
        for (int i = 1; i < arr.length; i++) {
            int curNumIndex = i;
            while (curNumIndex - 1 >= 0 && arr[curNumIndex - 1] > arr[curNumIndex]) {
                swapArr(arr, curNumIndex - 1, curNumIndex);
                curNumIndex--;
            }
        }
    }

    /**
     * 插入排序2
     *
     * @param arr
     */
    private static void insertSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        // 依次轮循 从第一个数开始  前一个数比后一个数大的话  就交换
        for (int end = 1; end < N; end++) {
            for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swapArr(arr, pre, pre + 1);
            }
        }
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectorSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 选择排序  需要找到索引位置，从第一个位置开始 选择最小的和它交换
        // 需要获取最小索引值
        for (int i = 0; i < arr.length; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 此处决定大小顺序
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swapArr(arr, i, minValueIndex);
        }
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 冒泡 每两个对比相对大的往后移，然后依次会减少
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swapArr(arr, j - 1, j);
                }
            }
        }
    }
}
