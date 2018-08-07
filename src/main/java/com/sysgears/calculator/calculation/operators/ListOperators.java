package com.sysgears.calculator.calculation.operators;

import java.util.HashMap;
import java.util.Map;

/**
 * Get list of operators by need priority
 */
public class ListOperators {

    /**
     * Needed priority
     */
    private final byte priority;

    /**
     * Set priority
     *
     * @param priority of operators
     */
    public ListOperators(byte priority) {
        this.priority = priority;
    }

    /**
     * Get Map of operators with the specified priority
     *
     * @return Map<String,String>key - operator. value - description </String>
     */
    public Map<String, String> getOperators() {
        Map<String, String> map = new HashMap<String, String>();
        for (TypeOperator t : TypeOperator.values())
            if (t.getPriority() == priority) for (String s : t.getOperator()) map.put(s, t.getDescription());
        return map;
    }

}
