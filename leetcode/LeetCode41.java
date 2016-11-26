/**
 * @(#)LeetCode41.java, Nov 26, 2016.
 * <p>
 * Copyright 2016 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package leetcode;

/**
 * archeryue
 * 11/26/16
 */
public class LeetCode41 {

    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (num > 0 && num < nums.length
                    && num != i + 1 && nums[num - 1] != num) {
                nums[i] = nums[num - 1];
                nums[num - 1] = num;
                num = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i+1;
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] {1,2,0}));
        System.out.println(firstMissingPositive(new int[] {3,4,-1,1}));
        System.out.println(firstMissingPositive(new int[] {10,4,16,54,17,-7,21,15,25,31,61,1,6,12,21,46,16,56,54,12,23,20,38,63,2,27,35,11,13,47,13,11,61,39,0,14,42,8,16,54,50,12,-10,43,11,-1,24,38,-10,13,60,0,44,11,50,33,48,20,31,-4,2,54,-6,51,6}));
    }

}