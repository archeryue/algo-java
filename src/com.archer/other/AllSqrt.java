/**
 * @(#)AllSqrt.java, May 17, 2020.
 * <p>
 * Copyright 2020 archer.com. All rights reserved.
 * ARCHER.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.archer.other;

/**
 * Archer Yue
 * 2020/5/17
 */
public class AllSqrt {

    private final static double e = 0.00001;

    public static double bsearch(double value) {
        double left = 0;
        double right = value > 1 ? value : 1;
        return innerSearch(value, left, right);
    }

    private static double innerSearch(double value, double left, double right) {
        double mid = (left + right) / 2;
        if ((mid * mid - value) * (mid * mid - value) < e * e) return mid;
        if (mid * mid >= value) {
            return innerSearch(value, left, mid);
        } else {
            return innerSearch(value, mid, right);
        }
    }

    public static double newton(double value) {
        double x = value;
        int i = 0;
        while ((x * x - value) * (x * x - value) > e * e && i < 1000) {
            x = (x + value / x) / 2;
            i++;
        }
        return x;
    }

    public static double gradient(double value) {
        double x = value;
        double step = 0.001;
        int i = 0;
        while ((x * x - value) * (x * x - value) > e * e && i < 1000) {
            x = x - step * (4 * x * (x * x - value));
            i++;
        }
        return x;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(bsearch(7));
        long stop = System.currentTimeMillis();
        System.out.println("Use : " + (stop - start));
        start = stop;
        System.out.println(gradient(7));
        stop = System.currentTimeMillis();
        System.out.println("Use : " + (stop - start));
        start = stop;
        System.out.println(newton(7));
        stop = System.currentTimeMillis();
        System.out.println("Use : " + (stop - start));
    }

}