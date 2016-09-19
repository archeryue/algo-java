package leetcode;

import java.util.Arrays;

/**
 * archeryue
 * 9/19/16
 */
public class LeetCode377 {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || target <= 0) {
            return 0;
        }
        Arrays.sort(nums);
        int[] result = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            for (int j : nums) {
                if (i < j) {
                    break;
                }

                if (i == j) {
                    result[i]++;
                } else {
                    result[i] += result[i - j];
                }
            }
        }
        return result[target];
    }
}
