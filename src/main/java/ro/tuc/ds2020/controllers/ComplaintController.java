package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.complaintDTOs.ComplaintDTO;
import ro.tuc.ds2020.services.ComplaintService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    @Autowired
    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @GetMapping()
    public ResponseEntity<List<ComplaintDTO>> findAll() {
        List<ComplaintDTO> complaintDTOS = complaintService.findComplaints();
        return new ResponseEntity<>(complaintDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<List<ComplaintDTO>> findComplaintsByUsername(@PathVariable String username) {
        try {
            List<ComplaintDTO> complaintDTOS = complaintService.findComplaintsByUsername(username);
            return new ResponseEntity<>(complaintDTOS, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Long> insertComplaint(@RequestBody ComplaintDTO complaintDTO) {
        Long insertedComplaintId;
        try {
            insertedComplaintId = complaintService.insertComplaint(complaintDTO);
            return new ResponseEntity<>(insertedComplaintId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{complaintId}")
    public ResponseEntity<Long> deleteComplaint(@PathVariable Long complaintId) {
        try {
            complaintService.deleteComplaint(complaintId);
            return new ResponseEntity<>(complaintId, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(complaintId, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Long> updateComplaint(@RequestBody ComplaintDTO complaintDTO) {
        try {
            complaintService.updateComplaint(complaintDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
