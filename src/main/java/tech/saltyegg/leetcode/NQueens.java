package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author hzhou
 */
public class NQueens {

    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<>();
        if (n < 1) return result;
        helper(result, new ArrayList<>(), 0, n);
        return result;
    }

    private void helper(List<String[]> result, List<String> crt, int row, int n) {
        if (row == n) {
            result.add(crt.toArray(new String[crt.size()]));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(crt, row, i, n)) {
                String s = lineGenerator(i, n);
                crt.add(s);
                helper(result, crt, row + 1, n);
                crt.remove(crt.size() - 1);
            }
        }
    }

    private boolean isValid(List<String> crt, int x, int y, int n) {
        for (int i = 0; i < x; i++) {
            int offSet = x - i;
            if (crt.get(i).charAt(y) == 'Q') return false;
            if (y - offSet >= 0 && crt.get(i).charAt(y - offSet) == 'Q') return false;
            if (y + offSet < n && crt.get(i).charAt(y + offSet) == 'Q') return false;
        }
        return true;
    }

    private String lineGenerator(int x, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == x) {
                sb.append('Q');
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }

    /**
     * added 11/04/2018
     */
    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[] l45 = new boolean[2 * n - 1];
        boolean[] l135 = new boolean[2 * n - 1];
        char[][] out = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out[i][j] = '.';
            }
        }
        boolean[] colUsed = new boolean[n];

        helper(result, out, l45, l135, colUsed, 0, n);

        return result;
    }

    private void helper(List<List<String>> result, char[][] out, boolean[] l45, boolean[] l135, boolean[] colUsed, int start, int n) {
        if (start == n) {
            List<String> tmp = new ArrayList<>();
            for (char[] l : out) {
                tmp.add(String.valueOf(l));
            }
            result.add(tmp);
            return;
        }

        for (int i = 0; i < n; i++) {
            int id45 = start + i;
            int id135 = n - 1 - i + start;
            if (l45[id45] || l135[id135] || colUsed[i]) continue;
            out[start][i] = 'Q';
            l45[id45] = l135[id135] = colUsed[i] = true;
            helper(result, out, l45, l135, colUsed, start + 1, n);
            out[start][i] = '.';
            l45[id45] = l135[id135] = colUsed[i] = false;
        }
    }
}