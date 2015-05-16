package com.codeashobby.leetcode;

import java.util.Stack;

import com.codeashobby.leetcode.parent.TreeLinkNode;
import org.junit.Test;

import static org.junit.Assert.assertSame;

/**
 * Created by hzhou on 4/27/15. codeashobby@gmail.com
 */
public class PopulatingNextRightPointersInEachNodeII {

	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}

		Stack<TreeLinkNode> stack = new Stack<TreeLinkNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeLinkNode node = stack.pop();
			if (node.left != null) {
				stack.push(node.left);
				TreeLinkNode cursor = null;
				while (node != null) {
					if (cursor != null) {
						cursor.next = node.left;
					}
					node.left.next = node.right;
					cursor = node.right;
					node = node.next;
				}
			}
		}
	}

	@Test
	public void test() {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
		root.left.right = new TreeLinkNode(5);
		root.right.right = new TreeLinkNode(7);

		connect(root);

		assertSame(root.left.right.next, root.right.right);
	}
}
