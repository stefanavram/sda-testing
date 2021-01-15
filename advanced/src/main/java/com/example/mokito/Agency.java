package com.example.mokito;

import java.util.List;

public interface Agency {
    List<Car> findCar(int amountSeats, String type);
}
