package tech.saltyegg.code;

public class Trie {

    private class TreeNode {
        boolean isEndNode = false;
        TreeNode[] children = new TreeNode[26];
    }

    private TreeNode root = new TreeNode();

    public void insert(String word) {
        TreeNode crawler = root;
        for (int i = 0; i < word.length(); i++) {
            if (crawler.children[(int) word.charAt(i) - 'a'] == null) {
                crawler.children[(int) word.charAt(i) - 'a'] = new TreeNode();
            }
            crawler = crawler.children[(int) word.charAt(i) - 'a'];
        }
        crawler.isEndNode = true;
    }

    public boolean search(String word) {
        TreeNode crawler = root;
        for (int i = 0; i < word.length(); i++) {
            if (crawler.children[(int) word.charAt(i) - 'a'] == null) {
                return false;
            }
            crawler = crawler.children[(int) word.charAt(i) - 'a'];
        }
        return crawler.isEndNode;
    }

    public boolean startsWith(String prefix) {
        TreeNode crawler = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (crawler.children[(int) prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            crawler = crawler.children[(int) prefix.charAt(i) - 'a'];
        }
        return true;
    }
}
