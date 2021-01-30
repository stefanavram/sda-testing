package com.example.mokito;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@TestConfiguration
public class ConfigBeansTest {

    @Bean
    @Primary
    public Agency testAgency() {
        return new TestAgency();
    }

}
