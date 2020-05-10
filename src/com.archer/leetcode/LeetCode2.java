/**
 * @(#)LeetCode2.java, May 10, 2020.
 * <p>
 * Copyright 2020 archer.com. All rights reserved. ARCHER.COM PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.archer.leetcode;

/**
 * Yu Zhengyang 2020/5/10
 */
public class LeetCode2 {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode ps = res;
        int carry = 0;
        do {
            ps.next = new ListNode(carry);
            ps = ps.next;
            carry = 0;
            if (p1 != null) {
                ps.val += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                ps.val += p2.val;
                p2 = p2.next;
            }
            if (ps.val >= 10) {
                carry = ps.val / 10;
                ps.val = ps.val % 10;
            }
        } while (p1 != null || p2 != null || carry != 0);
        res = res.next;
        return res;
    }
}