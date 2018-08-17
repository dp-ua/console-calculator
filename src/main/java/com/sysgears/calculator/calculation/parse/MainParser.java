package com.sysgears.calculator.calculation.parse;

import com.sysgears.calculator.calculation.operators.TypeOperator;
import com.sysgears.calculator.calculation.parse.FlatLineToDouble;
import com.sysgears.calculator.calculation.parse.StringToFlatLinesList;
import com.sysgears.calculator.calculation.parse.exception.MyException;

import java.util.List;

/**
 * Main calculation. MainParser input string and back answer in double
 * <p>
 * Accepts the input string. Disassembles it into components: numbers, operators and parentheses.
 * After parsing the priority of the parentheses and operators, it performs the necessary calculations
 */
public class MainParser {

    /**
     * Take main string, parse it to List of "flat" strings and return showResult of operations
     * <p>
     * "flat" strings - lines without brackets and all operations are linear
     *
     * @return double showResult of operation
     */
    public double calculate(String input) throws MyException {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList();
        List<String> list = stringToFlatLinesList.parse(input);

        StringBuilder finalFlatString = new StringBuilder();
        FlatLineToDouble flatLineToDouble = new FlatLineToDouble();
        for (String s : list) {
            if ("".equals(s.trim())) continue;
            if (s.contains(TypeOperator.DELIMETER.getOperator().get(0))) {
                finalFlatString.append(" ").append(flatLineToDouble.calculate(s));
            } else finalFlatString.append(" ").append(s.trim());
        }

        return flatLineToDouble.calculate(finalFlatString.toString().trim());

    }
}
