package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Description:
 *
 * @author hzhou
 */

public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (wordList == null || wordList.isEmpty()) return result;

        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> set = new HashSet<>();
        List<String> crt = new ArrayList<>();
        crt.add(beginWord);

        Queue<List<String>> queue = new LinkedList<>();
        queue.add(crt);
        int minLevel = Integer.MAX_VALUE;
        int level = 1;
        while (!queue.isEmpty()) {
            List<String> t = queue.poll();
            if (t.size() > level) {
                for (String w : set) wordSet.remove(w);
                set.clear();
                level = t.size();
                if (level > minLevel) break;
            }

            String last = t.get(t.size() - 1);

            for (int i = 0; i < last.length(); i++) {
                char[] arr = last.toCharArray();

                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == arr[i]) continue;
                    arr[i] = c;
                    String s = String.valueOf(arr);
                    if (!wordSet.contains(s)) continue;
                    set.add(s);
                    List<String> next = new ArrayList<>(t);
                    next.add(s);
                    if (s.equals(endWord)) {
                        result.add(next);
                        minLevel = Math.min(minLevel, level);
                    } else {
                        queue.add(next);
                    }
                    arr[i] = last.charAt(i);
                }

            }
        }
        return result;
    }

    public static void main(String[] args) {
        WordLadderII wl = new WordLadderII();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(wl.findLadders("hit", "cog", list));
    }
}