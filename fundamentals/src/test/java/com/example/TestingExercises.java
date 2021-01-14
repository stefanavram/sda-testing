package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class TestingExercises {

    @Test
    public void assert_equals() {
        assertEquals(15, 3 * 5);
    }

    @Test
    public void assertJ_test_equals() {
        assertThat(3 * 4).isEqualTo(15);
    }

    @Test
    public void assert_true_or_false() {
        assertTrue(3 == 3);
        assertFalse("Hello".equals("Gigi"));
    }

    @Test
    public void assertJ_test_true_or_false() {
        assertThat("Hello".equals("Gigi")).isFalse();
    }

    @Test
    public void assert_null() {
        String s = null;
        assertNull(s);

        String notEmptyString = "Hello";
        assertNotNull(notEmptyString);
    }

    @Test
    public void assertJ_test_null() {
        assertThat("Hello").isNotNull().isNotBlank().isNotEmpty();
        assertThat("Hello")
                .startsWith("H")
                .endsWith("o")
                .contains("l")
                .doesNotContainAnyWhitespaces();

    }


    @Test
    public void assert_same() {
        String s = new String("Hi");
        assertSame("Hi", s);
    }

    @Test
    public void assert_fail() {
        fail();
    }

    @Test
    public void test_arrays_equals() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        assertArrayEquals(array1, array2);
    }

    @Test
    public void assertJ_test_arrays_equals() {
        int[] array1 = {1, 2, 3};
        assertThat(array1).hasSize(3).containsAnyOf(2, 3).isNotExactlyInstanceOf(ArrayList.class);
    }
}
