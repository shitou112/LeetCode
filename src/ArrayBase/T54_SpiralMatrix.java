package ArrayBase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qian Shaofeng
 *         created on 2017/12/4.
 */
public class T54_SpiralMatrix {
    List<Integer> result = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length==0 || matrix[0].length==0)
            return result;

        recursion(matrix, 0, matrix.length-1, 0, matrix[0].length-1);
        return result;
    }

    private void recursion(int[][] matrix, int rowStart, int rowEnd, int colStart, int colEnd){
        if (rowStart > rowEnd || colStart > colEnd)
            return;

        if (rowStart == rowEnd && colStart <= colEnd){
            for (int i=colStart; i <= colEnd; ++i){
                result.add(matrix[rowEnd][i]);
            }
            return;
        }

        if (rowStart <= rowEnd && colStart == colEnd){
            for (int i=rowStart; i <= rowEnd; ++i){
                result.add(matrix[i][colEnd]);
            }
            return;
        }

        for (int i=colStart; i <= colEnd; ++i){
            result.add(matrix[rowStart][i]);
        }

        for (int i=rowStart+1; i < rowEnd; ++i){
            result.add(matrix[i][colEnd]);
        }

        for (int i=colEnd; i >= colStart; --i){
            result.add(matrix[rowEnd][i]);
        }

        for (int i=rowEnd-1; i > rowStart; --i){
            result.add(matrix[i][colStart]);
        }

        recursion(matrix, rowStart+1, rowEnd-1, colStart+1, colEnd-1);

    }

    public static void main(String[] args) {
        T54_SpiralMatrix sm = new T54_SpiralMatrix();
        int[][] matrix = {
                {1,2,3,4,5,6},
                {3,4,5,4,5,6},
                {5,6,7,8,9,1}

        };
        System.out.println(sm.spiralOrder(matrix));
    }
}
