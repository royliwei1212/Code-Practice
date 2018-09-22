package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

import tech.saltyegg.leetcode.parent.TreeNode;

public class MinimumAbsoluteDifferenceInBST {

    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            result = Math.min(result, list.get(i) - list.get(i - 1));
        }
        return result;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
    }
}
