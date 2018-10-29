package tech.saltyegg.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * Created by hzhou on 2016/5/10.
 */
public class ClosestBinarySearchTreeValue {

    public int closestValue(TreeNode root, double target) {
        int closet = root.val;
        while (root != null) {
            int r = root.val;
            closet = Math.abs(closet - target) > Math.abs(r - target) ? r : closet;
            root = r > target ? root.left : root.right;
        }
        return closet;
    }

    public int closestValue2(TreeNode root, double target) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int result = root.val;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (Math.abs(node.val - target) < Math.abs(result - target)) result = node.val;
            if (node.left != null && node.val >= target) queue.add(node.left);
            if (node.right != null && node.val <= target) queue.add(node.right);
        }
        return result;
    }
}
