package calculator.history;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс для работы с базой истории
 * <p/>
 */
public class Hystory {

    /**
     * Хранилище данных
     */
    private final DataStorage dataStorage;

    public Hystory(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    /**
     * Возвращает полный список операций
     * @return List<String[]> список всех записей в хранилище</String[]>
     */
    public List<String[]> getListFull() {
        return dataStorage.get();
    }

    /**
     * Возвращает список уникальных операций
     * @return Map<String,String> возращает список уникальных записей из базы</String,String>
     */
    public Map<String,String> getListUnique() {
        Map<String,String> map = new HashMap<String, String>();
        for (String[] s : getListFull()) {
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
    public boolean save(String sA, String sB) {
        return dataStorage.put(sA,sB);
    }

}
