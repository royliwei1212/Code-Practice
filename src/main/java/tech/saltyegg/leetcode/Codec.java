package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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


    public static void main(String[] args) {
        Codec c = new Codec();
        TreeNode n1 = new TreeNode(-1);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
//        n3.left = n4;
//        n3.right = n5;
        String ser = c.serialize(n1);
        System.out.println(ser);
        TreeNode root = c.deserialize(ser);
    }
}
