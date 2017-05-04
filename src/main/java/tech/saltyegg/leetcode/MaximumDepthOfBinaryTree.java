package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * Created by hzhou on 4/27/15. codeashobby@gmail.com
 */
public class MaximumDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
		return helper(root);
	}

	private int helper(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return Math.max(helper(root.left), helper(root.right)) + 1;
		}

	}
}
