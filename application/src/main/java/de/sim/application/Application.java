package de.sim.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main SpringApplication to start the whole project
 */
@SpringBootApplication(scanBasePackages = { "de.sim.rest", "de.sim.service", "de.sim.persistence", "de.sim.application.config"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(new Class[] { Application.class }, args);
    }
}
