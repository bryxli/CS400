import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * Represents a HashTableMap that uses a KeyType object to store a ValueType object.
 */
public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {

    /**
     * The list of KeyTypes and ValueTypes stored.
     */
    private LinkedList<Object>[] items;

    /**
     * The amount of ValueTypes stored in the HashTableMap.
     */
    private int size;

    /**
     * Creates a HashTableMap with a capacity of 10 ValueType objects.
     */
    public HashTableMap() {
        items = new LinkedList[20];
        for (int i = 0; i < items.length; i++) {
            items[i] = new LinkedList<>();
        }
        size = 0;
    }

    /**
     * Creates a HashTableMap with a given capacity.
     *
     * @param capacity The capacity of the HashTableMap.
     */
    public HashTableMap(int capacity) {
        items = new LinkedList[2 * capacity];
        for (int i = 0; i < items.length; i++) {
            items[i] = new LinkedList<>();
        }
        size = 0;
    }

    /**
     * Adds a ValueType object into the HashTableMap.
     *
     * @param key   The given key that denotes the ValueType object.
     * @param value The object to be stored.
     * @return False if key already exists, true otherwise.
     */
    public boolean put(KeyType key, ValueType value) {
        int hashCode = hashKey(key);
        if (containsKey(key))
            return false;
        items[hashCode * 2].add(key);
        items[hashCode * 2 + 1].add(value);
        size++;
        if (checkSize()) {
            grow();
        }
        return true;
    }

    /**
     * Obtains a ValueType object from the HashTableMap.
     *
     * @param key The key used to search for the ValueType object.
     * @return The ValueType object denoted by the key.
     * @throws NoSuchElementException Throws NoSuchElementException when key does not exist within the HashTableMap.
     */
    public ValueType get(KeyType key) throws NoSuchElementException {
        int hashCode = hashKey(key);
        int index = items[hashCode * 2].indexOf(key);
        if (index == -1)
            throw new NoSuchElementException();
        return (ValueType) items[hashCode * 2 + 1].get(index);
    }

    /**
     * Obtains the current amount of ValueType objects in the HashTableMap.
     *
     * @return The amount of ValueType objects in the HashTableMap.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the HashTableMap has a specific key.
     *
     * @param key The key to search for.
     * @return True if the key exists in the HashTableMap, false otherwise.
     */
    public boolean containsKey(KeyType key) {
        int hashCode = hashKey(key);
        return items[hashCode * 2].contains(key);
    }

    /**
     * Removes a ValueType object from the HashTableMap.
     *
     * @param key The key used to search for the ValueType object.
     * @return The ValueType object removed from the list. Returns null if the object does not exist.
     */
    public ValueType remove(KeyType key) {
        int hashCode = hashKey(key);
        int index = items[hashCode * 2].indexOf(key);
        if (index == -1)
            return null;
        items[hashCode * 2].remove(key);
        ValueType object = (ValueType) items[hashCode * 2 + 1].get(index);
        items[hashCode * 2 + 1].remove(index);
        return object;
    }

    /**
     * Clears the HashTableMap of all KeyType objects and ValueType objects.
     */
    public void clear() {
        items = new LinkedList[items.length];
        size = 0;
    }

    /**
     * Applies the hash function to the key.
     *
     * @param key The key to hash.
     * @return The hashed key.
     */
    private int hashKey(KeyType key) {
        return Math.abs(key.hashCode()) % (items.length / 2);
    }

    /**
     * Checks to see if the HashTableMap has reached its load factor.
     *
     * @return True if the load factor is >=80, false otherwise.
     */
    private boolean checkSize() {
        return 100 * size / (items.length / 2) >= 80;
    }

    /**
     * Doubles the capacity of the HashTableMap and rehashes all objects.
     */
    private void grow() {
        LinkedList<Object>[] temp = new LinkedList[items.length * 2];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new LinkedList<>();
        }
        for (int i = 0; i < items.length; i += 2) {
            int listSize = items[i].size();
            for (int j = 0; j < listSize; j++) {
                int hashCode = Math.abs(items[i].get(j).hashCode()) % items.length;
                temp[hashCode * 2].add(items[i].get(j));
                temp[hashCode * 2 + 1].add(items[i + 1].get(j));
            }
        }
        items = temp;
    }

    /**
     * Gets the current capacity of the HashTableMap array.
     *
     * @return The array length.
     */
    public int getCapacity() {
        return items.length;
    }
}
