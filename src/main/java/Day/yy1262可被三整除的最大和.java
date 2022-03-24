package Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class yy1262可被三整除的最大和 {
    /**
     * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,6,5,1,8]
     * 输出：18
     * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
     * 示例 2：
     * <p>
     * 输入：nums = [4]
     * 输出：0
     * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
     * 示例 3：
     * <p>
     * 输入：nums = [1,2,3,4,4]
     * 输出：12
     * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
     */

    public static void main(String[] args) {
        Integer[] integers = {1,2,3,4,4};
        int i = maxSumDivThree1(integers);
//        int k = 21 %3;
        System.out.printf("aaaa "+i);
    }

    public static int maxSumDivThree(Integer[] nums) {
        int n = nums.length;

        int[][] dp = new int[n+1][3];

/*        if ((nums[0] % 3) == 0){
            dp[0][0] = 0;
            dp[0][1] = -1;
            dp[0][2] = -2;
        }else if (nums[0] % 3 == 1){
            dp[0][0] = -2;
            dp[0][1] = 0;
            dp[0][2] = -1;
        }if (nums[0] % 3 == 2){
            dp[0][0] = -1;
            dp[0][1] = -2;
            dp[0][2] = 0;
        }*/
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;


        for (int i = 1; i < n; i++) {
            if (nums[i] % 3 == 0) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][0] + nums[i]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][1] + nums[i]);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][2] + nums[i]);
            } else if (nums[i] % 3 == 1) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] + nums[i]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + nums[i]);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + nums[i]);
            } else if (nums[i] % 3 == 2) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + nums[i]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][2] + nums[i]);
                dp[i][2] = Math.max(dp[i-1][2], dp[i-1][0] + nums[i]);
            }
        }
        return dp[n-1][0];
    }

    public static int maxSumDivThree1(Integer[] nums) {
        int n = nums.length;

        int[][] dp = new int[n + 1][3];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] % 3 == 0) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][0] + nums[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][1] + nums[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][2] + nums[i - 1]);
            } else if (nums[i - 1] % 3 == 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] + nums[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + nums[i - 1]);
            } else if (nums[i - 1] % 3 == 2) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] + nums[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + nums[i - 1]);
            }
        }
        return dp[n][0];
    }
}
