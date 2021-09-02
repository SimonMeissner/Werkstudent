package com.example.demo.bewerber;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class BewerberConfig {

    @Bean
    CommandLineRunner commandLineRunner(BewerberRepository repository) {
        return args -> {
            Bewerber mariam = new Bewerber(
                    "Mariam",
                    "mariam.jamal@gmail.com",
                    "015123456789",
                    "Manager",
                    "Vollzeit",
                    40000,
                    "Zweitgespraech"

            );

            Bewerber alex = new Bewerber(
                    "Alex",
                    "alex.heber@gmail.com",
                    "015122334455",
                    "Hausmeister",
                    "Teilzeit",
                    8000,
                    "Neu"
            );


            repository.saveAll(List.of(mariam,alex));

        };
    }
}
