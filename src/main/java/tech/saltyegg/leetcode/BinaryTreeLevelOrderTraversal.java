/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tech.saltyegg.leetcode.parent.TreeNode;
import org.junit.Test;

/**
 * Description:
 *
 * @author hzhou
 */
public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int crt = 1;
		int next = 0;
		List<Integer> list = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			list.add(node.val);
			crt--;
			if (node.left != null) {
				queue.offer(node.left);
				next++;
			}
			if (node.right != null) {
				queue.offer(node.right);
				next++;
			}

			if (crt == 0) {
				result.add(new ArrayList<Integer>(list));
				list.clear();
				crt = next;
				next = 0;
			}
		}

		return result;
	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		List<List<Integer>> result = levelOrder(root);

	}
}