package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.adminDTOs.AdminToBeInsertedDTO;
import ro.tuc.ds2020.dtos.customerDTOs.CustomerDTO;
import ro.tuc.ds2020.dtos.customerDTOs.CustomerToBeInsertedDTO;
import ro.tuc.ds2020.services.CustomerService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public ResponseEntity<List<CustomerDTO>> findAll() {
        List<CustomerDTO> customerDTOS = customerService.findAll();
        return new ResponseEntity<>(customerDTOS, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertCustomer(@RequestBody CustomerToBeInsertedDTO customerToBeInsertedDTO) {
        Long insertedCustomerId;
        try {
            insertedCustomerId = customerService.insertCustomer(customerToBeInsertedDTO);
            return new ResponseEntity<>(insertedCustomerId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/{customerId}")
    public ResponseEntity<Long> deleteCustomer(@PathVariable Long customerId) {
        try {
            customerService.deleteCustomer(customerId);
            return new ResponseEntity<>(customerId, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(customerId, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Long> updateCustomer(@RequestBody CustomerToBeInsertedDTO customerToBeInsertedDTO) {
        try {
            customerService.updateCustomer(customerToBeInsertedDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
