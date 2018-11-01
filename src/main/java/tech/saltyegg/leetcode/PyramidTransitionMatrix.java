package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PyramidTransitionMatrix {

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s.charAt(2));
        }

        return helper(bottom, map);
    }

    private boolean helper(String bottom, Map<String, List<Character>> map) {
        if (bottom.length() == 1) return true;
        for (int i = 0; i < bottom.length() - 1; i++) {
            String key = bottom.substring(i, i + 2);
            if (!map.containsKey(key)) return false;
        }

        List<String> list = new ArrayList<>();
        list(bottom, map, list, new StringBuilder(), 0);
        for (String s : list) {
            if (helper(s, map)) return true;
        }
        return false;
    }

    private void list(String bottom, Map<String, List<Character>> map, List<String> list, StringBuilder sb, int start) {
        if (start >= bottom.length() - 1) {
            list.add(sb.toString());
            return;
        }

        String key = bottom.substring(start, start + 2);
        for (char s : map.get(key)) {
            sb.append(s);
            list(bottom, map, list, sb, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}
