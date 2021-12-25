package ru.daniil1380.calculator.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import javax.script.ScriptException;

import static org.junit.jupiter.api.Assertions.*;

class EndpointControllerTest {

    private final EndpointController endpointController = new EndpointController();

    @Test
    void getTestData_checkSimplePlus() throws ScriptException {
        ResponseEntity<Double> actual = endpointController.getTestData("24+34");
        double expected = 58.0;
        assertEquals(expected, actual.getBody(), 0.001);
    }

    @Test
    void getTestData_checkPI() throws ScriptException {
        ResponseEntity<Double> actual = endpointController.getTestData("Pi");
        double expected = 3.14;
        assertEquals(expected, actual.getBody(), 0.01);
    }

    @Test
    void getTestData_checkHardOperations() throws ScriptException {
        ResponseEntity<Double> actual = endpointController.getTestData("2+4*2-6-(8*(5-9))");
        double expected = 36.0;
        assertEquals(expected, actual.getBody(), 0.001);
    }

    @Test
    void getTestData_checkZero() throws ScriptException {
        ResponseEntity<Double> actual = endpointController.getTestData("0");
        double expected = 0.0;
        assertEquals(expected, actual.getBody(), 0.001);
    }

    @Test
    void getTestData_checkNotCorrectString()  {
        try {
            endpointController.getTestData("CICD");
            fail();
        }
        catch (ScriptException scriptException) {
            assertTrue(true);
        }
    }

    @Test
    void getTestData_checkZeroDivision() throws ScriptException {
        ResponseEntity<Double> actual = endpointController.getTestData("1/0");
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual.getBody(), 0.001);
    }
}