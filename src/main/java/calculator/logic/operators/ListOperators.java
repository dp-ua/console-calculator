package logic.operators;

import java.util.HashMap;
import java.util.Map;

/**
 * Работает со списком типов доступных операций
 * <p/>
 * Используется для формирования справки по программе
 */
public class ListOperators {

    /**
     * Выдает список всех операций по указанному приоритету
     * @param priority приоритет операторов
     * @return список операторов и их описание
     */
    public Map<String, String> getOperatorsByPriority(byte priority) {
        Map<String, String> map = new HashMap<String, String>();
        for (TypeOperator t : TypeOperator.values())
            if (t.getPriority() == priority) for (String s : t.getOperator()) map.put(s, t.getDescription());
        return map;
    }

}
