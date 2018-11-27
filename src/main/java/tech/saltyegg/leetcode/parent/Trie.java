package tech.saltyegg.leetcode.parent;

public class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        if (s == null || s.isEmpty()) return;
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (p.children[index] == null) {
                p.children[index] = new TrieNode();
            }
            if (i == s.length() - 1) {
                p.children[index].isLeaf = true;
            }
            p = p.children[index];
        }
    }
}
