package com.archer.leetcode;

/**
 * archeryue
 * 9/19/16
 */
public class LeetCode209 {
    public int minSubArrayLen(int s, int[] nums) {
        int r = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int f = 0; f < nums.length; f++) {
            sum += nums[f];
            if (sum < s) {
                continue;
            }
            while (sum - nums[r] - s >= 0) {
                sum -= nums[r];
                r++;
            }
            min = Math.min(min, f - r + 1);
        }
        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }
}
