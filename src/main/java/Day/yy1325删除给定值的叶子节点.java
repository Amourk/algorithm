package Day;

import common.TreeNode;

public class yy1325删除给定值的叶子节点 {
    public static void main(String[] args) {

    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null){
            return null;
        }
//        root.getLeft() = removeLeafNodes(root.getLeft(),target);
//        root.getRight() = removeLeafNodes(root.getRight(),target);
        if (root.getLeft() == null && root.getRight() == null &&root.getVal() == target){
            return null;
        }
        return root;
    }
}


