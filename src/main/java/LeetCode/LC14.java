package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC14 {
    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：n = 3
     * 输出：[
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     */
    public static void main(String[] args) {
        int n = 3;
        List<String> list = generateParenthesis(n);
        System.out.println(list);
    }

    static List<String> list = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        int left = 0;
        int right = 0;
        String result = "";
        List<String> test = test(left, right, result, n);
        return test;
    }

    public static List<String> test(int left, int right, String result, int n) {
        if (left == n && right == n) {
            list.add(result);
            return list;
        }

        if (left < n) {
            test(left + 1, right, result + "(", n);
        }
        if (right < n && right < left) {
            test(left, right + 1, result + ")", n);
        }
        return list;
    }
}
