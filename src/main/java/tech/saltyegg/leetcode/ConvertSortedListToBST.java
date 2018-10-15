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

        ListNode fast = head.next.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = slow.next;
        slow.next = null;
        slow = fast.next;

        TreeNode root = new TreeNode(fast.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow);
        return root;
    }
}