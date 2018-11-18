package tech.saltyegg.airbnb;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tech.saltyegg.leetcode.parent.Trie;
import tech.saltyegg.leetcode.parent.TrieNode;

public class KEditDistance {
    private void search(String out, String target, int k, TrieNode root, int[] prevDist, List<String> result) {
        if (root.isLeaf) {
            if (prevDist[target.length()] <= k) {
                result.add(out);
            } else {
                return;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] == null) continue;
            char c = (char) (i + 'a');
            int[] currDist = new int[target.length() + 1];
            currDist[0] = out.length() + 1;
            for (int j = 1; j < prevDist.length; j++) {
                if (target.charAt(j - 1) == c) {
                    currDist[j] = prevDist[j - 1];
                } else {
                    currDist[j] = Math.min(currDist[j - 1], Math.min(prevDist[j], prevDist[j - 1])) + 1;
                }
            }
            search(out + c, target, k, root.children[i], currDist, result);
        }
    }

    public List<String> getKEditDistance(String[] words, String target, int k) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0 || target == null || target.isEmpty() || k < 0) return result;
        Trie root = new Trie();
        for (String s : words) root.insert(s);
        int[] prev = new int[target.length() + 1];
        for (int i = 0; i < prev.length; i++) prev[i] = i;
        search("", target, k, root.root, prev, result);
        return result;
    }

    @Test
    public void test() {
        System.out.println(getKEditDistance(new String[]{"hello", "word", "helxo", "heylo"}, "helo", 1));
    }
}
