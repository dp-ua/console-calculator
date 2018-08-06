package calculator.logic.parse;

import calculator.logic.operators.TypeOperator;

import java.util.*;

/**
 * Class for work with list of "flat" lines
 *
 */
public class CalcFlatList {

    /**
     * List of "flat" lines
     */
    private final List<String> list;

    /**
     * set the list of "flat" lines
     * @param list
     */
    public CalcFlatList(List<String> list) {
        this.list = list;
    }

    /**
     * Calculates the value of each complex "flat" line in the list, forms the final "flat" line and computes its value
     * @return result of calculations
     * @throws IllegalArgumentException if takes error in calculations
     * @throws StringIndexOutOfBoundsException if takes error in parsing
     */
    public double calculate()  throws IllegalArgumentException,StringIndexOutOfBoundsException {

        StringBuilder sFlat = new StringBuilder();
        for (String s : list) {
            if ("".equals(s.trim())) continue;
            if (s.contains(TypeOperator.DELIMETER.getOperator().get(0))) {
                String sCalc = new CalcFlatLine(s).calculate();
                sFlat.append(" ").append(sCalc);
            } else sFlat.append( " ").append(s.trim());
        }
        String result = new CalcFlatLine(sFlat.toString().trim()).calculate();
        return Double.parseDouble(result);
    }





}
