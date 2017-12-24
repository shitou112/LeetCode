package ArrayBase;

import java.util.*;

/**
 * @author Qian Shaofeng
 * created on 2017/12/24.
 */
public class T380_InsertDeleteGetRandom {
    private HashMap<Integer, Integer> hashMap;
    private List<Integer> list;
    private Random random;

    /** Initialize your data structure here. */
    public T380_InsertDeleteGetRandom() {
        random = new Random();
        hashMap = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (hashMap.containsKey(val))
            return false;

        hashMap.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int loc;
        if ((loc = hashMap.getOrDefault(val, -1))!=-1) {
            list.set(loc, list.get(list.size()-1));
            list.remove(list.size()-1);
            hashMap.remove(val);

            return true;
        }

        return false;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        System.out.println();
        return list.get(random.nextInt(hashMap.size()));

    }
}
