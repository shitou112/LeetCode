package AlgorithmsAndDataStructure.chapter8;

/**
 * @author Qian Shaofeng
 * created on 2018/1/25.
 */
public class FindNumInMatrix {

    public boolean findNumInMatrix(int[][] matrix, int target){
        if (matrix==null || matrix[0]==null)
            return false;

        int curRow = 0;
        int curCol = matrix[0].length-1;
        while (curRow<matrix.length && curCol>=0){
            if (matrix[curRow][curCol] < target)
                ++curRow;
            else if (matrix[curRow][curCol] > target)
                --curCol;
            else
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        FindNumInMatrix f = new FindNumInMatrix();
        int[][] a = {
                {0, 1, 2, 5},
                {2, 3, 4, 7},
                {4, 4, 4, 8},
                {5, 7, 7, 9}
        };
        System.out.println(f.findNumInMatrix(a, 9));
    }
}
