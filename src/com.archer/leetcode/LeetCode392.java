package com.archer.leetcode;

/**
 * archeryue
 * 10/22/16
 */
public class LeetCode392 {

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;

        int i = 0, j = 0;

        while (i < t.length() && j < s.length()) {
            if (t.charAt(i++) == s.charAt(j)) j++;
        }

        return j == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("leetcodef", "yyylyyyyyeyyyyyeyytyycyyoydyyeyy"));
    }

}
