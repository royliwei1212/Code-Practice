package tech.saltyegg.leetcode;

import java.util.Stack;

import tech.saltyegg.leetcode.parent.TreeLinkNode;

/**
 * Created by hzhou on 4/27/15. codeashobby@gmail.com
 */
public class PopulatingNextRightPointersInEachNode {

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
}
