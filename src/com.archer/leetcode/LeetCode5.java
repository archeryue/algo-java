/**
 * @(#)LeetCode5.java, May 10, 2020.
 * <p>
 * Copyright 2020 archer.com. All rights reserved. ARCHER.COM PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.archer.leetcode;

/**
 * Yu Zhengyang
 * 2020/5/10
 */
public class LeetCode5 {
    public static String longestPalindrome(String s) {
        if (null == s || s.length() < 2) {
            return s;
        }
        String res = s.substring(0, 1);
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(r) == s.charAt(l)) {
                    dp[l][r] = l + 1 == r || dp[l + 1][r - 1];
                    if (dp[l][r] && (r - l + 1 > res.length())) {
                        res = s.substring(l, r + 1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }
}