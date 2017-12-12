package ArrayBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qian Shaofeng
 * created on 2017/12/12.
 */
public class T118_PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();
        if (numRows <= 0) {
            results.add(new ArrayList<>());
            return results;
        }
        if (numRows>=1){
            List<Integer> list = new ArrayList<>(1);
            list.add(1);
            results.add(list);
        }

        if (numRows>=2){
            List<Integer> list = new ArrayList<>(2);
            list.add(1);
            list.add(1);
            results.add(new ArrayList<>(list));
        }

        if (numRows > 2) {
            for (int i = 2; i < numRows; ++i) {
                List<Integer> list = new ArrayList<>(i+1);
                list.add(1);

                List<Integer> preList = results.get(i - 1);
                for (int j = 1; j < i; ++j) {
                    list.add(preList.get(j - 1) + preList.get(j));
                }
                list.add(1);
                results.add(list);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        T118_PascalTriangle pt = new T118_PascalTriangle();
        System.out.println(pt.generate(5));
    }
}
