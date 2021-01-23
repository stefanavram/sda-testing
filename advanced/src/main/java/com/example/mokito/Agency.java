package com.example.mokito;

import java.util.List;

public interface Agency {
    List<Car> findCars(int amountSeats, String type);
}
