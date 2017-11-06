package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            node.left = null;

            if (stack.isEmpty()) {
                node.right = null;
            } else {
                node.right = stack.peek();
            }
        }
    }

}