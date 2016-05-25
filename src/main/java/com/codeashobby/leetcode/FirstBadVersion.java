package com.codeashobby.leetcode;

import com.codeashobby.leetcode.parent.VersionControl;

/**
 * Created by hzhou on 2016/5/24.
 * Email: i@hzhou.me
 */
public class FirstBadVersion extends VersionControl {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right -left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
