/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package com.codeashobby.leetcode;

import com.codeashobby.leetcode.parent.TreeNode;

/**
 * Description: Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * @author hzhou
 */
public class KthSmallestElementInABST {

	private int counter = 0;
	private int result = -1;

	public int kthSmallest(TreeNode root, int k) {
		counter = 0;
		helper(root, k);
		return result;
	}

	private void helper(TreeNode root, int k) {

		if (root.left != null) {
			helper(root.left, k);
		}
		counter++;
		if (k == counter) {
			this.result = root.val;
			return;
		}

		if (root.right != null) {
			helper(root.right, k);
		}

	}
}