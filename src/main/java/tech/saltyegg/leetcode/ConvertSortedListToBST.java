/**
 * Copyright (c) 2015 hzhou, All rights reserved.
 */
package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.ListNode;
import tech.saltyegg.leetcode.parent.TreeNode;

/**
 * Description: Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced
 * BST.
 *
 * @author hzhou
 * <p>
 * http://www.programcreek.com/2013/01/leetcode-convert-sorted-list-to-binary-search-tree-java/
 */

public class ConvertSortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode fast, slow, preSlow;
        fast = slow = preSlow = head;
        while (fast.next != null && fast.next.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        preSlow.next = null;
        TreeNode node = new TreeNode(slow.val);
        if (slow != head) node.left = sortedListToBST(head);
        node.right = sortedListToBST(fast);
        return node;
    }
}