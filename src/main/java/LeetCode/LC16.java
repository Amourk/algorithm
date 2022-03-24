package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC16 {
    /**
     * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
     *
     * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     *
     *  
     *
     * 示例：
     *
     * 输入：4
     * 输出：[
     *  [".Q..",  // 解法 1
     *   "...Q",
     *   "Q...",
     *   "..Q."],
     *
     *  ["..Q.",  // 解法 2
     *   "Q...",
     *   "...Q",
     *   ".Q.."]
     * ]
     * 解释: 4 皇后问题存在两个不同的解法。
     *  
     *
     * 提示：
     *
     * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
     * */
    public static void main(String[] args) {
        List<List<String>> test = solveNQueens(4);
    }

    static List<Integer> cols = new ArrayList<>();
    static List<String> list = new ArrayList<>();
    static List<List<String>> result = new ArrayList<>();


    public static List<List<String>> solveNQueens(int n) {
        int i = 0;
        List<List<String>> test = test(n, i);
        return test;
    }

    public static List<List<String>> test(int n,int i){
        StringBuilder stringBuilder = new StringBuilder();
        if (i == n){
            result.add(list);
            return result;
        }
        for (int k = 0; k <n ; k++) {
            if (cols.contains(k)){
                stringBuilder.append(".");
                continue;
            }
            cols.add(k);
            stringBuilder.append("Q");
            test(n,i+1);
        }
        list.add(stringBuilder.toString());
        return result;
    }
}
