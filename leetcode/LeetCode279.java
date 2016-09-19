package leetcode;

/**
 * archeryue
 * 9/19/16
 */
public class LeetCode279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i ++) {
            int tmp = (int)Math.floor(Math.sqrt(i));
            if (tmp * tmp == i) {
                dp[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= tmp; j++) {
                    if (dp[i - (j * j)] > 0) {
                        min = Math.min(min, dp[i - (j * j)] + 1);
                    }
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
}
