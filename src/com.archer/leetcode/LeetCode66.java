package com.archer.leetcode;

import java.util.Arrays;

/**
 * archeryue
 * 10/1/16
 */
public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (index >= 0 && digits[index] == 9) index--;
        int[] res;
        if (index < 0) {
            res = new int[digits.length + 1];
            res[0] = 1;
            index = 1;
        } else {
            res = Arrays.copyOf(digits, digits.length);
            res[index++] += 1;
        }
        while (index < digits.length) res[index++] = 0;
        return res;
    }
}
