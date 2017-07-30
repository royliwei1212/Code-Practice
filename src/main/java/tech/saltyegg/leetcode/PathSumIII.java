package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

public class PathSumIII {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int helper(TreeNode node, int sum) {
        if (node == null) return 0;
        int result = 0;
        if (node.val == sum) {
            result++;
        }
        result += helper(node.left, sum - node.val);
        result += helper(node.right, sum - node.val);
        return result;
    }
}