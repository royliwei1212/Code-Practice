package com.codeashobby.leetcode;

import java.util.*;

/**
 * Created by hzhou on 2015/5/28.
 * Email: codeashobby@gmail.com
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || words == null) {
            return result;
        }

        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
        if (s.length() < totalLength) {
            return result;
        }
        Set<String> set = getSet(words);
        for (int i = 0; i <= s.length() - totalLength; i++) {
            String tmp = s.substring(i, i + wordLength);
            if (set.contains(tmp)) {

            }
        }
    }

    private Set<String> getSet(String[] words) {
        Set<String> result = new HashSet<String>();
        Collections.addAll(result, words);
        return result;
    }

    private boolean check(String s, String[] words) {
        Set<String> set = getSet(words);
        for (int i = 0; i <= s.length() - words[0].length(); i = i + words[0].length()) {

        }
    }
}
