package logic.operators;

import java.util.HashMap;
import java.util.Map;

/**
 * Работает со списком типов доступных операций
 */
public class ListOperators {

    /**
     * Выдает список всех операций по указанному приоритету
     * @param priority
     * @return
     */
    public Map<String, String> getOperatorsByPriority(byte priority) {
        Map<String, String> map = new HashMap<String, String>();
        for (TypeOperator t : TypeOperator.values())
            if (t.getPriority() == priority) for (String s : t.getOperator()) map.put(s, t.getDescription());
        return map;
    }

}
