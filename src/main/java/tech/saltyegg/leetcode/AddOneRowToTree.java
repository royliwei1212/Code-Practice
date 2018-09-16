package tech.saltyegg.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import tech.saltyegg.leetcode.parent.TreeNode;

public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null && d > 1) return root;

        if (d == 1) {
            TreeNode result = new TreeNode(v);
            result.left = root;
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int dep = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                dep++;
                if (!queue.isEmpty()) queue.offer(null);
                continue;
            }

            if (d == dep + 1) {
                TreeNode tnl = new TreeNode(v);
                tnl.left = node.left;
                node.left = tnl;

                TreeNode tnr = new TreeNode(v);
                tnr.right = node.right;
                node.right = tnr;
            }
            if (dep >= d) break;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }
}
