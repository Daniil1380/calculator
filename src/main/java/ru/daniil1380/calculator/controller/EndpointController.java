package ru.daniil1380.calculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@RestController
public class EndpointController {

    @GetMapping(value = "api/calculator")
    public ResponseEntity<Double> getTestData(@RequestParam(name = "exp") String expression) throws ScriptException {
        expression = addSpecificSymbols(expression);
        expression = expression + ";";
        expression = expression.replace(" ", "+");
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        if (engine.eval(expression) instanceof Double) {
            return ResponseEntity.ok((Double) engine.eval(expression));
        }
        if (engine.eval(expression) instanceof Integer) {
            return ResponseEntity.ok(((Integer) engine.eval(expression)).doubleValue());
        }
        return ResponseEntity.ok(0.0);
    }

    private String addSpecificSymbols(String expression){
        expression = expression.replace("e", "Math.E");
        expression = expression.replace("pi", "Math.PI");
        expression = expression.replace("Pi", "Math.PI");
        expression = expression.replace("pI", "Math.PI");
        return expression;
    }

}
