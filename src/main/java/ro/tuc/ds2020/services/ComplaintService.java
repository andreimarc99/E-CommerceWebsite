package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos._builders.ComplaintBuilder;
import ro.tuc.ds2020.dtos.complaintDTOs.ComplaintDTO;
import ro.tuc.ds2020.entities.Complaint;
import ro.tuc.ds2020.repositories.ComplaintRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComplaintService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComplaintService.class);
    private final ComplaintRepository complaintRepository;

    @Autowired
    public ComplaintService(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    public List<ComplaintDTO> findComplaints() {
        List<Complaint> complaints = complaintRepository.findAll();
        return complaints.stream()
                .map(ComplaintBuilder::toComplaintDTO)
                .collect(Collectors.toList());
    }

    public List<ComplaintDTO> findComplaintsByUsername(String username) {
        List<Complaint> complaints = complaintRepository.getComplaintsByUsername(username);
        return complaints.stream()
                .map(ComplaintBuilder::toComplaintDTO)
                .collect(Collectors.toList());
    }

    public Long insertComplaint(ComplaintDTO complaintDTO) {
        Complaint complaint = ComplaintBuilder.toComplaint(complaintDTO);
        complaint = complaintRepository.save(complaint);
        LOGGER.debug("Complaint with ID {} was inserted in db", complaintDTO.getComplaintId());
        return complaint.getComplaintId();
    }

    public void deleteComplaint(Long complaintId) throws ResourceNotFoundException {
        Optional<Complaint> complaint = complaintRepository.findById(complaintId);
        if (!complaint.isPresent()) {
            throw new ResourceNotFoundException("Complaint with id " + complaintId + " not found.");
        }
        complaintRepository.deleteById(complaintId);
    }

    public ComplaintDTO updateComplaint(ComplaintDTO complaintDTO) throws ResourceNotFoundException {
        Optional<Complaint> complaint = complaintRepository.findById(complaintDTO.getComplaintId());
        if (!complaint.isPresent()) {
            throw new ResourceNotFoundException("Complaint with ID " + complaintDTO.getComplaintId() + " not found.");
        }
        Complaint updatedComplaint = ComplaintBuilder.toComplaint(complaintDTO);
        ComplaintDTO updatedComplaintDTO = ComplaintBuilder.toComplaintDTO(complaintRepository.save(updatedComplaint));
        return updatedComplaintDTO;
    }
}
