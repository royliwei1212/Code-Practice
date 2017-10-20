package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * Created by hzhou on 4/21/15. codeashobby@gmail.com
 */
@SuppressWarnings("Duplicates")
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(0, nums.length - 1, nums);
    }

    private TreeNode helper(int start, int end, int[] nums) {
        if (start > end) return null;
        int m = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = helper(start, m - 1, nums);
        root.right = helper(m + 1, end, nums);
        return root;
    }

}
