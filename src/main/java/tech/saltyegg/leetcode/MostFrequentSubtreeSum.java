package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * @author hzhou
 * @since 9/3/17
 */
@SuppressWarnings("Duplicates")
public class MostFrequentSubtreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];

        Map<Integer, Integer> dict = new HashMap<>();
        int max = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int sum = getSum(node);
            int count = dict.getOrDefault(sum, 0) + 1;
            max = Math.max(max, count);
            dict.put(sum, count);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : dict.entrySet()) {
            if (entry.getValue() == max) list.add(entry.getKey());
        }

        int[] result = new int[list.size()];
        int i = 0;
        for (int x : list) {
            result[i++] = x;
        }
        return result;
    }

    private int getSum(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result += node.val;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return result;
    }

}
