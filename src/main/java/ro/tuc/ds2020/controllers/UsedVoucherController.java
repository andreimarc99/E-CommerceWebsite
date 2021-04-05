package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.usedVouchersDTOs.UsedVoucherDTO;
import ro.tuc.ds2020.services.UsedVouchersService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/used_vouchers")
public class UsedVoucherController {
    private final UsedVouchersService usedVouchersService;

    @Autowired
    public UsedVoucherController(UsedVouchersService usedVouchersService) {
        this.usedVouchersService = usedVouchersService;
    }

    @GetMapping()
    public ResponseEntity<List<UsedVoucherDTO>> findAll() {
        List<UsedVoucherDTO> voucherDTOS = usedVouchersService.findUsedVouchers();
        return new ResponseEntity<>(voucherDTOS, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Long> insertVoucher(@RequestBody UsedVoucherDTO voucherDTO) {
        Long insertedVoucherId;
        try {
            insertedVoucherId = usedVouchersService.insertUsedVoucher(voucherDTO);
            return new ResponseEntity<>(insertedVoucherId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{usedVoucherId}")
    public ResponseEntity<Long> deleteVoucher(@PathVariable Long usedVoucherId) {
        try {
            usedVouchersService.deleteUsedVoucher(usedVoucherId);
            return new ResponseEntity<>(usedVoucherId, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(usedVoucherId, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping()
    public ResponseEntity<Long> updateVoucher(@RequestBody UsedVoucherDTO voucherDTO) {
        try {
            usedVouchersService.updateUsedVoucher(voucherDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
