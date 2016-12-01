/**
 * @(#)LeetCode44.java, Dec 01, 2016.
 * <p>
 * Copyright 2016 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package leetcode;

/**
 * archeryue
 * 12/1/16
 */
public class LeetCode44 {

    public boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }

        boolean[][] a = new boolean[s.length() + 1][p.length() + 1];
        a[0][0] = true;
        for (int m = 1; m <= p.length() && p.charAt(m - 1) == '*'; m++) {
            a[0][m] = true;
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '?'
                        || s.charAt(i - 1) == p.charAt(j - 1)) {
                    a[i][j] = a[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    for (int k = i; !a[i][j] && k >= 0; k--) {
                        a[i][j] |= a[k][j - 1];
                    }
                }
            }
        }

        return a[s.length()][p.length()];
    }

}