package com.example;

import org.junit.jupiter.api.*;

public class TestingBeforeAfter {
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

}
