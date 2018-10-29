package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.VersionControl;

/**
 * Created by hzhou on 2016/5/24.
 */
public class FirstBadVersion extends VersionControl {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
