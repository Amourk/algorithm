package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC5 {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 
     * 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     *  
     * <p>
     * 示例：
     * <p>
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * <p>
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int a = i;
                int b = i + 1;
                int c = nums.length - 1;
                while (b < c) {
                    if (nums[a] + nums[b] + nums[c] == 0) {
                        List<Integer> integers = new ArrayList<>();
                        integers.add(nums[a]);
                        integers.add(nums[b]);
                        integers.add(nums[c]);
                        lists.add(integers);
                        while (b < c && nums[b] == nums[b + 1]) {
                            b++;
                        }
                        while (b < c && nums[c] == nums[c - 1]) {
                            c--;
                        }
                        b++;
                        c--;
                    } else if (nums[a] + nums[b] + nums[c] < 0) {
                        while (b < c && nums[b] == nums[b + 1]) {
                            b++;
                        }
                        b++;
                    } else {
                        while (b < c && nums[c] == nums[c - 1]) {
                            c--;
                        }
                        c--;
                    }
                }
            }
        }
        return lists;
    }
}
