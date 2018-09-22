package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * @author hzhou
 * @since 9/15/17
 */
public class FindLeavesOfBinaryTree {

    public List<List<Integer>> findLeaves(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        helper(root, map);
        return new ArrayList<>(map.values());
    }

    private int helper(TreeNode root, Map<Integer, List<Integer>> map) {
        if (root == null) return 0;
        int depth = Math.max(helper(root.left, map), helper(root.right, map)) + 1;
        if (!map.containsKey(depth)) {
            map.put(depth, new ArrayList<>());
        }
        map.get(depth).add(root.val);
        return depth;
    }

}
