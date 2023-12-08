import java.util.NoSuchElementException;

/**
 * Test functions for HashTableMap.java.
 */
public class TestHashTable {

    /**
     * Tests to see if put(KeyType key, ValueType value) functions correctly.
     *
     * @return True when the HashTableMap behaves correctly, false otherwise.
     */
    public static boolean test1() {
        HashTableMap<Integer, String> test = new HashTableMap<>(5);
        test.put(1, "a");
        test.put(2, "b");
        test.put(3, "c");
        int initialCapacity = test.getCapacity();
        test.put(4, "d");
        return test.containsKey(1) && test.containsKey(2) && test.containsKey(3) && test.containsKey(4) && test.getCapacity() == 2 * initialCapacity;
    }

    /**
     * Tests to see if get(KeyType key) functions correctly.
     *
     * @return True when the HashTableMap behaves correctly, false otherwise.
     */
    public static boolean test2() {
        HashTableMap<Integer, String> test = new HashTableMap<>();
        test.put(1, "a");
        test.put(2, "b");
        test.put(3, "c");
        try {
            test.get(4);
        } catch (NoSuchElementException e) {
            return test.get(1).equals("a") && test.get(2).equals("b") && test.get(3).equals("c");
        }
        return false;
    }

    /**
     * Tests to see if containsKey(KeyType key) functions correctly.
     *
     * @return True when the HashTableMap behaves correctly, false otherwise.
     */
    public static boolean test3() {
        HashTableMap<Integer, String> test = new HashTableMap<>();
        test.put(1, "a");
        test.put(2, "b");
        test.put(3, "c");
        return test.containsKey(1) && test.containsKey(2) && test.containsKey(3) && !test.containsKey(4);
    }

    /**
     * Tests to see if remove(KeyType key) functions correctly.
     *
     * @return True when the HashTableMap behaves correctly, false otherwise.
     */
    public static boolean test4() {
        HashTableMap<Integer, String> test = new HashTableMap<>();
        test.put(1, "a");
        test.put(2, "b");
        test.put(3, "c");
        test.remove(1);
        try {
            test.get(1);
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;
    }

    /**
     * Tests to see that the HashTableMap clears all KeyType and ValueType objects.
     *
     * @return True when the HashTableMap behaves correctly, false otherwise.
     */
    public static boolean test5() {
        HashTableMap<Integer, String> test = new HashTableMap<>();
        test.put(1, "a");
        test.put(2, "b");
        test.put(3, "c");
        test.clear();
        return test.size() == 0;
    }
}
