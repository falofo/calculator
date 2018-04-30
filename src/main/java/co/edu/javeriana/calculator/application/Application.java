package co.edu.javeriana.calculator.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan({"co.edu.javeriana.calculator.controller"})
public class Application {

    public static void main(String[] args) {
        System.setProperty("server.servlet.context-path", "/api/v1/calculator");
        SpringApplication.run(Application.class, args);
    }
}
