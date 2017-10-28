package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by hzhou on 2016/5/21.
 * Email: i@hzhou.me
 */
public class FlattenNestedListIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        if (nestedList == null || nestedList.isEmpty()) return;
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) return stack.pop().getInteger();
        return null;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger ni = stack.peek();
            if (ni.isInteger()) return true;
            stack.pop();
            List<NestedInteger> list = ni.getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }
        return false;
    }
}
