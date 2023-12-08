import java.util.NoSuchElementException;

/**
 * Interface class that represents a Map that takes in a KeyType that denotes a ValueType.
 */
public interface MapADT<KeyType, ValueType> {

    /**
     * Adds a ValueType into the Map.
     *
     * @param key   The given key that denotes the ValueType object.
     * @param value The object to be stored.
     * @return False if key already exists, true otherwise.
     */
    public boolean put(KeyType key, ValueType value);


    /**
     * Obtains a ValueType object from the Map.
     *
     * @param key The key used to search for the ValueType object.
     * @return The ValueType object denoted by the key.
     * @throws NoSuchElementException Throws NoSuchElementException when key does not exist within the Map.
     */
    public ValueType get(KeyType key) throws NoSuchElementException;

    /**
     * Obtains the current amount of ValueType objects in the Map.
     *
     * @return The amount of ValueType objects in the Map.
     */
    public int size();

    /**
     * Checks if the Map has a specific key.
     *
     * @param key The key to search for.
     * @return True if the key exists in the Map, false otherwise.
     */
    public boolean containsKey(KeyType key);


    /**
     * Removes a ValueType object from the Map.
     *
     * @param key The key used to search for the ValueType object.
     * @return The ValueType object removed from the list. Returns null if the object does not exist.
     */
    public ValueType remove(KeyType key);


    /**
     * Clears the Map of all KeyType objects and ValueType objects.
     */
    public void clear();
}