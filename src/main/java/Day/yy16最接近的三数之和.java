package Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class yy16最接近的三数之和 {
    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
     * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
     * 返回这三个数的和。假定每组输入只存在唯一答案。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     *
     * [1,1,-1,-1,3]
     * -1
     *
     * [0,1,2]
     * 3
     *
     * [1,2,4,8,16,32,64,128]
     * 82
     */

    public static void main(String[] args) {
        int[] nums = {1,2,4,8,16,32,64,128};
        int i = threeSumClosest(nums, 82);
        System.out.printf("aaaaa  " + i);
    }

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int min = Math.abs(nums[0] + nums[1] + nums[2] - target);

        for (int i = 0; i < nums.length; i++) {
            int a = i;
            int b = i + 1;
            int c = nums.length - 1;

            while (b < c) {
                int count = nums[a] + nums[b] + nums[c];
                if (Math.abs(count - target) < Math.abs(min - target)){
                    min = count;
                }
                if (count > target){
                    c--;
                }else if (count < target){
                    b++;
                }else {
                    return min;
                }

            }
        }
        return min;
    }
}
