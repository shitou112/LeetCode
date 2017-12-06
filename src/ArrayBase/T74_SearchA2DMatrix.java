package ArrayBase;

/**
 * @author Qian Shaofeng
 *         created on 2017/12/6.
 */
public class T74_SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0 || matrix[0].length==0)
            return false;
        int m = matrix.length;
        int n= matrix[0].length;
        int startRow=0, endRow=m-1, midRow=0;
        while (startRow<=endRow){
            midRow = (startRow + endRow) / 2;
            if (matrix[midRow][0] == target)
                return true;
            else if (matrix[midRow][0] < target && matrix[midRow][n-1] >= target)
                break;
            else if (matrix[midRow][0] > target){
                endRow = midRow - 1;
            }else
                startRow = midRow + 1;
        }

        int startCol=0, endCol=n-1;
        while (startCol <= endCol){
            int midCol = (startCol + endCol) / 2;
            if (matrix[midRow][midCol] < target){
                startCol = midCol + 1;
            }else if (matrix[midRow][midCol] > target)
                endCol = midCol - 1;
            else
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        T74_SearchA2DMatrix sd = new T74_SearchA2DMatrix();
        int[][] matrix = {
                {1,3,5,7},{10,11,16,20},{23,30,34,50}
        };
        System.out.println(sd.searchMatrix(matrix, 7));
    }
}
