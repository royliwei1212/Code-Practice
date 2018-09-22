package tech.saltyegg.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import tech.saltyegg.leetcode.parent.TreeNode;

public class DiameterOfBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result = Math.max(result, getMaxDepth(node.left) + getMaxDepth(node.right));
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return result;
    }

    private int getMaxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getMaxDepth(node.left), getMaxDepth(node.right)) + 1;
    }
}
