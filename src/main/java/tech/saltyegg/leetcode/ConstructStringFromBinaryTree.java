package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode t) {
        if (t == null) return "";

        boolean hasLeft = t.left != null;
        boolean hasRight = t.right != null;

        if (!hasLeft && !hasRight) {
            return t.val + "";
        } else if (hasLeft && !hasRight) {
            return t.val + "(" + tree2str(t.left) + ")";
        } else if (!hasLeft && hasRight) {
            return t.val + "()(" + tree2str(t.right) + ")";
        } else {
            return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
        }
    }
}
