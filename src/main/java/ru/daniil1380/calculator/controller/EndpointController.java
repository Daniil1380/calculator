package ru.daniil1380.calculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndpointController {

    @GetMapping(value = "/calculator/")
    public ResponseEntity<Long> getTestData(@RequestParam(name = "exp") String expression) {
        return ResponseEntity.ok(0L);
    }

}
