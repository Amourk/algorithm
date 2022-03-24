package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC22 {
    /**
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     *
     * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
     *
     *  
     *
     * 例如，给定三角形：
     *
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     * */

    public static void main(String[] args) {
        List<Integer> list  = new ArrayList<>();
        list.add(2);
        List<Integer> list1  = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        List<Integer> list2  = new ArrayList<>();
        list2.add(6);
        list2.add(5);
        list2.add(7);
        List<Integer> list3  = new ArrayList<>();
        list3.add(4);
        list3.add(1);
        list3.add(8);
        list3.add(3);

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(list);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);

        int i = minimumTotal(lists);
        System.out.println("aaa "+i);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] DP = new int[triangle.size()][triangle.size()];
        for (int i = 0; i <triangle.get(triangle.size()-1).size() ; i++) {
            DP[triangle.size()-1][i] = triangle.get(triangle.size()-1).get(i);
        }
        for (int i = triangle.size()-2; i >=0 ; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                DP[i][j] =  triangle.get(i).get(j) +
                        (DP[i+1][j] < DP[i+1][j+1] ? DP[i+1][j] : DP[i+1][j+1]);
            }
        }
        return DP[0][0];

    }
}
