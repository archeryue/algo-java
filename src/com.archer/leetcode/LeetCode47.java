/**
 * @(#)LeetCode47.java, May 16, 2020.
 * <p>
 * Copyright 2020 archer.com. All rights reserved.
 * ARCHER.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.archer.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Archer Yue
 * 2020/5/16
 */
public class LeetCode47 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] left = nums.clone();
        backTrack(res, list, left, 0);
        return res;
    }

    private static void backTrack(List<List<Integer>> res, List<Integer> take, int[] left, int depth) {
        if (depth == left.length) {
            res.add(new ArrayList<>(take));
        }
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < left.length; i++) {
            int num = left[i];
            if (num == Integer.MIN_VALUE || used.contains(num)) continue;
            used.add(num);
            take.add(num);
            left[i] = Integer.MIN_VALUE;
            backTrack(res, take, left, depth + 1);
            left[i] = num;
            take.remove(take.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = permute(new int[] {1,1,3,3});
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}