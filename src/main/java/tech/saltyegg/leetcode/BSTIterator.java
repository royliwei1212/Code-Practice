/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import java.util.Stack;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * Description
 *
 * @author hzhou
 */
public class BSTIterator {

	private Stack<TreeNode> stack;

	public BSTIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	/**
	 * @return whether we have a next smallest number
	 */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/**
	 * @return the next smallest number
	 */
	public int next() {
		int result = Integer.MAX_VALUE;
		if (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result = node.val;
			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
		}

		return result;
	}
}