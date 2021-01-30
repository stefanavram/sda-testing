package com.example.mokito;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Import(ConfigBeansTest.class)
@SpringBootTest
class CarRentalTest {

    @Autowired
    private Agency agency;

    @Autowired
    private CarRental carRental;

    @Test
    void findCheapestCar() {


        Car theCheapestCar = carRental.findCheapestCar(4, "TEST_BMW");

        assertEquals(TestAgency.class, agency.getClass());
        TestAgency testAgency = (TestAgency) agency;
        assertEquals(testAgency.getCars().get(0), theCheapestCar);
    }
}