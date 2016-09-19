/**
 * archeryue
 * 9/19/16
 */
public class LeetCode34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        int l = findLess(nums, 0, nums.length - 1, target);
        int r = findGreater(nums, 0, nums.length - 1, target);

        if (l > r - 2) return new int[]{-1, -1};

        return new int[] {l + 1, r - 1};
    }

    private int findLess(int[] nums, int l, int r, int t) {
        if (l >= r)
            if (nums[l] >= t) return l - 1;
            else return l;

        int m = (l + r) / 2;
        if (nums[m] < t) return findLess(nums, m+1, r, t);
        else return findLess(nums, l, m-1, t);
    }

    private int findGreater(int[] nums, int l, int r, int t) {
        if (l >= r)
            if (nums[l] <= t) return l + 1;
            else return l;

        int m = (l + r) / 2;
        if (nums[m] > t) return findGreater(nums, l, m-1, t);
        else return findGreater(nums, m+1, r, t);
    }

}
