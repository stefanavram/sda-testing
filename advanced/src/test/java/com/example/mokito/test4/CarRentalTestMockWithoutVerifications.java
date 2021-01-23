package com.example.mokito.test4;

import com.example.mokito.Agency;
import com.example.mokito.Car;
import com.example.mokito.CarRental;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.exceptions.misusing.PotentialStubbingProblem;
import org.mockito.junit.jupiter.MockitoExtension;
import org.opentest4j.AssertionFailedError;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarRentalTestMockWithoutVerifications {

    @Mock //  (lenient = true) lenient = more tolerant; fewer verifications
    private Agency agency;

    @Spy
    private ArrayList<Agency> agencyMocks;

    @InjectMocks
    private CarRental carRental;

    @Test
    void findCheapestCarTestFail() {

        assertThrows(PotentialStubbingProblem.class, () -> {
            Car car = new Car("Mercedes");
            agencyMocks.add(agency);

            when(agency.findCars(4, "berlina"))
                    .thenReturn(Collections.singletonList(car));

            Car theCheapestCar = carRental.findCheapestCar(1, "berlina"); // it fails here

            assertEquals(car, theCheapestCar);
        });
    }

    @Test
    void findCheapestCarTestFailWithMoreDetails() {

        assertThrows(AssertionFailedError.class, () -> {
            Car car = new Car("Mercedes");

            Agency mockedAgency = mock(Agency.class);

            agencyMocks.add(mockedAgency);

            lenient().when(agency.findCars(4, "berlina"))
                    .thenReturn(Collections.singletonList(car));

            Car theCheapestCar = carRental.findCheapestCar(1, "berlina");

            assertEquals(car, theCheapestCar); // it fails here
        });
    }
}