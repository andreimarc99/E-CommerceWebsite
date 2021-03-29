package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.voucherDTOs.VoucherDTO;
import ro.tuc.ds2020.services.VoucherService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/vouchers")
public class VoucherController {

    private final VoucherService voucherService;

    @Autowired
    public VoucherController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    @GetMapping()
    public ResponseEntity<List<VoucherDTO>> findAll() {
        List<VoucherDTO> voucherDTOS = voucherService.findVouchers();
        return new ResponseEntity<>(voucherDTOS, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertVoucher(@RequestBody VoucherDTO voucherDTO) {
        Long insertedVoucherId;
        try {
            insertedVoucherId = voucherService.insertVoucher(voucherDTO);
            return new ResponseEntity<>(insertedVoucherId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{voucherId}")
    public ResponseEntity<Long> deleteVoucher(@PathVariable Long voucherId) {
        try {
            voucherService.deleteVoucher(voucherId);
            return new ResponseEntity<>(voucherId, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(voucherId, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Long> updateVoucher(@RequestBody VoucherDTO voucherDTO) {
        try {
            voucherService.updateVoucher(voucherDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
