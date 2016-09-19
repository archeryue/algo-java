import java.util.ArrayList;
import java.util.List;

/**
 * archeryue
 * 9/3/16
 */
public class LeetCode4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int min = Math.min(nums1.length > 0 ? nums1[0] : Integer.MAX_VALUE,
                nums2.length > 0 ? nums2[0] : Integer.MAX_VALUE);
        int max = Math.max(nums1.length > 0 ? nums1[nums1.length - 1] : Integer.MIN_VALUE,
                nums2.length > 0 ? nums2[nums2.length - 1] : Integer.MIN_VALUE);
        boolean f = (nums1.length + nums2.length) % 2 == 0;
        return binarySearch(nums1, nums2, min, max, f);
    }

    private static double binarySearch(int[] n1, int[] n2, int min, int max, boolean f) {
        if (min >= max) {
            return ((double)(min + max)) / 2;
        }

        int mid = (min + max) / 2;

        int i = findNum(n1, 0, n1.length - 1, mid);
        int j = findNum(n2, 0, n2.length - 1, mid);

        int count = i + j + 2;
        if (!f && count == ((n1.length + n2.length) / 2)) {
            int max1 = i + 1 < n1.length ? n1[i + 1] : Integer.MAX_VALUE;
            int max2 = j + 1 < n2.length ? n2[j + 1] : Integer.MAX_VALUE;
            return Math.min(max1, max2);
        } else if (!f && count == (n1.length + n2.length) / 2 + 1) {
            int min1 = i >= 0 ? n1[i] : Integer.MIN_VALUE;
            int min2 = j >= 0 ? n2[j] : Integer.MIN_VALUE;
            return Math.max(min1, min2);
        } else if (f && count == ((n1.length + n2.length) / 2)) {
            int min1 = i >= 0 ? n1[i] : Integer.MIN_VALUE;
            int min2 = j >= 0 ? n2[j] : Integer.MIN_VALUE;
            int max1 = i + 1 < n1.length ? n1[i + 1] : Integer.MAX_VALUE;
            int max2 = j + 1 < n2.length ? n2[j + 1] : Integer.MAX_VALUE;
            return ((double) (Math.max(min1, min2) + Math.min(max1, max2))) / 2;
        } else if (count < ((n1.length + n2.length) / 2)) {
            if (mid == min) {
                if (f) {
                    int k = (n1.length + n2.length) / 2 - count;
                    return (findK(n1, n2, i, j, k) + findK(n1, n2, i, j, k + 1)) / 2;
                } else {
                    int k = (n1.length + n2.length) / 2 + 1 - count;
                    return findK(n1, n2, i, j, k);
                }
            }
            return binarySearch(n1, n2, mid, max, f);
        } else {
            return binarySearch(n1, n2, min, mid, f);
        }
    }

    private static double findK(int[] n1, int[] n2, int i, int j, int k) {
        int tmp = 0;
        while (k > 0) {
            if (i >= n1.length - 1) {
                j++;
                tmp = n2[j];
            } else if (j >= n2.length - 1) {
                i++;
                tmp = n1[i];
            } else if (n1[i + 1] < n2[j + 1]) {
                i++;
                tmp = n1[i];
            } else {
                j++;
                tmp = n2[j];
            }
            k--;
        }
        return tmp;
    }

    private static int findNum(int[] arr, int l, int r, int num) {
        if (l > r) {
            return l - 1;
        }
        if (l == r && arr[l] == num) {
            return l;
        }

        int m = (l + r) / 2;
        if (arr[m] == num) {
            return m;
        } else if (arr[m] > num) {
            return findNum(arr, l, m - 1, num);
        } else {
            return findNum(arr, m + 1, r, num);
        }
    }

    public static void main(String[] args) {
        int[] n1 = new int[] {};
        int[] n2 = new int[] {1, 2, 2, 2, 100};
        List<Integer> list = new ArrayList<>();
        System.out.println(findMedianSortedArrays(n1, n2));
    }
}
