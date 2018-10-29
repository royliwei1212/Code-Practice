package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.ListNode;

/**
 * Created by hzhou on 2016/5/23.
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        ListNode oddEnd = head;

        while (oddEnd.next != null && oddEnd.next.next != null) {
            oddEnd = oddEnd.next.next;
        }

        while (odd.next != null && even.next != null) {
            if (even.next != odd) {
                odd.next = even.next;
                odd = odd.next;
            }
            if (odd.next != null && odd.next != even) {
                even.next = odd.next;
                even = even.next;
            }
        }
        even.next = null;
        oddEnd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        OddEvenLinkedList oell = new OddEvenLinkedList();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        //l7.next = l8;
        oell.oddEvenList(l1);
    }

}
