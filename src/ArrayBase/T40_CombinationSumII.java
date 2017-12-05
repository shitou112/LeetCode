package ArrayBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Qian Shaofeng
 *         created on 2017/12/1.
 */
public class T40_CombinationSumII {
    HashSet<List<Integer>> results = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        resursion(candidates, 0, new ArrayList<>(), 0, target);
        List<List<Integer>> list_result = new ArrayList<>(results);
        return list_result;
    }

    private void resursion(int[] candidates, int start, List<Integer> list, int sum, int target){
        if (sum == target){
            results.add(new ArrayList<>(list));
            return;
        }
        if (sum > target || start >= candidates.length){
            return;
        }

        for (int i=start; i <= candidates.length-1; ++i) {
            if (candidates[i] > target)
                break;
            sum += candidates[i];
            int index = list.size();
            list.add(candidates[i]);
            resursion(candidates, i+1, list, sum, target);
            sum -= candidates[i];
            list.remove(index);
        }
    }

    public static void main(String[] args) {
        T40_CombinationSumII cs = new T40_CombinationSumII();
        int[] candidates = {1,1,1};
        List<List<Integer>> a = cs.combinationSum2(candidates, 3);
        System.out.println(a);
    }
}
