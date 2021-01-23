package com.example.mokito;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CarRental {
    private final ArrayList<Agency> agencies;

    public CarRental(ArrayList<Agency> agencies) {
        this.agencies = agencies;
    }

    public Car findCheapestCar(int amountSeats, String type) {
        Optional<Car> cheapestCar =  agencies.stream()
                .map(a -> {
                    return a.findCars(amountSeats, type);
                })
                .flatMap(List::stream)
                .min(Comparator.comparing(Car::getCostPerDay));

        return cheapestCar.orElse(null);
    }
}
