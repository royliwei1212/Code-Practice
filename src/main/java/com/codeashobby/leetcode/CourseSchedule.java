package com.codeashobby.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hzhou on 2015/6/7.
 * Email: i@hzhou.me
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int length = prerequisites.length;
        if (numCourses < 2) {
            return true;
        }

        int[] counter = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            counter[prerequisite[0]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (counter[i] == 0) {
                queue.add(i);
            }
        }

        int ind = queue.size();

        while (!queue.isEmpty()) {
            int c = queue.poll();
            for (int[] prerequisite : prerequisites) {
                int crtC = prerequisite[0];
                if (crtC == c) {
                    counter[crtC]--;
                    if (counter[crtC] == 0) {
                        ind++;
                        queue.add(crtC);
                    }
                }
            }
        }

        return ind == numCourses;
    }
}
