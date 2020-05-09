/**
 * @(#)LeetCode87.java, Nov 30, 2016.
 * <p>
 * Copyright 2016 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.archer.leetcode;

/**
 * archeryue
 * 11/30/16
 */
public class LeetCode87 {

    public static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        boolean[][][] a = new boolean[s1.length() + 1][s1.length()][s1.length()];
        for (int len = 1; len <= s1.length(); len++) {
            for (int i = 0; i + len <= s1.length(); i++) {
                for (int j = 0; j + len <= s2.length(); j++) {
                    if (len == 1) {
                        a[len][i][j] = s1.charAt(i) == s2.charAt(j);
                    } else {
                        for (int k = 1; k < len; k++) {
                            if ((a[k][i][j] && a[len - k][i + k][j + k])
                                    || (a[k][i][j + len - k] && a[len - k][i + k][j])) {
                                a[len][i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        return a[s1.length()][0][0];
    }

    public static void main(String[] args) {
        System.out.println(isScramble("abc", "cba"));
    }
}