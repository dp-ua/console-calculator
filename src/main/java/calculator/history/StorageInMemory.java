package calculator.history;

import java.util.ArrayList;
import java.util.List;

/**
 * Realisations of DataStorage interface. Save and load data only to memory
 */
public class StorageInMemory implements DataStorage{
    /**
     * List of All data
     */
    private final List<String[]> list = new ArrayList<String[]>();

    /**
     * Put new data to list
     * @param inA first string
     * @param inB second string
     * @return true if operations is successful
     */
    public boolean put(String inA, String inB) {
        return list.add(new String[]{inA, inB});
    }

    /**
     * get all data in List
     * @return all not unique data in List
     */
    public List<String[]> get() {
        return list;
    }
}
