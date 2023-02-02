package operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author luofan
 */
public class 合并区间 {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= temp[1]) {
                temp[1] = Math.max(intervals[i][1], temp[1]);
           }else{
               result.add(temp);
               temp = intervals[i];
           }
        }
        result.add(temp);
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][]  intervals = {{1,3},{2,6},{8,10},{15,18}};
print(merge(intervals));

//        Arrays.sort(intervals);
//        print(intervals);
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
//        print(intervals);
    }
    public static void print(int[][] intervals){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < intervals.length; i++) {
            sb.append("[").append(intervals[i][0]).append(",").append(intervals[i][1]).append("]");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
