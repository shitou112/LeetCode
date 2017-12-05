package ArrayBase;

/**
 * @author Qian Shaofeng
 *         created on 2017/11/28.
 */
public class T79_WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board==null || board[0].length == 0)
            return false;

        int m = board.length;
        int n = board[0].length;

        boolean[][] boradFlag = new boolean[board.length][board[0].length];

        for (int i=0; i < m; ++i){
            for (int j=0; j < n; ++j){
                if (board[i][j] == word.charAt(0) && search(board, boradFlag, i, j, word, 0))
                    return true;
            }
        }

        return false;
    }

    private boolean search(char[][] board, boolean[][] boardFlag, int locationX, int locationY, String word, int index){
        if (index >= word.length())
            return true;

        if (locationX < 0 || locationX >= board.length ||
                locationY < 0 || locationY >= board[0].length ||
                board[locationX][locationY]!=word.charAt(index) || boardFlag[locationX][locationY])
            return false;

        boardFlag[locationX][locationY] = true;
        if (search(board, boardFlag, locationX-1, locationY, word, index+1) ||
                search(board, boardFlag, locationX+1, locationY, word, index+1)||
                search(board, boardFlag, locationX, locationY-1, word, index+1)||
                search(board, boardFlag, locationX, locationY+1, word, index+1))
            return true;

        boardFlag[locationX][locationY] = false;

        return false;
    }

    public static void main(String[] args) {
        T79_WordSearch t79WordSearch = new T79_WordSearch();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
//        String word = "ABCESEEEFS";
        String word = "SEE";

        System.out.println(t79WordSearch.exist(board, word));
    }
}
