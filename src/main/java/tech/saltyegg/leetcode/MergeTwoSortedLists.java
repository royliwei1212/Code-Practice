package tech.saltyegg.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

import tech.saltyegg.leetcode.parent.ListNode;

/**
 * Description
 *
 * @author hzhou
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        Queue<ListNode> queue = new PriorityQueue<>(2, (o1, o2) -> o1.val - o2.val);

        if (l1 != null) queue.add(l1);
        if (l2 != null) queue.add(l2);

        ListNode pre, cursor;
        pre = new ListNode(0);
        cursor = pre;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cursor.next = node;
            cursor = cursor.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return pre.next;
    }
}