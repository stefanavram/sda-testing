package com.example;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        String delimiter = extractDelimiter(numbers);
        String numbersWithoutDelimiter = numbers.split("//")[2];
        return add(numbersWithoutDelimiter, delimiter);
    }

    private int add(String numbers, String delimiter) {
        String[] numbersArray = numbers.split(delimiter);
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        int sum = 0;
        if (numbers.isEmpty()) {
            return sum;
        }

        for (String number : numbersArray) {
            int i = Integer.parseInt(number);
            if (i < 0) {
                negativeNumbers.add(i);
            }
            sum += i;
        }
        if (negativeNumbers.size() > 0) {
            throw new RuntimeException("Negative numbers not allowed: " + negativeNumbers.toString());
        }
        return sum;
    }

    private String extractDelimiter(String numbers) {
        Pattern pattern = Pattern.compile("//(.)//");
        Matcher matcher = pattern.matcher(numbers);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return ",";
    }

}
