package tech.saltyegg.leetcode;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {

    interface Robot {
        // Returns true if the cell in front is open and robot moves into the cell.
        // Returns false if the cell in front is blocked and robot stays in the current cell.
        boolean move();

        // Robot will stay in the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        void turnLeft();

        void turnRight();

        // Clean the current cell.
        void clean();
    }


    private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void cleanRoom(Robot robot) {
        helper(robot, 0, 0, 0, new HashSet<>());
    }

    private void helper(Robot robot, int direct, int r, int c, Set<String> visited) {
        String loc = r + ">" + c;

        if (visited.contains(loc)) return;

        visited.add(loc);
        robot.clean();

        for (int i = 0; i < dir.length; i++) {
            int cd = (direct + i) % 4;
            int x = r + dir[cd][0];
            int y = c + dir[cd][1];
            if (robot.move()) {
                helper(robot, cd, x, y, visited);
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnLeft();
                robot.turnLeft();
            }
            robot.turnRight();
        }
    }
}
