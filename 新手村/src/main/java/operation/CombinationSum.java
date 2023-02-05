package operation;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * @author luofan
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        process(candidates, target, lists, list, 0);
        return lists;
    }

    private void process(int[] candidates, int target, List<List<Integer>> lists, List<Integer> list,int index) {
        if(index == candidates.length){
            return;
        }

        if(target==0){
            lists.add( new ArrayList<>(list));
            return;
        }
        process(candidates,target,lists,list,index+1);
        if(target-candidates[index]>=0){
            list.add(candidates[index]);
            process(candidates,target-candidates[index],lists,list,index);
            list.remove(list.size()-1);
        }
    }
}
