package tech.saltyegg.airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakExt {

    int result = 0;

    public int maxCount(char[][] board, List<String> dict) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || dict == null || dict.isEmpty()) {
            return 0;
        }
        int w = board[0].length;

        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                map.putIfAbsent(c, new ArrayList<>());
                map.get(c).add(i * w + j);
            }
        }

        Map<String, List<List<Integer>>> pathMap = new HashMap<>();
        for (String s : dict) {
            char c = s.charAt(0);
            pathMap.putIfAbsent(s, new ArrayList<>());
            for (int p : map.get(c)) {
                int sx = p / w;
                int sy = p % w;
                List<List<Integer>> result = new ArrayList<>();
                getPath(board, s, 0, sx, sy, result, new ArrayList<>());
                pathMap.get(s).addAll(result);
            }
        }
        System.out.println(pathMap);

        return result;
    }

    private void getPath(char[][] board, String s, int n, int x, int y, List<List<Integer>> result, List<Integer> out) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != s.charAt(n)) {
            return;
        }
        out.add(x * board[0].length + y);
        if (n == s.length() - 1) {
            result.add(new ArrayList<>(out));
            out.remove(out.size() - 1);
            return;
        }

        getPath(board, s, n + 1, x + 1, y, result, out);
        getPath(board, s, n + 1, x - 1, y, result, out);
        getPath(board, s, n + 1, x, y + 1, result, out);
        getPath(board, s, n + 1, x, y - 1, result, out);
        out.remove(out.size() - 1);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'a', 'a', 'b', 'c', 'd'},
                {'b', 'c', 'e', 'f', 'a'},
                {'f', 'g', 'c', 'c', 'b'},
                {'q', 'm', 's', 'o', 't'},
                {'z', 'w', 'l', 'j', 'r'},
        };

        List<String> dict = Arrays.asList("acef", "aa", "abc", "j", "abt", "qmgcc", "zzz");

        System.out.println(new WordBreakExt().maxCount(board, dict));
    }
}
