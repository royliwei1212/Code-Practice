package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int max = findMax(0, nums.length - 1, nums);
        TreeNode root = new TreeNode(nums[max]);
        root.left = helper(0, max - 1, nums);
        root.right = helper(max + 1, nums.length - 1, nums);
        return root;
    }

    private int findMax(int start, int end, int[] nums) {
        int max = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        return max;
    }

    private TreeNode helper(int start, int end, int[] nums) {
        if (start > end) return null;
        if (start == end) return new TreeNode(nums[start]);
        int max = findMax(start, end, nums);
        TreeNode n = new TreeNode(nums[max]);
        n.left = helper(start, max - 1, nums);
        n.right = helper(max + 1, end, nums);
        return n;
    }
}
