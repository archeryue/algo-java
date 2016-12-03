/**
 * @(#)LeetCode287.java, Dec 03, 2016.
 * <p>
 * Copyright 2016 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package leetcode;

/**
 * archeryue
 * 12/3/16
 */
public class LeetCode287 {
    public int findDuplicate(int[] nums) {
        int fast = nums[nums[0]];
        int slow = nums[0];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        int p = 0;
        while (p != slow) {
            p = nums[p];
            slow = nums[slow];
        }

        return p;
    }
}