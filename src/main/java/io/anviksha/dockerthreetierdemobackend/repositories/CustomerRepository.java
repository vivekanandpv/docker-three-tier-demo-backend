package io.anviksha.dockerthreetierdemobackend.repositories;

import io.anviksha.dockerthreetierdemobackend.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
