package ru.daniil1380.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.daniil1380.calculator.CalculatorService;

import javax.script.ScriptException;

@RestController
public class EndpointController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping(value = "api/calculator")
    public ResponseEntity<Double> getTestData(@RequestParam(name = "exp") String expression) throws ScriptException {
        return ResponseEntity.ok(calculatorService.calculate(expression));
    }

}
