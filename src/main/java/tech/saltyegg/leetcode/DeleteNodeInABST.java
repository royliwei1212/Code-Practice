package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * @author hzhou
 * @since 9/17/17
 */
public class DeleteNodeInABST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) {
            return getNode(root);
        }
        helper(root.left, key, root, true);
        helper(root.right, key, root, false);
        return root;
    }

    private void helper(TreeNode root, int key, TreeNode parent, boolean isLeft) {
        if (root == null) return;
        if (root.val > key) {
            helper(root.left, key, root, true);
        } else if (root.val < key) {
            helper(root.right, key, root, false);
        } else {
            TreeNode node = getNode(root);
            if (isLeft) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
    }

    private TreeNode getNode(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null) return null;
        if (left == null) return right;
        if (right == null) return left;
        root = right;
        TreeNode cursor = left;
        while (cursor.right != null) {
            cursor = cursor.right;
        }
        cursor.right = right.left;
        root.left = left;
        return root;
    }

}
