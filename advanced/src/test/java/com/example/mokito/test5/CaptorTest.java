package com.example.mokito.test5;

import com.example.mokito.Agency;
import com.example.mokito.Car;
import com.example.mokito.CarRental;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CaptorTest {

    @Mock
    private Agency agency;

    @Spy
    private ArrayList<Agency> agencyMocks;

    @InjectMocks
    private CarRental carRental;

    @Captor
    ArgumentCaptor<Integer> argCaptorForSeats;

    @Captor
    ArgumentCaptor<String> argCaptorForType;

    @Test
    void findCheapestCarTest() {

        Car car = new Car("Mercedes");
        agencyMocks.add(agency);

        when(agency.findCars(anyInt(), anyString()))
                .thenReturn(Collections.singletonList(car));

        Car theCheapestCar = carRental.findCheapestCar(4, "berlina");

        verify(agency).findCars(argCaptorForSeats.capture(), argCaptorForType.capture());

        assertEquals(4, argCaptorForSeats.getValue());
        assertEquals("berlina", argCaptorForType.getValue());
    }
}
