package Off;

public class yy11礼物的最大价值 {
    /**
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，
     * 每个礼物都有一定的价值（价值大于 0）。
     * 你可以从棋盘的左上角开始拿格子里的礼物，
     * 并每次向右或者向下移动一格、直到到达棋盘的右下角。
     * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     */

    public static void main(String[] args) {
        int[][] p = {{1,3,1}, {1,5,1},{4,2,1}};
        int i = maxValue(p);
        System.out.println("aaa " + i);
    }

    public static int maxValue(int[][] grid) {
        int[][] dp = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i==0) {
                    dp[i][j] = dp[i][j] + dp[i][j - 1];
                } else if (j==0) {
                    dp[i][j] = dp[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
