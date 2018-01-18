package AlgorithmsAndDataStructure.chapter4;

/**
 * @author Qian Shaofeng
 * created on 2018/1/18.
 */
public class CardGame {

    public int win1(int[] array){
        if (array==null || array.length==0)
            return 0;
        int n = array.length;
        int[][] f = new int[n][n];
        int[][] s = new int[n][n];

        for (int j=0; j < n; ++j){
            f[j][j] = array[j];
            for (int i=j-1; i >= 0; --i){
                f[i][j] = Math.max(array[i] + s[i+1][j], array[j]+s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j], f[i][j-1]);
            }
        }

        return Math.max(f[0][n-1], s[0][n-1]);
    }
    public static void main(String[] args) {
        CardGame cg = new CardGame();
        int[] array = {1, 2, 100, 4};
        System.out.println(cg.win1(array));
    }
}
