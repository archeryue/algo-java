/**
 * @(#)LeetCode1.java, May 10, 2020.
 * <p>
 * Copyright 2020 archer.com. All rights reserved. ARCHER.COM PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.archer.leetcode;

import java.util.Arrays;

/**
 * Yu Zhengyang
 * 2020/5/10
 */
public class LeetCode1 {

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.println(String.valueOf(res[0]) + "," + String.valueOf(res[1]));
    }

}