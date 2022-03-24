package LeetCode;

public class LC23 {
    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     * <p>
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     */

    public static void main(String[] args) {
        int[] nums = {2, 3, -2,4};
        System.out.println("aaaa " + maxProduct2(nums));
    }

    public static int maxProduct2(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int[] max = new int[nums.length];
        max[0] = nums[0];
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            max[i] = Math.max(Math.max(max[i-1]*nums[i],nums[i]),min[i-1]*nums[i]);
            min[i] = Math.min(Math.min(max[i-1]*nums[i],nums[i]),min[i-1]*nums[i]);
            dp[i] = Math.max(max[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}
