package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

public class BinaryTreeTilt {

    public int findTilt(TreeNode root) {
        int[] result = new int[]{0};
        helper(root, result);
        return result[0];
    }

    private int helper(TreeNode node, int[] result) {
        if (node == null) return 0;
        int left = helper(node.left, result);
        int right = helper(node.right, result);
        result[0] += Math.abs(left - right);
        return left + right + node.val;
    }
}
