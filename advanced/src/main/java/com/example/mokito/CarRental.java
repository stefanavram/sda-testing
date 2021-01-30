package com.example.mokito;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.Optional;

public class CarRental {

    @Autowired
    private final Agency agency;

    public CarRental(Agency agency) {
        this.agency = agency;
    }

    public Car findCheapestCar(int amountSeats, String type) {
        Optional<Car> cheapestCar =
                agency.findCars(amountSeats, type)
                        .stream()
                        .min(Comparator.comparing(Car::getCostPerDay));
        return cheapestCar.orElse(null);
    }
}
