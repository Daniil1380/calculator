package ru.daniil1380.calculator;

import org.junit.jupiter.api.Test;

import javax.script.ScriptException;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();


    @Test
    void getTestData_checkSimplePlus() throws ScriptException {
        Double actual = calculatorService.calculate("24+34");
        double expected = 58.0;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void getTestData_checkPI() throws ScriptException {
        Double actual = calculatorService.calculate("Pi");
        double expected = 3.14;
        assertEquals(expected, actual, 0.01);
    }

    @Test
    void getTestData_checkHardOperations() throws ScriptException {
        Double actual = calculatorService.calculate("2+4*2-6-(8*(5-9))");
        double expected = 36.0;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void getTestData_checkZero() throws ScriptException {
        Double actual = calculatorService.calculate("0");
        double expected = 0.0;
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void getTestData_checkNotCorrectString()  {
        try {
            calculatorService.calculate("CICD");
            fail();
        }
        catch (ScriptException scriptException) {
            assertTrue(true);
        }
    }

    @Test
    void getTestData_checkZeroDivision() throws ScriptException {
        Double actual = calculatorService.calculate("1/0");
        double expected = Double.POSITIVE_INFINITY;
        assertEquals(expected, actual, 0.001);
    }
}