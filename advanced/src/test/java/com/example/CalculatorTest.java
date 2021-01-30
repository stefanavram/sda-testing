package com.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.*;

import java.time.Month;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Incepe testul");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Testul s-a terminat");
    }


    @Test
    void testException() {
        try {
            shouldThrowException();
            fail();
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    private void shouldThrowException() {
        throw new NullPointerException("bla");
    }


    @RepeatedTest(3)
    public void shouldReturnAddRepeat() {
        //when
        double result = calculator.add(1, 2);
        //then
        assertEquals(3, result);
    }

    @ParameterizedTest
    @ValueSource(doubles = {1.0, 2.0, -5.0, -2.0, -1.0})
    public void parameterValueSource(double param) {
        double reversedSignNumber = calculator.reverseSign(param);
        assertEquals(-1 * param, reversedSignNumber);
    }

    @ParameterizedTest
    @MethodSource("getParameters")
    public void shouldReturnReverseSing2(double a) {
        assertEquals(-1 * a, calculator.reverseSign(a));
    }

    static Stream<Arguments> getParameters() {
        return Stream.of(Arguments.of(1.0),
                Arguments.of(-231.0),
                Arguments.of(26.0),
                Arguments.of(-98.0),
                Arguments.of(100.0));
    }

    @ParameterizedTest
    @ArgumentsSource(Parameters.class)
    public void shouldReturnReverseSing3(double a) {
        assertEquals(-1 * a, calculator.reverseSign(a));
    }

    static class Parameters implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(final ExtensionContext context) {
            return Stream.of(Arguments.of(23.0),
                    Arguments.of(-56.0),
                    Arguments.of(64.92),
                    Arguments.of(-0.32));
        }
    }

    @ParameterizedTest
    @CsvSource({"10.0, 10.0, 20.0",
            "13.4, 2.9, 16.3",
            "123.2, 5.3, 128.5"})
    public void shouldReturnAdditionOperation(double a, double b, double sum) {
        assertEquals(sum, calculator.add(a, b));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataSource.csv", numLinesToSkip = 1)
    public void shouldReturnSubtractionOperation(String a, String b, String sub) {
        assertEquals(sub, a + b);
    }

    @ParameterizedTest
    @ValueSource(strings = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
    void someMonths_Are30DaysLong(Month month) {
        final boolean isALeapYear = false;
        assertEquals(30, month.length(isALeapYear));
    }

    @ParameterizedTest
    @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"}, mode = EnumSource.Mode.EXCLUDE)
    void someMonthEnums_Are30DaysLong(Month month) {
        final boolean isALeapYear = false;
        assertEquals(30, month.length(isALeapYear));
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "D", "16"})
    public void shouldReturnIntToHex(@ConvertWith(HexToInt.class) int a) {
        assertEquals(-1 * a, calculator.reverseSign(a));
    }

    static class HexToInt extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object o, Class<?> targetType) {
            assertEquals(int.class, targetType, "Can only convert to int");
            return Integer.decode("0x" + o.toString());
        }
    }
}