/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        if (word == null || word.isEmpty()) return;
        Map<Character, Node> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node node = children.getOrDefault(c, new Node());
            node.val = c;
            children.put(c, node);
            children = node.children;
            if (i == word.length() - 1) node.isLeaf = true;
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return word == null || word.isEmpty() || helper(0, word, root);
    }

    private boolean helper(int start, String word, Node node) {
        if (start == word.length()) return node.isLeaf;
        char c = word.charAt(start);
        boolean result = false;
        if (c == '.') {
            for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
                result = helper(start + 1, word, entry.getValue());
                if (result) break;
            }
        } else {
            if (node.children.containsKey(c)) {
                result = helper(start + 1, word, node.children.get(c));
            }
        }
        return result;
    }

    private static class Node {
        char val;
        boolean isLeaf = false;
        Map<Character, Node> children = new HashMap<>();

    }

}