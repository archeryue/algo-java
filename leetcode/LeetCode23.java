package leetcode;

import java.util.PriorityQueue;

/**
 * archeryue
 * 11/5/16
 */
public class LeetCode23 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode head = new ListNode(0);
            PriorityQueue<ListNode> queue =
                    new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
            for (ListNode node : lists) {
                if (node != null) {
                    queue.offer(node);
                }
            }
            ListNode p = head;
            while (!queue.isEmpty()) {
                ListNode node = queue.poll();
                p.next = new ListNode(node.val);
                p = p.next;
                if (node.next != null) {
                    queue.offer(node.next);
                }
            }
            return head.next;
        }
    }

}
