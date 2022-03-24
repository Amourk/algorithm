package PDD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class 排序题 {
  /**
   * 描述
   *
   * 有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
   *
   *
   *
   * 输入
   * n:参与人数
   *
   *
   * 输出
   * res:最后留下的人的序号
   *
   *
   * 输入样例 1
   *
   * 3
   * 输出样例 1
   *
   * 2
   * 输入样例 2
   *
   * 5
   * 输出样例 2
   *
   * 4
   * 提示
   */

  public static void main(String[] args) {
    Integer tt = tt(7);
    System.out.println(tt);
  }

  public static Integer tt(int n){
    List<Integer> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      list.add(i);
    }
    List<Integer> list1 = new ArrayList<>();
    Integer ys = 0;
    while (list.size()>2) {
      ys = list.size() %3 ;
      if (ys== 1){
        list1.add(list.get(list.size() - 1));
      } else if (ys == 2){
        list1.add(list.get(list.size() - 2));
        list1.add(list.get(list.size() - 1));
      }
      for (int i = 1; i <= list.size()-ys; i++) {
        if (i % 3 == 0) {
          continue;
        }
        list1.add(list.get(i - 1));
      }
      list = list1;
      list1 = new ArrayList<>();

    }
    return list.get(1);
  }
}
