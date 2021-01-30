package com.example.mokito;

import java.util.ArrayList;
import java.util.List;


// mock agency
public class TestAgency implements Agency {

   private List<Car> cars = new ArrayList<>();

    public TestAgency() {
        Car car = new Car("TEST_BMW");
        cars.add(car);
    }

    @Override
    public List<Car> findCars(int amountSeats, String type) {
        Car car = new Car("TEST_BMW");
        cars.add(car);
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
