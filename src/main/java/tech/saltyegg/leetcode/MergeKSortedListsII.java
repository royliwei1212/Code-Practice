package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by hzhou on 5/6/15. codeashobby@gmail.com
 */
public class MergeKSortedListsII {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        Queue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);

        for (ListNode n : lists) {
            if (n != null) {
                queue.add(n);
            }
        }
        ListNode preHead = new ListNode(0);
        ListNode cursor = preHead;

        while (!queue.isEmpty()) {
            ListNode tmp = queue.poll();
            cursor.next = tmp;
            if (tmp.next != null) {
                queue.offer(tmp.next);
            }
            cursor = cursor.next;
        }

        return preHead.next;
    }

}
