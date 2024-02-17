package org.mts.lab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@EnableScheduling
@SpringBootApplication
@ComponentScan("org.mts")
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
