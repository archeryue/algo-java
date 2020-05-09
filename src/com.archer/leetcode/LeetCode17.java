package com.archer.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * archeryue
 * 9/19/16
 */
public class LeetCode17 {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0 || digits.contains("0") || digits.contains("1")) {
            return Collections.emptyList();
        }

        String[] keys = new String[] {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        Tracer tracer = new Tracer(keys, digits.toCharArray());
        tracer.trace(new StringBuilder());
        return tracer.getResult();
    }

    public class Tracer {
        private List<String> res;
        private String[] keys;
        private char[] digits;

        public Tracer(String[] keys, char[] digits) {
            this.keys = keys;
            this.digits = digits;
            this.res = new LinkedList<>();
        }

        public void trace(StringBuilder sb) {
            if (sb.length() == digits.length) {
                res.add(sb.toString());
                return;
            }

            char[] arr = keys[digits[sb.length()] - '0'].toCharArray();
            for (char c : arr) {
                sb.append(c);
                trace(sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        public List<String> getResult() {
            return res;
        }
    }

}
