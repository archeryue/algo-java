package com.archer.leetcode;

/**
 * archeryue
 * 9/28/16
 */
public class LeetCode318 {

    public int maxProduct(String[] words) {
        if (words.length < 2) {
            return 0;
        }

        int[] value = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                value[i] |= 1 << (ch - 'a');
            }
        }

        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((value[i] & value[j]) == 0) {
                    int product = words[i].length() * words[j].length();
                    if (product > max) max = product;
                }
            }
        }

        return max;
    }

}
