import java.util.HashMap;
import java.util.Map;

public class RandomizedSet {

    private Map<Integer, Integer> v2p;
    private Map<Integer, Integer> p2v;
    private java.util.Random random;
    private int position;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        v2p = new HashMap<>();
        p2v = new HashMap<>();
        random = new java.util.Random();
        position = 0;
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (v2p.containsKey(val)) {
            return false;
        }

        v2p.put(val, position);
        p2v.put(position, val);
        position++;
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!v2p.containsKey(val)) {
            return false;
        }

        int p = v2p.get(val);
        v2p.remove(val);
        p2v.remove(p);

        if (p != position - 1) {
            int v = p2v.get(position - 1);
            v2p.put(v, p);
            p2v.put(p, v);
        }
        position--;
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int p = random.nextInt(position);
        return p2v.get(p);
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(1);
        set.remove(2);
        set.insert(2);
        set.getRandom();
        set.insert(1);
        set.remove(1);
        System.out.println(set.getRandom());
    }

}

