/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.codeashobby.leetcode.parent.TreeNode;

/**
 * Description
 *
 * @author hzhou
 */
public class BinaryTreeLevelOrderTraversalII {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int c1 = 1;
		int c2 = 0;
		//List<Integer>
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			c1--;
			if (node.left != null) {
				queue.offer(node.left);
				c2++;
			}
			if (node.right != null) {
				queue.offer(node.right);
				c2++;
			}
			if (c1 == 0) {
				c1 = c2;
			}
		}
		return result;
	}

	private void helper(List<List<Integer>> result, TreeNode root, int level) {

	}
}