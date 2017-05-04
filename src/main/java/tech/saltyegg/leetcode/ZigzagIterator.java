package tech.saltyegg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzhou on 2016/5/28.
 * Email: i@hzhou.me
 */
public class ZigzagIterator {

    private List<Integer> list;
    private int currentIndex;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new ArrayList<>();
        currentIndex = 0;
        if (v1 == null || v1.isEmpty()) {
            list = v2;
            return;
        }
        if (v2 == null || v2.isEmpty()) {
            list = v1;
            return;
        }

        for (int i = 0; i < v1.size(); i++) {
            list.add(v1.get(i));
            if (i < v2.size()) {
                list.add(v2.get(i));
            }
        }

        for (int i = v1.size(); i < v2.size(); i++) {
            list.add(v2.get(i));
        }

    }

    public int next() {
        return list.get(currentIndex++);
    }

    public boolean hasNext() {
        return currentIndex < list.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */