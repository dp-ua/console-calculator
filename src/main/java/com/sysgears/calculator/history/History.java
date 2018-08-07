package com.sysgears.calculator.history;

import java.util.*;

/**
 * Save and load history
 */
public class History {

    /**
     * Define place where save and load History
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
     * @return list of not unique string in history
     */
    public List<String> getFull() {
        return abstractStorage.get();
    }

    /**
     * Get List of unique String of history
     *
     * @return list of unique entry in history
     */
    public List<String> getUnique() {
        Set<String> set = new HashSet<String>(abstractStorage.get());
        return new ArrayList<String>(set);
    }

    /**
     * Put string to history
     *
     * @param input string to save
     * @return true if result is successful
     */
    public boolean save(String input) {
        return abstractStorage.put(input);
    }

}
