package ro.tuc.ds2020.dtos._builders;

import ro.tuc.ds2020.dtos.complaintResponseDTOs.ComplaintResponseDTO;
import ro.tuc.ds2020.entities.ComplaintResponse;

public class ComplaintResponseBuilder {

    public static ComplaintResponse toComplaintResponse(ComplaintResponseDTO complaintResponseDTO) {
        return new ComplaintResponse(complaintResponseDTO.getComplaintResponseId(),
                ComplaintBuilder.toComplaint(complaintResponseDTO.getComplaint()),
                AdminBuilder.toAdmin(complaintResponseDTO.getAdmin()),
                complaintResponseDTO.getMessage());
    }

    public static ComplaintResponseDTO toComplaintResponseDTO(ComplaintResponse complaintResponse) {
        return new ComplaintResponseDTO(complaintResponse.getComplaintResponseId(),
                ComplaintBuilder.toComplaintDTO(complaintResponse.getComplaint()),
                AdminBuilder.toAdminDTO(complaintResponse.getAdmin()),
                complaintResponse.getMessage());
    }
}
