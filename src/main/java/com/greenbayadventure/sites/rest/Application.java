package com.greenbayadventure.sites.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Program entry point.
 */
@SpringBootApplication
public class Application {

    /**
     * Program entry point.
     * @param args - Arguments to program.
     */
    public static void main(final String[] args) {
        SpringApplication.run(
                com.greenbayadventure.sites.rest.Application.class,
                args
        );
    }

}
