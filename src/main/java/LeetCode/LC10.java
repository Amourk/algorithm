package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class LC10 {
    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     * */

    public static void main(String[] args) {
        int[] num = {3,2,3};
        majorityElement(num);
    }

    public static int majorityElement(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();

        for (Integer num : nums) {
            Integer integer = map.get(num);
            map.put(num,integer == null ? 1 : integer+1);
        }


        Integer max = map.values().stream().max(Integer::compareTo).get();

        AtomicReference<Integer> m = new AtomicReference<>(0);
        map.forEach((k,v)->{
            if (v == max){
                m.set(k);
            }
        });
        return m.get();
    }
}
