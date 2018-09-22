package tech.saltyegg.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Description: Medium Word Ladder
 * <p/>
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to
 * end, such that:
 * <p/>
 * Only one letter can be changed at a time Each intermediate word must exist in the dictionary H
 * <pre>
 *     Example
 *     Given: start = "hit"
 *     end = "cog"
 *     dict = ["hot","dot","dog","lot","log"]
 * </pre>
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 * <p/>
 * Note Return 0 if there is no such transformation sequence. All words have the same length. All words contain only
 * lowercase alphabetic characters.
 *
 * @author hzhou
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        queue.add(null);
        int result = 1;
        while (!queue.isEmpty()) {
            String s = queue.poll();
            if (s == null) {
                result++;
                if (!queue.isEmpty()) queue.add(null);
            } else {
                if (s.equals(endWord)) return result;
                char[] arr = s.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == s.charAt(i)) continue;
                        arr[i] = c;
                        String x = String.valueOf(arr);
                        if (wordSet.contains(x)) {
                            wordSet.remove(x);
                            queue.add(x);
                        }
                    }
                    arr[i] = s.charAt(i);
                }
            }
        }
        return 0;
    }
}