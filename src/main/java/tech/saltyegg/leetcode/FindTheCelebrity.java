package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.Relation;

public class FindTheCelebrity extends Relation {

    public int findCelebrity(int n) {
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (knows(result, i)) {
                result = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != result && (knows(result, i) || !knows(i, result))) {
                return -1;
            }
        }
        return result;
    }

}
