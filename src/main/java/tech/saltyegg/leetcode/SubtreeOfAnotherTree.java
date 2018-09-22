package tech.saltyegg.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import tech.saltyegg.leetcode.parent.TreeNode;

public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(s);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (isSame(node, t)) return true;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return false;
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
