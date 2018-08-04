package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 *
 */
public class BinaryTreeLongestConsecutiveSequence {

    private int result = 1;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        handle(root, 1);
        return result;
    }

    private void handle(TreeNode parent, int count) {
        if (parent == null) {
            return;
        }

        result = Math.max(count, result);
        if (parent.left != null) {
            handle(parent.left, parent.val == parent.left.val - 1 ? count + 1 : 1);
        }

        if (parent.right != null) {
            handle(parent.right, parent.val == parent.right.val - 1 ? count + 1 : 1);
        }
    }
}
