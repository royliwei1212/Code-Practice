package tech.saltyegg.leetcode;

import tech.saltyegg.leetcode.parent.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hzhou on 4/27/15. codeashobby@gmail.com
 * <p/>
 * https://chazyhabit.wordpress.com/2014/08/16/populating-next-right-pointers-in-each-node-ii-leetcode-83/
 */
public class PopulatingNextRightPointersInEachNodeII {

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) queue.add(null);
            } else {
                node.next = queue.peek();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
    }
}
