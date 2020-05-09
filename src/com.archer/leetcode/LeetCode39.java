package com.archer.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * archeryue
 * 11/5/16
 */
public class LeetCode39 {

    public static class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            dfs(0, 0, target, candidates);
            return res;
        }

        private void dfs(int start, int sum, int target, int[] candidates) {
            if (sum == target){
                res.add(new ArrayList<>(list));
            } else if (sum < target) {
                for(int i = start; i < candidates.length; i++){
                    list.add(candidates[i]);
                    sum += candidates[i];
                    dfs(i, sum, target, candidates);
                    sum -= candidates[i];
                    list.remove(list.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combinationSum(new int[] {3,2,6,7}, 11);
        for (List<Integer> list : solution.res) {
            for (int i : list) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }

}
