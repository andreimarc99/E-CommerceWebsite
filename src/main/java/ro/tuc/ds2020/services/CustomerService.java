package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos._builders.AdminBuilder;
import ro.tuc.ds2020.dtos._builders.CustomerBuilder;
import ro.tuc.ds2020.dtos.adminDTOs.AdminDTO;
import ro.tuc.ds2020.dtos.adminDTOs.AdminToBeInsertedDTO;
import ro.tuc.ds2020.dtos.customerDTOs.CustomerDTO;
import ro.tuc.ds2020.dtos.customerDTOs.CustomerToBeInsertedDTO;
import ro.tuc.ds2020.entities.Admin;
import ro.tuc.ds2020.entities.Customer;
import ro.tuc.ds2020.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerBuilder::toCustomerDTO)
                .collect(Collectors.toList());
    }

    public Long insertCustomer(CustomerToBeInsertedDTO customerToBeInsertedDTO) {
        Customer customer = CustomerBuilder.toCustomer(customerToBeInsertedDTO);
        customer = customerRepository.save(customer);
        LOGGER.debug("Customer with username {} was inserted in db", customer.getUser().getUsername());
        return customer.getCustomerId();
    }

    public void deleteCustomer(Long customerId) throws ResourceNotFoundException {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (!customer.isPresent()) {
            throw new ResourceNotFoundException("Customer with id " + customerId + " not found.");
        }
        customerRepository.deleteById(customerId);
    }

    public CustomerDTO updateCustomer(CustomerToBeInsertedDTO customerToBeInsertedDTO) throws ResourceNotFoundException {
        Optional<Customer> customer = customerRepository.findById(customerToBeInsertedDTO.getCustomerId());
        if (!customer.isPresent()) {
            throw new ResourceNotFoundException("Customer with username " + customerToBeInsertedDTO.getUsername() + " not found.");
        }
        Customer updatedCustomer = CustomerBuilder.toCustomer(customerToBeInsertedDTO);
        CustomerDTO updatedCustomerDTO = CustomerBuilder.toCustomerDTO(customerRepository.save(updatedCustomer));
        return updatedCustomerDTO;
    }
}
