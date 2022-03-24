package Day;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class yy967连续差相同的数字 {
    /**
     * 返回所有长度为 N 且满足其每两个连续位上的数字之间的差的绝对值为 K 的非负整数。
     * <p>
     * 请注意，除了数字 0 本身之外，答案中的每个数字都不能有前导零。
     * 例如，01 因为有一个前导零，所以是无效的；但 0 是有效的。
     * <p>
     * 你可以按任何顺序返回答案。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：N = 3, K = 7
     * 输出：[181,292,707,818,929]
     * 解释：注意，070 不是一个有效的数字，因为它有前导零。
     * 示例 2：
     * <p>
     * 输入：N = 2, K = 1
     * 输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
     * <p>
     * 1 <= N <= 9
     * 0 <= K <= 9
     */

    public static void main(String[] args) {
        int[] ints = numsSameConsecDiff(3, 0);
        System.out.println("aaa " + ints);
    }

    public static int[] numsSameConsecDiff(int n, int k) {
        List<Integer> a = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            a.add(i);
        }
        for (int i = 1; i <= n - 1; i++) {
            List<Integer> b = new ArrayList<>();
            for (Integer aa : a) {
                int y = aa % 10;
                if (y - k <= 9 && y - k >= 0) {
                    b.add(aa * 10 + (y - k));
                }
                if (y + k <= 9 && y + k >= 0) {
                    b.add(aa * 10 + (y + k));
                }
            }
            a = b;
        }
        List<Integer> collect = a.stream().distinct().collect(Collectors.toList());

        int[] ints = new int[collect.size()];
        for (int i = 0; i < collect.size(); i++) {
            ints[i] = collect.get(i);
        }
        return ints;
    }
}
