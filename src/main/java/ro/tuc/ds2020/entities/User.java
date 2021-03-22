package ro.tuc.ds2020.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    @Column(name = "cnp", nullable = false)
    private String cnp;

    @Column(name = "birthDate", nullable = true)
    private Date birthDate;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "gender", nullable = true)
    private String gender;

    @OneToMany(mappedBy = "user")
    private List<Address> addressList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserBan> banList = new ArrayList<>();

    public User() {}

    public User(String username, String password, UserRole role, String cnp, Date birthDate, String firstName, String lastName, String gender) {
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

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<UserBan> getBanList() {
        return banList;
    }

    public void setBanList(List<UserBan> banList) {
        this.banList = banList;
    }

    public String toString() {
        return "Username: " + this.username + ", pass: " + this.password
                + "; Name: " + this.firstName + " " + this.lastName + "; CNP: " + this.cnp
                + "; Gender: " + this.gender + " - Role: " + this.role;
    }
}
