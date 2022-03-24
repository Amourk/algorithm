package Day;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;

public class yy17电话号码的字母组合 {
    /**
     * 删除链表的倒数第 N 个结点
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * <p>
     * 2: abc
     * 3: def
     * 说明:
     */

    public static void main(String[] args) {

/*        List<String> list = letterCombinations("");
        System.out.println("aaaaaaaa " + list);*/

        String aa = "Rdtest13";

        byte[] bytes = aa.getBytes();

        //Base64 加密
        String encoded = Base64.getEncoder().encodeToString(bytes);
        System.out.println("Base 64 加密后：" + encoded);

        //Base64 解密
        byte[] decoded = Base64.getDecoder().decode("UmR0ZXN0MTM=");

        String decodeStr = new String(decoded);
        System.out.println("Base 64 解密后：" + decodeStr);


    }

    public static List<String> letterCombinations(String digits) {
        List<String> stringList = new ArrayList<>();
        HashMap<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        if (digits.length() != 0) {
            tt(phoneMap, digits, 0, new StringBuilder(), stringList);
        }

        return stringList;
    }

    static void tt(HashMap<Character, String> phoneMap, String digits, int index, StringBuilder stringBuilder, List<String> stringList) {
        if (index == digits.length()) {
            stringList.add(stringBuilder.toString());
            return;
        }
        String s = phoneMap.get(digits.charAt(index));
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            tt(phoneMap, digits, index + 1, stringBuilder, stringList);
            stringBuilder.deleteCharAt(index);
        }
    }
}

