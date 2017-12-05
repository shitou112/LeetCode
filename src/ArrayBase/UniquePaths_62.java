package ArrayBase;

/**
 * @author Qian Shaofeng
 *         created on 2017/12/5.
 */
public class UniquePaths_62 {
    int pathCounts = 0;
    public int uniquePaths(int m, int n) {
        if (m==0||n==0)
            return 1;

        return dynamicProgram(m, n);
    }

    private void recursion(int row, int col, int targetRow, int targetCol){
        if (row==targetRow && col==targetCol){
            ++pathCounts;
            return;
        }

        if (row==targetRow) {
            recursion(row, col + 1, targetRow, targetCol);
            return;
        }
        if (col==targetCol) {
            recursion(row + 1, col, targetRow, targetCol);
            return;
        }

        recursion(row+1, col, targetRow, targetCol);
        recursion(row, col+1, targetRow, targetCol);
    }

    private int dynamicProgram(int m, int n){
        int[][] paths = new int[m][n];
        paths[0][0] = 1;
        for (int i=0; i < m; ++i){
            for (int j=0;j < n; ++j){
                if (i==0 && j!=0){
                    paths[i][j] = paths[i][j-1];
                }
                else if (j==0 && i!=0){
                    paths[i][j] = paths[i-1][j];
                }else if (i != 0){
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
                }
            }
        }
        return paths[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths_62 up = new UniquePaths_62();
        System.out.println(up.uniquePaths(2, 3));
    }
}
