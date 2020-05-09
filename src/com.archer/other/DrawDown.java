package com.archer.other;

/**
 * archeryue
 * 11/19/16
 */
public class DrawDown {

    private static double maxDrawDown(double[] prices) {
        if (prices == null || prices.length < 2)
            return 0;

        double maxDrawDown = 0;
        double denominator = prices[0];
        double cal = 0;
        for (int i = 1; i < prices.length; i++) {
            double delta = prices[i - 1] - prices[i];
            cal += delta;
            if (delta > 0) {
                double drawDown = cal / denominator;
                maxDrawDown = Math.max(drawDown, maxDrawDown);
            } else if (cal < 0) {
                cal = 0;
                denominator = prices[i];
            }
        }
        return maxDrawDown;
    }

    public static void main(String[] args) {
        System.out.println(maxDrawDown(new double[0]));
        System.out.println(maxDrawDown(new double[] {1, 10}));
        System.out.println(maxDrawDown(new double[] {10, 1}));
        System.out.println(maxDrawDown(new double[] {1, 3, 5, 9, 10, 1, 9, 7, 8, 2}));
        System.out.println(maxDrawDown(new double[] {1, 3, 5, 9, 10, 15, 9, 7, 8, 2}));
        System.out.println(maxDrawDown(new double[] {100, 1, 5, 9, 10, 1, 9, 7, 8, 2}));
        System.out.println(maxDrawDown(new double[] {10, 3, 5, 9, 10, 3, 9, 1, 8, 2}));
        System.out.println(maxDrawDown(new double[] {10, 3, 8, 9, 5, 3, 2, 1, 10}));
        System.out.println(maxDrawDown(new double[] {10, 10, 10, 10, 10}));
        System.out.println(maxDrawDown(new double[] {10, 5, 9, 4, 10, 10}));
    }

}
