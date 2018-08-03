package history;

import java.util.ArrayList;
import java.util.List;

public class DataStory {
    private final List<String[]> list = new ArrayList<String[]>();

    /**
     * Добавляем строку список.
     * Список только с накоплением
     * @param sString основная строка
     * @param sResult результат просчета
     * @return Boolean результат операции: удача\неудача
     */

    public boolean add(String sString, String sResult) {
        String[] s = new String[]{sString,sResult};
        int iSize = list.size();
        list.add(s);
        return (list.size()-iSize)==1;
    }

    /**
     * Возвращает список
     * @return List<String[]> список всех записей в хранилище</String[]>
     */
    public List<String[]> getList() {
        return list;
    }
}
