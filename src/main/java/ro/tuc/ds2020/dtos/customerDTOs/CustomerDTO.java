package ro.tuc.ds2020.dtos.customerDTOs;

import ro.tuc.ds2020.dtos.userDTOs.UserDTO;
import ro.tuc.ds2020.entities.User;

import java.util.Date;

public class CustomerDTO {
    private Long customerId;
    private UserDTO user;
    private Date dateJoined;

    public CustomerDTO(Long customerId, UserDTO user, Date dateJoined) {
        this.customerId = customerId;
        this.user = user;
        this.dateJoined = dateJoined;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }
}
