package Off;

public class yy02 {
    /**
     * 请实现一个函数，
     * 将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public static void main(String[] args) {
        String aa = "We Are Happy";
        System.out.println(test1(aa.toCharArray()));
    }

    /**
     * 字符串替换为字符数组，遇见空格替换为%20
     * 增加字符串对应数据的长度，从后往前遍历，遇到空格替换%20，对应字符不变
     * @return
     */
    public static String test1(char[] chars1) {
        int sum = 0;
        int size = chars1.length - 1;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] == ' ') {
                sum++;
            }
        }
        int size1 = size + (2 * sum);
        char[] chars = new char[chars1.length + (2 * sum)];
        for (int i = 0; i <chars1.length ; i++) {
            chars[i] = chars1[i];
        }
        while (size >= 0) {
            if (chars[size] == ' ') {
                chars[size1--] = '0';
                chars[size1--] = '2';
                chars[size1--] = '%';
            } else {
                chars[size1--] = chars[size];
            }
            size--;
        }
        return new String(chars);
    }
}
