/**
 * @(#)LeetCode142.java, Dec 03, 2016.
 * <p>
 * Copyright 2016 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package leetcode;

/**
 * archeryue
 * 12/3/16
 */
public class LeetCode142 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head.next.next;
        ListNode slow = head.next;

        while (fast != null && fast.next != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        ListNode p = head;
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }

        return p;
    }

}