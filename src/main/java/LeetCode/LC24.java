package LeetCode;

public class LC24 {
    /**
     * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     * <p>
     * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,3,5,0,0,3,1,4]
     * 输出: 6
     * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     * 示例 2:
     * <p>
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * 示例 3:
     * <p>
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
     */

    public static void main(String[] args) {
        int[] p = {3, 3, 5, 0, 0, 3, 1, 4};
        int i = maxProfit(p);
        int i1 = maxProfit(2, p);
        System.out.println("aaa  " + i);
        System.out.println("bbbb  " + i1);
    }

    public static int maxProfit(int[] prices) {

        /**
         * int[i][j][k]
         *
         * j； 当前是否持有股票  0 没有; 1 持有
         * k:  最多交易k次
         * */
        int[][][] dp = new int[prices.length][2][3];

        dp[0][0][0] = 0;
        dp[0][1][0] = -prices[0];
        dp[0][0][1] = 0;
        dp[0][1][1] = 0;
        dp[0][0][2] = 0;
        dp[0][1][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            for (int k = 0; k <= 2; k++) {
                if (k == 0) {
                    dp[i][0][k] = dp[i - 1][0][k];
                } else {
                    dp[i][0][k] = Math.max(dp[i - 1][0][k], dp[i - 1][1][k - 1] + prices[i]);
                }
                dp[i][1][k] = Math.max(dp[i - 1][1][k], dp[i - 1][0][k] - prices[i]);

            }
        }

        return Math.max(dp[prices.length - 1][0][2], Math.max(dp[prices.length - 1][0][0], dp[prices.length - 1][0][1]));
    }

    public static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        /**
         当k大于等于数组长度一半时, 问题退化为贪心问题此时采用 买卖股票的最佳时机 II
         的贪心方法解决可以大幅提升时间性能，如果不用这个贪心，有个testCase过不去，会报空间超
         限
         */
        if (k >= prices.length / 2)
            return greedy(prices);
        int[][][] mp = new int[prices.length][2][k + 1];
        for (int i = 0; i <= k; i++) {
            // 第 1 天买入 - 卖出循环 K 次之后不再买入，所以初始值为 0
            mp[0][0][i] = 0;
            // 第 1 天买入 - 卖出循环 K 次之后又买入，所以初始值为 -prices[0]
            mp[0][1][i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                mp[i][0][j] = j != 0 ? Math.max(mp[i - 1][1][j - 1] + prices[i], mp[i - 1][0][j]) : mp[i - 1][0][j];
                mp[i][1][j] = Math.max(mp[i - 1][0][j] - prices[i], mp[i - 1][1][j]);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= k; i++)
            max = Math.max(max, mp[prices.length - 1][0][i]);
        return max;
    }

    private static int greedy(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];
        }
        return max;
    }
}
