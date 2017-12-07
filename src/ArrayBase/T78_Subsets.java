package ArrayBase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Qian Shaofeng
 * created on 2017/12/7.
 */
public class T78_Subsets {
    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0)
            return results;
        dfs(nums, 0, new ArrayList<>());
        return results;

    }

    private void dfs(int[] nums, int start, List<Integer> list){
        results.add(new ArrayList<>(list));
        if (start >= nums.length)
            return;
        for (int i=start; i < nums.length; ++i){
            list.add(nums[i]);
            dfs(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        T78_Subsets subsets = new T78_Subsets();
        int[] nums = {1,2,3};
        System.out.println(subsets.subsets(nums));
    }
}
