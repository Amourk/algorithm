package Day;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class yy637二叉树的层平均值 {
    /**
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 输出：[3, 14.5, 11]
     * 解释：
     * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
     *
     * */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        root.setLeft(left);
        root.setRight(right);
        TreeNode left1 = new TreeNode(15);
        TreeNode right1 = new TreeNode(7);
        right.setLeft(left1);
        right.setRight(right1);
        List<Double> doubles = averageOfLevels(root);
        System.out.println("aaa " + doubles);
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        queue.add(root);

        while (queue.size() != 0){
            List<Integer> aa = new ArrayList<>();
            int j = queue.size();
            double sum = 0;
            for (int i = 0; i < j; i++) {
                TreeNode poll = queue.poll();
                aa.add(poll.getVal());
                if (poll.getLeft() != null){
                    queue.add(poll.getLeft());
                }
                if (poll.getRight() != null){
                    queue.add(poll.getRight());
                }
            }
            for (Integer a: aa) {
                sum+=a;
            }
            result.add((sum/aa.size()));
        }
        return result;
    }
}
