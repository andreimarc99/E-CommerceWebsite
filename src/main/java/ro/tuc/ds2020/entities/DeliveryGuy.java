package ro.tuc.ds2020.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "delivery_guy")
public class DeliveryGuy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deliveryGuyId", nullable = false)
    private Long deliveryGuyId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "username")
    private User user;

    @Column(name = "salary", nullable = false)
    private Float salary;

    @Column(name = "date_hired", nullable = false)
    private Date dateHired;

    public DeliveryGuy() {}

    public DeliveryGuy(Long deliveryGuyId, User user, Float salary, Date dateHired) {
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
}
