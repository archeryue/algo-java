package com.archer.leetcode;

import java.util.PriorityQueue;

/**
 * archeryue
 * 9/19/16
 */
public class LeetCode378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> queue = new PriorityQueue<>();
        for (int i = 0; i < matrix[0].length; i++) {
            queue.offer(new Tuple(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple tmp = queue.poll();
            if (tmp.getX() < matrix.length - 1) {
                queue.offer(new Tuple(tmp.getX() + 1, tmp.getY(), matrix[tmp.getX() + 1][tmp.getY()]));
            }
        }
        return queue.poll().getVal();
    }

    class Tuple implements Comparable<Tuple> {
        private int x;
        private int y;
        private int val;

        public Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple other) {
            return Integer.compare(getVal(), other.getVal());
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getVal() {
            return val;
        }
    }
}
