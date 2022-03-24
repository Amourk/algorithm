package Off;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class yy08 {

    /**
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
     * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
     * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
     * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
     * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     * 窗口大于数组长度的时候，返回空
     * 示例1
     * 输入
     * 复制
     * [2,3,4,2,6,2,5,1],3
     * 返回值
     * 复制
     * [4,4,6,6,6,5]
     */

    public static void main(String[] args) {
        int[] num ={2,3,4,2,6,2,5,1};
        ArrayList<Integer> integerArrayList = maxInWindows(num, 3);
        System.out.println(integerArrayList);
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        if (size <= 0 || size > num.length){
            return integerArrayList;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < num.length ; i++) {
            if (queue.size() < size) {
                queue.add(num[i]);
            } else {
                integerArrayList.add(queue.peek());
                queue.remove(num[i-size]);
                queue.add(num[i]);
            }
        }
        integerArrayList.add(queue.peek());
        return integerArrayList;
    }
}
