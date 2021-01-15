package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    public void whenEmptyStringReturnZero() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add("");
        assertThat(result).isEqualTo(0);
    }

//    @Test
//    public void whenMoreThan2NumbersError() {
//        StringCalculator stringCalculator = new StringCalculator();
//        assertThatThrownBy(
//                () -> {
//                    int result = stringCalculator.add("1,2,3");
//                }
//        );
//    }

    @Test
    public void when2NumbersAddedSuccess() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add("1,2");
        assertEquals(1 + 2, result);
    }

    @Test
    public void when1NumberAddedSuccess() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add("1");
        assertEquals(1, result);
    }

    @Test
    public void whenMultipleAddedNumbersAddedThenSumIsReturned() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add("1,2,3,4");
        assertEquals(1 + 2 + 3 +4, result);
    }

    @Test
    public void whenNewLinesSeparatorIsUsedThenTheSumIsReturned() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add("1\n2,3,4");
        assertEquals(1 + 2 + 3 +4, result);
    }

    @Test
    public void whenADifferentDelimiterIsUsedThenTheSumIsReturned() {
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add("//;//1;2;3;4");
        assertEquals(1 + 2 + 3 +4, result);
    }

    @Test
    public void whenNegativeNumberThenThrowExceptionWithList() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThatThrownBy(
                () -> {stringCalculator.add("//;//1;-2;3;-4");}
        ).isInstanceOf(RuntimeException.class).hasMessageContaining("[-2, -4]");
    }
}
