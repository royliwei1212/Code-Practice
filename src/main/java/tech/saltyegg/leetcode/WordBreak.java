/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import java.util.Set;

/**
 * Description: Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * <p/>
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * <p/>
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * @author hzhou
 */
public class WordBreak {

    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        boolean[] map = new boolean[s.length() + 1];
        map[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!map[i]) {
                continue;
            }

            for (String str : wordDict) {
                int l = str.length();
                int end = i + l;

                if (end > s.length() || map[end]) {
                    continue;
                }
                String sub = s.substring(i, end);
                if (sub.equals(str)) {
                    map[end] = true;
                }
            }
        }
        return map[s.length()];
    }
}