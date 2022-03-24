package LeetCode;

import sun.text.normalizer.Trie;

public class LC17 {
    /**
     * 实现 int sqrt(int x) 函数。
     *
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     *
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     *
     * 示例 1:
     *
     * 输入: 4
     * 输出: 2
     * 示例 2:
     *
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     *      由于返回类型是整数，小数部分将被舍去。
     *
     * */
    public static void main(String[] args) {
        double v = mySqrt(10);
        System.out.println("aaaa "+v);

    }

    public static double mySqrt(int x) {
        //二分查找
        double left = 0;
        double right = x;
        double result = 0;
        double flag = 0.0001;
        while (right-left>flag){
            double mid = (left+right)/2;

            if (x/mid<mid){
                right = mid;
            }else if (x/mid > mid){
                left = mid;
            }
            result = mid;
        }
        return result;
    }
}
