package leetcode;

/**
 * archeryue
 * 9/19/16
 */
public class LeetCode29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == divisor) {
            return 1;
        }

        int k = 0;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            dividend += 1;
            k = 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }

        boolean positive = true;
        if (dividend < 0) {
            dividend = 0 - dividend;
            positive = false;
        }
        if (divisor < 0) {
            divisor = 0 - divisor;
            positive = !(positive ^ false);
        }

        int res = 0;
        int f;
        int c;
        while (dividend + k - divisor>= 0) {
            f = divisor;
            c = 1;
            while (dividend + k - f - f >= 0) {
                f += f;
                c += c;
            }
            dividend -= f;
            res += c;
        }
        return positive ? res : 0 - res;
    }
}
