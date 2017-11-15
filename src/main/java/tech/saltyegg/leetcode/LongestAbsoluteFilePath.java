package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
        if (input == null || input.isEmpty()) return 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        String[] splits = input.split("\n");

        map.put(-2, 0);
        for (String s : splits) {
            int depth = s.lastIndexOf("\t");
            if (s.contains(".")) {
                result = Math.max(map.get(depth - 1) + s.length() - depth - 1, result);
            } else {
                map.put(depth, map.get(depth - 1) + s.length() - depth);
            }
        }
        return result;
    }
}
