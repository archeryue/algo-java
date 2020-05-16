/**
 * @(#)LeetCode46.java, May 16, 2020.
 * <p>
 * Copyright 2020 archer.com. All rights reserved.
 * ARCHER.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.archer.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Archer Yue
 * 2020/5/16
 */
public class LeetCode46 {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backTrack(res, list, 0, used, nums);
        return res;
    }

    private static void backTrack(List<List<Integer>> res, List<Integer> list, int depth,
                                  boolean[] used, int[] nums) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            backTrack(res, list, depth + 1, used, nums);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = permute(new int[] {1,2,3});
        for (List<Integer> list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}