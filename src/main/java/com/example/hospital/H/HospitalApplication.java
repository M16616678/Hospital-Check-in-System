package com.example.hospital.H;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication   // one annotation does it all now
public class HospitalApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(HospitalApplication.class, args);

        String[] controllers = ctx.getBeanNamesForAnnotation(RestController.class);
        System.out.println(">>> REST controllers found: " + java.util.Arrays.toString(controllers));
    }
}