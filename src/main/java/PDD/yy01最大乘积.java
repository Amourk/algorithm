package PDD;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class yy01最大乘积 {
    /**
     * 给定一个无序数组，包含正数、负数和0
     * 要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
     * 输入描述:
     * 输入共2行，第一行包括一个整数n，表示数组长度
     * 第二行为n个以空格隔开的整数，分别为A1,A2, … ,An
     * 输出描述:
     * 满足条件的最大乘积
     * 示例1
     * 输入
     * 复制
     * 4
     * 3 4 1 2
     * 输出
     * 复制
     * 24
     * */

    public static void main(String[] args) {

    }

    public void test(int n,int[] num){

        List<Integer> list = new ArrayList<>();

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < num.length; i++) {
            if (queue.size() < n){
                queue.add(num[i]);
            }else {

            }

        }
    }
}
