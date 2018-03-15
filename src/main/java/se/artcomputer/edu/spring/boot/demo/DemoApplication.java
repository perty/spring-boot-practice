package se.artcomputer.edu.spring.boot.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import se.artcomputer.edu.spring.boot.demo.customer.Customer;
import se.artcomputer.edu.spring.boot.demo.customer.CustomerRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    ApplicationRunner runner(CustomerRepository customerRepository) {
        return args ->
                Stream.of("John Doe",
                        "Minne Smith",
                        "Karl-Oskar Bremberg")
                        .forEach(x -> customerRepository.save(
                                new Customer(x)
                                )
                        );
    }
}
