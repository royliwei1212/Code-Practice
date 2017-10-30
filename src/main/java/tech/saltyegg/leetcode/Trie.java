/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: Implement a trie with insert, search, and startsWith methods.
 * <p/>
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * <p/>
 * <p/>
 * http://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
 */


@SuppressWarnings("Duplicates")
public class Trie {

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
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
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.isEmpty()) return true;
        Map<Character, Node> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!children.containsKey(c)) return false;
            if (i + 1 == word.length()) return children.get(c).isLeaf;
            children = children.get(c).children;
        }
        return false;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.isEmpty()) return true;
        Map<Character, Node> children = root.children;
        for (char c : prefix.toCharArray()) {
            if (!children.containsKey(c)) return false;
            children = children.get(c).children;
        }
        return true;
    }

    private static class Node {
        char val = '\0';
        Map<Character, Node> children = new HashMap<>();
        boolean isLeaf = false;

    }
}