package tech.saltyegg.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * Created by hzhou on 2015/6/8.
 * Email: i@hzhou.me
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 1) {
            return new int[0];
        }
        int[] result = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0) {
            while (numCourses > 0) {
                result[numCourses - 1] = numCourses - 1;
                numCourses--;
            }
            return result;
        }

        int[] counter = new int[numCourses];
        for (int[] val : prerequisites) {
            counter[val[0]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < numCourses; i++) {
            if (counter[i] == 0) {
                queue.add(i);
            }
        }
        int courseCanTake = queue.size();

        int index = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[index++] = course;
            for (int[] val : prerequisites) {
                if (val[1] == course) {
                    counter[val[0]]--;
                    if (counter[val[0]] == 0) {
                        courseCanTake++;
                        queue.add(val[0]);
                    }
                }
            }
        }

        return (courseCanTake == numCourses) ? result : new int[0];
    }

    @Test
    public void test() {
        int[][] arr = new int[][]{{1, 0}};
        int[] result = findOrder(2, arr);
    }
}
