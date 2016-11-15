package leetcode;

/**
 * archeryue
 * 11/15/16
 */
public class LeetCode413 {

    public int numberOfArithmeticSlices(int[] A) {
        int[] b = new int[A.length];
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                b[i] = b[i - 1] + 1;
                sum += b[i];
            }
        }
        return sum;
    }

}
