package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by hzhou on 2015/6/8.
 * Email: i@hzhou.me
 */
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }

        Trie trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(result, board, "", i, j, trie, visited);
            }
        }

        return new ArrayList<>(result);
    }

    private void helper(Set<String> result, char[][] board, String str, int x, int y, Trie trie, boolean[][] visited) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
            return;
        }
        str += board[x][y];
        if (!trie.startsWith(str)) {
            return;
        }

        if (trie.search(str)) {
            result.add(str);
        }

        visited[x][y] = true;
        helper(result, board, str, x + 1, y, trie, visited);
        helper(result, board, str, x - 1, y, trie, visited);
        helper(result, board, str, x, y + 1, trie, visited);
        helper(result, board, str, x, y - 1, trie, visited);
        visited[x][y] = false;
    }


    static class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            if (word == null || word.isEmpty()) {
                return;
            }

            Map<Character, TrieNode> children = root.getChildren();

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode tmp;
                if (children.containsKey(c)) {
                    tmp = children.get(c);
                } else {
                    tmp = new TrieNode(c);
                    children.put(c, tmp);
                }
                children = tmp.getChildren();

                if (i == word.length() - 1) {
                    tmp.setIsLeaf(true);
                }
            }
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            if (word == null || word.isEmpty()) {
                return true;
            }
            Map<Character, TrieNode> children = root.getChildren();
            char[] chars = word.toCharArray();
            TrieNode tmp = null;
            for (char c : chars) {
                if (!children.containsKey(c)) {
                    return false;
                } else {
                    tmp = children.get(c);
                    children = tmp.getChildren();
                }
            }
            return tmp != null && tmp.isLeaf();
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.isEmpty()) {
                return true;
            }
            Map<Character, TrieNode> children = root.getChildren();
            char[] chars = prefix.toCharArray();

            for (char c : chars) {
                if (!children.containsKey(c)) {
                    return false;
                } else {
                    children = children.get(c).getChildren();
                }
            }
            return true;
        }

        class TrieNode {

            private Map<Character, TrieNode> children;
            private Character value;
            private boolean isLeaf;

            // Initialize your data structure here.
            public TrieNode() {
                children = new HashMap<>();
                isLeaf = false;
            }

            public TrieNode(Character value) {
                this();
                this.value = value;
            }

            public Map<Character, TrieNode> getChildren() {
                return children;
            }

            public boolean isLeaf() {
                return isLeaf;
            }

            public void setIsLeaf(boolean isLeaf) {
                this.isLeaf = isLeaf;
            }
        }
    }
}
