package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

import tech.saltyegg.leetcode.parent.TreeNode;

public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return min;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
