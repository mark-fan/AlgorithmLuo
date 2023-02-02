package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineSum2 {
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] test = {2, 5, 2, 1, 2};
        combinationSum2(test, 5);
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> ofResult = new ArrayList<>();
        backTrack(candidates, target, ofResult, 0, 0);
        System.out.println("aaaaa");
        return res;
    }

    private static void backTrack(int[] candidates, int target, List<Integer> result, int sum, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(result));
            return;
        }

        for (int i = index; i < candidates.length && candidates[i] + sum <= target; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            result.add(candidates[i]);
            backTrack(candidates, target, result, candidates[i] + sum, i + 1);
            result.remove(result.size() - 1);
        }

    }
}
