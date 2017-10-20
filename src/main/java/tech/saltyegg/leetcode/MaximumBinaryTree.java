package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(0, nums.length - 1, nums);
    }

    private int findMaxIndex(int start, int end, int[] nums) {
        int result = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[result]) result = i;
        }
        return result;
    }

    private TreeNode helper(int l, int r, int[] nums) {
        if (l > r) return null;

        int max = findMaxIndex(l, r, nums);
        TreeNode root = new TreeNode(nums[max]);
        root.left = helper(l, max - 1, nums);
        root.right = helper(max + 1, r, nums);
        return root;
    }
}
