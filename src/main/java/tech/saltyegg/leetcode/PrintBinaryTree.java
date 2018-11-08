package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

import tech.saltyegg.leetcode.parent.TreeNode;

public class PrintBinaryTree {

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        if (root == null) return result;
        int depth = getDepth(root);
        int len = (int) Math.pow(2, depth) - 1;
        List<String> out = new ArrayList<>();
        for (int i = 0; i < len; i++) out.add("");
        for (int i = 0; i < depth; i++) result.add(new ArrayList<>(out));

        helper(result, root, 0, depth, 0, len - 1);

        return result;
    }

    private void helper(List<List<String>> result, TreeNode root, int i, int r, int s, int e) {
        if (i == r || root == null) return;
        int target = (s + e) / 2;
        result.get(i).set(target, String.valueOf(root.val));
        helper(result, root.left, i + 1, r, s, target - 1);
        helper(result, root.right, i + 1, r, target + 1, e);
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
