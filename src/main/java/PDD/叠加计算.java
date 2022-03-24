package PDD;

import java.util.ArrayList;
import java.util.List;

public class 叠加计算 {

  /**
   * 描述
   * <p>
   * 计算s=a+aa+aaa+aaaa+aa...a，其中a是一个数字。例如2+22+222+2222+22222(此时共有5个数相加)
   * <p>
   * <p>
   * 输入 int: number,要计算的数字,int: sum:，要重复的次数
   * <p>
   * <p>
   * 输出 int
   * <p>
   * <p>
   * 输入样例 1
   * <p>
   * number：1, sum:2 输出样例 1
   * <p>
   * 12 输入样例 2
   * <p>
   * number：1, sum:4 输出样例 2
   * <p>
   * 1234
   */

  public static void main(String[] args) {
    int i = numAdd(1, 2);
    System.out.println(i);
  }

  public static int numAdd(int number, int sum) {

    List<Integer> list = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < sum; i++) {
      stringBuilder.append(number);
      list.add(Integer.valueOf(stringBuilder.toString()));
    }
    int result = 0;
    for (Integer i : list) {
      result+=i;
    }
    return result;
  }
}
