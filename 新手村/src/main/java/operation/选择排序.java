package operation;

import java.util.Arrays;

/**
 * 由简单到复杂，局部到整体，粗糙到惊喜，逐步打印，多细分，语句合并，边界处理
 *
 * @author luofan
 */
public class 选择排序 {
    public static void main(String[] args) {

        int arr[] = {5, 2, 1, 3, 4};
        SortUtil.printArr(arr);
        selectSort(arr);
        SortUtil.printArr(arr);
    }

    public static void selectSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        int Len = arr.length;
        for (int i = 0; i < Len; i++) {
            int minValueIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                minValueIndex = arr[j] < arr[minValueIndex]?j:minValueIndex;
            }
            //交换
            SortUtil.swap(arr,i,minValueIndex);
        }

    }



}