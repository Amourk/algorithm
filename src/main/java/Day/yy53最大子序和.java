package Day;

public class yy53最大子序和 {

  /**
   * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
   * <p>
   *  
   * <p>
   * 示例 1：
   * <p>
   * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4] 输出：6 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。 示例 2：
   * <p>
   * 输入：nums = [1] 输出：1 示例 3：
   * <p>
   * 输入：nums = [0] 输出：0 示例 4：
   * <p>
   * 输入：nums = [-1] 输出：-1 示例 5：
   * <p>
   * 输入：nums = [-100000] 输出：-100000
   */
  public static void main(String[] args) {
//    int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
    int nums[] = {1};
    int i = maxSubArray(nums);
    System.out.println("aaaaaaa----->" + i);
  }

  public static int maxSubArray(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int max = nums[0];
    for (int i = 1; i < nums.length ; i++) {
      dp[i] = Math.max((nums[i] + dp[i-1]),nums[i]);
      max = Math.max(max,dp[i]);
    }
    return max;
  }
}
