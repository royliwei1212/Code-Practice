package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * Created by hzhou on 2015/6/13.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode t = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(t);

        return root;
    }
}
