package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by hzhou on 2015/6/8.
 */
@SuppressWarnings("Duplicates")
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || words == null || words.length == 0) return Collections.emptyList();
        Trie trie = new Trie();
        for (String s : words) trie.insert(s);

        Set<String> result = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(result, board, i, j, trie, visited, "");
            }
        }
        return new ArrayList<>(result);
    }

    private void helper(Set<String> result, char[][] board, int x, int y, Trie trie, boolean[][] visited, String out) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y]) return;
        out += board[x][y];
        if (!trie.startsWith(out)) return;
        if (trie.search(out)) result.add(out);

        visited[x][y] = true;
        helper(result, board, x + 1, y, trie, visited, out);
        helper(result, board, x - 1, y, trie, visited, out);
        helper(result, board, x, y + 1, trie, visited, out);
        helper(result, board, x, y - 1, trie, visited, out);
        visited[x][y] = false;
    }

    private static class Trie {

        private TrieNode root = new TrieNode();

        void insert(String s) {
            if (s == null || s.isEmpty()) return;

            Map<Character, TrieNode> children = root.children;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                TrieNode node = children.getOrDefault(c, new TrieNode());
                node.val = c;
                if (i + 1 == s.length()) node.isLeaf = true;
                children.put(c, node);
                children = node.children;
            }
        }

        boolean search(String s) {
            if (s == null || s.isEmpty()) return true;
            Map<Character, TrieNode> children = root.children;
            TrieNode node = null;
            for (char c : s.toCharArray()) {
                if (!children.containsKey(c)) return false;
                node = children.get(c);
                children = node.children;
            }
            return node != null && node.isLeaf;
        }

        boolean startsWith(String s) {
            if (s == null || s.isEmpty()) return true;
            Map<Character, TrieNode> children = root.children;
            for (char c : s.toCharArray()) {
                if (!children.containsKey(c)) return false;
                children = children.get(c).children;
            }
            return true;
        }
    }

    private static class TrieNode {
        char val;
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isLeaf = false;
    }
}
