package calculator.history;

import java.util.List;

/**
 * Global interace for work with Data Storage
 */
public interface DataStorage {
    /**
     * Put new data to storage
     * @param inA first string
     * @param inB second string
     * @return true if the result is successful
     */
    boolean put(String inA, String inB);

    /**
     * Get all data in Storage
     * @return list of saved data
     */
    List<String[]> get();
}
