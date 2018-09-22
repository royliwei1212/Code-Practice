package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * @author hzhou
 * @since 8/12/17
 */
public class TwoSumIV {

    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> dict = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            dict.put(node.val, dict.getOrDefault(node.val, 0) + 1);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        for (Map.Entry<Integer, Integer> entry : dict.entrySet()) {
            int val = entry.getKey();
            int tar = k - val;
            if (val == tar && entry.getValue() > 1) return true;
            if (val != tar && dict.containsKey(tar)) return true;

        }
        return false;
    }
}
