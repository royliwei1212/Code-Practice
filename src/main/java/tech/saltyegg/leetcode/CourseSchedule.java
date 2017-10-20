package tech.saltyegg.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hzhou on 2015/6/7.
 * Email: i@hzhou.me
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 2) return true;
        int[] dp = new int[numCourses];
        for (int[] p : prerequisites) {
            dp[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == 0) queue.add(i);
        }
        int result = queue.size();
        while (!queue.isEmpty()) {
            int c = queue.poll();
            for (int[] p : prerequisites) {
                if (p[1] == c) {
                    dp[p[0]]--;
                    if (dp[p[0]] == 0) {
                        result++;
                        queue.add(p[0]);
                    }
                }
            }
        }
        return result == numCourses;
    }
}
