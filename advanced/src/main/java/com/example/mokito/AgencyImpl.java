package com.example.mokito;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AgencyImpl implements Agency {

    private ArrayList<Car> carArrayList = new ArrayList<>();

    @Override
    public List<Car> findCars(int amountSeats, String type) {
        return carArrayList
                .stream()
                .filter(car -> car.getAmountSeats() == amountSeats && car.getType().equals(type))
                .collect(Collectors.toList());
    }
}
