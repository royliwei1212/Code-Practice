package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author hzhou
 * @since 9/17/17
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
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
}
