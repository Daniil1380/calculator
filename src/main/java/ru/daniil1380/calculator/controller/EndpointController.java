package ru.daniil1380.calculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;

@RestController
public class EndpointController {

    @GetMapping(value = "api/calculator/")
    public ResponseEntity<Double> getTestData(@RequestParam(name = "exp") String expression) throws ScriptException {
        expression = addSpecificSymbols(expression);
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        return ResponseEntity.ok((Double) engine.eval(expression));
    }

    private String addSpecificSymbols(String expression){
        expression = expression.replace("e", "E");
        expression = expression.replace("pi", "PI");
        expression = expression.replace("Pi", "PI");
        expression = expression.replace("pI", "PI");
        List<String> symbols = List.of("E", "PI");
        for (String symbol : symbols) {
            while (expression.contains(symbol)){
                int index = expression.indexOf(symbol);
                expression = expression.substring(0, index) + "Math." + expression.substring(index);
            }
        }
        return expression;
    }

}
