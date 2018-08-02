package history;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс для работы с базой истории
 * <p/>
 */
public class DataInterface {

    /**
     * Хранилище данных
     */
    DataStory dataStory;

    /**
     * Базовый конструктор
     * @param dataStory
     */
    public DataInterface(DataStory dataStory) {
        this.dataStory = dataStory;
    }

    /**
     * Возвращает полный список операций
     * @return
     */
    public List<String[]> getListFull() {
        return dataStory.getList();
    }

    /**
     * Возвращает список уникальных операций
     * @return
     */
    public Map<String,String> getListUniq() {
        Map<String,String> map = new HashMap<String, String>();
        for (String[] s : getListFull()             ) {
            map.put(s[0],s[1]);

        }
        return map;
    }

    /**
     * Сохраняем данные в базу
     * @param sA
     * @param sB
     * @return
     */
    public boolean saveToHistory(String sA, String sB) {
        if (dataStory.add(sA,sB))         return true;
        return false;
    }

}
