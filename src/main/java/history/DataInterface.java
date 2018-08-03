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
    private final DataStory dataStory;

    /**
     * Базовый конструктор
     * @param dataStory место хранения данных
     */
    public DataInterface(DataStory dataStory) {
        this.dataStory = dataStory;
    }

    /**
     * Возвращает полный список операций
     * @return List<String[]> список всех записей в хранилище</String[]>
     */
    public List<String[]> getListFull() {
        return dataStory.getList();
    }

    /**
     * Возвращает список уникальных операций
     * @return Map<String,String> возращает список уникальных записей из базы</String,String>
     */
    public Map<String,String> getListUnique() {
        Map<String,String> map = new HashMap<String, String>();
        for (String[] s : getListFull()             ) {
            map.put(s[0],s[1]);

        }
        return map;
    }

    /**
     * Сохраняем данные в базу
     * @param sA исходная строка
     * @param sB результат
     * @return успешная или не успешная запись в базу
     */
    public boolean saveToHistory(String sA, String sB) {
        return dataStory.add(sA,sB);
    }

}
