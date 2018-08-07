package com.sysgears.calculator.calculations;

import com.sysgears.calculator.calculations.operators.TypeOperator;
import com.sysgears.calculator.calculations.parse.FlatLineToDouble;
import com.sysgears.calculator.calculations.parse.StringToFlatLinesList;

import java.util.List;

public class Calculate {
    String input;

    public Calculate(String input) {
        this.input = input;
    }

    public double calculate() {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList(input);
        List<String> list = stringToFlatLinesList.parse();

        StringBuilder finalFlatString = new StringBuilder();
        for (String s : list) {
            if ("".equals(s.trim())) continue;
            if (s.contains(TypeOperator.DELIMETER.getOperator().get(0))) {
                finalFlatString.append(" ").append(new FlatLineToDouble(s).calculate() +"");
            } else finalFlatString.append( " ").append(s.trim());
        }
        Double result = new FlatLineToDouble(finalFlatString.toString().trim()).calculate();

        return result;

    }
}
