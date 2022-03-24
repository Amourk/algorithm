package Day;

import java.util.ArrayList;
import java.util.List;

public class yy46全排列 {

  /**
   * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
   * <p>
   *  
   * <p>
   * 示例 1：
   * <p>
   * 输入：nums = [1,2,3] 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] 示例 2：
   * <p>
   * 输入：nums = [0,1] 输出：[[0,1],[1,0]] 示例 3：
   * <p>
   * 输入：nums = [1] 输出：[[1]]
   */
  public static void main(String[] args) {
    int[] nums = {1,2,3};
    List<List<Integer>> permute = permute(nums);
    System.out.println("aaaaaaaa");
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tt = new ArrayList<>();
    dfs(nums,result,tt);
    return result;
  }

  private static void dfs(int[] nums, List<List<Integer>> result, List<Integer> tt) {
    if (tt.size() == nums.length) {
      result.add(new ArrayList<>(tt));
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (tt.contains(nums[i])){
        continue;
      }
      tt.add(nums[i]);
      dfs(nums, result, tt);
      tt.remove(tt.size() - 1);
    }
  }
}
