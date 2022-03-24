package Day;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class yy49字母异位词分组 {

  /**
   * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
   * <p>
   * 示例:
   * <p>
   * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"] 输出: [ ["ate","eat","tea"], ["nat","tan"],
   * ["bat"] ]
   */
  public static void main(String[] args) {
    String str[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> lists = groupAnagrams(str);
    System.out.println("aaaaaaaaaaa");

  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    Map<String,List<String>> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      char[] chars = strs[i].toCharArray();
      Arrays.sort(chars);
      String key = new String(chars);
      List<String> orDefault = map.getOrDefault(key, new ArrayList<>());
      orDefault.add(strs[i]);
      map.put(key,orDefault);
    }
    return new ArrayList<>(map.values());
  }

}
