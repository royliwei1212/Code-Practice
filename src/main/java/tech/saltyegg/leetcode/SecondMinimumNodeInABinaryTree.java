package tech.saltyegg.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * @author hzhou
 * @since 9/5/17
 */
public class SecondMinimumNodeInABinaryTree {

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            heap.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        while (!heap.isEmpty() && heap.peek() == root.val) {
            heap.poll();
        }
        return heap.isEmpty() ? -1 : heap.peek();
    }

}
