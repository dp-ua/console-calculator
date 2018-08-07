package com.sysgears.calculator.calculations.operators;

import java.util.HashMap;
import java.util.Map;

/**
 * Class work with operators list. Used for generate Help
 */
public class ListOperators {
    /**
     * Priority
     */
    private final byte priority;

    /**
     * set priority
     * @param priority of operator
     */
    public ListOperators(byte priority) {
        this.priority = priority;
    }

    /**
     * returns a list of operators with the specified priority
     * @return Map<>operator + description</>
     */
    public Map<String, String> getOperators() {
        Map<String, String> map = new HashMap<String, String>();
        for (TypeOperator t : TypeOperator.values())
            if (t.getPriority() == priority) for (String s : t.getOperator()) map.put(s, t.getDescription());
        return map;
    }

}
