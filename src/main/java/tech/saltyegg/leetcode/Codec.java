package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

import java.util.Stack;

/**
 * @author hzhou
 * @since 9/5/17
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        return root.val + "(" + serialize(root.left) + "," + serialize(root.right) + ")";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty() || !(Character.isDigit(data.charAt(0)) || data.charAt(0) == '-')) return null;
        int x = parseInt(data);
        TreeNode root = new TreeNode(x);
        _deserialize(data.substring(data.indexOf('(') + 1, data.length() - 1), root);
        return root;
    }

    private void _deserialize(String data, TreeNode root) {
        if (data == null || data.isEmpty()) return;

        if (data.equals(",")) {
            root.left = root.right = null;
            return;
        }

        Stack<Character> stack = new Stack<>();
        int splitPoint = -1;
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (c == ',' && stack.isEmpty()) {
                splitPoint = i;
                break;
            }
            if (c == '(') stack.push('(');
            if (c == ')') stack.pop();

        }
        if (splitPoint == -1) return;

        String left = (splitPoint == 0 ? null : data.substring(0, splitPoint));
        String right = (splitPoint == data.length() - 1 ? null : data.substring(splitPoint + 1, data.length()));

        Integer integer = parseInt(left);
        if (integer == null) {
            root.left = null;
        } else {
            TreeNode l = new TreeNode(integer);
            root.left = l;
            if (left.contains("(")) _deserialize(left.substring(left.indexOf('(') + 1, left.length() - 1), l);
        }

        integer = parseInt(right);
        if (integer == null) {
            root.right = null;
        } else {
            TreeNode r = new TreeNode(integer);
            root.right = r;
            if (right.contains("(")) _deserialize(right.substring(right.indexOf('(') + 1, right.length() - 1), r);
        }
    }

    private Integer parseInt(String serial) {
        if (serial == null || serial.isEmpty() ||
                !(Character.isDigit(serial.charAt(0)) || serial.charAt(0) == '-')) {
            return null;
        }
        int result = 0;
        boolean isNegative = (serial.charAt(0) == '-');
        for (int i = isNegative ? 1 : 0; i < serial.length(); i++) {
            char c = serial.charAt(i);
            if (Character.isDigit(c)) {
                result = 10 * result + (c - '0');
            } else {
                break;
            }
        }
        return result * (isNegative ? -1 : 1);
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
