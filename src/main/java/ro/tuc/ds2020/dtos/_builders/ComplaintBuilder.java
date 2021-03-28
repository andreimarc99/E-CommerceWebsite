package ro.tuc.ds2020.dtos._builders;

import ro.tuc.ds2020.dtos.complaintDTOs.ComplaintDTO;
import ro.tuc.ds2020.entities.Complaint;

public class ComplaintBuilder {

    public static Complaint toComplaint(ComplaintDTO complaintDTO) {
        return new Complaint(complaintDTO.getComplaintId(),
                CustomerBuilder.toCustomer(complaintDTO.getCustomer()),
                complaintDTO.getType(),
                complaintDTO.getMessage());
    }

    public static ComplaintDTO toComplaintDTO(Complaint complaint) {
        return new ComplaintDTO(complaint.getComplaintId(),
                CustomerBuilder.toCustomerDTO(complaint.getCustomer()),
                complaint.getType(),
                complaint.getMessage());
    }

}
