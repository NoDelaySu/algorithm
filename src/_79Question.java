import java.util.Arrays;

public class _79Question {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    static class BooleanWrapper{
        boolean value;
    }

    public static boolean exist(char[][] board, String word) {
        String destWord = "";
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(dfs(board, word, destWord, i, j)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String sourWord, String destWord,
                            Integer x, Integer y) {
        if(sourWord.equals(destWord)){
            return true;
        }
        if(x < 0 || x >= board.length || y < 0 || y >= board[x].length){
            return false;
        }
        if(sourWord.length() == destWord.length()){ // deep > destWord.length
            return false;
        }
        if(board[x][y] == sourWord.charAt(destWord.length())){
            destWord += board[x][y];
            board[x][y] = '\b';
            if(dfs(board, sourWord, destWord, x - 1, y))return true;

            if(dfs(board, sourWord, destWord, x + 1, y))return true;

            if(dfs(board, sourWord, destWord, x, y - 1))return true;

            if(dfs(board, sourWord, destWord, x, y + 1))return true;
            board[x][y] = destWord.length() > 0 ? destWord.charAt(destWord.length() - 1) : '\b';
            destWord.substring(0, destWord.length() > 0 ? destWord.length() - 1 : 0);
        }
        return false;
    }

    public static int getMatrixCount(char[][] matrix){
        // 获取二维数组的行数和列数
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 初始化计数器
        int totalCount = 0;

        // 使用嵌套循环遍历二维数组
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 在每次迭代时递增计数器
                totalCount++;
            }
        }
        return totalCount;
    }
}
