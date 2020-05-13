package com.archer.leetcode;

/**
 * archeryue
 * 9/15/16
 */
public class LeetCode188 {

        private static int maxProfitA(int k, int[] prices) {
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

    private static int maxProfitB(int k, int[] prices) {
        if (prices == null || prices.length < 2 || k < 1) {
            return 0;
        }
        k = Math.min(k, prices.length / 2);
        int[] local = new int[k + 1];
        int[] global = new int[k + 1];
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            int[] tmp = new int[k + 1];
            for (int j = 1; j <= k; j++) {
                local[j] = Math.max(global[j - 1], local[j]) + diff;
                tmp[j] = Math.max(global[j], local[j]);
            }
            global = tmp;
        }
        return global[k];
    }

    public static void main(String[] args) {
        int[] prices = new int[] {2, 4, 1};
        System.out.println(maxProfitA(2, prices));
        System.out.println(maxProfitB(2, prices));
    }

}
