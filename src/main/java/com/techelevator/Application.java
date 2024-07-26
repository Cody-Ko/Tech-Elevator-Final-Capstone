package com.techelevator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class Application {

//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//    }

//    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(Application.class);
//        app.run(args);
//    }
//}
public static void main(String[] args) {
    SpringApplication app = new SpringApplication(Application.class);
    app.setDefaultProperties(Collections.singletonMap("server.port", getPort()));
    app.run(args);
}

    private static String getPort() {
        String port = System.getenv("PORT");
        return port != null ? port : "https://stellar-discussions-142a61c436e5.herokuapp.com";
    }

}
