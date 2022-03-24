package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC3 {
    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: s = "rat", t = "car"
     * 输出: false
     */
    public static void main(String[] args) {
        String s = "cat";
        String t = "cat";


        System.out.println(isAnagram(s,t));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        Map<Character, Integer> test = test(chars1, map1);
        Map<Character, Integer> test1 = test(chars2, map2);



        return test.equals(test1);
    }

    private static Map<Character, Integer> test(char[] chars, Map<Character, Integer> map) {
        for (Character character : chars) {
            Integer integer = map.get(character);
            map.put(character, integer == null ? 1 : integer + 1);
        }
        return map;
    }
}
