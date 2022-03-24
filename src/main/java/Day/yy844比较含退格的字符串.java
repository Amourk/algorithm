package Day;

import java.util.Stack;

public class yy844比较含退格的字符串 {
    /**
     * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
     * <p>
     * 注意：如果对空文本输入退格字符，文本继续为空。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：S = "ab#c", T = "ad#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “ac”。
     * 示例 2：
     * <p>
     * 输入：S = "ab##", T = "c#d#"
     * 输出：true
     * 解释：S 和 T 都会变成 “”。
     * 示例 3：
     * <p>
     * 输入：S = "a##c", T = "#a#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “c”。
     * 示例 4：
     * <p>
     * 输入：S = "a#c", T = "b"
     * 输出：false
     * 解释：S 会变成 “c”，但 T 仍然是 “b”。
     */

    public static void main(String[] args) {
        boolean b = backspaceCompare("a##c", "#a#c");
        System.out.println("aaaaaaa   "+b);
    }

    public static boolean backspaceCompare(String S, String T) {
            return tes(S).equals(tes(T));
    }

    private static Stack<Character> tes(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (Character c : chars) {
            if (c == '#'){
                if (!stack.empty()){
                    stack.pop();
                }
            }else {
                stack.push(c);
            }
        }
        return stack;
    }
}
