package com.sysgears.calculator.history;

import java.util.ArrayList;
import java.util.List;

/**
 * Realisations of AbstractStorage interface. Save and load data only to memory
 */
public class StorageInMemory implements AbstractStorage {
    /**
     * List of All data
     */
    private final List<String> list = new ArrayList<String>();

    /**
     * Put string to list
     *
     * @param input string to save
     * @return true if operations is successful
     */
    public boolean put(String input) {
        return list.add(input);
    }

    /**
     * get all data in List
     * @return all not unique data in List
     */
    public List<String> get() {
        return list;
    }
}
