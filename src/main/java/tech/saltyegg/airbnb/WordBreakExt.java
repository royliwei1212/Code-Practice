package tech.saltyegg.airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

        // 这个变量是调试用的
        Map<String, List<Set<Integer>>> pathMap = new HashMap<>();
        // 以初始起点为key存path，这样在最后计算的时候，同一个key下面的path是互斥的，因为他们有共同的起点，所以一个group最多只能取一个值
        Map<Integer, List<Set<Integer>>> groupMap = new HashMap<>();
        for (String s : dict) {
            char c = s.charAt(0);
            pathMap.putIfAbsent(s, new ArrayList<>());
            for (int p : map.get(c)) {
                int sx = p / w;
                int sy = p % w;
                groupMap.putIfAbsent(p, new ArrayList<>());
                List<Set<Integer>> paths = new ArrayList<>();
                getPath(board, s, 0, sx, sy, paths, new HashSet<>());
                pathMap.get(s).addAll(paths);
                groupMap.get(p).addAll(paths);
            }
        }
        System.out.println(pathMap);
        System.out.println(groupMap);
        System.out.println("\n------------\n");
        getMaxCount(new ArrayList<>(groupMap.values()), 0, 0, new HashSet<>());

        return result;
    }

    private void getMaxCount(List<List<Set<Integer>>> groupValue, int n, int out, Set<Integer> visited) {
        if (n >= groupValue.size()) {
            result = Math.max(result, out);
            return;
        }
        getMaxCount(groupValue, n + 1, out, visited); //当前group不取值
        List<Set<Integer>> list = groupValue.get(n);
        for (Set<Integer> path : list) {
            if (!containAny(visited, path)) {
                visited.addAll(path);
                getMaxCount(groupValue, n + 1, out + 1, visited);
                visited.removeAll(path);
            }
        }
    }

    private boolean containAny(Set<Integer> base, Set<Integer> target) {
        for (int t : target) {
            if (base.contains(t)) {
                return true;
            }
        }
        return false;
    }

    private void getPath(char[][] board, String s, int n, int x, int y, List<Set<Integer>> result, Set<Integer> out) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != s.charAt(n)) {
            return;
        }
        if (out.contains(x * board[0].length + y)) return;

        out.add(x * board[0].length + y);
        if (n == s.length() - 1) {
            result.add(out);
            return;
        }

        getPath(board, s, n + 1, x + 1, y, result, new HashSet<>(out));
        getPath(board, s, n + 1, x - 1, y, result, new HashSet<>(out));
        getPath(board, s, n + 1, x, y + 1, result, new HashSet<>(out));
        getPath(board, s, n + 1, x, y - 1, result, new HashSet<>(out));

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
        System.out.println("result = " + new WordBreakExt().maxCount(board, dict));
        // result = 5 => ["abc", "abc". "abt", "j", "qmgcc"]
    }
}
