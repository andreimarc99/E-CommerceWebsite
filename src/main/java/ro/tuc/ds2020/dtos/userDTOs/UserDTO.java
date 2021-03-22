package ro.tuc.ds2020.dtos.userDTOs;

import ro.tuc.ds2020.entities.UserRole;

import java.util.Date;

public class UserDTO {
    private String username;
    private String password;
    private UserRole role;
    private String cnp;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String gender;

    public UserDTO() {}

    public UserDTO(String username, String password, UserRole role, String cnp, Date birthDate, String firstName, String lastName, String gender) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.cnp = cnp;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
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
        return cnp;
    }

    public void setCNP(String CNP) {
        this.cnp = CNP;
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
}
