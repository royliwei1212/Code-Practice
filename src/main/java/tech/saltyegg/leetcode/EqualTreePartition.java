package tech.saltyegg.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * @author hzhou
 * @since 8/27/17
 */
public class EqualTreePartition {

    public boolean checkEqualTree(TreeNode root) {
        int sum = sum(root);
        if (sum % 2 != 0 || (root.left == null && root.right == null)) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root.left != null) queue.add(root.left);
        if (root.right != null) queue.add(root.right);

        int target = sum / 2;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (sum(node) == target) return true;

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return false;
    }

    private int sum(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int sum = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sum += node.val;

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return sum;
    }

}
