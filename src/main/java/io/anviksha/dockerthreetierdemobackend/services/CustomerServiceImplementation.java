package io.anviksha.dockerthreetierdemobackend.services;

import com.fasterxml.jackson.databind.util.BeanUtil;
import io.anviksha.dockerthreetierdemobackend.exceptions.RecordNotFoundException;
import io.anviksha.dockerthreetierdemobackend.models.Customer;
import io.anviksha.dockerthreetierdemobackend.repositories.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImplementation implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImplementation(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(int id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new RecordNotFoundException(
                        String.format("Could not find the customer: %d", id)
                ));
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.saveAndFlush(customer);
    }

    @Override
    public Customer update(int id, Customer customer) {
        Customer customerDb = getById(id);
        BeanUtils.copyProperties(customer, customerDb);
        return customerRepository.saveAndFlush(customerDb);
    }

    @Override
    public void deleteById(int id) {
        customerRepository.delete(getById(id));
    }
}
