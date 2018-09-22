package tech.saltyegg.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * @author hzhou
 * @since 9/5/17
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        sb.append(root.val).append(",");
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null) {
                sb.append("#");
            } else {
                sb.append(node.left.val);
                queue.add(node.left);
            }
            sb.append(",");
            if (node.right == null) {
                sb.append("#");
            } else {
                sb.append(node.right.val);
                queue.add(node.right);
            }
            sb.append(",");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] splits = data.trim().split(",");
        if (splits == null || splits.length == 0) return null;

        int start = 0;
        TreeNode root = new TreeNode(Integer.parseInt(splits[start++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String a = splits[start++];
            String b = splits[start++];
            if (!a.equals("#")) {
                node.left = new TreeNode(Integer.parseInt(a));
                queue.add(node.left);
            }
            if (!b.equals("#")) {
                node.right = new TreeNode(Integer.parseInt(b));
                queue.add(node.right);
            }
        }
        return root;
    }
}
