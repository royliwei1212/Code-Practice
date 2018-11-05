package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * Created by hzhou on 4/28/15. codeashobby@gmail.com
 */
public class BinaryTreeUpsideDown {

    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        TreeNode node = root, parent = null, right = null;
        while (node != null) {
            TreeNode left = node.left;
            node.left = right;
            right = node.right;
            node.right = parent;
            parent = node;
            node = left;
        }
        return parent;
    }

    /**
     *     1
     *    / \
     *   2   3
     *  / \
     * 4   5
     *   ||
     *    4
     *   / \
     *  5   2
     *     / \
     *    3   1
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = null;

        left.right = root;
        left.left = right;

        return newRoot;
    }
}
