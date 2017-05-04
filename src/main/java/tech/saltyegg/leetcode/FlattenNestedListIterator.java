package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hzhou on 2016/5/21.
 * Email: i@hzhou.me
 */
public class FlattenNestedListIterator implements Iterator<Integer> {

    private int currentIndex = 0;
    private List<Integer> list;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        load(nestedList);
    }

    private void load(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                load(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if (currentIndex >= list.size()) {
            return null;
        }
        return list.get(currentIndex++);
    }

    @Override
    public boolean hasNext() {
        return currentIndex < list.size();
    }
}
