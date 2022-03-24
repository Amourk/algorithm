package DP;

public class yy1137第N个泰波那契数 {

  /**
   * 泰波那契序列 Tn 定义如下： 
   * <p>
   * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
   * <p>
   * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
   * <p>
   *  
   * <p>
   * 示例 1：
   * <p>
   * 输入：n = 4 输出：4 解释： T_3 = 0 + 1 + 1 = 2 T_4 = 1 + 1 + 2 = 4 示例 2：
   * <p>
   * 输入：n = 25 输出：1389537
   */
  public static void main(String[] args) {
    int tribonacci = tribonacci(25);
    System.out.println(tribonacci);
  }

  public static int tribonacci(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;
    for (int i = 3; i < n+1; i++) {
      dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    }
    return dp[n];
  }
}
