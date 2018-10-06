package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.Node;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

    public Node treeToDoublyList(Node root) {
        if (root == null) return root;
        Node left = treeToDoublyList(root.left);
        Node right = treeToDoublyList(root.right);
        root.left = root;
        root.right = root;
        return helper(helper(left, root), right);
    }

    private Node helper(Node n1, Node n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;

        Node t1 = n1.left;
        Node t2 = n2.left;

        n1.left = t2;
        t1.right = n2;
        n2.left = t1;
        t2.right = n1;
        return n1;
    }
}
