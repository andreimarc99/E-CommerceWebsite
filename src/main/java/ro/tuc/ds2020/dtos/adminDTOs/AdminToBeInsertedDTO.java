package ro.tuc.ds2020.dtos.adminDTOs;

import ro.tuc.ds2020.entities.User;
import ro.tuc.ds2020.entities.UserRole;

import java.util.Date;

public class AdminToBeInsertedDTO {
    private String username;
    private String password;
    protected UserRole role;
    private String CNP;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private Long adminId;
    private Float salary;
    private Date dateHired;

    public AdminToBeInsertedDTO(Long adminId, String username, String password, UserRole role, String CNP, Date birthDate,
                                String firstName, String lastName, String gender,
                                Float salary, Date dateHired) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.CNP = CNP;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.adminId = adminId;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
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
