package Day;

import java.util.HashMap;
import java.util.Map;

public class yy136只出现一次的数字 {

  /**
   * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
   * <p>
   * 说明：
   * <p>
   * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
   * <p>
   * 示例 1:
   * <p>
   * 输入: [2,2,1] 输出: 1 示例 2:
   * <p>
   * 输入: [4,1,2,1,2] 输出: 4
   */
  public static void main(String[] args) {
    int[] nums = {4,1,2,1,2};
    int i = singleNumber(nums);
    System.out.println(i);
  }

  public static int singleNumber(int[] nums) {
    int result = 0;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    for (int i = 0; i < nums.length; i++) {
      if (map.get(nums[i]) == 1){
        result = nums[i];
      }
    }
    return result;
  }
}
