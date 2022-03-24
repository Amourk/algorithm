package Day;

import java.util.ArrayList;
import java.util.List;

public class yy78子集 {

  /**
   * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
   * <p>
   * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
   * <p>
   *  
   * <p>
   * 示例 1：
   * <p>
   * 输入：nums = [1,2,3] 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]] 示例 2：
   * <p>
   * 输入：nums = [0] 输出：[[],[0]]
   */
  public static void main(String[] args) {
    int num[] = {1,2,3};
    List<List<Integer>> subsets = subsets(num);
    System.out.println(subsets);
  }

  public static List<List<Integer>> subsets(int[] nums) {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    dfs(nums,0, list, result);
    return result;
  }

  private static void dfs(int[] nums,int k, List<Integer> list, List<List<Integer>> result) {
      result.add(new ArrayList<>(list));
    for (int i = k; i < nums.length; i++) {
      list.add(nums[i]);
      dfs(nums,i+1, list, result);
      list.remove(list.size() - 1);
    }
  }
}
