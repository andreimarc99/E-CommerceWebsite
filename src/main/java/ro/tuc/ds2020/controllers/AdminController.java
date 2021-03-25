package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.adminDTOs.AdminDTO;
import ro.tuc.ds2020.dtos.adminDTOs.AdminToBeInsertedDTO;
import ro.tuc.ds2020.services.AdminService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/admins")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping()
    public ResponseEntity<List<AdminDTO>> findAll() {
        List<AdminDTO> admins = adminService.findAll();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertAdmin(@RequestBody AdminToBeInsertedDTO adminToBeInsertedDTO) {
        Long insertedAdminId;
        try {
            insertedAdminId = adminService.insertAdmin(adminToBeInsertedDTO);
            return new ResponseEntity<>(insertedAdminId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{adminId}")
    public ResponseEntity<Long> deleteAdmin(@PathVariable Long adminId) {
        try {
            adminService.deleteAdmin(adminId);
            return new ResponseEntity<>(adminId, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(adminId, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Long> updateAdmin(@RequestBody AdminToBeInsertedDTO adminToBeInsertedDTO) {
        try {
            adminService.updateAdmin(adminToBeInsertedDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
