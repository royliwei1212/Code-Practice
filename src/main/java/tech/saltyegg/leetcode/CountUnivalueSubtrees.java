package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * Created by hzhou on 2015/8/8.
 * Email: i@hzhou.me
 */
public class CountUnivalueSubtrees {

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        int[] result = new int[]{0};
        isUnival(root, root.val, result);
        return result[0];
    }

    private boolean isUnival(TreeNode root, int val, int[] result) {
        if (root == null) return true;
        if (!isUnival(root.left, root.val, result) | !isUnival(root.right, root.val, result)) return false;
        result[0]++;
        return root.val == val;
    }

}
