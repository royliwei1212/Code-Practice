package tech.saltyegg.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tech.saltyegg.leetcode.parent.Pair;

public class ParseString {

  static class Node {
    String value;
    List<Node> children = new ArrayList<>();

    public Node(String value) {
      this.value = value;
    }
  }

  public static void main(String[] args) {
    String input = "node_a(node_b(node_b1, node_b2), node_c, node_d(node_d1))";
    Node root = helper(input, null, 0, input.length());
    System.out.println();
  }

  private static Node helper(String input, Node root, int start, int end) {
    StringBuilder value = new StringBuilder();
    Stack<Character> stack = new Stack<>();
    int s = start;
    List<Pair<Integer, Integer>> ranges = new ArrayList<>();

    for (int i = start; i < end; i++) {
      char c = input.charAt(i);
      if (c == ',' && stack.isEmpty()) {
        ranges.add(new Pair<>(s, i));
        s = i + 1;
        continue;
      }
      if (c == '(') {
        stack.push('(');
      } else if (c == ')') {
        stack.pop();
      }
      if (i == end - 1 && s < end) {
        ranges.add(new Pair<>(s, end));
      }
    }

    for (Pair<Integer, Integer> p : ranges) {
      int r = findIndex(p, input);
      Node n = new Node(input.substring(p.getKey(), r));
      if (r < p.getValue()) {
        helper(input, n, r + 1, p.getValue() - 1);
      }
      if (root != null) {
        root.children.add(n);
      } else return n;
    }
    return root;
  }

  private static int findIndex(Pair<Integer, Integer> p, String input) {
    int i = p.getKey();
    for (; i < p.getValue(); i++) {
      char c = input.charAt(i);
      if (c == ',' || c == '(' || c == ')') break;
    }
    return i;
  }
}
