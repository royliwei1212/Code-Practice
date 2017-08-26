package tech.saltyegg.leetcode;

/**
 * @author hzhou
 * @since 8/26/17
 */
public class JudgeRouteCircle {

    public boolean judgeCircle(String moves) {
        if (moves == null || moves.isEmpty()) {
            return false;
        }

        int[] start = {0, 0};
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'R':
                    start[1]++;
                    break;
                case 'L':
                    start[1]--;
                    break;
                case 'U':
                    start[0]--;
                    break;
                case 'D':
                    start[0]++;
                    break;
                default:
            }
            if (start[0] == 0 && start[1] == 0) return true;
        }
        return false;
    }

}
