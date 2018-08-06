package calculator.history;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Work with data storage
 */
public class History {

    /**
     * data storage
     */
    private final DataStorage dataStorage;

    /**
     * set Data Storage
     *
     * @param dataStorage
     */
    public History(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    /**
     * get List of all data in storage
     *
     * @return List<String> return list of not unique String[] </String>
     */
    public List<String[]> getListFull() {
        return dataStorage.get();
    }

    /**
     * get Map of uniqie String[] in data Storage
     *
     * @return Map of unique entry in data storage
     */
    public Map<String, String> getListUnique() {
        Map<String, String> map = new HashMap<String, String>();
        for (String[] s : getListFull()) {
            map.put(s[0], s[1]);
        }
        return map;
    }

    /**
     * put data to storage
     *
     * @param sA first string
     * @param sB second string
     * @return true if result is successful
     */
    public boolean save(String sA, String sB) {
        return dataStorage.put(sA, sB);
    }

}
