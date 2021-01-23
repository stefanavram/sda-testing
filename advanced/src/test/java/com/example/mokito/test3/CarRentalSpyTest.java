package com.example.mokito.test3;

import com.example.mokito.Agency;
import com.example.mokito.Car;
import com.example.mokito.CarRental;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarRentalSpyTest {

    @Mock
    private Agency agency;

    @Spy
    private ArrayList<Agency> agencyMocks;

    @InjectMocks
    private CarRental carRental;

    @Test
    void findCheapestCarTest() {

        Car car = new Car("Mercedes");
        agencyMocks.add(agency);

        when(agency.findCars(4, "berlina"))
                .thenReturn(Collections.singletonList(car));

//        when(agency.findCars(anyInt(), anyString()))
//                .thenReturn(Collections.singletonList(car));

        Car theCheapestCar = carRental.findCheapestCar(4, "berlina");
        verify(agency, atLeastOnce()).findCars(4, "berlina");

        assertEquals(car, theCheapestCar);
    }
}