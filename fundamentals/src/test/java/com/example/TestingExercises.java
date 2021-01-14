package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestingExercises {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Run before the first test method");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Run before each test");
    }

    @Test
    public void test_example() {
        assert 1 == 1;
    }

    @AfterEach
    void tearDown() {
        System.out.println("Run after each test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Run after the last test method");
    }

    @Test
    public void assert_true_or_false() {
        assertTrue(3 == 3);
        assertFalse("Hello".equals("Gigi"));
    }

    @Test
    public void assert_null() {
        String s = null;
        assertNull(s);

        String notEmptyString = "Hello";
        assertNotNull(notEmptyString);
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
}
