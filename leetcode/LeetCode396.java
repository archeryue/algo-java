package leetcode;

/**
 * archeryue
 * 10/1/16
 */
public class LeetCode396 {

    public static int maxRotateFunction(int[] A) {
        if (A.length == 0 || A.length == 1) return 0;

        int sum = 0;
        int tmp = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            tmp += i * A[i];
        }

        int max = tmp;
        for (int i = 1; i < A.length; i++) {
            tmp += sum - (A[A.length - i] * A.length);
            max = tmp > max ? tmp : max;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,4,5,6,7,8,9,10};
        System.out.println(maxRotateFunction(a));
    }

}
