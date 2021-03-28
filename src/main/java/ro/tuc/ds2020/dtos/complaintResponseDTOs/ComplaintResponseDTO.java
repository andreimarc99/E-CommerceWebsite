package ro.tuc.ds2020.dtos.complaintResponseDTOs;

import ro.tuc.ds2020.dtos.adminDTOs.AdminDTO;
import ro.tuc.ds2020.dtos.complaintDTOs.ComplaintDTO;

public class ComplaintResponseDTO {
    private Long complaintResponseId;
    private ComplaintDTO complaint;
    private AdminDTO admin;
    private String message;

    public ComplaintResponseDTO(Long complaintResponseId, ComplaintDTO complaint, AdminDTO admin, String message) {
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

    public ComplaintDTO getComplaint() {
        return complaint;
    }

    public void setComplaint(ComplaintDTO complaint) {
        this.complaint = complaint;
    }

    public AdminDTO getAdmin() {
        return admin;
    }

    public void setAdmin(AdminDTO admin) {
        this.admin = admin;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
