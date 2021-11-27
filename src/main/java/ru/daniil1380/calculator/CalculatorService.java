package ru.daniil1380.calculator;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Service
public class CalculatorService {

    private final String PI = "Math.PI";
    private final String E = "Math.E";

    public Double calculate(String expression) throws ScriptException {
        expression = addSpecificSymbols(expression);
        expression = expression + ";";
        expression = expression.replace(" ", "+");
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        if (engine.eval(expression) instanceof Double) {
            return (Double) engine.eval(expression);
        }
        if (engine.eval(expression) instanceof Integer) {
            return ((Integer) engine.eval(expression)).doubleValue();
        }
        return 0.0;
    }

    private String addSpecificSymbols(String expression){
        expression = expression.replace("e", E);
        expression = expression.replace("pi", PI);
        expression = expression.replace("Pi", PI);
        expression = expression.replace("pI", PI);
        return expression;
    }


}
