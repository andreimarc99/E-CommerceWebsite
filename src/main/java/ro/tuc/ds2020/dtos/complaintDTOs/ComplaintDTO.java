package ro.tuc.ds2020.dtos.complaintDTOs;

import ro.tuc.ds2020.dtos.customerDTOs.CustomerDTO;

public class ComplaintDTO {

    private Long complaintId;
    private CustomerDTO customer;
    private String type;
    private String message;

    public ComplaintDTO(Long complaintId, CustomerDTO customer, String type, String message) {
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

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
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
