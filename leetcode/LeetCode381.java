package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * archeryue
 * 9/26/16
 */
public class LeetCode381 {

    public static class RandomizedCollection {
        private Map<Integer, List<Integer>> valMap;
        private List<Integer> valList;
        private Random random;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            valMap = new HashMap<>();
            valList = new ArrayList<>();
            random = new Random();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean flag = false;
            valList.add(val);
            List<Integer> list = valMap.get(val);
            if (list == null) {
                list = new ArrayList<>();
                valMap.put(val, list);
                flag = true;
            }
            list.add(valList.size() - 1);
            return flag;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!valMap.containsKey(val)) {
                return false;
            }

            List<Integer> list = valMap.get(val);
            int index = list.get(list.size() - 1);
            if (list.size() == 1) {
                valMap.remove(val);
            } else {
                list.remove(list.size() - 1);
            }

            if (index != valList.size() - 1) {
                int tmp = valList.get(valList.size() - 1);
                List<Integer> tmpList = valMap.get(tmp);
                tmpList.set(tmpList.size() - 1, index);
                Collections.sort(tmpList);
                valList.set(index, tmp);
            }
            valList.remove(valList.size() - 1);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return valList.get(random.nextInt(valList.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedCollection set = new RandomizedCollection();
        System.out.println(set.insert(4));
        System.out.println(set.insert(3));
        System.out.println(set.insert(4));
        System.out.println(set.insert(2));
        System.out.println(set.insert(4));
        System.out.println(set.remove(4));
        System.out.println(set.remove(3));
        System.out.println(set.remove(4));
        System.out.println(set.remove(4));
        System.out.println(set.getRandom());
    }

}
