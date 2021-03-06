package Off;

public class yy10把数字翻译成字符串 {
    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a”
     * ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。
     * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     * 示例 1:
     * <p>
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     */

    public static void main(String[] args) {
        int i = translateNum(18822);
        System.out.println("aaa " + i);
    }

    public static int translateNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] dp = new int[chars.length+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < chars.length+1; i++) {
            if ((chars[i - 2] - 48) != 0 && (chars[i - 2] - 48) * 10 + (chars[i-1] - 48) < 26) {
                dp[i] = dp[i - 1] + dp[i-2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[chars.length];
    }
}
