package Day;

import java.util.ArrayList;
import java.util.List;

public class YY39组合总和 {

  /**
   * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
   * <p>
   * candidates 中的数字可以无限制重复被选取。
   * <p>
   * 说明：
   * <p>
   * 所有数字（包括 target）都是正整数。 解集不能包含重复的组合。  示例 1：
   * <p>
   * 输入：candidates = [2,3,6,7], target = 7, 所求解集为： [ [7], [2,2,3] ] 示例 2：
   * <p>
   * 输入：candidates = [2,3,5], target = 8, 所求解集为： [   [2,2,2,2],   [2,3,3],   [3,5] ]
   */
  public static void main(String[] args) {
    int[] candidates = {2, 3, 6, 7};
    List<List<Integer>> lists = combinationSum(candidates, 7);
    System.out.println("aaa--->" + lists);
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tt = new ArrayList<>();
    dfs(candidates, target, result, tt, 0);
    return result;
  }

  private static void dfs(int[] candidates, int target, List<List<Integer>> result,
      List<Integer> tt, int index) {
    if (index == candidates.length){
      return;
    }
    if (target == 0) {
      result.add(new ArrayList<>(tt));
      return;
    }
    dfs(candidates, target, result, tt, index + 1);
    if (target - candidates[index] >= 0) {
      tt.add(candidates[index]);
      dfs(candidates, target - candidates[index], result, tt, index);
      tt.remove(tt.size() - 1);
    }
  }
}
