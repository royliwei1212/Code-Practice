package tech.saltyegg.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hzhou on 2015/6/14.
 */
public class ImplementStackUsingQueues {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        if (empty()) {
            q1.add(x);
            return;
        }

        if (q1.isEmpty()) {
            q1.add(x);
            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }
        } else {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.poll());
            }
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (empty()) {
            return;
        }
        if (q1.isEmpty()) {
            q2.poll();
        } else {
            q1.poll();
        }
    }

    // Get the top element.
    public int top() {
        int result;
        if (q1.isEmpty()) {
            result = q2.peek();
        } else {
            result = q1.peek();
        }
        return result;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
