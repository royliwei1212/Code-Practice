package tech.saltyegg.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {

    public int slidingPuzzle(int[][] board) {
        String TARGET = "123450";
        String start = arr2Str(board);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);
        int result = 0;

        Map<Integer, List<Integer>> moveMap = new HashMap<>();
        moveMap.put(0, Arrays.asList(1, 3));
        moveMap.put(1, Arrays.asList(0, 2, 4));
        moveMap.put(2, Arrays.asList(1, 5));
        moveMap.put(3, Arrays.asList(4, 0));
        moveMap.put(4, Arrays.asList(1, 3, 5));
        moveMap.put(5, Arrays.asList(2, 4));

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                if (s.equals(TARGET)) return result;
                char[] arr = s.toCharArray();
                int z = s.indexOf("0");
                for (int nz : moveMap.get(z)) {
                    swap(arr, z, nz);
                    String ns = String.valueOf(arr);
                    if (!visited.contains(ns)) {
                        queue.add(ns);
                        visited.add(ns);
                    }
                    swap(arr, nz, z);
                }
            }
            result++;
        }
        return -1;
    }

    private String arr2Str(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int[] b : board) {
            for (int n : b) sb.append(n + "");
        }
        return sb.toString();
    }

    private void swap(char[] arr, int x, int y) {
        char c = arr[x];
        arr[x] = arr[y];
        arr[y] = c;
    }
}
