package ro.tuc.ds2020.entities;

import javax.persistence.*;

@Entity
@Table(name = "complaint_response")
public class ComplaintResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complaintResponseId", nullable = false)
    private Long complaintResponseId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "complaintId")
    private Complaint complaint;

    @ManyToOne()
    @JoinColumn(name = "adminId")
    private Admin admin;

    @Column(name = "message", nullable = false)
    private String message;

    public ComplaintResponse() {}

    public ComplaintResponse(Long complaintResponseId, Complaint complaint, Admin admin, String message) {
        this.complaintResponseId = complaintResponseId;
        this.complaint = complaint;
        this.admin = admin;
        this.message = message;
    }

    public Long getComplaintResponseId() {
        return complaintResponseId;
    }

    public void setComplaintResponseId(Long complaintResponseId) {
        this.complaintResponseId = complaintResponseId;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
