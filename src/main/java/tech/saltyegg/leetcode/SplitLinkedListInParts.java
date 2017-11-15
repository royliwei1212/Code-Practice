package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.ListNode;

public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null) return new ListNode[Math.max(k, 0)];

        int size = 0;
        ListNode c = root;
        while (c != null) {
            size++;
            c = c.next;
        }
        ListNode[] result = new ListNode[k];

        c = root;
        int i = 0;
        while (size > 0) {
            int a = size / k;
            int b = size % k;
            int len = a + (b != 0 ? 1 : 0);
            size -= len;
            result[i++] = c;

            while (len > 1 && c != null) {
                c = c.next;
                len--;
            }
            if (c == null) break;
            ListNode t = c.next;
            c.next = null;
            c = t;
            k--;
        }
        return result;
    }
}
