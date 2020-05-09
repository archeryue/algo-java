package com.archer.leetcode;

/**
 * archeryue
 * 9/28/16
 */
public class LeetCode198 {

    public int rob(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        int[] a = new int[nums.length + 1];
        a[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            a[i] = Math.max(a[i - 1], a[i - 2] + nums[i - 1]);
        }
        return a[nums.length];
    }

}
