package PDD;

import java.util.HashMap;
import java.util.Set;

public class 字符串压缩 {
  /**
   * 描述
   *
   * 字符串压缩
   *
   * 利用字符串中重复出现的字符数，编写代码，实现字符串压缩功能。
   *
   * 如：字符串如“AAbbbCCCCd”压缩为“A2b3C4d1”。
   *
   * 若压缩之后的字符串没有缩短，则返回原字符串不进行压缩，如：“AbbCD”压缩为“A1b2C1D1”比原字符串更长，返回原字符串。
   *
   * 假设字符串中只包含大小写英文字母（a-z,A-Z）。
   *
   *
   * 输入
   * 输入一个字符串（a-z,A-Z）
   *
   *
   * 输出
   * 输出为压缩后的字符串
   * 输入样例 1
   *
   * AAbbbCCCCd
   * 输出样例 1
   *
   * A2b3C4d1
   *
   *
   * 输入样例 2
   *
   * AA
   * 输出样例 2
   *
   * AA
   */

  public static void main(String[] args) {
    String t = tt("AA");
    System.out.println(t);
  }

  public static String tt(String str){
    char[] chars = str.toCharArray();
    HashMap<Character,Integer> aa = new HashMap<>();
    for (int i = 0; i < chars.length; i++) {
      aa.put(chars[i],aa.getOrDefault(chars[i],0)+1);
    }

    Set<Character> characters = aa.keySet();

    StringBuilder result = new StringBuilder();
    for (Character c: characters) {
      result.append(c).append(aa.get(c));
    }
    return result.toString().length() < str.length() ? result.toString() : str;

  }
}
