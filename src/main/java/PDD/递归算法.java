package PDD;

public class 递归算法 {
  /**
   * 描述
   *
   * 第1个人x岁，第2个比第1个人大2岁，依次递推，请用递归方式计算出第n个人多大？
   *
   *
   * 输入
   * n ：第N个人， x: 第一个人的年龄
   *
   *
   * 输出
   * res:第N个人的年龄
   *
   *
   * 输入样例 1
   *
   * n= 3 , x= 1
   * 输出样例 1
   *
   * 5
   */

  public static void main(String[] args) {
    int tt = tt(3,1);
    System.out.println(tt);
  }

  private static int tt(int n, int x){
    int[] dp = new int[n+1];
    dp[1] = x;
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i-1] + 2;
    }
    return dp[n];
  }
}
