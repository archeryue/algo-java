package com.archer.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * archeryue
 * 11/5/16
 */
public class LeetCode22 {
    static List<String> res = new LinkedList<>();

    public static List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        dfs(sb, n, 0);
        return res;
    }

    private static void dfs(StringBuilder sb, int n, int m) {
        if (n == 0 && m == 0) {
            res.add(sb.toString());
        }
        if (n > 0) {
            sb.append('(');
            dfs(sb, n-1, m+1);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (m > 0) {
            sb.append(')');
            dfs(sb, n, m-1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(5);
        for (String str : res) {
            System.out.println(str);
        }
    }

}
