package tech.saltyegg.code;

import tech.saltyegg.leetcode.parent.TreeNode;

public class BST2DoubleLinkedList {

    // solution 1 is use a list to store all TreeNodes with inorder traverse, fairly easy

    // solution 2
    public TreeNode convert(TreeNode root) {
        if (root == null) return null;
        TreeNode tail = helper(root);
        TreeNode head = tail.right;
        tail.right = null;
        return head;
    }

    private TreeNode helper(TreeNode root) {
        if (root == null) return null;
        TreeNode leftEnd = helper(root.left);
        TreeNode rightEnd = helper(root.right);

        TreeNode leftStart = leftEnd == null ? null : leftEnd.right;
        TreeNode rightStart = rightEnd == null ? null : rightEnd.right;

        if (leftEnd != null && rightEnd != null) {
            leftEnd.right = root;
            root.left = leftEnd;
            root.right = rightStart;
            rightStart.left = root;
            rightEnd.right = leftStart;
            return rightEnd;
        } else if (leftEnd != null) {
            leftEnd.right = root;
            root.left = leftEnd;
            root.right = leftStart;
            return root;
        } else if (rightEnd != null) {
            root.right = rightStart;
            rightStart.left = root;
            rightEnd.right = root;
            return rightEnd;
        } else {
            root.right = root;
            return root;
        }
    }
}
