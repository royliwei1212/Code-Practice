package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                result += node.left.val;
            }

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return result;
    }

}
