package com.example.airlinesreservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AirlinesReservationApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AirlinesReservationApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AirlinesReservationApplication.class);
    }

}
