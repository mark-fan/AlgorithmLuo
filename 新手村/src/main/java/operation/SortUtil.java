package operation;

/**
 * @author luofan
 */
public class SortUtil {
    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i ,int minValueIndex){
        int temp = arr[i];
        arr[i] = arr[minValueIndex];
        arr[minValueIndex] = temp;
    }
}
