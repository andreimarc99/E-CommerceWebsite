package ro.tuc.ds2020.dtos.adminDTOs;

import ro.tuc.ds2020.dtos.userDTOs.UserDTO;

import java.util.Date;

public class AdminDTO {
    private Long adminId;
    private UserDTO user;
    private Float salary;
    private Date dateHired;

    public AdminDTO(Long adminId, UserDTO user, Float salary, Date dateHired) {
        this.adminId = adminId;
        this.user = user;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
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
