/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.leetcode;

import com.codeashobby.leetcode.parent.TreeNode;

/**
 * Description:
 *
 * @author hzhou
 */
public class BinaryTreeMaximumPathSum {

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int[] max = new int[1];
		max[0] = Integer.MIN_VALUE;
		helper(max, root);

		return max[0];

	}

	private int helper(int[] max, TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = helper(max, root.left);
		int right = helper(max, root.right);
		int crt = Math.max(root.val, Math.max(root.val + left, root.val + right));
		max[0] = Math.max(max[0], Math.max(crt, root.val + left + right));
		return crt;
	}
}