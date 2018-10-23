package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * @author hzhou
 * @since 9/6/17
 */
public class TrimABinarySearchTree {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        if (L <= root.val && root.val <= R) {
            return root;
        }

        if (root.val < L) {
            return root.right;
        }

        return root.left;

    }

    public TreeNode trimBST2(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val < L) root = trimBST2(root.right, L, R);
        else if (root.val > R) root = trimBST2(root.left, L, R);
        if (root == null) return null;
        root.left = trimBST2(root.left, L, R);
        root.right = trimBST2(root.right, L, R);
        return root;
    }
}
