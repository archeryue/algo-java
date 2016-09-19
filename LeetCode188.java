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

        int[][] local = new int[k + 1][prices.length];
        int[][] global = new int[k + 1][prices.length];

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < prices.length; j++) {
                int profit = prices[j] - prices[j - 1];
                local[i][j] = Math.max(global[i - 1][j - 1] + profit, local[i][j - 1] + profit);
                global[i][j] = Math.max(global[i][j - 1], local[i][j]);
            }
        }

        return global[k][prices.length - 1];
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
        System.out.println(maxProfit(5, prices));
    }

}
