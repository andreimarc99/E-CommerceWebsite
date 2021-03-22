package ro.tuc.ds2020.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="admins")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adminId", nullable = false)
    private Long adminId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private User user;

    @Column(name = "salary", nullable = false)
    private Float salary;

    @Column(name = "date_hired", nullable = false)
    private Date dateHired;

    @OneToMany(mappedBy="admin")
    private List<ComplaintResponse> complaintResponseList = new ArrayList<>();

    public Admin() {}

    public Admin(Long adminId, User user, Float salary, Date dateHired) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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

    public List<ComplaintResponse> getComplaintResponseList() {
        return complaintResponseList;
    }

    public void setComplaintResponseList(List<ComplaintResponse> complaintResponseList) {
        this.complaintResponseList = complaintResponseList;
    }
}
