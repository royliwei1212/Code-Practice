/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description:
 *
 * @author hzhou
 */

public class WordLadderII {

    private int globalMinLength;

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<>();
        if (start == null || end == null || dict == null || dict.isEmpty()) {
            return result;
        }

        dict.add(end);
        List<String> crt = new ArrayList<>();
        crt.add(start);
        Set<String> set = new HashSet<>(crt);
        globalMinLength = dict.size() + 1;
        helper(start, end, crt, set, result, dict);

        int min = Integer.MAX_VALUE;
        for (List<String> list : result) {
            min = Math.min(min, list.size());
        }

        List<List<String>> result2 = new ArrayList<>();
        for (List<String> list : result) {
            if (list.size() == min) {
                result2.add(list);
            }
        }

        return result2;
    }

    private void helper(String start, String end, List<String> crt, Set<String> set, List<List<String>> result, Set<String> dict) {
        if (crt.size() > globalMinLength) {
            return;
        }
        if (start.equals(end)) {
            globalMinLength = Math.min(globalMinLength, crt.size());
            result.add(new ArrayList<>(crt));
            return;
        }

        for (int i = 0; i < start.length(); i++) {
            char[] chars = start.toCharArray();
            for (char k = 'a'; k <= 'z'; k++) {
                chars[i] = k;
                String str = String.valueOf(chars);
                if (dict.contains(str) && !set.contains(str)) {
                    crt.add(str);
                    set.add(str);
                    helper(str, end, crt, set, result, dict);
                    crt.remove(crt.size() - 1);
                    set.remove(str);
                }
            }
        }
    }
}