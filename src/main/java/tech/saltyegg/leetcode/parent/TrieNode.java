package tech.saltyegg.leetcode.parent;

public class TrieNode {
    public TrieNode[] children;
    public boolean isLeaf;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isLeaf = false;
    }
}
