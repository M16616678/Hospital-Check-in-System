package com.example.hospital.H;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.hospital.H.repository")
@ComponentScan(basePackages = "com.example.hospital.H")
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class HospitalApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(HospitalApplication.class, args);

        String[] controllers = ctx.getBeanNamesForAnnotation(RestController.class);
        System.out.println(">>> REST controllers found: " + java.util.Arrays.toString(controllers));
    }
}