package ro.tuc.ds2020.entities;

import javax.persistence.*;

@Entity
@Table(name =  "complaint")
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complaintId", nullable = false)
    private Long complaintId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Column(name = "type", nullable = true)
    private String type;

    @Column(name = "message", nullable = false)
    private String message;

    public Complaint() {}

    public Complaint(Long complaintId, Customer customer, String type, String message) {
        this.complaintId = complaintId;
        this.customer = customer;
        this.type = type;
        this.message = message;
    }

    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
