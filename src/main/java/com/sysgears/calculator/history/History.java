package com.sysgears.calculator.history;

import java.util.*;

/**
 * Save and load history
 */
public class History {

    /**
     * Define place where save and load History
     *
     */
    private final AbstractStorage abstractStorage;

    /**
     * Set Data Storage
     *
     * @param abstractStorage storage where we take all data
     */
    public History(AbstractStorage abstractStorage) {
        this.abstractStorage = abstractStorage;
    }

    /**
     * Get List of all data in storage
     *
     * @return List<String> return list of not unique String </String>
     */
    public List<String> getFull() {
        return abstractStorage.get();
    }

    /**
     * Get List of unique String in data Storage
     *
     * @return List of unique entry in data storage
     */
    public List<String> getUnique() {
        Set<String> set = new HashSet<String>(abstractStorage.get());
        return new ArrayList<String>(set);
    }

    /**
     * Put string to storage
     *
     * @param input string to save
     * @return true if result is successful
     */
    public boolean save(String input) {
        return abstractStorage.put(input);
    }

}
