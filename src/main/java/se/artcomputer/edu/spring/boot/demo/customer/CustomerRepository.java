package se.artcomputer.edu.spring.boot.demo.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import se.artcomputer.edu.spring.boot.demo.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
