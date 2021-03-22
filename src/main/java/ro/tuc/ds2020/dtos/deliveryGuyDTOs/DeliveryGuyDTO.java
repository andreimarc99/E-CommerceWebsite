package ro.tuc.ds2020.dtos.deliveryGuyDTOs;

import ro.tuc.ds2020.dtos.userDTOs.UserDTO;

import java.util.Date;

public class DeliveryGuyDTO {

    private Long deliveryGuyId;
    private UserDTO user;
    private Float salary;
    private Date dateHired;

    public DeliveryGuyDTO(Long deliveryGuyId, UserDTO user, Float salary, Date dateHired) {
        this.deliveryGuyId = deliveryGuyId;
        this.user = user;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public Long getDeliveryGuyId() {
        return deliveryGuyId;
    }

    public void setDeliveryGuyId(Long deliveryGuyId) {
        this.deliveryGuyId = deliveryGuyId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }
}
