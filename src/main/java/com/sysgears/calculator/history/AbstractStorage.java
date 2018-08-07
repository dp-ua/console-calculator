package com.sysgears.calculator.history;

import java.util.List;

/**
 * Global interface for work with Data Storage
 */
public interface AbstractStorage {
    /**
     * Put new data to storage
     *
     * @param s string to save
     * @return true if the result is successful
     */
    boolean put(String s);

    /**
     * Get all data in Storage
     *
     * @return list of saved data
     */
    List<String> get();
}
