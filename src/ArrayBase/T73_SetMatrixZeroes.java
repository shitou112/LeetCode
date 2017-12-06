package ArrayBase;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Qian Shaofeng
 *         created on 2017/12/6.
 */
public class T73_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        HashSet<Integer> zeroRows = new HashSet<>();
        HashSet<Integer> zeroCols = new HashSet<>();
        for (int i=0; i < m; ++i){
            for (int j=0; j < n; ++j){
                if (matrix[i][j] == 0){
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }
        for (Integer row: zeroRows){
            Arrays.fill(matrix[row], 0);
        }

        for (Integer col: zeroCols){
            for (int i=0; i < m; ++i){
                matrix[i][col] = 0;
            }
        }
    }


    public static void main(String[] args) {
        T73_SetMatrixZeroes smz = new T73_SetMatrixZeroes();
        int[][] matrix = {
                {1, 2, 3},
                {4, 0, 6},
                {0, 1, 1}
        };
        smz.setZeroes(matrix);
        System.out.println(matrix);
    }
}
