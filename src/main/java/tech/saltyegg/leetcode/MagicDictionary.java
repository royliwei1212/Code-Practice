package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MagicDictionary {

    private Map<Integer, Set<String>> map;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        map = new HashMap<>();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            int n = s.length();
            map.putIfAbsent(n, new HashSet<>());
            map.get(n).add(s);
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        Set<String> set = map.get(word.length());
        if (set == null || set.isEmpty()) return false;
        for (String s : set) {
            if (isValid(s, word)) return true;
        }
        return false;
    }

    private boolean isValid(String base, String str) {
        int count = 0;
        for (int i = 0; i < base.length(); i++) {
            char a = str.charAt(i);
            char b = base.charAt(i);
            if (a != b) count++;
            if (count > 1) return false;
        }
        return count == 1;
    }
}
