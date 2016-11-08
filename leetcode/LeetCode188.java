package leetcode;

/**
 * archeryue
 * 9/15/16
 */
public class LeetCode188 {

    private static int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }

        if (k > prices.length / 2) {
            return quick(prices);
        }

        int[][] buy = new int[prices.length][k + 1];
        int[][] sell = new int[prices.length][k + 1];

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                buy[i][j] = Math.max(buy[i - 1][j] + profit, sell[i - 1][j - 1]);
                sell[i][j] = Math.max(buy[i - 1][j] + profit, sell[i - 1][j]);
            }
        }

        return sell[prices.length - 1][k];
    }

    private static int quick(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {4,4,6,1,1,4,2,5};
        System.out.println(maxProfit(1, prices));
    }

}
