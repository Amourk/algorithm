package Day;

public class yy5最长回文子串 {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     *
     * 输入：s = "cbbd"
     * 输出："bb"
     * 示例 3：
     *
     * 输入：s = "a"
     * 输出："a"
     * 示例 4：
     *
     * 输入：s = "ac"
     * 输出："a"
     * */

    public static void main(String[] args) {
//        for (int i = 0; i <10 ; i++) {
//            longestPalindrome(i);
//        }

        String babad = longestPalindrome("aacabdkacaa");
//        String babad = "babad";
        System.out.println("zzzzz    "+ babad);
    }

    static String longestPalindrome(String s) {

        if (s.length() < 2){
            return s;
        }

        //暴力
        char[] chars = s.toCharArray();

        int start = 0;
        int max = 1;

        for (int i = 0; i <chars.length ; i++) {
            for (int j = i + 1; j <chars.length ; j++) {
                if (j+1 - i > max && tt(chars,i,j)){
                    max = j+1 - i;
                    start = i;
                }
            }
        }
        return s.substring(start, start + max);
    }

    static boolean tt(char[] chars, int left, int right){
        while (left < right){
            if (chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
