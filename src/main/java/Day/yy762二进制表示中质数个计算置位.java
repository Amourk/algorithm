package Day;

import java.util.ArrayList;
import java.util.List;

public class yy762二进制表示中质数个计算置位 {
    /**
     * 给定两个整数 L 和 R ，
     *  [L, R] 范围内，计算置位位数为质数的整数个数。
     * <p>
     * （注意，计算置位代表二进制表示中1的个数。
     * 例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
     * <p>
     * 示例 1:
     * <p>
     * 输入: L = 6, R = 10
     * 输出: 4
     * 解释:
     * 6 -> 110 (2 个计算置位，2 是质数)
     * 7 -> 111 (3 个计算置位，3 是质数)
     * 9 -> 1001 (2 个计算置位，2 是质数)
     * 10-> 1010 (2 个计算置位，2 是质数)
     * 示例 2:
     * <p>
     * 输入: L = 10, R = 15
     * 输出: 5
     * 解释:
     * 10 -> 1010 (2 个计算置位, 2 是质数)
     * 11 -> 1011 (3 个计算置位, 3 是质数)
     * 12 -> 1100 (2 个计算置位, 2 是质数)
     * 13 -> 1101 (3 个计算置位, 3 是质数)
     * 14 -> 1110 (3 个计算置位, 3 是质数)
     * 15 -> 1111 (4 个计算置位, 4 不是质数)
     * 567
     * 607
     * 244
     * 269
     */
    public static void main(String[] args) {
        countPrimeSetBits(244, 269);
    }

    public static int countPrimeSetBits(int L, int R) {
        List<Integer> list = new ArrayList<>();
        int value = 0;
        for (int i = L; i <= R; i++) {
            int j = i;
            int result = 0;
            while (j != 0) {
                result++;
                j = j & (j - 1);
            }
            if (result != 1) {
                list.add(result);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 2) {
                value++;
                continue;
            }
            if (test(list.get(i))) {
                value++;
            }

        }
        return value;
    }

    public static boolean test(int result) {
        for (int k = 2; k < result; k++) {
            if (result % k == 0) {
                return false;
            }
        }
        return true;
    }
}
