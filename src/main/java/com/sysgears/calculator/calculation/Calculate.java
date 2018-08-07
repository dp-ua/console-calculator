package com.sysgears.calculator.calculation;

import com.sysgears.calculator.calculation.operators.TypeOperator;
import com.sysgears.calculator.calculation.parse.FlatLineToDouble;
import com.sysgears.calculator.calculation.parse.StringToFlatLinesList;

import java.util.List;

/**
 * Main calculation. Calculate input string and back answer in double
 *
 * Use help classes in parse package
 */
public class Calculate {

    /**
     * Input string
     */
    private final String input;

    /**
     * Set the input string
     *
     * @param input string for calculation
     */
    public Calculate(String input) {
        this.input = input;
    }

    /**
     * Take main string, parse it to List of "flat" strings and return result of operations
     *
     * "flat" strings - lines without brackets and all operations are linear
     * @return double result of operation
     */
    public double calculate() {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList(input);
        List<String> list = stringToFlatLinesList.parse();

        StringBuilder finalFlatString = new StringBuilder();
        for (String s : list) {
            if ("".equals(s.trim())) continue;
            if (s.contains(TypeOperator.DELIMETER.getOperator().get(0))) {
                finalFlatString.append(" ").append(new FlatLineToDouble(s).calculate());
            } else finalFlatString.append( " ").append(s.trim());
        }

        return new FlatLineToDouble(finalFlatString.toString().trim()).calculate();

    }
}
