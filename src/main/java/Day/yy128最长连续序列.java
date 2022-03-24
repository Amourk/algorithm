package Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class yy128最长连续序列 {

  /**
   * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
   * <p>
   *  
   * <p>
   * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
   * <p>
   *  
   * <p>
   * 示例 1：
   * <p>
   * 输入：nums = [100,4,200,1,3,2] 输出：4 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 示例 2：
   * <p>
   * 输入：nums = [0,3,7,2,5,8,4,6,0,1] 输出：9
   */
  public static void main(String[] args) {
    int[] nums = {100,4,200,1,3,2};
    int i = tt(nums);
    System.out.println(i);
  }

  public static int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    Arrays.sort(nums);
    int n = 0;
    int max = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        continue;
      }
      if (nums[i] + 1 == nums[i + 1]) {
        n++;
      } else {
        max = Math.max(max, n);
        n = 0;
        continue;
      }
      max = Math.max(max, n);
    }
    return max + 1;
  }

  public static int tt(int[] nums){
    Set<Integer> list = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      list.add(nums[i]);
    }

    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (!list.contains(nums[i] - 1)){
        int aa = nums[i];
        int count = 1;
        while (list.contains(aa + 1)){
          aa++;
          count++;
        }
        max = Math.max(max,count);
      }
    }
    return max;
  }
}
