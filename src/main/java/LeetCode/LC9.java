package LeetCode;

public class LC9 {
    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 2.00000, 10
     * 输出: 1024.00000
     * 示例 2:
     * <p>
     * 输入: 2.10000, 3
     * 输出: 9.26100
     * 示例 3:
     * <p>
     * 输入: 2.00000, -2
     * 输出: 0.25000
     * 解释: 2-2 = 1/22 = 1/4 = 0.25
     */

    public static void main(String[] args) {

    }

    public double myPow(double x, int n) {
        if (n < 0){
            return pow(x,-n);
        }
        return pow(x, n);
    }

    public double pow(double x, int n) {
        if (n == 1 || n == 0) {
            return x;
        }
        return n % 2 == 0 ? pow(x, n / 2) * pow(x, n / 2) : pow(x, n / 2) * pow(x, n / 2) * x;
    }
}
