package io.anviksha.dockerthreetierdemobackend.services;

import io.anviksha.dockerthreetierdemobackend.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAll();
    Customer getById(int id);
    Customer create(Customer customer);
    Customer update(int id, Customer customer);
    void deleteById(int id);
}
