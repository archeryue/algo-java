import java.util.HashMap;
import java.util.Map;

/**
 * archeryue
 * 9/19/16
 */
public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        UnionFinder uf = new UnionFinder(nums.length);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
                if (map.containsKey(nums[i] - 1)) {
                    uf.union(i, map.get(nums[i] - 1));
                }
                if (map.containsKey(nums[i] + 1)) {
                    uf.union(i, map.get(nums[i] + 1));
                }
            }
        }

        return uf.getMaxSize();

    }

    public class UnionFinder {
        private int[] parent;
        private int[] size;
        private int maxSize;

        public UnionFinder(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            maxSize = 1;
        }

        private int getMaxSize() {
            return maxSize;
        }

        private void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP != rootQ) {
                if (size[rootP] < size[rootQ]) {
                    parent[rootP] = rootQ;
                    size[rootQ] += size[rootP];
                    maxSize = Math.max(maxSize, size[rootQ]);
                } else {
                    parent[rootQ] = rootP;
                    size[rootP] += size[rootQ];
                    maxSize = Math.max(maxSize, size[rootP]);
                }
            }
        }

        private int find(int p) {
            while (parent[p] != p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }
    }
}
