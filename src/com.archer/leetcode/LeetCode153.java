/**
 * @(#)LeetCode153.java, Nov 26, 2016.
 * <p>
 * Copyright 2016 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.archer.leetcode;

/**
 * archeryue
 * 11/26/16
 */
public class LeetCode153 {

    public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;

        if (nums[lo] < nums[hi]) {
            return nums[lo];
        }

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[lo] <= nums[mid]) {
                if (nums[mid+1] <= nums[hi]) {
                    return nums[mid+1];
                } else {
                    lo = mid + 1;
                }
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {1}));
        System.out.println(findMin(new int[] {1,2,3,4,5,6,7,7,7,7,7,7,7,7,8,9,10,1,1}));
        System.out.println(findMin(new int[] {7,7,7,7,7,7,7,7,7,7,7,7,7,7}));
        System.out.println(findMin(new int[] {2,3,4,5,1}));
        System.out.println(findMin(new int[] {2,3,4,5,6,1}));
        System.out.println(findMin(new int[] {1,2,3,4,5,6}));
    }

}