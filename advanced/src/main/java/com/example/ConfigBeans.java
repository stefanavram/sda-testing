package com.example;

import com.example.mokito.Agency;
import com.example.mokito.AgencyImpl;
import com.example.mokito.CarRental;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeans {

    @Bean
    public Agency agency() {
        return new AgencyImpl();
    }

    @Bean
    public CarRental carRental(Agency agency) {
        return new CarRental(agency);
    }

}
