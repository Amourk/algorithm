package Day;

import java.util.HashMap;

public class yy540有序数组中的单一元素 {
    /**
     * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,1,2,3,3,4,4,8,8]
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: [3,3,7,7,10,11,11]
     * 输出: 10
     * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
     */
    public static void main(String[] args) {
        int[] s = {1,1,2,3,3,4,4,8,8};
        int i = singleNonDuplicate(s);
        System.out.println("aaaaaaaa "+i);
    }

    public static int singleNonDuplicate(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1);
        }
        for (int i = 0; i <nums.length ; i++) {
            if (hashMap.get(nums[i]) == 1){
                return nums[i];
            }
        }
        return 0;
    }


    public static int singleNonDuplicate1(int[] nums) {
        //二分

        return 0;
    }
}
