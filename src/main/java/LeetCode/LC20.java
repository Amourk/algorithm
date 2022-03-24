package LeetCode;

public class LC20 {
    /**
     * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 2
     * 输出: [0,1,1]
     * 示例 2:
     * <p>
     * 输入: 5
     * 输出: [0,1,1,2,1,2]
     */
    public static void main(String[] args) {
        int[] ints = countBits(2);
    }

    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int j = i;
            int count = 0;
            while (j != 0) {
                count++;
                j = j & (j - 1);
            }
            result[i] = count;
        }
        return result;
    }

}
