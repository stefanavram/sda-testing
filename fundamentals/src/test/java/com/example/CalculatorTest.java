package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    public void test_multiply_two_numbers() {
        // given
        final double firstNumber = 2;
        final double secondNumber = 3;

        final double result = firstNumber * secondNumber;

        assertEquals(6, result);
    }

}