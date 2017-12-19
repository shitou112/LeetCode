package ArrayBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qian Shaofeng
 * created on 2017/12/19.
 */
public class T216_CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(k, 1, n, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum(int k, int start, int n, List<Integer> list, List<List<Integer>> result){
        if (k==0 && n==0){
            result.add(new ArrayList(list));
            return;
        }

        for (int i=start; i <= 9; ++i){
            if (n-i < 0)
                break;
            list.add(i);
            combinationSum(k-1, i+1, n-i, list, result);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        T216_CombinationSumIII cs = new T216_CombinationSumIII();
        System.out.println(cs.combinationSum3(2, 13));
    }
}
