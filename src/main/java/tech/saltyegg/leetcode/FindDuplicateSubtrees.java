package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tech.saltyegg.leetcode.parent.TreeNode;

public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        helper(root, new HashMap<>(), result);
        return result;
    }

    private String helper(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
        if (root == null) return "#";
        String key = root.val + "#" + helper(root.left, map, result) + "#" + helper(root.right, map, result);
        if (map.getOrDefault(key, 0) == 1) result.add(root);
        map.put(key, map.getOrDefault(key, 0) + 1);
        return key;
    }
}
