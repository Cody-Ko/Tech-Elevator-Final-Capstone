package com.techelevator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import java.util.Collections;

@SpringBootApplication
public class Application {

//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//    }
public static void main(String[] args) {
    SpringApplication app = new SpringApplication(Application.class);
    app.run(args);
}
}
