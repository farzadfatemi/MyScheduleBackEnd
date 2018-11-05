package com.fartech.myschedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MyscheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyscheduleApplication.class, args);
    }
}
