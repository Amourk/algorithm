package LeetCode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC13 {
    public static void main(String[] args) {

    }

    /**
     * 给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     *
     * */
    public int maxDepth(TreeNode root) {
        //最大深度
        return root == null ? 0 :
                Math.max(maxDepth(root.getLeft()),maxDepth(root.getRight()))+1;
    }

    /**
     *给定一个二叉树，找出其最小深度。
     *
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     *
     * 说明：叶子节点是指没有子节点的节点。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：2
     * 示例 2：
     *
     * 输入：root = [2,null,3,null,4,null,5,null,6]
     * 输出：5
     *
     * */

    public int minDepth(TreeNode root) {
        //最小深度

        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (queue.size() != 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode poll = queue.poll();
                list.add(poll.getVal());
                if (poll.getLeft() != null) {
                    queue.add(poll.getLeft());
                } else {
                    lists.add(list);
                    return list.size();
                }
                if (poll.getRight() != null) {
                    queue.add(poll.getRight());
                }else {
                    lists.add(list);
                    return list.size();
                }
            }
            lists.add(list);
        }
        return lists.size();
    }
}
