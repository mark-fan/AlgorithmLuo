package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数据排序 然后回溯找值
 */
public class CombineSum {

    public static void main(String[] args) {
        int[] test = {2, 3, 6, 7};
        combinationSum(test, 7);
        char aa = '9';
        System.out.println(aa - '0');
    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> result = new ArrayList<>();
        backTrack(candidates, target, result, 0, 0);
        System.out.println("111111");
        return res;
    }

    private static void backTrack(int[] candidates, int target, List<Integer> result, int sum, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(result));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] + sum <= target) {
                result.add(candidates[i]);
                backTrack(candidates, target, result, candidates[i] + sum, i);
                result.remove(result.size() - 1);
            } else {
                return;
            }

        }

    }
}
