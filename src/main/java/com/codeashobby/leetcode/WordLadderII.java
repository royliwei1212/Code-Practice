/**
 * Copyright (c) 2015 Ovitas Inc, All rights reserved.
 */
package com.codeashobby.leetcode;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Description:
 *
 * @author hzhou
 */

// TODO: not finished
public class WordLadderII {

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (start == null || end == null || dict == null || dict.isEmpty()) {
            return result;
        }

        dict.add(end);
        List<String> crt = new ArrayList<String>();
        crt.add(start);
        helper(start, end, crt, result, dict);

        int min = Integer.MAX_VALUE;
        for (List<String> list : result) {
            min = Math.min(min, list.size());
        }

        List<List<String>> result2 = new ArrayList<List<String>>();
        for (List<String> list : result) {
            if(list.size() == min) {
                result2.add(list);
            }
        }

        return result2;
    }

    private void helper(String start, String end, List<String> crt, List<List<String>> result, Set<String> dict) {
        if (start.equals(end)) {
            result.add(new ArrayList<String>(crt));
            return;
        }

        for (int i = 0; i < start.length(); i++) {
            char[] chars = start.toCharArray();
            for (char k = 'a'; k <= 'z'; k++) {
                chars[i] = k;
                String str = String.valueOf(chars);
                if (dict.contains(str) && !crt.contains(str)) {
                    crt.add(str);
                    helper(str, end, crt, result, dict);
                    crt.remove(crt.size() - 1);
                }
            }
        }
    }

    @Test
    public void test() {
        Set<String> dict = Sets.newHashSet("hot", "dot", "dog", "lot", "log");
        String start = "hit";
        String end = "cog";
        List<List<String>> result = findLadders(start, end, dict);
    }
}