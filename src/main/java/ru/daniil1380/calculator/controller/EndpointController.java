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

    @GetMapping(value = "/calculator/")
    public ResponseEntity<Double> getTestData(@RequestParam(name = "exp") String expression) throws ScriptException {
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        return ResponseEntity.ok((Double) engine.eval(expression));
    }

}
