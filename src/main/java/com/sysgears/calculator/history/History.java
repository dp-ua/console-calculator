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
    public List<String> getListFull() {
        return abstractStorage.getAll();
    }

    /**
     * Get List of unique String of history
     *
     * @return list of unique entry in history
     */
    public List<String> getListUnique() {
        Set<String> set = new HashSet<>(abstractStorage.getAll());
        return new ArrayList<>(set);
    }

    /**
     * Put string to history
     *
     * @param input string to save
     * @return true if showResult is successful
     */
    public boolean save(String input) {
        return abstractStorage.put(input);
    }

}
