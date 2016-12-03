/**
 * @(#)LeetCode141.java, Dec 03, 2016.
 * <p>
 * Copyright 2016 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package leetcode;

/**
 * archeryue
 * 12/3/16
 */
public class LeetCode141 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != null && fast.next != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return fast != null && fast.next != null;
    }
}