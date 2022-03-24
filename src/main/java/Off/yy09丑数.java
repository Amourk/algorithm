package Off;

public class yy09丑数 {
    /**
     * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
     *
     *  
     *
     * 示例:
     *
     * 输入: n = 10
     * 输出: 12
     * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     * */
    public static void main(String[] args) {
        int i = nthUglyNumber(10);
        System.out.println("aaaa "+i);
    }
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int a = 0;
        int b = 0;
        int c = 0;

        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(5*dp[c],Math.min(2*dp[a],3*dp[b]));
            if (dp[i] == 2*dp[a]){
                a++;
            }
            if (dp[i] == 3*dp[b]){
                b++;
            }
            if (dp[i] == 5*dp[c]){
                c++;
            }
        }
        return dp[n-1];
    }
}
