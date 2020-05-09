package com.archer.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * archeryue
 * 11/15/16
 */
public class LeetCode149 {

    private class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    public class Solution {

        private class Slope {
            int x;
            int y;
            int count;

            public Slope(int x, int y) {
                this.x = x;
                this.y = y;
                count = 2;
            }
        }

        public int maxPoints(Point[] points) {
            if (points.length == 1) return 1;
            List<Slope>[] a = new List[points.length];
            for (int i = 0; i < points.length; i++) {
                a[i] = new ArrayList<>();
            }
            int max = 0;
            for (int i = 1; i < points.length; i++) {
                for (int j = 0; j < i; j++) {
                    int x1 = points[i].x - points[j].x;
                    int y1 = points[i].y - points[j].y;
                    boolean f1 = false; // 已属于某条线
                    int sameCount = 0; // 点j中重复点的个数
                    for (Slope slope : a[j]) {
                        if (x1 == 0 && y1 == 0) {
                            slope.count++;
                            max = Math.max(slope.count, max);
                            if (slope.x == 0 && slope.y == 0) f1 = true;
                        } else if (slope.x == 0 && slope.y == 0) {
                            sameCount = slope.count - 1;
                        } else if (slope.x * y1 == slope.y * x1) {
                            slope.count++;
                            max = Math.max(slope.count, max);
                            f1 = true;
                        }
                    }
                    if (sameCount > 0) {
                        Slope tmp = new Slope(x1, y1);
                        tmp.count += sameCount;
                        max = Math.max(tmp.count, max);
                        a[j].add(tmp);
                    } else if (!f1) {
                        a[j].add(new Slope(x1, y1));
                        max = Math.max(2, max);
                    }
                }
            }
            return max;
        }
    }
}
