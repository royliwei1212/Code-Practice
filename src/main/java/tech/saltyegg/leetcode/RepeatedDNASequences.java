/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description
 *
 * @author hzhou
 */
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.isEmpty()) return result;
        Map<String, Integer> dp = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            dp.put(sub, dp.getOrDefault(sub, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : dp.entrySet()) {
            if (entry.getValue() < 2) continue;
            result.add(entry.getKey());
        }
        return result;
    }
}