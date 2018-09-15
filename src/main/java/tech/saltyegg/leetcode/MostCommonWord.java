package tech.saltyegg.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null || paragraph.isEmpty()) return null;

        String[] splits = paragraph.toLowerCase().split("\\W+");
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        for (String s : splits) {
            String ls = s.trim();
            if (bannedSet.contains(ls)) {
                continue;
            }
            map.put(ls, map.getOrDefault(ls, 0) + 1);
        }

        int max = 0;
        String result = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
