package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author hzhou
 * @since 9/13/17
 */
public class BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            TreeNode node = p.node;
            List<Integer> list = map.getOrDefault(p.key, new ArrayList<>());
            list.add(node.val);
            map.put(p.key, list);

            if (node.left != null) queue.add(new Pair(p.key - 1, node.left));
            if (node.right != null) queue.add(new Pair(p.key + 1, node.right));
        }

        return new ArrayList<>(map.values());
    }

    private static class Pair {
        int key;
        TreeNode node;

        Pair(int key, TreeNode node) {
            this.key = key;
            this.node = node;
        }
    }
}
