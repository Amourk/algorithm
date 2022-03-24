package Day;

import java.util.HashMap;

public class yy3无重复字符的最长子串 {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * 示例 4:
     * <p>
     * 输入: s = ""
     * 输出: 0
     */

    public static void main(String[] args) {
        String s = "aaw";
        int i = lengthOfLongestSubstring1(s);
        System.out.println("aaaaaaaaaa   " + i);
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> windows = new HashMap<>();

        Integer left = 0;
        Integer right = 0;
        Integer count = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            windows.put(r, windows.getOrDefault(r, 0) + 1);
            right++;
            while (windows.get(r) > 1) {
                char l = s.charAt(left);
                windows.put(l, windows.getOrDefault(l, 0) - 1);
                left++;
            }
            count = Math.max(count, right - left);
        }

        return count;
    }

    public static int lengthOfLongestSubstring1(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();
        int c = s.charAt(1);

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
}
