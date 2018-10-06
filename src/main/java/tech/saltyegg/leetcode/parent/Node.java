package tech.saltyegg.leetcode.parent;

public class Node {
    public int val;
    public Node next;

    public Node left;
    public Node right;

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    public Node() {
    }


    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
}
