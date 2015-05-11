/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import com.codeashobby.leetcode.parent.TreeNode;

/**
 * Description:
 *
 * @author hzhou
 */
public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) {
			return true;
		}
		return getMaxDepth(root) != -1;
	}

	private int getMaxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = getMaxDepth(root.left);
		int right = getMaxDepth(root.right);

		if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
}