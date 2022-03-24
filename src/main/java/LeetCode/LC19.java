package LeetCode;

import java.util.Arrays;

public class LC19 {
    /**
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
     * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。
     * <p>
     *  
     * <p>
     * 示例:
     * <p>
     * board =
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * <p>
     * 给定 word = "ABCCED", 返回 true
     * 给定 word = "SEE", 返回 true
     * 给定 word = "ABCB", 返回 false
     */


    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String w = "ABCF";

        boolean exist = exist(board, w);

        System.out.println("aaaa " + exist);
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i,j,board,word,flag,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(int i, int j, char[][] board, String word, boolean[][] flag, int num) {
        if (num == word.length()) {
            return true;
        }
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0) {
            return false;
        }
        if (board[i][j] != word.charAt(num)) {
            return false;
        }
        if (flag[i][j]) {
            return false;
        }

        flag[i][j] = true;

        boolean result =
                dfs(i - 1, j, board, word, flag, num + 1) ||
                        dfs(i + 1, j, board, word, flag, num + 1) ||
                        dfs(i, j - 1, board, word, flag, num + 1) ||
                        dfs(i, j + 1, board, word, flag, num + 1);
        flag[i][j] = false;
        return result;
    }
}
