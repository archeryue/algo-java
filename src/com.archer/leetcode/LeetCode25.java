/**
 * @(#)LeetCode25.java, May 16, 2020.
 * <p>
 * Copyright 2020 archer.com. All rights reserved.
 * ARCHER.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.archer.leetcode;

/**
 * Archer Yue
 * 2020/5/16
 */
public class LeetCode25 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = null;
        ListNode p = head;
        while (p != null) {
            ListNode todo = p;
            int index = 1;
            while (index <= k && p != null) {
                p = p.next;
                index++;
            }
            if (index > k) {
                ListNode tmp = innerReverse(k, todo, todo, p);
                if (res == null) {
                    res = tmp;
                } else {
                    head.next = tmp;
                    head = todo;
                }
            }
        }
        res = res == null ? head : res;
        return res;
    }

    private static ListNode innerReverse(int k, ListNode todo, ListNode doing, ListNode done) {
        for (int i = 0; i < k; i++) {
            todo = doing.next;
            doing.next = done;
            done = doing;
            doing = todo;
        }
        return done;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i < 3; i++) {
            ListNode newNode = new ListNode(i);
            p.next = newNode;
            p = newNode;
        }
        reverseKGroup(head, 2);
    }
}