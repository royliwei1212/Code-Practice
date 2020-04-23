package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * @author hzhou
 * @since 9/17/17
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];

        int[] result = new int[matrix.length * matrix[0].length];
        List<List<Integer>> dict = new ArrayList<>(matrix.length + matrix[0].length - 1);
        for (int i = 0; i < matrix[0].length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(matrix[0][i]);
            int x = 1;
            int y = i - 1;
            while (y >= 0 && x < matrix.length) {
                list.add(matrix[x][y]);
                x++;
                y--;
            }
            dict.add(list);
        }

        print(dict);

        for (int i = 1; i < matrix.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(matrix[i][matrix[0].length - 1]);
            int x = i + 1;
            int y = matrix[0].length - 2;
            while (y >= 0 && x < matrix.length) {
                list.add(matrix[x][y]);
                x++;
                y--;
            }
            dict.add(list);
        }
        print(dict);
        int index = 0;
        for (int i = 0; i < dict.size(); i++) {
            List<Integer> list = dict.get(i);
            if (i % 2 == 0) {
                Collections.reverse(list);
            }
            for (int n : list) result[index++] = n;
        }
        return result;
    }

    private void print(List<List<Integer>> dict) {
        System.out.println("====================");
        for (List<Integer> list : dict) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println("====================\n\n");
    }

    public void print(int[] dict) {
        System.out.println("--------------------\n");
        for (int i : dict) {
            System.out.print(i + " ");
        }
        System.out.println("--------------------\n\n");
    }

    @Test
    public void test1() {
        int[][] input = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        DiagonalTraverse dt = new DiagonalTraverse();
        dt.print(dt.findDiagonalOrder1(input));
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return new int[0];
        int lr = matrix.length;
        int lc = matrix[0].length;

        int[] result = new int[lc * lr];
        int[][] dir = new int[][]{{-1, 1}, {1, -1}};
        int k = 0;
        int r = 0;
        int c = 0;
        for (int i = 0; i < lr * lc; i++) {
            result[i] = matrix[r][c];
            r += dir[k][0];
            c += dir[k][1];

            if (r >= lr) {
                r = lr - 1;
                c += 2;
                k = 1 - k;
            }
            if (c >= lc) {
                c = lc - 1;
                r += 2;
                k = 1 - k;
            }
            if (r < 0) {
                r = 0;
                k = 1 - k;
            }
            if (c < 0) {
                c = 0;
                k = 1 - k;
            }


        }
        return result;
    }
}
