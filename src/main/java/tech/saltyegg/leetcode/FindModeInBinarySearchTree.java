package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

import java.util.*;

public class FindModeInBinarySearchTree {

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Map<Integer, Integer> dict = new HashMap<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            dict.put(node.val, dict.getOrDefault(node.val, 0) + 1);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        int max = dict.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : dict.entrySet()) {
            if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }
        return toArray(result);
    }

    private int[] toArray(List<Integer> result) {
        int[] r = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        return r;
    }
}
