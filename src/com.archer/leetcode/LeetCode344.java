package com.archer.leetcode;

/**
 * archeryue
 * 10/16/16
 */
public class LeetCode344 {

    public String reverseString(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(s.length() - i - 1));
        }

        return sb.toString();
    }

}
