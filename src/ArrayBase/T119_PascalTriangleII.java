package ArrayBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qian Shaofeng
 * created on 2017/12/12.
 */
public class T119_PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex <0)
            return list;

        list.add(1);
        for (int i=0; i < rowIndex; ++i){
            int pre = list.get(0);
            int current;
            for (int j=1; j <= i; ++j){

                current = list.get(j);
                list.set(j, pre+list.get(j));
                pre = current;

            }
            list.add(1);

        }
        return list;
    }

    public static void main(String[] args) {
        T119_PascalTriangleII pt = new T119_PascalTriangleII();
        System.out.println(pt.getRow(0));
    }
}
