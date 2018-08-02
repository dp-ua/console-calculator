package history;

import java.util.ArrayList;
import java.util.List;

public class DataStory {
    private List<String[]> list = new ArrayList<String[]>();

    /**
     * Добавляем строку список.
     * Список только с накоплением
     * @param sString
     * @param sResult
     * @return результат операции: удача\неудача
     */
    public boolean add(String sString, String sResult) {
        String[] s = new String[]{sString,sResult};
        list.add(s);
        return true;
    }

    /**
     * Возвращает список
     * @return
     */
    public List<String[]> getList() {
        return list;
    }
}
