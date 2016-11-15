package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * archeryue
 * 11/15/16
 */
public class LeetCode83 {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return null;
            Set<Integer> set = new HashSet<>();
            set.add(head.val);
            ListNode p = head;
            while (p.next != null) {
                if (set.contains(p.next.val)) {
                    p.next = p.next.next;
                } else {
                    set.add(p.next.val);
                    p = p.next;
                }
            }
            return head;
        }
    }
}
