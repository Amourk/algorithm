package PDD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class 寻找目标值的和 {

  /**
   * 描述
   * <p>
   * 有N个整数数组，对于每个数组需要寻找其目标值，目标值为第一个重复整数，若该数组没有重复元素，则目标值为第3大的元素。最后，将每个数组的目标值累加，得出最终结果。
   * <p>
   * 数组个数N<=30 ,每个数组整数个数3=<M<=10^5，数组内每个整数范围： -2^31  <= x <= 2^31 -1
   * <p>
   * <p>
   * 输入 输出N个数组，每个数据元素用，分割
   * <p>
   * <p>
   * 输出 输出每个数据目标值的和
   * <p>
   * <p>
   * 输入样例 1
   * <p>
   * 1,3,44,9,10 3,2,19,99,2,3 输出样例 1
   * <p>
   * 11 提示
   * <p>
   * [3,2,19,99,2,3] 中 目标值为 2,按照顺序先找到重复数为2
   */

  public static void main(String[] args) {
    Integer[] aa = {1,3,44,9,10};
    List<Integer> list1 = new ArrayList(Arrays.asList(aa));

    Integer[] bb = {3,2,19,99,2,3};
    List<Integer> list2 = new ArrayList(Arrays.asList(bb));

    List<List> lists = new ArrayList<>();
    lists.add(list1);
    lists.add(list2);
    long totalTargetValue = getTotalTargetValue2(lists);
    System.out.println(totalTargetValue);
  }

  public static long getTotalTargetValue(List<List> lists) {
    // todo
    long result = 0;
    for (int i = 0; i < lists.size(); i++) {
      result += tt(lists.get(i));
    }
    return result;
  }

  public static Integer tt(List<Integer> list) {
    Map<Integer, Integer> map = new HashMap<>();
    // 重复数字
    Integer result = 0;
    // 重复标准
    boolean flag = false;
    for (Integer i : list) {
      map.put(i, map.getOrDefault(i, 0) + 1);
      if (map.get(i).equals(2)) {
        result = i;
        flag = true;
        break;
      }
    }

    // 没有重复数字找第三大数字
    if (!flag) {
      PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(3);
      for (Integer num : list) {
        if (3 > priorityQueue.size()) {
          priorityQueue.add(num);
        } else if (priorityQueue.peek() < num) {
          priorityQueue.poll();
          priorityQueue.add(num);
        }
      }
      result = priorityQueue.peek();
    }
    return result;
  }

  ////////////////////////////////////////////////////////////////////////////////////
  public static long getTotalTargetValue1(List<List> lists) {
    long result = 0;
    for (List<Integer> item : lists) {
      Set<Integer> tempSet = new HashSet<Integer>();
      // 重复标准
      boolean flag = false;
      for (Integer number : item) {
        //目标值：第一个重复的数字
        if (!tempSet.add(number)) {
          result += number;
          flag = true;
          break;
        }
      }
      if (!flag) {
        //目标值：该数组没有重复元素，目标值为第3大元素
        if (tempSet.size() == item.size()) {
          //排序
          Collections.sort(item);
          result += item.get(item.size()-3);
        }
      }
    }
    return result;
  }
  //////////////////////
  public static long getTotalTargetValue2(List<List> lists){
    long result = 0;
    for(List<Integer> item : lists){
      Set<Integer> tempSet = new HashSet<Integer>();
      for(Integer number : item){
        //目标值：第一个重复的数字
        if(!tempSet.add(number)) {
          result += number;
          break;
        }
        //目标值：该数组没有重复元素，目标值为第3大元素
        if(tempSet.size() == item.size()){
          //排序
          Collections.sort(item);
          result += item.get(item.size()-3);
        }
      }
    }
    return result;
  }
}
