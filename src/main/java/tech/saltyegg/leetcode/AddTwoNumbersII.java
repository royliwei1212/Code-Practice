package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hzhou
 * @since 9/13/17
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = toList(l1);
        List<Integer> list2 = toList(l2);

        int carry = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Math.max(list1.size(), list2.size()); i++) {
            int x = i >= list1.size() ? 0 : list1.get(i);
            int y = i >= list2.size() ? 0 : list2.get(i);
            int z = x + y + carry;
            result.add(z % 10);
            carry = z / 10;
        }
        if (carry > 0) result.add(carry);
        return toListNode(result);
    }

    private List<Integer> toList(ListNode ln) {
        List<Integer> result = new ArrayList<>();
        while (ln != null) {
            result.add(0, ln.val);
            ln = ln.next;
        }
        return result;
    }

    private ListNode toListNode(List<Integer> list) {
        ListNode pre = new ListNode(0);
        ListNode cursor = pre;
        for (int i = list.size() - 1; i >= 0; i--) {
            cursor.next = new ListNode(list.get(i));
            cursor = cursor.next;
        }
        return pre.next;
    }

}
