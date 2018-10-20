package tech.saltyegg.leetcode;

import org.junit.Test;

public class AlienOrder {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        boolean[][] connected = new boolean[26][26];
        int[] visited = new int[26];
        if (!buildGraph(words, connected, visited)) return "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (visited[i] == 0) {
                if (!dfs(connected, visited, i, sb)) return "";
            }
        }
        return sb.reverse().toString();
    }

    private boolean dfs(boolean[][] connected, int[] visited, int i, StringBuilder sb) {
        visited[i] = 1;
        for (int j = 0; j < 26; j++) {
            if (connected[i][j]) {
                if (visited[j] == 1) return false;
                if (visited[j] == 0 && !dfs(connected, visited, j, sb)) return false;
            }
        }

        visited[i] = 2;
        sb.append((char) (i + 'a'));
        return true;
    }

    private boolean buildGraph(String[] words, boolean[][] connected, int[] visited) {
        for (int i = 0; i < 26; i++) visited[i] = -1;
        for (int i = 0; i < words.length; i++) {

            String w2 = words[i];
            for (char c : w2.toCharArray()) visited[c - 'a'] = 0;
            if (i > 0) {
                String w1 = words[i - 1];
                for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                    int c1 = w1.charAt(j) - 'a';
                    int c2 = w2.charAt(j) - 'a';
                    if (c1 != c2) {
                        connected[c1][c2] = true;
                        break;
                    }
                    if (j == w1.length() - 1 && w1.length() > w2.length()) return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        alienOrder(new String[]{"wrt","wrtkj"});
    }
}
