package com.example;

public class Calculator {

    public double add(double x, double y) {
        return x + y;
    }

    public double sub(double x, double y) {
        return x - y;
    }
    public int divide(int x, int y) {
        return x / y;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divide by 0");
        }
        return a / b;
    }

    public double reverseSign(double a) {
        return -1 * a;
    }
}
