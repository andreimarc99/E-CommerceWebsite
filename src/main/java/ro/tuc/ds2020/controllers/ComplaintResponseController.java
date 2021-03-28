package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.complaintResponseDTOs.ComplaintResponseDTO;
import ro.tuc.ds2020.services.ComplaintResponseService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/complaint_responses")
public class ComplaintResponseController {

    private final ComplaintResponseService complaintResponseService;

    @Autowired
    public ComplaintResponseController(ComplaintResponseService complaintResponseService) {
        this.complaintResponseService = complaintResponseService;
    }

    @GetMapping()
    public ResponseEntity<List<ComplaintResponseDTO>> findAll() {
        List<ComplaintResponseDTO> complaintResponseDTOS = complaintResponseService.findComplaintResponses();
        return new ResponseEntity<>(complaintResponseDTOS, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertComplaintResponse(@RequestBody ComplaintResponseDTO complaintResponseDTO) {
        Long insertedComplaintResponseId;
        try {
            insertedComplaintResponseId = complaintResponseService.insertComplaintResponse(complaintResponseDTO);
            return new ResponseEntity<>(insertedComplaintResponseId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{complaintResponseId}")
    public ResponseEntity<Long> deleteComplaintResponse(@PathVariable Long complaintResponseId) {
        try {
            complaintResponseService.deleteComplaintResponse(complaintResponseId);
            return new ResponseEntity<>(complaintResponseId, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(complaintResponseId, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Long> updateComplaintResponse(@RequestBody ComplaintResponseDTO complaintResponseDTO) {
        try {
            complaintResponseService.updateComplaintResponse(complaintResponseDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
