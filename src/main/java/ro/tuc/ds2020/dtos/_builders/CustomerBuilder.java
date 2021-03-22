package ro.tuc.ds2020.dtos._builders;

import ro.tuc.ds2020.dtos.customerDTOs.CustomerDTO;
import ro.tuc.ds2020.dtos.customerDTOs.CustomerToBeInsertedDTO;
import ro.tuc.ds2020.entities.Customer;
import ro.tuc.ds2020.entities.User;

public class CustomerBuilder {

    public static Customer toCustomer(CustomerDTO customerDTO) {
        return new Customer(customerDTO.getCustomerId(),
                UserBuilder.toUser(customerDTO.getUser()),
                customerDTO.getDateJoined());
    }

    public static CustomerDTO toCustomerDTO(Customer customer) {
        return new CustomerDTO(customer.getCustomerId(),
                UserBuilder.toUserDTO(customer.getUser()),
                customer.getDateJoined());
    }

    public static Customer toCustomer(CustomerToBeInsertedDTO customerToBeInsertedDTO) {
        return new Customer(customerToBeInsertedDTO.getCustomerId(),
                new User(customerToBeInsertedDTO.getUsername(),
                        customerToBeInsertedDTO.getPassword(),
                        customerToBeInsertedDTO.getRole(),
                        customerToBeInsertedDTO.getCNP(),
                        customerToBeInsertedDTO.getBirthDate(),
                        customerToBeInsertedDTO.getFirstName(),
                        customerToBeInsertedDTO.getLastName(),
                        customerToBeInsertedDTO.getGender()),
                customerToBeInsertedDTO.getDateJoined());
    }
}
