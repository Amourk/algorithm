package LeetCode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC8 {
    /**
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [1,null,2,3]
     * 输出：[1,2,3]
     * 示例 2：
     * <p>
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：root = [1]
     * 输出：[1]
     * 示例 4：
     * <p>
     * <p>
     * 输入：root = [1,2]
     * 输出：[1,2]
     * 示例 5：
     * <p>
     * <p>
     * 输入：root = [1,null,2]
     * 输出：[1,2]
     */
    public static void main(String[] args) {

    }

    static List<Integer> integers = new ArrayList<>();

    public static List<Integer> preorderTraversal(TreeNode root) {


        return integers;
    }


    /**
     * 先序遍历
     *
     * */
    public static List<Integer> preorder(TreeNode root) {
        if (root == null){
            return integers;
        }
        integers.add(root.getVal());
        if (root.getLeft() != null){
            preorder(root.getLeft());
        }
        if (root.getRight() != null) {
            preorder(root.getRight());
        }
        return integers;
    }


    /**
     * 中序遍历
     *
     * */
    public static List<Integer> inorder(TreeNode root) {
        if (root == null){
            return integers;
        }
        if (root.getLeft() != null){
            inorder(root.getLeft());
        }
        integers.add(root.getVal());
        if (root.getRight() != null) {
            inorder(root.getRight());
        }
        return integers;
    }


    /**
     * 后序遍历
     *
     * */
    public static List<Integer> postorder(TreeNode root) {
        if (root == null){
            return integers;
        }
        if (root.getLeft() != null){
            postorder(root.getLeft());
        }
        if (root.getRight() != null) {
            postorder(root.getRight());
        }
        integers.add(root.getVal());
        return integers;
    }
}
