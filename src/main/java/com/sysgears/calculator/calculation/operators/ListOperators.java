package com.sysgears.calculator.calculation.operators;


import java.util.Map;
import java.util.TreeMap;

/**
 * Get list of operators by need priority
 */
public class ListOperators {

    /**
     * Get Map of operators with the specified priority
     *
     * @return Map<String,String>key - operator. value - description </String>
     */
    public Map<String, String> getOperators(byte priority) {
        Map<String, String> map = new TreeMap<>();
        for (TypeOperator t : TypeOperator.values())
            if (t.getPriority() == priority) for (String s : t.getOperator()) map.put(s, t.getDescription());
        return map;
    }

}
