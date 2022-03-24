package Day;

import javax.swing.*;
import java.util.HashMap;

public class yy567字符串的排列yy滑动窗口 {
    /**
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     *
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     *
     * 示例1:
     *
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     *  
     *
     * 示例2:
     *
     * 输入: s1= "ab" s2 = "eidboaoo"
     * 输出: False
     * "hello"
     * "ooolleoooleh"
     * 输入
     * "ab"
     * "eidba
     *
     * "adc"
     * "dcda"
     * */

    public static void main(String[] args) {

        boolean b = checkInclusion("adc", "dcda");
        System.out.println("aaaaaaaa   "+b);
    }

    public static boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            hashMap.put(c,hashMap.getOrDefault(c,0)+1);
        }

        Integer left = 0;
        Integer right = 0;
        Integer count = 0;

        while (right<s2.length()){
            char c = s2.charAt(right);
            if (hashMap.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if (hashMap.get(c).equals(window.get(c))){
                    count++;
                }
            }
            right++;

            while (right-left>=s1.length()){
                if (count == hashMap.size()){
                    return true;
                }
                char le = s2.charAt(left);
                if (hashMap.containsKey(le)){
                    if (hashMap.get(le).equals(window.get(le))){
                        count--;
                    }
                    window.put(le,window.getOrDefault(le,0)-1);
                }
                left++;
            }
        }
        return false;
    }
}
