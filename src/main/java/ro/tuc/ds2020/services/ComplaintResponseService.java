package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos._builders.ComplaintResponseBuilder;
import ro.tuc.ds2020.dtos.complaintResponseDTOs.ComplaintResponseDTO;
import ro.tuc.ds2020.entities.ComplaintResponse;
import ro.tuc.ds2020.repositories.ComplaintResponseRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComplaintResponseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComplaintResponseService.class);
    private final ComplaintResponseRepository complaintResponseRepository;

    @Autowired
    public ComplaintResponseService(ComplaintResponseRepository complaintResponseRepository){
        this.complaintResponseRepository = complaintResponseRepository;
    }

    public List<ComplaintResponseDTO> findComplaintResponses() {
        List<ComplaintResponse> complaintResponses = complaintResponseRepository.findAll();
        return complaintResponses.stream()
                .map(ComplaintResponseBuilder::toComplaintResponseDTO)
                .collect(Collectors.toList());
    }

    public Long insertComplaintResponse(ComplaintResponseDTO complaintResponseDTO) {
        ComplaintResponse complaintResponse = ComplaintResponseBuilder.toComplaintResponse(complaintResponseDTO);
        complaintResponse = complaintResponseRepository.save(complaintResponse);
        LOGGER.debug("ComplaintResponse with ID {} was inserted in db", complaintResponseDTO.getComplaintResponseId());
        return complaintResponse.getComplaintResponseId();
    }

    public void deleteComplaintResponse(Long complaintResponseId) throws ResourceNotFoundException {
        Optional<ComplaintResponse> complaintResponse = complaintResponseRepository.findById(complaintResponseId);
        if (!complaintResponse.isPresent()) {
            throw new ResourceNotFoundException("ComplaintResponse with id " + complaintResponseId + " not found.");
        }
        complaintResponseRepository.deleteById(complaintResponseId);
    }

    public ComplaintResponseDTO updateComplaintResponse(ComplaintResponseDTO complaintResponseDTO) throws ResourceNotFoundException {
        Optional<ComplaintResponse> complaintResponse = complaintResponseRepository.findById(complaintResponseDTO.getComplaintResponseId());
        if (!complaintResponse.isPresent()) {
            throw new ResourceNotFoundException("ComplaintResponse with ID " + complaintResponseDTO.getComplaintResponseId() + " not found.");
        }
        ComplaintResponse updatedComplaintResponse = ComplaintResponseBuilder.toComplaintResponse(complaintResponseDTO);
        ComplaintResponseDTO updatedComplaintResponseDTO = ComplaintResponseBuilder.toComplaintResponseDTO(complaintResponseRepository.save(updatedComplaintResponse));
        return updatedComplaintResponseDTO;
    }
}
